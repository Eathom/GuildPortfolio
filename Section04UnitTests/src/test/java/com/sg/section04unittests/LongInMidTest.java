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
public class LongInMidTest {
    LongInMid lim = new LongInMid();
    public LongInMidTest() {
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
    // Given 2 Strings, a and b, return a String of the form 
    // short+long+short, with the shorter String on the outside 
    // and the longer String on the inside. The Strings will not 
    // be the same length, but they may be empty (length 0). 
    //
    // longInMiddle("Hello", "hi") -> "hiHellohi"
    // longInMiddle("hi", "Hello") -> "hiHellohi"
    // longInMiddle("aaa", "b") -> "baaab"
  

    @Test
    public void testHelloHi() {
      String exp = "hiHellohi";
      
      assertEquals(exp, lim.longInMiddle("Hello", "hi"));
    }
        @Test
    public void testHiHello() {
      String exp = "hiHellohi";
      
      assertEquals(exp, lim.longInMiddle("hi", "Hello"));
    }
        @Test
    public void testAaaB() {
      String exp = "baaab";
      
      assertEquals(exp, lim.longInMiddle("aaa", "b"));
    }
    
}
