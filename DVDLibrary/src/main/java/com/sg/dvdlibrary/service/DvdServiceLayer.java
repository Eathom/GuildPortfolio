/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DvdFilePersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lizz
 */
public interface DvdServiceLayer {

    DVD add(DVD dvd) throws DvdFilePersistenceException, DvdAlreadyExistsException;

    DVD remove(String title) throws DvdFilePersistenceException, DvdNotFoundException;

    DVD edit(String title, String property, int selection) throws DvdFilePersistenceException, DvdNotFoundException;

    Collection<DVD> listAll() throws DvdFilePersistenceException;

    DVD listOne(String title) throws DvdFilePersistenceException, DvdNotFoundException;

    List<DVD> listInLastXYears(int yearsAgo) throws DvdFilePersistenceException;

    List<DVD> listByMPAA(String MPAA) throws DvdFilePersistenceException;

    Map<String, List<DVD>> listByDirectorSortedByMPAA(String director) throws DvdFilePersistenceException;

    double findAverageAge() throws DvdFilePersistenceException;

    DVD viewNewest() throws DvdFilePersistenceException;

    DVD viewOldest() throws DvdFilePersistenceException;

    double findAvgStarRating() throws DvdFilePersistenceException;
}
