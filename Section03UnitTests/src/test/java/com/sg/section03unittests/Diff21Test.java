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
public class Diff21Test {

    private Diff21 diff = new Diff21();

    public Diff21Test() {
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
     * Test of diff21 method, of class Diff21.
     */
    @Test
    public void test23() {
        int expRes = 4;
        assertEquals(expRes, diff.diff21(23));
    }

    @Test
    public void test10() {
        int expRes = 11;
        assertEquals(expRes, diff.diff21(10));
    }

    @Test
    public void test21() {
        int expRes = 0;
        assertEquals(expRes, diff.diff21(21));
    }

    @Test
    public void test22() {
        int expRes = 2;
        assertEquals(expRes, diff.diff21(22));
    }
}
