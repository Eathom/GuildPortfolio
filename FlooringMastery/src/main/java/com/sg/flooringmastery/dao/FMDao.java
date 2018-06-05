/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.FMOrder;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Lizz
 */
public interface FMDao {

    int getOrderCount();

    void setOrderCount(int newCount);

    List<LocalDate> getDates();

    List<FMOrder> getOrdersOnDate(LocalDate orderDate) throws FMDaoDataPersistException;

    FMOrder addNewDateOrder(LocalDate orderDate, FMOrder newOrder) throws FMDaoDataPersistException;

    FMOrder addExistingDateOrder(LocalDate orderDate, FMOrder newOrder) throws FMDaoDataPersistException;

    FMOrder editOrder(LocalDate orderDate, FMOrder editedOrder);

    FMOrder removeOrder(LocalDate orderDate, int orderNumber);

    List<FMOrder> removeOrdersOnDate(LocalDate date);

    void commitChanges() throws FMDaoDataPersistException;

}
