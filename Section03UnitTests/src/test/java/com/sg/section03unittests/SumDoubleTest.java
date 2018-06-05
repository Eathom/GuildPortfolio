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
public class SumDoubleTest {

    private SumDouble sum = new SumDouble();

    public SumDoubleTest() {
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
     * Test of sumDouble method, of class SumDouble.
     */
    @Test
    public void testOneTwo() {
        int expRes = 3;
        assertEquals(expRes, sum.sumDouble(1, 2));
    }

    @Test
    public void testThreeTwo() {
        int expRes = 5;
        assertEquals(expRes, sum.sumDouble(3, 2));
    }

    @Test
    public void testTwoTwo() {
        int expRes = 8;
        assertEquals(expRes, sum.sumDouble(2, 2));
    }

}
