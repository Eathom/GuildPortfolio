/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook2;

import controller.Controller;
import dao.Dao;
import dao.DaoException;
import dao.DaoFileImpl;
import ui.UserIO;
import ui.UserIOConsoleImpl;
import ui.View;

/**
 *
 * @author Lizz
 */
public class App {
    public static void main(String[] args)
    throws DaoException {
        
        //wire together dependancies
  UserIO io = new UserIOConsoleImpl();
  View myView = new View(io);
  Dao myDao = new DaoFileImpl();
  Controller myController = new Controller(myView, myDao);
  
        //run from controller
        System.out.println(myDao.viewAddr("Cruise").getfName());;
       // myController.run();
        
    }
}
