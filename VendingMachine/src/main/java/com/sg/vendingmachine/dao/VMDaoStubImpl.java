/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VMItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lizz
 */
public class VMDaoStubImpl implements VMDao {
    //canned data of 1 and only item in hashmap to test service layer

    private Map<String, VMItem> itemsMap = new HashMap<>();
    VMItem only;

    public VMDaoStubImpl() {
        only = new VMItem("Chicas");
        only.setNumInStock(3);
        only.setPrice("8.00");
        itemsMap.put(only.getName(), only);

    }

    //purchase method
    @Override
    public VMItem buyItem(String itemName) {
        if (only.getName().equals(itemName)) {
            return only;
        } else {
            return null;
        }
    }

    @Override
    public List<VMItem> getAllItems() {
        return new ArrayList<VMItem>(itemsMap.values());
    }

    @Override
    public VMItem removeItem(String itemName) {
        if (only.getName().equals(itemName)) {
            return only;
        } else {
            return null;
        }
    }

    @Override
    public VMItem getItem(String itemName) {
        if (only.getName().equals(itemName)) {
            return only;
        } else {
            return null;
        }
    }

    @Override
    public VMItem addToItem(VMItem itemToAdd) {
        if (only.getName().equals(itemToAdd.getName())) {
            int currentNum = only.getNumInStock();
            int numToAdd = itemToAdd.getNumInStock();
            VMItem onlyUpdated = only;

            only.setNumInStock(numToAdd + currentNum);

            return onlyUpdated;
        } else {
            return only;
        }

    }

    @Override
    public VMItem addNewItem(VMItem itemToAdd) {
        if (only.getName().equals(itemToAdd.getName())) {
            return only;
        } else {
            return null;
        }
    }

}
