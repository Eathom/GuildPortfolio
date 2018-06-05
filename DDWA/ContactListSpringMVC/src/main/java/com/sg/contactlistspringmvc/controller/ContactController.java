/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistspringmvc.controller;

import com.sg.contactlistspringmvc.dao.ContactListDao;
import com.sg.contactlistspringmvc.model.Contact;
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

/**
 *
 * @author Lizz
 */
//spring knows about it and controls the life cycle of this component
@Controller
public class ContactController {
    
    ContactListDao dao;
    
    @Inject
    public ContactController(ContactListDao dao){
        this.dao = dao;
    }
    
    
    @RequestMapping(value="/displayContactsPage", method=RequestMethod.GET)
    public String displayContactsPage(Model model){
        
        List<Contact> contactList = dao.getAllContacts();
        
        model.addAttribute("contactList", contactList);
        return "contacts";
    }
    
    
    @RequestMapping(value="/createContact", method=RequestMethod.POST)
    public String createContact(HttpServletRequest request) {
        Contact contact = new Contact();
        contact.setFirstName(request.getParameter("firstName"));
        contact.setLastName(request.getParameter("lastName"));
        contact.setCompany(request.getParameter("company"));
        contact.setPhone(request.getParameter("phone"));
        contact.setEmail(request.getParameter("email"));
        //persist
        dao.addContact(contact);
        //we wont forward to a view, we redirect to the endpoint that displays
        //the contacts page, so it displays new contact in table
        //REDIRECTS TO A METHOD INSTEAD OF A VIEW
        
        return "redirect:displayContactsPage";
    }
    
    @RequestMapping(value="/displayContactDetails", method=RequestMethod.GET)
    public String displayContactDetails(HttpServletRequest request, Model model){
        
        int contactId = Integer.parseInt(request.getParameter("contactId"));
        Contact contact = dao.getContactById(contactId);
        
        model.addAttribute("contact", contact);
        
        return "contactDetails";
    }
    
    @RequestMapping(value="/deleteContact", method=RequestMethod.GET)
    public String deleteContact(HttpServletRequest request){
        String contactIdParam = request.getParameter("contactId");
        long contactId = Long.parseLong(contactIdParam);
        
        dao.removeContact(contactId);
        
        return "redirect:displayContactsPage";
    }
    
    @RequestMapping(value="/displayEditContactForm", method=RequestMethod.GET)
    public String displayEditContactForm(HttpServletRequest request, Model model){
        long contactId = Long.parseLong(request.getParameter("contactId"));
        Contact contact = dao.getContactById(contactId);
        
        model.addAttribute("contact", contact);
        
        return "editContactForm";
        
    }
    
    @RequestMapping(value="/editContact", method=RequestMethod.POST)
    public String editContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result){
        if(result.hasErrors()) {
            return "editContactForm";
        }
        dao.updateContact(contact);
        return "redirect:displayContactsPage";
    }
}
