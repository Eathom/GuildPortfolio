/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.controller;

import com.sg.dvdlibraryspringmvc.dao.DvdDao;
import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 *
 * @author Lizz
 */
@CrossOrigin
@Controller
public class RESTController {
    @Inject
    DvdDao dao;
    
    public RESTController(DvdDao dao){
        this.dao = dao;
    }
    @RequestMapping(value = "/dvds", method = RequestMethod.GET)
    @ResponseBody
    public List<Dvd> getAll(){
        List<Dvd> list = dao.getAllDvds();
       
        return list;
    }
    
   
}
