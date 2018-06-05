/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Lizz
 */
public interface UserIO {
    

    //basic input output methods
    
void print(String msg);    

String getString(String prompt);

int getInt(String prompt);

int getInt(String prompt, int min, int max);
}
