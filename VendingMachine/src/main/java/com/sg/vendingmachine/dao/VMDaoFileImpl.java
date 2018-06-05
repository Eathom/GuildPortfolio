/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.VMItem;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Lizz
 */
public class VMDaoFileImpl implements VMDao {
    //hashmap of itemsMap

    private Map<String, VMItem> itemsMap = new HashMap<>();

    public static final String VENDING_FILE = "vendingFile.txt";
    public static final String DELIMITER = "::";

    public VMDaoFileImpl() throws VMDaoDataPersistException {
        //this constructs a new fileImpl that loads the txt file
        loadFile();

    }

    @Override
    public VMItem buyItem(String itemName) throws VMDaoDataPersistException {
        VMItem itemToBuy = itemsMap.get(itemName);

        int newNumOf = (itemToBuy.getNumInStock() - 1);
        updateItemStock(itemName, newNumOf);

        writeFile();
        return itemToBuy;
    }

    @Override
    public List<VMItem> getAllItems() {
        return new ArrayList<VMItem>(itemsMap.values());
    }

    @Override
    public VMItem removeItem(String itemName) throws VMDaoDataPersistException {
        VMItem toRemove = itemsMap.get(itemName);

        itemsMap.remove(toRemove.getName());

        writeFile();
        return toRemove;
    }

    @Override
    public VMItem addToItem(VMItem itemToAdd) throws VMDaoDataPersistException {
        VMItem itemInMap = itemsMap.get(itemToAdd.getName());

        int calcNumOf = itemInMap.getNumInStock() + itemToAdd.getNumInStock();

        updateItemStock(itemToAdd.getName(), calcNumOf);
        writeFile();
        return itemToAdd;
    }

    @Override
    public VMItem addNewItem(VMItem itemToAdd) throws VMDaoDataPersistException {

        itemsMap.put(itemToAdd.getName(), itemToAdd);
        writeFile();
        return itemToAdd;
    }

    @Override
    public VMItem getItem(String itemName) {
        VMItem item = itemsMap.get(itemName);
        return item;
    }

    private int updateItemStock(String itemName, int calcdNumOf) {
        VMItem item = itemsMap.get(itemName);
        item.setNumInStock(calcdNumOf);

        itemsMap.replace(itemName, item);
        return itemsMap.get(itemName).getNumInStock();
    }

    //----------------DATA PERSISTANCE METHODS ----------------------------------//
    private void loadFile() throws VMDaoDataPersistException {
        Scanner sc;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(VENDING_FILE)));
        } catch (FileNotFoundException e) {
            throw new VMDaoDataPersistException("error", e);

        }
        String currentLine;
        String[] currentTokens;

        while (sc.hasNext()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            VMItem current = new VMItem(currentTokens[0]);
            int numOf = Integer.parseInt(currentTokens[1]);
            current.setNumInStock(numOf);
            current.setPrice(currentTokens[2]);

            itemsMap.put(current.getName(), current);

        }
        sc.close();
    }

    private void writeFile() throws VMDaoDataPersistException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(VENDING_FILE));
        } catch (IOException e) {
            throw new VMDaoDataPersistException("No file to save to", e);
        }

        List<VMItem> list = this.getAllItems();
// used for loop because didn't know how to flush forEach stream
        for (VMItem i : list) {
            out.println(i.getName()
                    + DELIMITER
                    + String.valueOf(i.getNumInStock())
                    + DELIMITER
                    + i.getPrice().toString());

            out.flush();
        }
        out.close();

    }
}
