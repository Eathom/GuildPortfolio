/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lizz
 */
public interface DvdDao {
    
    DVD add(DVD newDVD) throws DvdFilePersistenceException; 
    
    DVD remove(String title) throws DvdFilePersistenceException;
    
    DVD edit(String DVD, DVD editedDVD) throws DvdFilePersistenceException;
    
     List<DVD> listAll() throws DvdFilePersistenceException;
    
    DVD showDVD(String title) throws DvdFilePersistenceException;
    

    
    List<DVD> listByMPAA(String mpaaRating) throws DvdFilePersistenceException;
    
    Map<String, List<DVD>> listByDirectorSortedByMPAA(String director) throws DvdFilePersistenceException;
    
    List<DVD> listByStudio(String studio) throws DvdFilePersistenceException;
    
    List<DVD> listInLastXYears(int yearsAgo) throws DvdFilePersistenceException;
    
    double findAvgAge() throws DvdFilePersistenceException;
    
    DVD viewNewest() throws DvdFilePersistenceException;
    
    DVD viewOldest() throws DvdFilePersistenceException;
    
    double avgStarRating() throws DvdFilePersistenceException;
    
    
    /**
     * 
     * @param title will get the title name via view method.
     * @return object DVD which is the value of the key/title, or if no title exists, will return null.
     * @throws com.sg.dvdlibrary.dao.DvdFilePersistenceException
     */
    DVD searchLibrary(String title)
            throws DvdFilePersistenceException ;
    
    
    
}
