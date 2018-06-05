/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

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
public class FrontTimesTest {

    private FrontTimes front = new FrontTimes();

    public FrontTimesTest() {
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

    /**
     * Test of frontTimes method, of class FrontTimes.
     */
    @Test
    public void testChocolate2() {
        String expResult = "ChoCho";
        assertEquals(expResult, front.frontTimes("Chocolate", 2));
    }

    @Test
    public void testChocolate3() {
        String expResult = "ChoChoCho";
        assertEquals(expResult, front.frontTimes("Chocolate", 3));
    }

    @Test
    public void testAbc3() {
        String expResult = "AbcAbcAbc";
        assertEquals(expResult, front.frontTimes("Abc", 3));
    }

    @Test
    public void testAb2() {
        String expResult = "AbAb";
        assertEquals(expResult, front.frontTimes("Ab", 2));
    }

}
