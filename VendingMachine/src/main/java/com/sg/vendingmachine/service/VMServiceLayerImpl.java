/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VMDao;
import com.sg.vendingmachine.dao.VMDaoDataPersistException;
import com.sg.vendingmachine.dto.VMChange;
import com.sg.vendingmachine.dto.VMItem;
import com.sg.vendingmachine.dto.VMMoneyInMachine;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Lizz
 */
public class VMServiceLayerImpl implements VMServiceLayer {

    private VMDao dao;
    private VMMoneyInMachine moneyInMachine = new VMMoneyInMachine();

    public VMServiceLayerImpl(VMDao dao) {
        this.dao = dao;

    }

    @Override
    public VMChange buyItem(String itemName, BigDecimal monies)
            throws VMInsuffFundsException,
            VMDaoDataPersistException,
            VMNoItemInvException {

        VMItem itemToBuy = dao.getItem(itemName);

        //right now, impossible to try to buy an item that doesn't exist due to only giving user number options of what is in dao.
        if (itemToBuy == null) {
            throw new VMNoItemInvException("No item exists in vending machine.");
        } else if ((itemToBuy.getNumInStock() == 0)) {

            throw new VMNoItemInvException("Out of stock!!");
        } else {
            BigDecimal price = itemToBuy.getPrice();

            if (monies.compareTo(price) >= 0) {

                dao.buyItem(itemName);
                resetMoney();
                //audit.writeAudit(itemName + " purchased. ");
                return calcChange(monies, price);

            } else {
                throw new VMInsuffFundsException("Not enough funds added, empty those pocketeses.");

            }

        }
    }

    @Override
    public List<VMItem> getAllItems() {
        return dao.getAllItems();
    }

    @Override
    public VMItem removeItems(String itemName)
            throws VMDaoDataPersistException,
            VMNoItemInvException {

        VMItem found = dao.getItem(itemName);

        if (found != null) {
            dao.removeItem(itemName);
            //audit.writeAudit(itemName + " removed.");
            return found;
        } else {
            throw new VMNoItemInvException("No item exists to remove.");
        }
    }

    @Override
    public int addItem(VMItem item) throws
            VMDaoDataPersistException,
            VMDataValidationException {
        //if item  to add not in inventory, add it as new key-value. if item is there, update the numberOf.

        validateItem(item);

        VMItem found = dao.getItem(item.getName());

        if (found == null) {

            dao.addNewItem(item);
            // audit.writeAudit(item.getName() + " added.");
            return item.getNumInStock();
        } else {
            //if item exists in inventory
            dao.addToItem(item);
            // audit.writeAudit(item.getName() + " added.");
            return dao.getItem(item.getName()).getNumInStock();

        }

    }

    @Override
    public VMChange calcChange(BigDecimal monies, BigDecimal price) {

        BigDecimal initChange = monies.subtract(price);
        BigDecimal hundred = new BigDecimal("100");
        BigDecimal calcChange = initChange.multiply(hundred);
        BigDecimal formatChange = calcChange.setScale(0);

        String strChange = formatChange.toString();
        Integer change = Integer.parseInt(strChange);

        Integer quarters = 0;
        Integer dimes = 0;
        Integer nickels = 0;
        Integer pennies = 0;
        Integer remainder = 0;

        if ((change / 25) >= 1) {
            quarters = change / 25;
            remainder = change % 25;

            if ((remainder / 10) >= 1) {
                dimes = remainder / 10;
                remainder = remainder % 10;

            }
            if ((remainder / 5) >= 1) {
                nickels = remainder / 5;
                remainder = remainder % 5;
            }

        } else if ((change / 10) >= 1) {
            dimes = change / 10;
            remainder = change % 10;

            if ((remainder / 5) >= 1) {
                nickels = remainder / 5;
                remainder = remainder % 5;
            }

        } else if ((change / 5) >= 1) {
            nickels = change / 5;
            remainder = change % 5;

        } else {
            remainder = change;
        }

        pennies = remainder;

        VMChange changeToReturn = new VMChange();

        changeToReturn.setQuarter(quarters);

        changeToReturn.setDime(dimes);

        changeToReturn.setNickel(nickels);

        changeToReturn.setPenny(pennies);

        return changeToReturn;
    }

    @Override
    public VMItem getItem(String itemName) throws VMNoItemInvException {
        VMItem found = dao.getItem(itemName);

        if (found != null) {
            return found;
        } else {
            throw new VMNoItemInvException("No item exists.");
        }
    }

    private void validateItem(VMItem item)
            throws VMDataValidationException {

        Integer numInStock = item.getNumInStock();
        BigDecimal price = new BigDecimal("0");
        price = item.getPrice();
        String strPrice = price.toString();

        if (item.getName() == null
                || item.getName().trim().length() == 0
                || numInStock == null
                || numInStock == 0
                || strPrice == null
                || strPrice.trim().length() == 0
                || strPrice == "0") {

            throw new VMDataValidationException("All fields are required and cannot be zero.");

        }

    }

    @Override
    public String addToMoney(BigDecimal money) {

        BigDecimal currentMoney = moneyInMachine.getMoneyInMachine();
        BigDecimal newMoney = money;

        BigDecimal total = currentMoney.add(newMoney);
        String strTotal = total.toString();
        moneyInMachine.setMoneyIn(strTotal);

        return moneyInMachine.getMoneyInMachine()
                .toString();
    }

    private void resetMoney() {
        String reset = "0";
        moneyInMachine.setMoneyIn(reset);
    }

    @Override
    public BigDecimal getCurrentMoney() {
        return moneyInMachine.getMoneyInMachine();
    }

}
