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
public class SayHiTest {

    SayHi hi = new SayHi();

    public SayHiTest() {
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
    public void testBob() {
        String expectedResult = "Hello Bob!";
        assertEquals(expectedResult, hi.sayHi("Bob"));
    }

    @Test
    public void testAlice() {
        String expectedResult = "Hello Alice!";
        assertEquals(expectedResult, hi.sayHi("Alice"));
    }

    @Test
    public void testX() {
        String expRes = "Hello X!";
        assertEquals(expRes, hi.sayHi("X"));
    }

}
