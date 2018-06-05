/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.FMDaoDataPersistException;
import com.sg.flooringmastery.ui.FMInputFormatException;
import com.sg.flooringmastery.ui.FMView;
import com.sg.flooringmastery.dto.FMOrder;
import com.sg.flooringmastery.enums.FMMenuSelection;
import com.sg.flooringmastery.service.FMServiceLayer;
import com.sg.flooringmastery.service.FMInvalidPropertyException;
import com.sg.flooringmastery.service.FMMissingPropertyException;
import com.sg.flooringmastery.service.FMNoOrderExistsException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Lizz
 */
public class FMController {

    FMView view;
    FMServiceLayer service;

    public FMController(FMView view, FMServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void execute() {
        FMMenuSelection menuSelection = FMMenuSelection.NOTSET;
        boolean menuInputHasErrors = false;

        do {
            try {
                menuSelection = getMainMenuSelection();
                menuInputHasErrors = false;

                switch (menuSelection) {
                    case DISPLAY:
                        displayOrders();
                        break;
                    case ADD:
                        addOrder();
                        break;
                    case EDIT:
                        editOrder();
                        break;
                    case REMOVE:
                        removeOrder();
                        break;
                    case SAVE:
                        save();
                        break;
                    case QUIT:
                        quit();
                        break;
                }

            } catch (FMInputFormatException | FMNoOrderExistsException | FMInvalidPropertyException | FMMissingPropertyException e) {
                view.displayError(e);
                menuInputHasErrors = true;
            } catch (FMDaoDataPersistException e) {
                view.displayError(e);
                //menu does "have errors" but want to end loop, cannot recover from data persist exception.
                menuInputHasErrors = false;
            }
        } while (menuInputHasErrors || FMMenuSelection.QUIT != menuSelection);
    }

    private FMMenuSelection getMainMenuSelection() throws FMInputFormatException {
        return view.getMenuSelection();
    }

    private void displayOrders() throws FMNoOrderExistsException, FMDaoDataPersistException {
        view.displayOrdersBanner();

        LocalDate date = view.getOrderDate();
        List<FMOrder> ordersOnDate = service.getOrdersOnDate(date);
        view.displayOrders(date, ordersOnDate);
    }

    private void addOrder() throws FMInputFormatException, FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException {
        view.displayAddOrderBanner();
        LocalDate orderDate = view.getOrderDate();
        FMOrder newOrder = view.getNewOrder();
        FMOrder calculatedOrder = null;

        //User gets one try to edit bad order.
        try {
            calculatedOrder = service.calculateNewOrder(orderDate, newOrder);

        } catch (FMMissingPropertyException | FMInvalidPropertyException e) {
            view.displayError(e);

            FMOrder correctedOrder = view.getOrderEdits(newOrder);
            calculatedOrder = service.correctBadOrder(orderDate, newOrder, correctedOrder);

        }

        String commitChoice = view.getNewOrderCommit(calculatedOrder);

        if (commitChoice.equalsIgnoreCase("y") || commitChoice.equalsIgnoreCase("yes")) {
            service.addOrder(orderDate, calculatedOrder);
            view.displayAddOrderSuccess();
        } else {
            view.displayAddOrderCancelled();
        }

    }

    private void editOrder() throws FMNoOrderExistsException, FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException {
        view.displayEditOrderBanner();
        LocalDate date = view.getOrderDate();
        int orderNumber = view.getOrderNumber();
        FMOrder originalOrder = service.getOrder(date, orderNumber);
        FMOrder orderWithEdits = view.getOrderEdits(originalOrder);
        service.editOrder(date, originalOrder, orderWithEdits);

        view.displayEditSuccess();
    }

    private void removeOrder() throws FMNoOrderExistsException, FMDaoDataPersistException {
        view.displayRemoveOrderBanner();
        LocalDate date = view.getOrderDate();
        int orderNumber = view.getOrderNumber();
        FMOrder toRemove = service.getOrder(date, orderNumber);
        String confirmRemove = view.confirmRemove(toRemove);

        if (confirmRemove.equalsIgnoreCase("y") || confirmRemove.equalsIgnoreCase("yes")) {
            FMOrder removed = service.removeOrder(date, orderNumber);
            view.displayRemoveSuccess();
        } else {
            view.displayRemoveCancelled();
        }
    }

    private void save() throws FMDaoDataPersistException {
        view.displayCommitBanner();
        //view's general vs new order commit - new order prints an order passed to it.
        String commitChoice = view.getGeneralCommit();

        if (commitChoice.equalsIgnoreCase("y") || commitChoice.equalsIgnoreCase("yes")) {
            service.commitChanges();
            view.displayCommitSuccessBanner();
        }

    }

    private void quit() throws FMDaoDataPersistException {
        service.commitChanges();
        view.displayGoodbye();
    }
}
