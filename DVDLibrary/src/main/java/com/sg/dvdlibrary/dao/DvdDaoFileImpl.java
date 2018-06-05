/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Lizz
 */
public class DvdDaoFileImpl implements DvdDao {

    Map<String, DVD> dvdLibrary = new HashMap<>();

    public static final String LIBRARY_FILE = "dvdlibrary.txt";
    public static final String DELIMITER = "::";

    @Override
    public DVD searchLibrary(String title)
            throws DvdFilePersistenceException {
        loadLibrary();
        DVD found = dvdLibrary.get(title);
        return found;
    }

    @Override
    public DVD add(DVD newDVD)
            throws DvdFilePersistenceException {
         dvdLibrary.put(newDVD.getTitle(), newDVD);
        writeLibrary();
        return newDVD;
    }

    @Override
    public DVD remove(String title)
            throws DvdFilePersistenceException {
        DVD removed = dvdLibrary.remove(title);
        writeLibrary();
        return removed;
    }

    @Override
    public DVD edit(String title, DVD editedDVD)
            throws DvdFilePersistenceException {
        dvdLibrary.replace(title, editedDVD);
        writeLibrary();
        return editedDVD;
    }

    @Override
    public List<DVD> listAll()
            throws DvdFilePersistenceException {
        loadLibrary();
        return new ArrayList<DVD>(dvdLibrary.values());
    }

    @Override
    public DVD showDVD(String title)
            throws DvdFilePersistenceException {
        return searchLibrary(title);
    }

    private void loadLibrary() throws DvdFilePersistenceException {
        Scanner sc;

        try {
            sc = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));

        } catch (FileNotFoundException e) {
            throw new DvdFilePersistenceException("could not load data", e);
        }

        String currentLine;
        String[] currentTokens;

        while (sc.hasNext()) {
            currentLine = sc.nextLine();
            //splits the string into a string array at the delimiter and removes the delimiter
            currentTokens = currentLine.split(DELIMITER);

            DVD current = new DVD(currentTokens[0]);
            LocalDate rlsDate = LocalDate.parse(currentTokens[1]);
            current.setReleaseDate(rlsDate);
            current.setMpaaRating(currentTokens[2]);
            current.setDirector(currentTokens[3]);
            current.setStudio(currentTokens[4]);
            
            String userRating = currentTokens[5];
            int intUserRating = Integer.parseInt(userRating);
            current.setUserReview(intUserRating);

            dvdLibrary.put(current.getTitle(), current);

        }
        sc.close();
    }

    private void writeLibrary() throws DvdFilePersistenceException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));

        } catch (IOException e) {
            throw new DvdFilePersistenceException("Could not save.", e);
        }

        // create a new list that gets the values from dvd library
        Collection<DVD> dvds = dvdLibrary.values();
       
        for (DVD current : dvds) {
            out.println(current.getTitle() + DELIMITER + current.getReleaseDate().toString() + DELIMITER + current.getRating() + DELIMITER
                    + current.getDirector() + DELIMITER + current.getStudio() + DELIMITER + String.valueOf(current.getUserReview()));
            out.flush();
        }
        out.close();
    }

    @Override
    public List<DVD> listInLastXYears(int yearsAgo) throws DvdFilePersistenceException {
        loadLibrary();
        
        return dvdLibrary.values()
                .stream()
                .filter(d -> d.getAge() <= yearsAgo)
                .collect(Collectors.toList());
    }

    @Override
    public List<DVD> listByMPAA(String mpaaRating) throws DvdFilePersistenceException {
        loadLibrary();
        return dvdLibrary.values()
                .stream()
                .filter(d -> d.getRating().equalsIgnoreCase(mpaaRating))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<DVD>> listByDirectorSortedByMPAA(String director) throws DvdFilePersistenceException {
        loadLibrary();
        return dvdLibrary.values()
                .stream()
                .filter(d -> d.getDirector().equalsIgnoreCase(director))
                //this creates a map with rating as string, and list of dvds with that rating
                //as the value. filtered out any other keys for other directors. making a new map
                .collect(Collectors.groupingBy(DVD::getRating));  
        
        
               
    }

    @Override
    public List<DVD> listByStudio(String studio) throws DvdFilePersistenceException {
        loadLibrary();
        return dvdLibrary.values()
                .stream()
                .filter(d -> d.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
    }

    @Override
    public double findAvgAge() throws DvdFilePersistenceException {
        loadLibrary();
        
        return dvdLibrary.values()
                .stream()
                .mapToDouble(d -> d.getAge())
                .average()
                .getAsDouble();
        
    }

    @Override
    public DVD viewNewest() throws DvdFilePersistenceException {
        
        loadLibrary();
       int youngest = dvdLibrary.values()
               .stream()
               .mapToInt(d -> d.getAge())
               .min()
               .getAsInt();
       
       List<DVD> dvds = new ArrayList<>(dvdLibrary.values());
       DVD newest = null;
       
       for (DVD d : dvds) {
           if (d.getAge() == youngest){
               newest = d;
           }
       
    } 
       return newest;
    }
    
    
    @Override
    public DVD viewOldest() throws DvdFilePersistenceException {
          loadLibrary();
       int oldest = dvdLibrary.values()
               .stream()
               .mapToInt(d -> d.getAge())
               .max()
               .getAsInt();
       
       List<DVD> dvds = new ArrayList<>(dvdLibrary.values());
       DVD old = null;
       
       for (DVD d : dvds) {
           if (d.getAge() == oldest) {
               old = d;
           }
       }
       return old;
    }

    @Override
    public double avgStarRating() throws DvdFilePersistenceException {
          loadLibrary();
        return dvdLibrary.values()
                .stream()
                .mapToInt(d -> d.getUserReview())
                .average()
                .getAsDouble();
    }

 

}
