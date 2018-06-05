/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Lizz
 */
public class DvdDaoImpl implements DvdDao{

    private Map<Long, Dvd> dvdMap = new HashMap<>();
    private static long dvdIdCounter = 0;
    
    @Override
    public Dvd addDvd(Dvd dvd) {
        dvd.setDvdId(dvdIdCounter);
        
       dvdMap.put(dvdIdCounter, dvd);
       dvdIdCounter++;
       
       Dvd added = dvdMap.get(dvd.getDvdId());
       return added;
    }

    @Override
    public void removeDvd(long dvdId) {
        dvdMap.remove(dvdId);
    }

    @Override
    public void updateDvd(Dvd dvd) {
        dvdMap.replace(dvd.getDvdId(), dvd);
    }

    @Override
    public List<Dvd> getAllDvds() {
        List<Dvd> dvds = new ArrayList<>(dvdMap.values());
        
        return dvds;
    }

    @Override
    public Dvd getDvdById(long dvdId) {
       return dvdMap.get(dvdId);
    }

    @Override
    public List<Dvd> searchDvds(Map<SearchTerm, String> criteria) {
      String titleSearch = criteria.get(SearchTerm.TITLE);
      String strDate = criteria.get(SearchTerm.RLS_DATE);
      
      
      String ratingSearch = criteria.get(SearchTerm.RATING);
      String directorSearch = criteria.get(SearchTerm.DIRECTOR);
      
      Predicate<Dvd> titleMatch;
      Predicate<Dvd> dateMatch;
      Predicate<Dvd> ratingMatch;
      Predicate<Dvd> directorMatch;
      
      Predicate<Dvd> truePredicate = (d) -> {
          return true;
      };
              
    if (titleSearch == null || titleSearch.isEmpty()){
        titleMatch = truePredicate;
    } else {
        titleMatch = d -> d.getTitle().equals(titleSearch);
    }
    
       if (strDate == null || strDate.toString().isEmpty()){
        dateMatch = truePredicate;
    } else {
           String dateSearch = strDate;
        dateMatch = d -> d.getRlsDate().equals(dateSearch);
    }
       
          if (ratingSearch == null || ratingSearch.isEmpty()){
        ratingMatch = truePredicate;
    } else {
        ratingMatch = d -> d.getRating().equals(ratingSearch);
    }
          
             if (directorSearch == null || directorSearch.isEmpty()){
        directorMatch = truePredicate;
    } else {
        directorMatch = d -> d.getDirector().equals(directorSearch);
    }
    
    return dvdMap.values().stream()
            .filter(titleMatch.and(dateMatch).and(ratingMatch).and(directorMatch))
            .collect(Collectors.toList());
    
    
    
    
    
    }
    
}
