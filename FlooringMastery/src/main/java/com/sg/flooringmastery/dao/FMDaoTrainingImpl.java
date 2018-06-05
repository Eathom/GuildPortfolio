/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import static com.sg.flooringmastery.dao.FMDaoFileImpl.ORDER_COUNT;
import com.sg.flooringmastery.dto.FMOrder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Lizz
 */
public class FMDaoTrainingImpl implements FMDao {

    private List<LocalDate> fileDates = new ArrayList<>();
    private Map<LocalDate, List<FMOrder>> dateOrdersMap = new HashMap<>();
    private int orderCount = 0;

    public static final String ALL_FILES_FILE = "allfiles.txt";
    public static final String DELIMITER = "::";

    public FMDaoTrainingImpl() throws FMDaoDataPersistException {
        loadFile();
    }

    @Override
    public int getOrderCount() {
        return orderCount;
    }

    @Override
    public void setOrderCount(int newCount) {
        this.orderCount = newCount;
    }

    @Override
    public List<LocalDate> getDates() {
        return new ArrayList<>(dateOrdersMap.keySet());
    }

    @Override
    public List<FMOrder> getOrdersOnDate(LocalDate orderDate) {
        return new ArrayList<>(dateOrdersMap.get(orderDate));

    }

    @Override
    public FMOrder addNewDateOrder(LocalDate orderDate, FMOrder newOrder) {

        List<FMOrder> orderList = new ArrayList<>();
        orderList.add(newOrder);

        dateOrdersMap.put(orderDate, orderList);

        return newOrder;
    }

    @Override

    public FMOrder addExistingDateOrder(LocalDate orderDate, FMOrder newOrder) {
        dateOrdersMap.get(orderDate).add(newOrder);

        return newOrder;
    }

    @Override
    public FMOrder editOrder(LocalDate orderDate, FMOrder editedOrder) {

        int index;
        List<FMOrder> orders = dateOrdersMap.get(orderDate);

        for (FMOrder o : orders) {
            if (o.getOrderNumber() == editedOrder.getOrderNumber()) {
                index = orders.indexOf(o);
                orders.set(index, editedOrder);
                dateOrdersMap.put(orderDate, orders);
            }
        }

        return editedOrder;

    }

    @Override
    public FMOrder removeOrder(LocalDate orderDate, int orderNumber) {

        List<FMOrder> oneOrder = dateOrdersMap.get(orderDate)
                .stream()
                .filter(o -> o.getOrderNumber() == orderNumber)
                .collect((Collectors.toList()));

        FMOrder toRemove = oneOrder.get(0);

        boolean removed = dateOrdersMap.get(orderDate).remove(toRemove);
        if (removed) {
            return toRemove;
        } else {
            return null;
        }

    }

    @Override
    public List<FMOrder> removeOrdersOnDate(LocalDate date) {
        return dateOrdersMap.remove(date);
    }

    private void loadFile() throws FMDaoDataPersistException {
        Scanner sc;

        try {
            sc = new Scanner(new BufferedReader(new FileReader(ALL_FILES_FILE)));
        } catch (FileNotFoundException e) {
            throw new FMDaoDataPersistException("Error, could not load file", e);
        }
        String currentLineDate;

        while (sc.hasNext()) {
            currentLineDate = sc.nextLine();
            LocalDate currentDate = LocalDate.parse(currentLineDate);
            fileDates.add(currentDate);
        }

        try {
            sc = new Scanner(new BufferedReader(new FileReader(ORDER_COUNT)));
        } catch (FileNotFoundException e) {
            throw new FMDaoDataPersistException("Error, could not load file", e);
        }
        String strCount = sc.nextLine();
        if (strCount.trim().length() > 0) {
            orderCount = Integer.parseInt(strCount);
        }

        for (LocalDate currentDate : fileDates) {
            try {
                sc = new Scanner(new BufferedReader(new FileReader("Orders_" + currentDate.format(DateTimeFormatter.ofPattern("MMddyyyy")) + ".txt")));
            } catch (FileNotFoundException e) {
                throw new FMDaoDataPersistException("Error, could not load file", e);
            }

            String currentLine;
            String[] currentTokens;
            String date = "9999-01-01";
            List<FMOrder> orders = new ArrayList<>();
            while (sc.hasNext()) {
                currentLine = sc.nextLine();
                currentTokens = currentLine.split(DELIMITER);

                FMOrder currentOrder = new FMOrder();

                date = currentTokens[0];

                String strOrderNumber = currentTokens[1];
                int orderNumber = Integer.parseInt(strOrderNumber);
                currentOrder.setOrderNumber(orderNumber);

                currentOrder.setCustomerName(currentTokens[2]);
                currentOrder.setState(currentTokens[3]);

                String strTaxRate = currentTokens[4];
                BigDecimal taxRate = new BigDecimal(strTaxRate);
                currentOrder.setTaxRate(taxRate);

                currentOrder.setMaterialType(currentTokens[5]);

                currentOrder.setStringArea(currentTokens[6]);

                String strArea = currentTokens[7];
                BigDecimal area = new BigDecimal(strArea);
                currentOrder.setArea(area);

                String strMatSqFt = currentTokens[8];
                BigDecimal matSqFt = new BigDecimal(strMatSqFt);
                currentOrder.setMaterialPerSqFt(matSqFt);

                String strLaborSqFt = currentTokens[9];
                BigDecimal laborSqFt = new BigDecimal(strLaborSqFt);
                currentOrder.setLaborPerSqFt(laborSqFt);

                String strMatTotal = currentTokens[10];
                BigDecimal mattotal = new BigDecimal(strMatTotal);
                currentOrder.setMaterialTotal(mattotal);

                String strLabTotal = currentTokens[11];
                BigDecimal labTotal = new BigDecimal(strLabTotal);
                currentOrder.setLaborTotal(labTotal);

                String strTaxTotal = currentTokens[12];
                BigDecimal taxTotal = new BigDecimal(strTaxTotal);
                currentOrder.setTaxTotal(taxTotal);

                String strTotal = currentTokens[13];
                BigDecimal total = new BigDecimal(strTotal);
                currentOrder.setTotal(total);

                orders.add(currentOrder);
            }
            LocalDate ld = LocalDate.parse(date);
            dateOrdersMap.put(ld, orders);

        }
        sc.close();
    }

    @Override
    public void commitChanges() throws FMDaoDataPersistException {
        //do nothing
    }

}
