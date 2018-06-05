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
public class TrimOneTest {
    TrimOne to = new TrimOne();
    public TrimOneTest() {
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
   // Given a String, return a version without the first and 
    // last char, so "Hello" yields "ell". The String length will be at least 2. 
    //
    // trimOne("Hello") -> "ell"
    // trimOne("java") -> "av"
    // trimOne("coding") -> "odin"
    @Test
    public void testHello() {
        String exp = "ell";
        
        assertEquals(exp, to.trimOne("Hello"));
    }
    
      @Test
    public void testCoding() {
        String exp = "odin";
        
        assertEquals(exp, to.trimOne("coding"));
    }
    
      @Test
    public void testJava() {
        String exp = "av";
        
        assertEquals(exp, to.trimOne("java"));
    }
    
}
