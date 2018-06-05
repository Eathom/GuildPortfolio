/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineDao;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Lizz
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineDao dao;

    @Inject
    public VendingMachineServiceLayerImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public String purchaseItem(int itemId, BigDecimal money) throws NoInventoryException, InsufficientFundsException {
        Item item = dao.getItemById(itemId);
        if (item == null) {
            throw new NoInventoryException("This item does not exist");
        } else if (item.getAmountInStock() <= 0) {
            throw new NoInventoryException("Out of stock");
        }

        BigDecimal price = item.getPrice();
        if (money.compareTo(price) >= 0) {
            dao.purchaseItem(itemId);

        } else {
            BigDecimal difference = item.getPrice().subtract(money);
            throw new InsufficientFundsException("Please insert $" + difference.toString() + ".");
        }

        return "Thank you!";

    }

    @Override
    public Change returnChange(BigDecimal money, BigDecimal price) {

        BigDecimal initChange = money.subtract(price);
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

        Change changeToReturn = new Change();

        changeToReturn.setQuarter(quarters);

        changeToReturn.setDime(dimes);

        changeToReturn.setNickel(nickels);

        changeToReturn.setPenny(pennies);

        return changeToReturn;
    }

    @Override
    public Item getItemById(int itemId) {
        return dao.getItemById(itemId);
    }

    @Override
    public List<Item> getAllItems() {
        return dao.getAllItems();
    }

}
