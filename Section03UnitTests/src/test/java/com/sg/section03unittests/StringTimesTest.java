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
public class StringTimesTest {

    StringTimes stTi = new StringTimes();

    public StringTimesTest() {
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
    public void testStringTimes2() {
        String expResult = "HiHi";
        assertEquals(expResult, stTi.stringTimes("Hi", 2));
    }

    @Test
    public void testStringTimes3() {
        String expResult = "HiHiHi";
        assertEquals(expResult, stTi.stringTimes("Hi", 3));
    }

    @Test
    public void testStringTimes1() {
        String expResult = "Hi";
        assertEquals(expResult, stTi.stringTimes("Hi", 1));
    }

}
