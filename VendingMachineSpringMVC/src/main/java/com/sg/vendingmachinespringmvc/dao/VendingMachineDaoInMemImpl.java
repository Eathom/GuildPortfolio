/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lizz
 */
public class VendingMachineDaoInMemImpl implements VendingMachineDao {

    private Map<Integer, Item> itemMap = new HashMap<>();

    public VendingMachineDaoInMemImpl() {
        Item shoelaces = new Item();
        shoelaces.setName("Shoelaces");
        shoelaces.setAmountInStock(14);
        shoelaces.setPrice(new BigDecimal("3.00"));
        shoelaces.setItemId(1);
        itemMap.put(1, shoelaces);

        Item bobblehead = new Item();
        bobblehead.setName("Bobblehead");
        bobblehead.setAmountInStock(4);
        bobblehead.setPrice(new BigDecimal("2.50"));
        bobblehead.setItemId(2);
        itemMap.put(2, bobblehead);

        Item sparkleSticker = new Item();
        sparkleSticker.setName("Sparkle Sticker");
        sparkleSticker.setAmountInStock(11);
        sparkleSticker.setPrice(new BigDecimal(".49"));
        sparkleSticker.setItemId(3);
        itemMap.put(3, sparkleSticker);

        Item pony = new Item();
        pony.setName("Pony");
        pony.setAmountInStock(2);
        pony.setPrice(new BigDecimal("1.75"));
        pony.setItemId(4);
        itemMap.put(4, pony);

        Item movieStub = new Item();
        movieStub.setName("Movie Stub");
        movieStub.setAmountInStock(0);
        movieStub.setPrice(new BigDecimal("1.85"));
        movieStub.setItemId(5);
        itemMap.put(5, movieStub);

        Item NightmareFoxy = new Item();
        NightmareFoxy.setName("Nightmare Foxy");
        NightmareFoxy.setAmountInStock(3);
        NightmareFoxy.setPrice(new BigDecimal("1.95"));
        NightmareFoxy.setItemId(6);
        itemMap.put(6, NightmareFoxy);

        Item lintRoller = new Item();
        lintRoller.setName("Lint Roller");
        lintRoller.setAmountInStock(9);
        lintRoller.setPrice(new BigDecimal("1.25"));
        lintRoller.setItemId(7);
        itemMap.put(7, lintRoller);

        Item virtualApple = new Item();
        virtualApple.setName("Virtual Apple");
        virtualApple.setAmountInStock(9);
        virtualApple.setPrice(new BigDecimal("2.10"));
        virtualApple.setItemId(8);
        itemMap.put(8, virtualApple);

        Item portalGun = new Item();
        portalGun.setName("Portal Gun");
        portalGun.setAmountInStock(5);
        portalGun.setPrice(new BigDecimal("1.25"));
        portalGun.setItemId(9);
        itemMap.put(9, portalGun);

    }

    @Override
    public Item purchaseItem(int itemId) {
        Item purchased = itemMap.get(itemId);
        int stockBeforePurchase = purchased.getAmountInStock();

        purchased.setAmountInStock(stockBeforePurchase - 1);

        return purchased;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>(itemMap.values());
        //sort items by their item number 
        itemList.sort(Comparator.comparing(Item::getItemId));
        return itemList;
    }

    @Override
    public Item getItemById(int itemId) {
        return itemMap.get(itemId);
    }

}
