/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FMDao;
import com.sg.flooringmastery.dao.FMDaoDataPersistException;
import com.sg.flooringmastery.dto.FMOrder;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Lizz
 */
public class FMServiceLayerImpl implements FMServiceLayer {

    private FMDao dao;

    public FMDao getDao() {
        return dao;
    }

    @Override
    public void setDao(FMDao dao) throws FMDaoDataPersistException {
        this.dao = dao;
    }

    @Override
    public List<FMOrder> getOrdersOnDate(LocalDate date) throws FMNoOrderExistsException, FMDaoDataPersistException {
        List<FMOrder> orders;
        try {
            return orders = dao.getOrdersOnDate(date);

        } catch (NullPointerException e) {
            throw new FMNoOrderExistsException("No orders exist on " + date.toString());
        }

    }

    @Override
    public FMOrder calculateNewOrder(LocalDate date, FMOrder newOrder) throws FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException {
        setOrderNumber(date, newOrder);
        validateOrderFields(newOrder);
        validateOptionsCalculateOrder(newOrder);

        return newOrder;
    }

    @Override
    public FMOrder addOrder(LocalDate date, FMOrder newOrder) throws FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException {
        boolean isNewDate = checkIfNewDate(date);
        FMOrder addedOrder;
        if (isNewDate) {
            addedOrder = dao.addNewDateOrder(date, newOrder);

        } else {
            addedOrder = dao.addExistingDateOrder(date, newOrder);
        }

        return addedOrder;
    }

    @Override
    public FMOrder getOrder(LocalDate date, int orderNumber) throws FMNoOrderExistsException, FMDaoDataPersistException {

        List<FMOrder> orders = getOrdersOnDate(date);
        FMOrder found = null;

        for (FMOrder o : orders) {
            if (o.getOrderNumber() == orderNumber) {
                found = o;
            }
        }
        if (found != null) {
            return found;
        } else {
            throw new FMNoOrderExistsException("No order number " + orderNumber + " exists on " + date + ".");
        }
    }

    @Override
    public FMOrder editOrder(LocalDate date, FMOrder originalOrder, FMOrder orderWithChanges) throws FMMissingPropertyException, FMInvalidPropertyException {

        FMOrder updatedOrder = updateOrder(originalOrder, orderWithChanges);

        validateOrderFields(updatedOrder);
        validateOptionsCalculateOrder(updatedOrder);

        return dao.editOrder(date, updatedOrder);
    }

    @Override
    public FMOrder correctBadOrder(LocalDate date, FMOrder originalOrder, FMOrder orderWithChanges) throws FMMissingPropertyException, FMInvalidPropertyException {

        FMOrder updatedOrder = updateOrder(originalOrder, orderWithChanges);

        validateOrderFields(updatedOrder);
        validateOptionsCalculateOrder(updatedOrder);

        return updatedOrder;
    }

    @Override
    public FMOrder removeOrder(LocalDate date, int orderNumber) throws FMNoOrderExistsException, FMDaoDataPersistException {

        List<FMOrder> orders = dao.getOrdersOnDate(date);
        if (orders.size() > 1) {
            return dao.removeOrder(date, orderNumber);
        } else {
            List<FMOrder> ordersRemoved = dao.removeOrdersOnDate(date);
            return ordersRemoved.get(0);
        }
    }

    @Override
    public boolean commitChanges() throws FMDaoDataPersistException {

        dao.commitChanges();
        return true;

    }

    private boolean checkIfNewDate(LocalDate orderDate) {
        boolean isNewDate = true;
        List<LocalDate> dates = dao.getDates();
        if (dates.contains(orderDate)) {
            isNewDate = false;
        }
        return isNewDate;
    }

    private void validateOrderFields(FMOrder order) throws FMMissingPropertyException, FMInvalidPropertyException {

        if (order.getCustomerName() == null
                || order.getCustomerName().trim().length() == 0
                || order.getState() == null
                || order.getState().trim().length() == 0
                || order.getMaterialType() == null
                || order.getMaterialType().trim().length() == 0
                || order.getStringArea() == null
                || order.getStringArea().trim().length() == 0) {

            throw new FMMissingPropertyException("All fields must be entered.");
        }
        String stringArea = order.getStringArea();
        try {
            BigDecimal area = new BigDecimal(stringArea);
            order.setArea(area);
        } catch (NumberFormatException e) {
            throw new FMInvalidPropertyException("Area must be a number");
        }

    }

