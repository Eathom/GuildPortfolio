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
public class CommonEndTest {
    
    CommonEnd ce = new CommonEnd();
    public CommonEndTest() {
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

    @Test
    public void test33() {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{7, 3};
      
        assertTrue(ce.commonEnd(a, b));
    }
    
     @Test
    public void test32() {
         int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{7, 3, 2};
      
        assertFalse(ce.commonEnd(a, b)); 
    }
    
     @Test
    public void test313() {
          int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{1, 3};
      
        assertTrue(ce.commonEnd(a, b));
    }
        // Given 2 arrays of ints, a and b, return true if they 
    
// have the same first element or they have the same 
   
 // last element. Both arrays will be length 1 or more. 
    //
    // commonEnd({1, 2, 3}, {7, 3}) -> true
    // commonEnd({1, 2, 3}, {7, 3, 2}) -> false
    // commonEnd({1, 2, 3}, {1, 3}) -> true
  //  public boolean commonEnd(int[] a, int[] b) {
  //      throw new UnsupportedOperationException("Not implemented");  
 //   }
}
