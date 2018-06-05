/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Address;
import java.util.List;

/**
 *
 * @author Lizz
 */
public interface Dao {
    
    //specify methods for user stories
    
    
    /**
     *  set all fields and add object to dao list.
     * @param newAddr
     * @throws dao.DaoException
     */
    void add(Address newAddr)
            throws DaoException ;
    
    
    
    /**
     * @param lName iterate thru list, if it matches the current addr's lName, then remove that address from the book.
     * @return boolean of found (true) or not found (false). if found, object at index that last name is found will be removed.
     * @throws dao.DaoException
     */
    boolean remove(String lName)
            throws DaoException;
    
    
    
    /**
     * 
     * @return size of list.
     * @throws dao.DaoException
     */
    int getCount()
            throws DaoException;
    
    
    
    /**
     * 
     * @param lName see if lName equals object.get(lName) get the int index ?? or add to new List?? . returns that list and each field is printed. if no lName, print not found msg
     * @return 
     * @throws dao.DaoException
     */
    Address viewAddr(String lName)
            throws DaoException;
    
    
    /**
     * show all address objects in list.
     * @return 
     * @throws dao.DaoException
     */
    List<Address> viewAll()
            throws DaoException;
    
    
    boolean edit(String lName, String newAddr)
            throws DaoException;
    
}
