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
public class FirstHalfTest {
    FirstHalf fh = new FirstHalf();
    public FirstHalfTest() {
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
    // Given a String of even length, return the first half. 
    // So the String "WooHoo" yields "Woo". 
    //
    // firstHalf("WooHoo") -> "Woo"
    // firstHalf("HelloThere") -> "Hello"
    // firstHalf("abcdef") -> "abc"
    @Test
    public void testWoohoo() {
      String exp = "Woo";
      
      assertEquals(exp, fh.firstHalf("WooHoo"));
    }
   @Test
    public void testHellothere() {
      String exp = "Hello";
      
      assertEquals(exp, fh.firstHalf("HelloThere"));
    }
     @Test
    public void testabcdef() {
      String exp = "abc";
      
      assertEquals(exp, fh.firstHalf("abcdef"));
    }
}
