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
public class SkipSumTest {
   SkipSum ss = new SkipSum(); 
    public SkipSumTest() {
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
     // Given 2 ints, a and b, return their sum. However, sums 
    // in the range 10..19 inclusive are forbidden, so in that case just return 20. 
    //
    // skipSum(3, 4) → 7
    // skipSum(9, 4) → 20
    // skipSum(10, 11) → 21
    @Test
    public void test34() {
        int sum = 7;
      assertEquals(sum, ss.skipSum(3, 4));
    }
        @Test
    public void test94() {
        int sum = 20;
      assertEquals(sum, ss.skipSum(9, 4));
    }
        @Test
    public void test1011() {
        int sum = 21;
      assertEquals(sum, ss.skipSum(10, 11));
    }
}
