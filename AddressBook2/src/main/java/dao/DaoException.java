/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Lizz
 */
public class DaoException extends Exception {
    
    //will encapsulate / translate errors from file persistance read and write
    
    public DaoException(String message) {
        super(message);
    }
    
    public DaoException(String message, Throwable cause){
        super(message, cause);
    }
}
