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
public class SumTest {
    Sum s = new Sum();
    public SumTest() {
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
    // Given an array of ints, return the sum of all the elements. 
    //
    // sum({1, 2, 3}) -> 6
    // sum({5, 11, 2}) -> 18
    // sum({7, 0, 0}) -> 7

    @Test
    public void test123() {
      int sum = 6;
      int nums[] = {1, 2, 3};
      assertEquals(sum, s.sum(nums));
    }
    @Test
    public void test5112() {
      int sum = 18;
    int nums[] = {5, 11, 2};
      assertEquals(sum, s.sum(nums));
    }
    @Test
    public void test700() {
      int sum = 7;
     int nums[] = {7, 0, 0};
      assertEquals(sum, s.sum(nums));
    }
}
