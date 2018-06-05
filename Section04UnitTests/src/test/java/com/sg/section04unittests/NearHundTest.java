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
public class NearHundTest {
    NearHund nh = new NearHund();
    public NearHundTest() {
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
  // Given an int n, return true if it is within 10 of 100 
    // or 200.
    // Hint: Check out the Math class for absolute value
    //
    // nearHundred(103) -> true
    // nearHundred(90) -> true
    // nearHundred(89) -> false
    @Test
    public void test103() {
      assertTrue(nh.nearHundred(103));
    }
     @Test
    public void test90() {
      assertTrue(nh.nearHundred(90));
    }
     @Test
    public void test89() {
      assertFalse(nh.nearHundred(89));
    }
    
}
