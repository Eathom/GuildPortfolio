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
public class CaughtSpeedingTest {
    CaughtSpeeding cs = new CaughtSpeeding();
    public CaughtSpeedingTest() {
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
    public void test60And0() {
       assertEquals(0, cs.caughtSpeeding(60, false));
    }
    @Test
    public void test60And0B() {
     assertEquals(0, cs.caughtSpeeding(60, true));  
    }
    @Test
    public void test61And1() {
      assertEquals(1, cs.caughtSpeeding(61, false)); 
    }
      @Test
    public void test61And1B() {
      assertEquals(0, cs.caughtSpeeding(61, true));  
    }
    @Test
    public void test80And1() {
         assertEquals(1, cs.caughtSpeeding(80, false));
    }
     @Test
    public void test80And1B() {
       assertEquals(1, cs.caughtSpeeding(80, true));
    }
    @Test
    public void test81And2() {
      assertEquals(2, cs.caughtSpeeding(81, false));  
    }
    @Test
    public void test81And2B() {
     assertEquals(1, cs.caughtSpeeding(81, true));    
    }
    
}
