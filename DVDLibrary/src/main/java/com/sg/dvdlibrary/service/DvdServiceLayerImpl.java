/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dao.DvdDao;
import com.sg.dvdlibrary.dao.DvdFilePersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lizz
 */
public class DvdServiceLayerImpl implements DvdServiceLayer {

    DvdDao dao;

    public DvdServiceLayerImpl(DvdDao dao) {
        this.dao = dao;
    }

    @Override
    public DVD add(DVD dvd) throws DvdFilePersistenceException, DvdAlreadyExistsException {

        DVD found = dao.searchLibrary(dvd.getTitle());

        if (found == null) {
            dao.add(dvd);
            return dvd;

        } else {
            throw new DvdAlreadyExistsException("This title already exists.");
        }

    }

    @Override
    public DVD remove(String title) throws DvdFilePersistenceException, DvdNotFoundException {
        DVD found = dao.searchLibrary(title);

        if (found != null) {
            dao.remove(title);
            return found;
        } else {
            throw new DvdNotFoundException("This title does not exist.");
        }
    }

    @Override
    public DVD edit(String title, String property, int selection) throws DvdFilePersistenceException, DvdNotFoundException {
        DVD found = dao.searchLibrary(title);

        if (found != null) {

            switch (selection) {
                case 1:
                    LocalDate ldReleaseDate = LocalDate.parse(property, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                    found.setReleaseDate(ldReleaseDate);
                    break;
                case 2:
                    found.setMpaaRating(property);
                    break;
                case 3:
                    found.setDirector(property);
                    break;
                case 4:
                    found.setStudio(property);
                    break;
                case 5:
                    Integer intRating = Integer.parseInt(property);
                    found.setUserReview(intRating);
                    break;
                default:
                    break;

            }
            dao.edit(title, found);
            return found;
        } else {
            throw new DvdNotFoundException("This title does not exist to be edited.");
        }

    }

    //    return ld;
    @Override
    public Collection<DVD> listAll() throws DvdFilePersistenceException {
        return dao.listAll();
    }

    @Override
    public DVD listOne(String title) throws DvdFilePersistenceException, DvdNotFoundException {
        DVD found = dao.searchLibrary(title);

        if (found != null) {
            return found;
        } else {
            throw new DvdNotFoundException("This title does not exist.");
        }
    }

    @Override
    public List<DVD> listInLastXYears(int yearsAgo) throws DvdFilePersistenceException {
        return dao.listInLastXYears(yearsAgo);
    }

    @Override
    public List<DVD> listByMPAA(String MPAA) throws DvdFilePersistenceException {
        return dao.listByMPAA(MPAA);
    }

    @Override
    public Map<String, List<DVD>> listByDirectorSortedByMPAA(String director) throws DvdFilePersistenceException {
        return dao.listByDirectorSortedByMPAA(director);
    }

    @Override
    public double findAverageAge() throws DvdFilePersistenceException {
        return dao.findAvgAge();
    }

    @Override
    public DVD viewNewest() throws DvdFilePersistenceException {
        return dao.viewNewest();
    }

    @Override
    public DVD viewOldest() throws DvdFilePersistenceException {
        return dao.viewOldest();
    }

    @Override
    public double findAvgStarRating() throws DvdFilePersistenceException {
        return dao.avgStarRating();
    }

}
