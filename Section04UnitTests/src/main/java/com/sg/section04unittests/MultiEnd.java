/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

/**
 *
 * @author Lizz
 */
public class MultiEnd {
    public String multipleEndings(String str) {
    String ending = str.substring((str.length() - 2), (str.length()));
    String total1 = ending.concat(ending);
    String total2 = total1.concat(ending);
    
    return total2;
    }

}
