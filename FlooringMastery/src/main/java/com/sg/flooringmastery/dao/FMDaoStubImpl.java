/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.FMOrder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lizz
 */
public class FMDaoStubImpl implements FMDao {

    private Map<LocalDate, List<FMOrder>> dateOrdersMap = new HashMap<>();
    int orderCount = 0;

    @Override
    public int getOrderCount() {
        return orderCount;
    }
    
     @Override
    public void setOrderCount(int newCount){
        this.orderCount = newCount;
    }

    public FMDaoStubImpl() {
        FMOrder newOrder = new FMOrder();
        newOrder.setOrderNumber(1);
        newOrder.setCustomerName("Doe");
        newOrder.setState("OH");

        BigDecimal taxRate = new BigDecimal("6.25");
        newOrder.setTaxRate(taxRate);

        newOrder.setMaterialType("Wood");
        newOrder.setStringArea("50.00");

        BigDecimal area = new BigDecimal("50.00");
        newOrder.setArea(area);

        BigDecimal matSq = new BigDecimal("5.15");
        newOrder.setMaterialPerSqFt(matSq);

        BigDecimal labSq = new BigDecimal("4.75");
        newOrder.setLaborPerSqFt(labSq);

        BigDecimal matTot = new BigDecimal("257.50");
        newOrder.setMaterialTotal(matTot);

        BigDecimal labTot = new BigDecimal("237.50");
        newOrder.setLaborTotal(labTot);

        BigDecimal taxTot = new BigDecimal("30.94");
        newOrder.setTaxTotal(taxTot);

        BigDecimal tot = new BigDecimal("525.94");
        newOrder.setTotal(tot);

        LocalDate date = LocalDate.parse("2014-01-01");

        List<FMOrder> only = new ArrayList<>();
        only.add(newOrder);

        dateOrdersMap.put(date, only);
    }

    @Override
    public List<LocalDate> getDates() {
        return new ArrayList<>(dateOrdersMap.keySet());
    }

    @Override
    public List<FMOrder> getOrdersOnDate(LocalDate orderDate) {
        //returns list, or null
        return new ArrayList<>(dateOrdersMap.get(orderDate));
    }

    @Override
    public FMOrder addNewDateOrder(LocalDate orderDate, FMOrder newOrder) {
        FMOrder only = dateOrdersMap.get(LocalDate.parse("2014-01-01")).get(0);

        if (newOrder != only && !dateOrdersMap.keySet().contains(orderDate)) {
            return newOrder;
        } else {
            return null;
        }
    }

    @Override

    public FMOrder addExistingDateOrder(LocalDate orderDate, FMOrder newOrder) {
        FMOrder only = dateOrdersMap.get(orderDate).get(0);
        if (dateOrdersMap.keySet().contains(orderDate) && newOrder != only) {
            return newOrder;
        } else {
            return null;
        }

    }

    @Override
    public FMOrder editOrder(LocalDate orderDate, FMOrder editedOrder) {
        //check that the date has an edited order associated
        List<FMOrder> orders = dateOrdersMap.get(orderDate);
        boolean orderExists = false;

        if (orders != null) {
            for (FMOrder o : orders) {
                if (o.getOrderNumber() == editedOrder.getOrderNumber()) {
                    orderExists = true;
                }
            }
        }

        if (orderExists) {
            return editedOrder;
        } else {
            return null;
        }
    }

    @Override
    public FMOrder removeOrder(LocalDate orderDate, int orderNumber) {

        List<FMOrder> orders = dateOrdersMap.get(orderDate);

        FMOrder existingOrder = null;

        if (orders != null) {
            for (FMOrder o : orders) {
                if (o.getOrderNumber() == orderNumber) {
                    existingOrder = o;

                }
            }
        }

        return existingOrder;

    }

    @Override
    public List<FMOrder> removeOrdersOnDate(LocalDate date) {
        List<FMOrder> orders = dateOrdersMap.get(date);

        if (orders != null) {
            return orders;
        } else {
            return null;
        }
    }

    @Override
    public void commitChanges() throws FMDaoDataPersistException {
        //do nothing
    }

}
