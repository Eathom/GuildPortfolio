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
public class EveryOtherTest {
    EveryOther eo = new EveryOther();
    public EveryOtherTest() {
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
    public void testHello() {
      String expRes = "Hlo";  
      assertEquals(expRes, eo.everyOther("Hello"));
    }
   @Test
    public void testHi() {
        String expRes = "H";  
        assertEquals(expRes, eo.everyOther("Hi"));
    }  
     @Test
    public void testHeeololeo() {
       String expRes = "Hello";  
       assertEquals(expRes, eo.everyOther("Heeololeo"));
    }
}
