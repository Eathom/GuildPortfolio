/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VMItem;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Lizz
 */
public interface VMDao {

    //method to purchase from hashmap of items
    /**
     *
     * @param item replace(K key, V value) Replaces the entry for the specified
     * key only if it is currently mapped to some value.
     */
    VMItem buyItem(String itemName) throws VMDaoDataPersistException;

    List<VMItem> getAllItems();

    VMItem removeItem(String itemName) throws VMDaoDataPersistException;

    VMItem addToItem(VMItem item) throws VMDaoDataPersistException;

    VMItem getItem(String itemName);

    VMItem addNewItem(VMItem itemToAdd) throws VMDaoDataPersistException;
}
