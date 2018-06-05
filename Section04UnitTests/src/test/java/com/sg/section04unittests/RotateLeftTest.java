/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lizz
 */
public class RotateLeftTest {
    RotateLeft rl = new RotateLeft();
    public RotateLeftTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
     // Given an array of ints, return an array with the elements 
    // “rotated left" so {1, 2, 3} yields {2, 3, 1}. 
    //
    // rotateLeft({1, 2, 3}) -> {2, 3, 1}
    // rotateLeft({5, 11, 9}) -> {11, 9, 5}
    // rotateLeft({7, 0, 0}) -> {0, 0, 7}
    @Test
    public void test123() {
        int[] nums = {1, 2, 3};
       int[] exp = {2, 3, 1};
       
      for (int i = 0; i < exp.length ; i++){
          assertEquals(exp[i], rl.rotateLeft(nums)[i]);
      }
    }
    
        @Test
    public void test5119() {
        int[] nums = {5, 11, 9};
       int[] exp = {11, 9, 5};
        for (int i = 0; i < exp.length ; i++){
          assertEquals(exp[i], rl.rotateLeft(nums)[i]);
      }
    }
    
        @Test
    public void test700() {
        int[] nums = {7, 0, 0};
       int[] exp = {0, 0, 7};
        for (int i = 0; i < exp.length ; i++){
          assertEquals(exp[i], rl.rotateLeft(nums)[i]);
      }
    }
    
}
