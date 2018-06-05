/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.controller;

import com.sg.dvdlibraryspringmvc.dao.DvdDao;
import com.sg.dvdlibraryspringmvc.model.Dvd;
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
@Controller
public class DvdController {
    
    DvdDao dao;
    
    @Inject
    public DvdController(DvdDao dao){
        this.dao = dao;
    }
//links are always POST methods
    @RequestMapping(value = "/displayTablePage", method = RequestMethod.GET)
    public String displayTablePage(HttpServletRequest request) {
        
        
        return "table";
    }
    
    @RequestMapping(value = "/displayCreatePage", method = RequestMethod.GET)
    public String displayCreatePage(HttpServletRequest request) {
        return "create";
    }
    
    @RequestMapping(value = "/addDvd", method = RequestMethod.POST)
    public String addDvd( HttpServletRequest request){
       
        
   
        Dvd dvd = new Dvd();
        dvd.setDirector(request.getParameter("director"));
        dvd.setRating(request.getParameter("rating"));
        dvd.setTitle(request.getParameter("title"));
        
        dvd.setRlsDate(request.getParameter("rlsDate"));
       
        
       
        dao.addDvd(dvd);
        
        return "redirect:displayTablePage";
    }
    
    @RequestMapping(value = "/displayIndex", method = RequestMethod.GET)
    public String displayIndex(HttpServletRequest request){
    return "index";
    }  
    
    @RequestMapping(value = "/showDetails", method = RequestMethod.GET)
    public String showDetails(HttpServletRequest request, Model model){
        
        String dvdId = request.getParameter("dvdId");
        long id = Long.parseLong(dvdId);
        Dvd dvd = dao.getDvdById(id);
        
        model.addAttribute("dvd", dvd);
        
        return "details";
        
    }
    
    @RequestMapping(value = "/deleteDvd", method= RequestMethod.GET)
    public String deleteDvd(HttpServletRequest request){
        String dvdId = request.getParameter("dvdId");
        long id = Long.parseLong(dvdId);
        dao.removeDvd(id);
        
        return "redirect:displayTablePage";
    }
    
    @RequestMapping(value = "/displayEditPage", method = RequestMethod.GET)
    public String displayEditPage(HttpServletRequest request, Model model) {
        String dvdId = request.getParameter("dvdId");
        long id = Long.parseLong(dvdId);
        Dvd dvd = dao.getDvdById(id);
        model.addAttribute(dvd);
        
        return "edit";
    }
    
    @RequestMapping (value = "editDvd", method= RequestMethod.POST)
    public String editDvd(@Valid @ModelAttribute("dvd") Dvd dvd, BindingResult result) throws UpdateIntegrityException{
        
        
        if(result.hasErrors()){
            return "edit";
        }
        long dvdId = dvd.getDvdId();
        
        if(dvdId != dao.getDvdById(dvdId).getDvdId()) {
            throw new UpdateIntegrityException("id's don't match");
        }
        
        dao.updateDvd(dvd);
        
        return "redirect:displayTablePage";
    }
}
