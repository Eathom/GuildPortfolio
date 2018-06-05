/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.controller;

import com.sg.dvdlibraryspringmvc.dao.DvdDao;
import com.sg.dvdlibraryspringmvc.dao.SearchTerm;
import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Lizz
 */
@CrossOrigin
@Controller
public class SearchController {
    DvdDao dao;
    
    @Inject
    public SearchController(DvdDao dao){
        this.dao = dao;
    }
    
    @RequestMapping(value = "/displaySearchPage", method = RequestMethod.POST)
    public String searchDvds(HttpServletRequest request){
        return "search";
    }
    
    @RequestMapping(value = "/search/dvds", method = RequestMethod.POST)
    @ResponseBody
    public List<Dvd> searchDvds(@RequestBody Map<String, String> search){
        
        Map<SearchTerm, String> criteria = new HashMap<>();
        
     String currentCategory = search.get("category");
     
     if (currentCategory.equalsIgnoreCase("title")){
         criteria.put(SearchTerm.TITLE, search.get("term"));
     }

        return dao.searchDvds(criteria);
        
    }
    
    
}
