/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.VMChange;
import com.sg.vendingmachine.dto.VMItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizz
 */
public class VMView {

    //display menu, banners, get info for service layer
    private VMUserIO io;

    public VMView(VMUserIO io) {
        this.io = io;
    }

    private String enterToCont() {
        return io.readString("Press enter to continue.");
    }

    public String displayMainMenu() {
        io.print("*******Welcome!!!!******");
        io.print("Freddy's Vending Machine");
        return io.readString("Input [1] to continue, [2] to exit, or input [password] / abc.");
    }

    public BigDecimal displayUserMenuItemsGetMoney(List<VMItem> items, BigDecimal previous) throws VMInputFormatException {

        io.print("Shopping Menu - Freddy's Vending Machine \n");
        items.stream()
                .forEach(i -> io.print(i.getName()
                + "\n    In stock: " + String.valueOf(i.getNumInStock()
                        + "  Price: $" + i.getPrice().toString())));
        io.print("\n Current money in: $" + previous);

        return io.readBigDec("Put in your money: \n $");

    }

    public String displayErrorMsg(String error) {
        io.print("== ERROR ==");
        io.print(error);
        return enterToCont();
    }

    public void displayExitBanner() {
        io.print("Thank you for visiting. Please wipe your fingerprints off my buttons.");
    }

    //------------------ area 52 ---------------------------------------------//
    public int displaySecretMenu() throws VMInputFormatException {
        io.print("TOP SECRET - AREA 52  \n Update Inventory Menu");
        return io.readInt("1. ADD to inventory \n2. VIEW inventory \n3. REMOVE from inventory \n4. RETURN to main");
    }

    public VMItem getItemToAdd() throws VMInputFormatException {
        String name = io.readString("Enter name of item to sell.");

        int numberOf = io.readInt("Enter # of items to add.");
        String price = io.readString("Enter price");
        VMItem toAdd = new VMItem(name);
        toAdd.setNumInStock(numberOf);
        toAdd.setPrice(price);

        return toAdd;

    }
//-------------------------Add ---------------------------------------------------------------------

    public void displayAddBanner() {
        io.print("Add Something to Inventory");
    }

    public String displayAddSuccess(VMItem item) {
        String num = String.valueOf(item.getNumInStock());
        String price = item.getPrice().toString();
        io.print(item.getName() + " " + num + " " + price);
        io.print("~~~Successfully added to inventory~~");
        return enterToCont();
    }
//-----------------------------------------------------------------------------------------------------------

    public String displayAllItems(List<VMItem> list) {
        io.print("Inventory List:");
        list.stream()
                .forEach(i -> System.out.println(i.getName() + " " + i.getNumInStock() + " " + i.getPrice()));
        return enterToCont();
    }
// ---------------------------------- Remove ----------------------------------------------

    public String removeItem() {
        return io.readString("Enter the name of the item to remove all of those items from inventory.");
    }

    public void displayRemoveItemBanner() {
        io.print("Remove Something from Inventory");
    }

    public String displayRemoveItemSuccess() {
        io.print("~~~~~Successfully removed ~~~~~~~~");
        return enterToCont();
    }

    //------------------------------------------------------------------
    public VMItem getItemSelectn(ArrayList<VMItem> items) throws VMInputFormatException {

        int menuNum = 1;
        for (VMItem i : items) {
            io.print((menuNum) + ". " + i.getName());
            menuNum++;
        }
        io.print((menuNum) + ". EXIT");

        int selection = io.readInt("Enter a number to purchase.", 1, menuNum);

        try {
            return items.get(selection - 1);

        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public String printChange(VMChange change) {

        if (change.getQuarter() == 0
                && change.getDime() == 0
                && change.getNickel() == 0
                && change.getPenny() == 0) {
            io.print("    No change returned.");
        } else {
            io.print("Please take your change: ");
            io.print(change.getQuarter() + " quarter(s), "
                    + change.getDime() + " dime(s), "
                    + change.getNickel() + " nickel(s,)"
                    + change.getPenny() + " pennies.");

        }
        return enterToCont();
    }

    public String printExitWithMoney(BigDecimal previous) {
        io.print("I'm keeping your $" + previous.toString() + "!");
        return enterToCont();
    }

    public void displayPurchaseSuccessBanner(VMItem purchased) {
        io.print("~~~~~~Purchase successful~~~~~~~~");
        io.print("Enjoy your " + purchased.getName() + "!!!");

    }

}
