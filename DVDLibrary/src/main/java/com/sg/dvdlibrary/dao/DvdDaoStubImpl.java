/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Lizz
 */
public class DvdDaoStubImpl implements DvdDao {

    Map<String, DVD> oneDVD = new HashMap<>();
    
    
    public DvdDaoStubImpl(){
     DVD only = new DVD("Scream");
     only.setDirector("JH");
     only.setMpaaRating("R");
     LocalDate rlsDate = LocalDate.parse("1997-01-01");
     only.setReleaseDate(rlsDate);
     only.setStudio("Universal");
     only.setUserReview(5);
        
     oneDVD.put(only.getTitle(), only);
    }

    @Override
    public DVD add(DVD newDVD) {
      if (newDVD != oneDVD.get(newDVD.getTitle())) {
          return newDVD;
      } else {
          return oneDVD.get("Scream");
      }
    }

    @Override
    public DVD remove(String title)  {
        DVD existing = oneDVD.get("Scream");
        
         if (title == existing.getTitle()) {
          return existing;
      } else {
          return null;
      }
    }

    @Override
    public DVD edit(String title, DVD editedDVD)  {
              DVD existing = oneDVD.get("Scream");
        
         if (title == existing.getTitle()) {
          return existing;
      } else {
          return null;
      }
    }

    @Override
    public List<DVD> listAll()  {
       return new ArrayList<DVD>(oneDVD.values());
    }

    @Override
    public DVD showDVD(String title) {
        return oneDVD.get(title);
    }

    @Override
    public List<DVD> listByMPAA(String mpaaRating)  {
     return oneDVD.values()
                .stream()
                .filter(d -> d.getRating().equalsIgnoreCase(mpaaRating))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<DVD>> listByDirectorSortedByMPAA(String director)  {
        return oneDVD.values()
                .stream()
                .filter(d -> d.getDirector().equalsIgnoreCase(director))
                //this creates a map with rating as string, and list of dvds with that rating
                //as the value. filtered out any other keys for other directors. making a new map
                .collect(Collectors.groupingBy(DVD::getRating));  
    }

    @Override
    public List<DVD> listByStudio(String studio) {
         return oneDVD.values()
                .stream()
                .filter(d -> d.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
    }

    @Override
    public List<DVD> listInLastXYears(int yearsAgo)  {
         return oneDVD.values()
                .stream()
                .filter(d -> d.getAge() <= yearsAgo)
                .collect(Collectors.toList());
    }

    @Override
    public double findAvgAge()  {
         return oneDVD.values()
                .stream()
                .mapToDouble(d -> d.getAge())
                .average()
                .getAsDouble();
    }

    @Override
    public DVD viewNewest()  {
       int youngest = oneDVD.values()
               .stream()
               .mapToInt(d -> d.getAge())
               .min()
               .getAsInt();
       
       List<DVD> dvds = new ArrayList<>(oneDVD.values());
       DVD newest = null;
       
       for (DVD d : dvds) {
           if (d.getAge() == youngest){
               newest = d;
           }
            } 
       return newest;
    }

    @Override
    public DVD viewOldest() {
    int oldest = oneDVD.values()
               .stream()
               .mapToInt(d -> d.getAge())
               .max()
               .getAsInt();
       
       List<DVD> dvds = new ArrayList<>(oneDVD.values());
       DVD old = null;
       
       for (DVD d : dvds) {
           if (d.getAge() == oldest) {
               old = d;
           }
       }
       return old;
    }


    @Override
    public double avgStarRating() {
         return oneDVD.values()
                .stream()
                .mapToInt(d -> d.getUserReview())
                .average()
                .getAsDouble();
    }
    

    @Override
    public DVD searchLibrary(String title) {
        DVD only = oneDVD.get("Scream");
        
       if (title == only.getTitle()){
           return only;
           
       } else {
           
           return null;
       }
    }


}

