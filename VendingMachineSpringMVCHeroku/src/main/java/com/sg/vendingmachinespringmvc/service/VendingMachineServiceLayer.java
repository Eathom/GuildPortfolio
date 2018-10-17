/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Lizz
 */
public interface VendingMachineServiceLayer {

    public String purchaseItem(int itemId, BigDecimal money) throws NoInventoryException, InsufficientFundsException;

    public Change returnChange(BigDecimal money, BigDecimal price);

    public Item getItemById(int itemId);

    public List<Item> getAllItems();
}
