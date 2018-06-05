/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.ui.VMInputFormatException;
import com.sg.vendingmachine.dao.VMDaoDataPersistException;
import com.sg.vendingmachine.dto.VMChange;
import com.sg.vendingmachine.dto.VMItem;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Lizz
 */
public interface VMServiceLayer {
    //business logic, is there enough money?
    //is there any in inventory
    //possible calculating of currancy

    VMChange buyItem(String itemName, BigDecimal monies) throws VMInsuffFundsException, VMDaoDataPersistException, VMNoItemInvException;

    List<VMItem> getAllItems();

    VMItem removeItems(String itemName) throws VMDaoDataPersistException, VMNoItemInvException;

    int addItem(VMItem item) throws VMDaoDataPersistException, VMDataValidationException, VMInputFormatException;

    VMChange calcChange(BigDecimal monies, BigDecimal Price);

    VMItem getItem(String itemName) throws VMNoItemInvException;

    String addToMoney(BigDecimal money);

    BigDecimal getCurrentMoney();

}
