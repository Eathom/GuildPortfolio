/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.model.InputFormObject;
import com.sg.vendingmachinespringmvc.service.InsufficientFundsException;
import com.sg.vendingmachinespringmvc.service.NoInventoryException;
import com.sg.vendingmachinespringmvc.service.VendingMachineServiceLayer;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Lizz
 */
@Controller
public class VendingMachineController {

    VendingMachineServiceLayer service;

    @Inject
    public VendingMachineController(VendingMachineServiceLayer service) {
        this.service = service;
    }

    //takes in request from landing page, returns a model; returns model attribute to page.
    @RequestMapping(value = "/displayVendingItems", method = RequestMethod.GET)
    public String displayVendingItems(HttpServletRequest request, Model model, @ModelAttribute("inputFormObject") InputFormObject input) {

        List<Item> itemList = service.getAllItems();
        model.addAttribute("itemList", itemList);

        return "vendingMachine";
    }

    // this link -GET is not grabbing the modelAttribute from the form-- it is not a post, the total is passed on link's request
    @RequestMapping(value = "/selectItem", method = RequestMethod.GET)
    public String selectItem(HttpServletRequest request, RedirectAttributes redirect) {
        //Get information about item
        String id = request.getParameter("itemId");
        String total = request.getParameter("total");

        if (total.length() > 0) {
            //Create new form object to redirect if a total has been input on form

            InputFormObject input = new InputFormObject();
            BigDecimal bdTotal = new BigDecimal(total);
            input.setTotal(bdTotal);

            redirect.addFlashAttribute("inputFormObject", input);
        }

        int itemId = Integer.parseInt(id);
        Item item = service.getItemById(itemId);
        //the item object is redirected, to be grabbed by the EL on jsp, displayed in a path=itemSelected input.
        redirect.addFlashAttribute("item", item);

        return "redirect:displayVendingItems";
    }

    //form action is submitForm - each button has a name parameter to distinguish endpoint.  
    @RequestMapping(value = "/submitForm", params = "addDollar", method = RequestMethod.POST)
    public String submitDollar(@ModelAttribute("inputFormObject") InputFormObject input, RedirectAttributes redirect) {

        BigDecimal total = checkAndSetTotal(input.getTotal());
        BigDecimal dollar = new BigDecimal("1.00");

        BigDecimal newTotal = total.add(dollar);
        input.setTotal(newTotal);
        redirect.addFlashAttribute("inputFormObject", input);

        return "redirect:displayVendingItems";
    }

    @RequestMapping(value = "/submitForm", params = "addQuarter", method = RequestMethod.POST)
    public String submitQuarter(@ModelAttribute("inputFormObject") InputFormObject input, RedirectAttributes redirect) {
        BigDecimal total = checkAndSetTotal(input.getTotal());
        BigDecimal quarter = new BigDecimal("0.25");

        BigDecimal newTotal = total.add(quarter);
        input.setTotal(newTotal);
        redirect.addFlashAttribute("inputFormObject", input);

        return "redirect:displayVendingItems";
    }

    @RequestMapping(value = "/submitForm", params = "addDime", method = RequestMethod.POST)
    public String submitDime(@ModelAttribute("inputFormObject") InputFormObject input, RedirectAttributes redirect) {
        BigDecimal total = checkAndSetTotal(input.getTotal());
        BigDecimal dime = new BigDecimal("0.10");

        BigDecimal newTotal = total.add(dime);
        input.setTotal(newTotal);
        redirect.addFlashAttribute("inputFormObject", input);

        return "redirect:displayVendingItems";
    }

    @RequestMapping(value = "/submitForm", params = "addNickel", method = RequestMethod.POST)
    public String submitNickel(@ModelAttribute("inputFormObject") InputFormObject input, RedirectAttributes redirect) {
        BigDecimal total = checkAndSetTotal(input.getTotal());
        BigDecimal nickel = new BigDecimal("0.05");

        BigDecimal newTotal = total.add(nickel);
        input.setTotal(newTotal);
        redirect.addFlashAttribute("inputFormObject", input);

        return "redirect:displayVendingItems";
    }

    @RequestMapping(value = "/submitForm", params = "makePurchase", method = RequestMethod.POST)
    public String makePurchase(@ModelAttribute("inputFormObject") @Valid InputFormObject input, BindingResult result, Model model, RedirectAttributes redirect) {
        //check bindingResult from form validation
        if (result.hasErrors()) {

            //method is not a successful post, returned jsp, vs redirect.
            List<Item> itemList = service.getAllItems();

            model.addAttribute("InputFormObject", input);
            model.addAttribute("itemList", itemList);
            return "vendingMachine";

        }

        String id = input.getItemSelectedIdString();
        int itemId = Integer.parseInt(id);
        Item toBuy = service.getItemById(itemId);
        String message;
        BigDecimal money = input.getTotal();

        try {
            message = service.purchaseItem(itemId, money);
            Change change = calculateChange(money, toBuy.getPrice());
            input.setChange(change.toString());
            input.setTotal(BigDecimal.ZERO);

        } catch (InsufficientFundsException | NoInventoryException e) {
            message = e.getMessage();
            //display exception to message
        }

        input.setMessage(message);

        redirect.addFlashAttribute("inputFormObject", input);
        return "redirect:displayVendingItems";

    }

    @RequestMapping(value = "/submitForm", params = "returnChange", method = RequestMethod.POST)
    public String returnChange(@ModelAttribute("inputFormObject") InputFormObject input, RedirectAttributes redirect) {
        BigDecimal total = input.getTotal();
        int difference = total.compareTo(BigDecimal.ZERO);

        if (difference >= 1) {
            //clear out form inputs by creating new object with only change set.
            InputFormObject inputToReturn = new InputFormObject();
            Change toReturn = calculateChange(input.getTotal(), BigDecimal.ZERO);
            inputToReturn.setChange(toReturn.toString());

            redirect.addFlashAttribute("inputFormObject", inputToReturn);
        }
        return "redirect:displayVendingItems";
    }

    private Change calculateChange(BigDecimal money, BigDecimal cost) {
        Change toReturn = service.returnChange(money, cost);
        return toReturn;
    }

    private BigDecimal checkAndSetTotal(BigDecimal inputTotal) {
        BigDecimal total = inputTotal;

        if (inputTotal == null) {
            total = new BigDecimal("0");
        }

        return total;
    }
}