    private BigDecimal validateStateGetTax(FMOrder order) throws FMInvalidPropertyException {
        String state = order.getState();
        String strTaxRate = "";

        if (state.equalsIgnoreCase("oh")) {
            strTaxRate = "6.25";
        } else if (state.equalsIgnoreCase("pa")) {
            strTaxRate = "6.75";
        } else if (state.equalsIgnoreCase("mi")) {
            strTaxRate = "5.75";
        } else if (state.equalsIgnoreCase("in")) {
            strTaxRate = "6.00";
        } else {
            throw new FMInvalidPropertyException("We do not serve your region. Please try again or check back in the future.");
        }
        BigDecimal taxRate = new BigDecimal(strTaxRate);

        return taxRate;
    }

    private BigDecimal validateMaterialGetCost(FMOrder order) throws FMInvalidPropertyException {
        String material = order.getMaterialType();
        String strMaterialPerSqFt = "";

        if (material.equalsIgnoreCase("carpet")) {
            strMaterialPerSqFt = "2.25";

        } else if (material.equalsIgnoreCase("laminate")) {
            strMaterialPerSqFt = "1.75";

        } else if (material.equalsIgnoreCase("tile")) {
            strMaterialPerSqFt = "3.50";

        } else if (material.equalsIgnoreCase("wood")) {
            strMaterialPerSqFt = "5.15";

        } else {
            throw new FMInvalidPropertyException("We do not have your material choice available. Please try again or check back in the future.");
        }
        BigDecimal materialCost = new BigDecimal(strMaterialPerSqFt);

        return materialCost;
    }

    private BigDecimal getLaborCost(String material) throws FMInvalidPropertyException {
        String strLaborPerSqFt = "";

        if (material.equalsIgnoreCase("carpet")) {

            strLaborPerSqFt = "2.10";
        } else if (material.equalsIgnoreCase("laminate")) {

            strLaborPerSqFt = "2.10";
        } else if (material.equalsIgnoreCase("tile")) {

            strLaborPerSqFt = "4.15";
        } else if (material.equalsIgnoreCase("wood")) {

            strLaborPerSqFt = "4.75";
        }

        BigDecimal laborCost = new BigDecimal(strLaborPerSqFt);

        return laborCost;
    }

    private FMOrder validateOptionsCalculateOrder(FMOrder order) throws FMInvalidPropertyException {
        BigDecimal taxRate = validateStateGetTax(order);
        BigDecimal materialCost = validateMaterialGetCost(order);

        BigDecimal laborCost = getLaborCost(order.getMaterialType());

        BigDecimal materialTotal = materialCost.multiply(order.getArea()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal laborTotal = laborCost.multiply(order.getArea()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal preTaxTotal = materialTotal.add(laborTotal);
        BigDecimal taxTotal = taxRate.multiply(preTaxTotal).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        BigDecimal total = preTaxTotal.add(taxTotal).setScale(2, RoundingMode.HALF_UP);

        order.setTaxRate(taxRate);
        order.setMaterialPerSqFt(materialCost);
        order.setLaborPerSqFt(laborCost);
        order.setMaterialTotal(materialTotal);
        order.setLaborTotal(laborTotal);
        order.setTaxTotal(taxTotal);
        order.setTotal(total);

        return order;
    }

    private void setOrderNumber(LocalDate date, FMOrder order) throws FMDaoDataPersistException {
        int count = dao.getOrderCount();
        count += 1;
        dao.setOrderCount(count);
        order.setOrderNumber(count);

    }

    private FMOrder updateOrder(FMOrder originalOrder, FMOrder orderWithEdits) {
        String customerName = orderWithEdits.getCustomerName();
        String state = orderWithEdits.getState();
        String material = orderWithEdits.getMaterialType();
        String area = orderWithEdits.getStringArea();

        if (customerName != null && customerName.trim().length() != 0) {
            originalOrder.setCustomerName(customerName);
        }
        if (state != null && state.trim().length() != 0) {
            originalOrder.setState(state);
        }
        if (material != null && material.trim().length() != 0) {
            originalOrder.setMaterialType(material);
        }

        if (area != null && area.trim().length() != 0) {
            originalOrder.setStringArea(area);
        }

        return originalOrder;
    }

}
