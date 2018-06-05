/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.FMOrder;
import com.sg.flooringmastery.enums.FMMenuSelection;
import com.sg.flooringmastery.enums.FMModeSelection;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Lizz
 */
public class FMView {

    FMUserIO io;

    public FMView(FMUserIO io) {
        this.io = io;
    }

    public void displayError(Throwable e) {
        io.print("==Error== \n" + e.getMessage());
        enterToContinue();
    }

    private String enterToContinue() {
        return io.readString("\nPress enter to continue.");
    }

    public FMModeSelection getModeSelection() throws FMInputFormatException {
        io.print("Mode Selection");
        int intMode = io.readInt("1. Training Mode \n2. Production Mode", 1, 2);
        FMModeSelection selection = FMModeSelection.getMode(intMode);
        return selection;
    }

    public FMMenuSelection getMenuSelection() throws FMInputFormatException {
        io.print("<<Flooring Program>>");
        int selection = io.readInt("1.Display Order \n2.Add an Order \n3.Edit an Order \n4.Remove an Order \n5.Save Current Work \n6.Quit", 1, 6);
        FMMenuSelection menuSelection = FMMenuSelection.getMenuChoice(selection);
        return menuSelection;

    }

    //------------------DISPLAY ORDERS--------------------------------------//
    public void displayOrdersBanner() {
        io.print("  .-=-. Display Orders .-=-.  ");
    }

    public LocalDate getOrderDate() {

        //view is handling local date parse exception instead of controller
        //for user friendliness
        boolean hasErrors = false;
        LocalDate date = LocalDate.parse("9999-01-01");

        do {

            try {
                date = io.readDate("Enter a date: mm/dd/yyyy");
                hasErrors = false;

            } catch (FMInputFormatException e) {
                displayError(e);
                hasErrors = true;
            }
        } while (hasErrors);
        return date;
    }

    public String displayOrders(LocalDate date, List<FMOrder> ordersOnDate) {
        io.print("Orders on date: " + date.toString());
        ordersOnDate.stream()
                .forEach(o -> printOrderProperties(o));
        return enterToContinue();
    }

    //------------------ADD ORDER--------------------------------------//
    public void displayAddOrderBanner() {
        io.print(".-=-. Add an Order .-=-.");
    }

    public FMOrder getNewOrder() {

        String customerName = io.readString("Enter customer's name.");
        String state = io.readString("Enter state: OH, PA, MI or IN.");
        String materialType = io.readString("Enter material choice: Carpet, Tile, Laminate, or Wood.");
        String area = io.readString("Enter area.");

        FMOrder newOrder = new FMOrder();
        newOrder.setCustomerName(customerName);
        newOrder.setState(state);
        newOrder.setMaterialType(materialType);
        newOrder.setStringArea(area);

        return newOrder;

    }

    public String getNewOrderCommit(FMOrder newOrder) {
        printOrderProperties(newOrder);
        return io.readString("Do you want to save your work? (Y/N)");
    }

    public String displayAddOrderSuccess() {
        io.print(" .-=-. Order successfully added .-=-.");
        return enterToContinue();
    }

    public String displayAddOrderCancelled() {
        io.print(" .-=-.  Order cancelled. -=-.");
        return enterToContinue();
    }

    public String displayCorrectOrder() {
        return io.readString(" .-=-. Please correct your order .-=-. ");
    }

    //------------------EDIT ORDER--------------------------------------//
    public void displayEditOrderBanner() {
        io.print(".-=-. Edit an Order .-=-.");
    }

    //controller reuses getOrderDate here
    public int getOrderNumber() {
        boolean hasErrors = false;
        int number = 0;
        do {
            try {
                number = io.readInt("Enter order number:");
                hasErrors = false;
            } catch (FMInputFormatException e) {
                displayError(e);
                hasErrors = true;
            }
        } while (hasErrors);
        return number;
    }

    public FMOrder getOrderEdits(FMOrder orderToEdit) {
        io.print("Order number: " + orderToEdit.getOrderNumber());

        String newName = io.readString("Enter customer name (" + orderToEdit.getCustomerName() + "):");
        String newState = io.readString("Enter state (" + orderToEdit.getState() + "):");
        String newMaterial = io.readString("Enter material type (" + orderToEdit.getMaterialType() + "):");
        String newArea = io.readString("Enter area (" + orderToEdit.getStringArea() + "):");

        FMOrder orderWithEdits = new FMOrder();
        orderWithEdits.setCustomerName(newName);
        orderWithEdits.setState(newState);
        orderWithEdits.setMaterialType(newMaterial);
        orderWithEdits.setStringArea(newArea);

        return orderWithEdits;
    }

    public String displayEditSuccess() {
        io.print(" .-=-. Order successfully edited .-=-.");
        return enterToContinue();
    }

    //------------------REMOVE ORDER--------------------------------------//
    public void displayRemoveOrderBanner() {
        io.print(".-=-. Remove an Order .-=-.");
    }

    public String confirmRemove(FMOrder order) {
        printOrderProperties(order);
        return io.readString("Do you want to continue with removal? (Y/N)");
    }

    public String displayRemoveCancelled() {
        io.print(".-=-. Remove an Order CANCELLED .-=-.");
        return enterToContinue();
    }

    public String displayRemoveSuccess() {
        io.print(".-=-. Order successfully removed .-=-.");
        return enterToContinue();
    }

    //------------------SAVE WORK--------------------------------------//
    public void displayCommitBanner() {
        io.print(".-=-. Save .-=-.");
    }

    public String getGeneralCommit() {
        return io.readString("Would you like to save your work? (Y/N)");
    }

    public String displayCommitSuccessBanner() {
        io.print(".-=-. Changes successfully saved .-=-.");
        return enterToContinue();
    }
//----------------- goodbye---------------------------------------------------//

    public void displayGoodbye() {
        io.print(".-=-. Goodbye .-=-.");
    }

    private void printOrderProperties(FMOrder order) {
        io.print(
                "Order No: " + order.getOrderNumber()
                + "\n Name: " + order.getCustomerName()
                + "\n State: " + order.getState()
                + "\n Tax Rate: %" + order.getTaxRate()
                + "\n Material: " + order.getMaterialType()
                + "\n Area: " + order.getArea()
                + "\n Material/sq ft $" + order.getMaterialPerSqFt()
                + "\n Labor/sq ft: $" + order.getLaborPerSqFt()
                + "\n Material total: $" + order.getMaterialTotal()
                + "\n Labor total: $" + order.getLaborTotal()
                + "\n Tax Total: $" + order.getTaxTotal()
                + "\n Total: $" + order.getTotal() + "\n");
    }
}
