/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FMDao;
import com.sg.flooringmastery.dao.FMDaoDataPersistException;
import com.sg.flooringmastery.dto.FMOrder;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Lizz
 */
public interface FMServiceLayer {

    void setDao(FMDao dao) throws FMDaoDataPersistException;

    List<FMOrder> getOrdersOnDate(LocalDate date) throws FMNoOrderExistsException, FMDaoDataPersistException;

    FMOrder calculateNewOrder(LocalDate date, FMOrder newOrder) throws FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException;

    FMOrder addOrder(LocalDate date, FMOrder newOrder) throws FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException;

    FMOrder getOrder(LocalDate date, int orderNumber) throws FMNoOrderExistsException, FMDaoDataPersistException;

    FMOrder editOrder(LocalDate date, FMOrder originalOrder, FMOrder editedOrder) throws FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException;

    FMOrder correctBadOrder(LocalDate date, FMOrder originalOrder, FMOrder orderWithChanges) throws FMMissingPropertyException, FMInvalidPropertyException;

    FMOrder removeOrder(LocalDate date, int orderNumber) throws FMNoOrderExistsException, FMDaoDataPersistException;

    boolean commitChanges() throws FMDaoDataPersistException;

}
