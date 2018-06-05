/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Dao;
import dao.DaoException;
import dto.Address;
import java.util.List;
import ui.View;

/**
 *
 * @author Lizz
 */
public class Controller {
    private View myView;
    private Dao myDao;
    //constuctor to loosely couple dependancy
    public Controller(View myView, Dao myDao ){
        this.myView = myView;
        this.myDao = myDao;
    }
    
    
    //run method- shows menu and switch for each menu option (control flow)
    public void run(){
        
        int menuSelectn;
        boolean keepGoing = true;
        try {
        while (keepGoing) {
            menuSelectn = getSelectn();
            
            switch (menuSelectn){
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    showCount();
                    break;
                case 4:
                    showAddr();
                    break;
                case 5:
                    showAll();
                    break;
                case 6:
                    edit();
                    break;
                case 7:
                    keepGoing = false;
                     break;
                default:
                    unknown();
                    break;
            } 
          }
        exit();
     } catch (DaoException e) {
         myView.errorMsg(e.getMessage());
     }
    }
    
    //private methods utilizaing view and dao
    
    
 private int getSelectn(){
     return myView.printMenuGetSelectn();
     
 }
    private void add()
    throws DaoException {
     Address newAddr = myView.getAddr();
     myDao.add(newAddr);
     myView.dispAddSuc();
    }
    
    private void remove()
    throws DaoException {
        myView.dispRemove();
       String lName = myView.getInfo("Enter last name to remove");
      boolean found = myDao.remove(lName);
      if (found){
       myView.dispRemoveSuc();
      } else {
          myView.notFound();
      }
    }
    
    
    private void showCount()
    throws DaoException {
        int num = myDao.getCount();
        myView.showCount(num);
    }
    
    private void showAddr()
    throws DaoException {
        String lName = myView.getInfo("Enter last name to view");
        Address show = myDao.viewAddr(lName);
        myView.showAddr(show);
    }
    
    private void showAll()
    throws DaoException {
       List<Address> myBook = myDao.viewAll();
       myView.showAll(myBook);
    }
    
    private void edit()
    throws DaoException {
      String lName = myView.getInfo("Enter the last name");
      String newAddr = myView.getInfo("Enter the new address");
      
      if (myDao.edit(lName, newAddr) == true){
          myView.dispEditSucs();
      } else {
          myView.dispEditFail();
      }
          
    }
    
    private void exit(){
        myView.exitMsg();
    }
    
    private void unknown(){
        myView.notFound();
    }
}
