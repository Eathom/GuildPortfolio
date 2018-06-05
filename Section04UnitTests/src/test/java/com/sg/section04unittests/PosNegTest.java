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
public class PosNegTest {
    PosNeg pn = new PosNeg();
    public PosNegTest() {
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
    // Given two int values, return true if one is negative and 
    // one is positive. Except if the parameter "negative" is 
    // true, then return true only if both are negative. 
    //
    // posNeg(1, -1, false) -> true
    // posNeg(-1, 1, false) -> true
    // posNeg(-4, -5, true) -> true
    @Test
    public void test1N1f() {
        assertTrue(pn.posNeg(1, -1 , false));
    }
    @Test
    public void testN11f() {
        assertTrue(pn.posNeg(-1, 1 , false));
    }
    
    @Test
    public void testn4n5t() {
        assertTrue(pn.posNeg(-4, -5 , true));
    }
    
}
