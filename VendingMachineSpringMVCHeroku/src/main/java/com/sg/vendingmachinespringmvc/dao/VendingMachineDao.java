/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.util.List;

/**
 *
 * @author Lizz
 */
public interface VendingMachineDao {

    public Item purchaseItem(int itemId);

    public Item getItemById(int itemId);

    public List<Item> getAllItems();

}
