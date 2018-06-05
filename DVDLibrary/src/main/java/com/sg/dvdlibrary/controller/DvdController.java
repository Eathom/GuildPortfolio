/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdFilePersistenceException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.service.DvdAlreadyExistsException;
import com.sg.dvdlibrary.service.DvdNotFoundException;
import java.util.Collection;
import com.sg.dvdlibrary.ui.DvdView;
import com.sg.dvdlibrary.service.DvdServiceLayer;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lizz
 */
public class DvdController {

    DvdServiceLayer service;
    DvdView view;
    //DvdAuditDao audit;

    public DvdController(DvdServiceLayer service, DvdView view) {
        this.service = service;
        this.view = view;
        //this.audit = audit;
    }

    public void run() {

        int menuSelection;
        boolean keepGoing = true;

        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {

                    case 1:
                        add();
                        break;
                    case 2:
                        remove();
                        break;
                    case 3:
                        edit();
                        break;
                    case 4:
                        listAll();
                        break;
                    case 5:
                        listOne();
                        break;
                    case 6:
                        listYearsAgo();
                        break;
                    case 7:
                        listByMPAA();
                        break;
                    case 8:
                        listByDirector();
                        break;
                    case 9:
                        findAverageAge();
                        break;
                    case 10:
                        viewNewest();
                        break;
                    case 11:
                        viewOldest();
                        break;
                    case 12:
                        findAveStarRating();
                        break;
                    case 13:
                        keepGoing = false;
                        break;
                    default:
                        unknown();
                        break;

                }
            }
            exit();

        } catch (DvdFilePersistenceException e) {
            view.displayError(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuGetSelection();
    }

    // to add, it will search for the key (title) first, then add if it doesn't already exist.
    //these methods should be private, but changed to public so that app cxt could reach this method and audit. missing svc layer
    private void add()
            throws DvdFilePersistenceException {

        view.displayAddBanner();
        DVD newDVD = view.addDVD();

        try {
            service.add(newDVD);
            view.displayAddSuccess();
        } catch (DvdAlreadyExistsException e) {
            view.displayError(e.getMessage());
            view.displayAddFailBanner();
        }

    }

    private void remove()
            throws DvdFilePersistenceException {
        view.displayRemoveBanner();
        String title = view.getTitle();

        try {
            service.remove(title);
            view.displayRemoveSuccessBanner();
        } catch (DvdNotFoundException e) {
            view.displayError(e.getMessage());
            view.displayRemoveFailBanner();
        }

    }
    //these methods should be private, but changed to public so that app cxt could reach this method and audit. missing svc layer

    public void edit()
            throws DvdFilePersistenceException {

        view.displayEditBanner();

        String title = view.getTitle();
        int selectn = view.getEditProp();
        String property = "";
        view.displayEditBanner();
        

            switch (selectn) {
                case 1:
                     property = view.getDate();
                    
                    break;
                case 2:
                     property = view.getMPAA();
                   
                    break;
                case 3:
                     property = view.getDirec();
                    
                    break;
                case 4:
                     property = view.getStudio();
                    
                    break;
                case 5:
                     property = view.getReview();
                    
                    break;
                default:
                    view.displayUnknown();
                    break;

            }
            try {
            service.edit(title, property, selectn);
            view.displayEditSuccess();

        } catch (DvdNotFoundException e) {
            view.displayError(e.getMessage());
            view.displayEditFail();

        }
    }

    private void listAll()
            throws DvdFilePersistenceException {
        Collection<DVD> library = service.listAll();
        view.listAll(library);
    }

    private void listOne()
            throws DvdFilePersistenceException {
        String title = view.getTitle();
        try {
            DVD found = service.listOne(title);
            view.listOne(found);
        } catch (DvdNotFoundException e) {
            view.displayError(e.getMessage());
            view.displayListOneFail();
        }
    }

    private void exit() {
        view.displayExit();
    }

    private void listYearsAgo()
            throws DvdFilePersistenceException {
        view.displayAgeRangeBanner();
        int yearsAgo = view.geYearsAgo();

        List<DVD> listRes = service.listInLastXYears(yearsAgo);
        view.displayByYearsAgo(listRes);
    }

    private void listByMPAA()
            throws DvdFilePersistenceException {
        view.displayByMPAABanner();
        String MPAA = view.getMPAA();
        List<DVD> dvds = service.listByMPAA(MPAA);
        view.displayByMPAA(dvds);

    }

    private void listByDirector() throws DvdFilePersistenceException {
        view.displayByDirectorBanner();
        String director = view.getByDirector();
        Map<String, List<DVD>> dvds = service.listByDirectorSortedByMPAA(director);
        view.displayByDirector(dvds);

    }

    private void findAverageAge() throws DvdFilePersistenceException {
        double age = service.findAverageAge();
        view.displayAvgAge(age);

    }

    private void viewNewest() throws DvdFilePersistenceException {
        DVD dvd = service.viewNewest();
        view.displayNewest(dvd.getTitle());

    }

    private void viewOldest() throws DvdFilePersistenceException {
        DVD dvd = service.viewOldest();
        view.displayOldest(dvd.getTitle());
    }

    private void findAveStarRating() throws DvdFilePersistenceException {
        double avg = service.findAvgStarRating();
        view.displayAvgNote(avg);
    }

    private void unknown() {
        view.displayUnknown();
    }

}
