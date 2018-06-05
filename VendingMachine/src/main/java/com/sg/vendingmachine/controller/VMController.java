/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VMDaoDataPersistException;
import com.sg.vendingmachine.dto.VMChange;
import com.sg.vendingmachine.dto.VMItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.sg.vendingmachine.service.VMDataValidationException;
import com.sg.vendingmachine.service.VMInsuffFundsException;
import com.sg.vendingmachine.service.VMNoItemInvException;
import com.sg.vendingmachine.service.VMServiceLayer;
import com.sg.vendingmachine.ui.VMInputFormatException;
import com.sg.vendingmachine.ui.VMView;

/**
 *
 * @author Lizz
 */
public class VMController {

    private VMView view;
    private VMServiceLayer service;

    public VMController(VMView view, VMServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    //--------------------- MAIN MENU ------------------------------------------------//
    public void run() {
        String menuSel;

        //boolean to keep menu appearing while user inputs wrong String.
        //would be more efficient to make menu options ints, and use io's method to read int inside range
        //but wanted to do a string password function. ???  maybe will work as usual. when done/break; in "sub menu" will return to this.
        boolean keepGoing = true;

        while (keepGoing) {
            menuSel = view.displayMainMenu();
            switch (menuSel) {
                case "1":
                    userPanel();
                    break;
                case "2":
                    keepGoing = false;
                    break;
                case "abc":
                    secretMenu();
                    break;
                default:
                    view.displayErrorMsg("Unknown command");
                    break;
            }
        }
        view.displayExitBanner();

    }

    //---------------------------SECRET MENU------------------------------------------------------------//
    private void secretMenu() {

        int ownerSelectn = 0;
        boolean hasErrors = false;
        boolean keepGoing = true;
        do {
            try {
                ownerSelectn = view.displaySecretMenu();
                hasErrors = false;

                switch (ownerSelectn) {
                    case 1:
                        addItem();
                        break;

                    case 2:
                        listAll();
                        break;
                    case 3:
                        removeItem();
                        break;
                    case 4:
                        hasErrors = false;
                        keepGoing = false;

                        // run(); - not necesary, main menu is still open and set to keepGoing
                        break;
                }
            } catch (VMInputFormatException e) {
                hasErrors = true;
                view.displayErrorMsg(e.getMessage());
            }

        } while (hasErrors || keepGoing);
    }

    //----------------------------- USER MENU----------------------------------------------------//
    private void userPanel() {

        boolean hasErrors = false;

        VMChange change;

        List<VMItem> allItems = service.getAllItems();
        ArrayList<VMItem> orderedItems = new ArrayList<>(allItems);
        do {

            try {

                BigDecimal moneyFromConsumer = view.displayUserMenuItemsGetMoney(allItems, service.getCurrentMoney());

                service.addToMoney(moneyFromConsumer);
                VMItem itemSelected = view.getItemSelectn(orderedItems);
                //because of EXIT option, itemSelected could return null. It is controller because has to do with exiting/flow of program vs an exception.

                if (itemSelected == null) {

                    view.printExitWithMoney(service.getCurrentMoney());
                    hasErrors = false;

                } else {

                    change = service.buyItem(itemSelected.getName(), service.getCurrentMoney());
                    hasErrors = false;

                    view.displayPurchaseSuccessBanner(itemSelected);
                    view.printChange(change);

                }

            } catch (VMDaoDataPersistException | VMNoItemInvException | VMInsuffFundsException | VMInputFormatException e) {
                hasErrors = true;
                view.displayErrorMsg(e.getMessage());
            }

        } while (hasErrors);
    }
//-------------------------------------------------------------------------------------------------------------------

    private void addItem() {
        view.displayAddBanner();

        try {
            VMItem itemToAdd = view.getItemToAdd();

            service.addItem(itemToAdd);

            view.displayAddSuccess(itemToAdd);

        } catch (VMInputFormatException | VMDaoDataPersistException | VMDataValidationException e) {

            view.displayErrorMsg(e.getMessage());
        }

    }

    private void listAll() {
        List<VMItem> list = service.getAllItems();
        view.displayAllItems(list);

    }

    private void removeItem() {

        view.displayRemoveItemBanner();

        String mapKey = view.removeItem();
        try {
            service.removeItems(mapKey);
            view.displayRemoveItemSuccess();

        } catch (VMDaoDataPersistException | VMNoItemInvException e) {

            view.displayErrorMsg(e.getMessage());
        }

    }
}
