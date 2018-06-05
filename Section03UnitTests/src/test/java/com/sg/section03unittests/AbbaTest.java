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
public class AbbaTest {

    Abba abba = new Abba();

    public AbbaTest() {
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
     * Test of abba method, of class Abba.
     *
     */
    
    @Test
    public void testHiBye() {
        String expRes = "HiByeByeHi";
        assertEquals(expRes, abba.abba("Hi", "Bye"));
    }

    @Test
    public void testYoAlice() {
        String expRes = "YoAliceAliceYo";
        assertEquals(expRes, abba.abba("Yo", "Alice"));
    }

    @Test
    public void testWhatUp() {
        String expRes = "WhatUpUpWhat";
        assertEquals(expRes, abba.abba("What", "Up"));
    }

}
