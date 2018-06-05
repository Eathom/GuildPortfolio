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
public class InsertWord {
     public String insertWord(String container, String word) {
        String split1 =  container.substring(0, 2);
        String split2 = container.substring(2);
        return split1.concat(word).concat(split2);
    }

}
