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
public class StringSplosionTest {
    StringSplosion ss = new StringSplosion();
    public StringSplosionTest() {
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
    // Given a non-empty String like "Code" return a String like 
    // “CCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"
 
    @Test
    public void testCode() {
        String exp = "CCoCodCode";
        
        assertEquals(exp, ss.stringSplosion("Code"));
    }
      @Test
    public void testabc() {
        String exp = "aababc";
        
        assertEquals(exp, ss.stringSplosion("abc"));
    }  
      @Test
    public void testab() {
        String exp = "aab";
        
        assertEquals(exp, ss.stringSplosion("ab"));
    }  
}
