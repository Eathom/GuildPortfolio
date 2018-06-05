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
public class SameFirstLastTest {

    private SameFirstLast same = new SameFirstLast();

    public SameFirstLastTest() {
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
     * Test of sameFirstLast method, of class SameFirstLast.
     *
     */
    @Test
    public void testOneTwoThree() {
        int[] input = new int[]{1, 2, 3};
        assertFalse(same.sameFirstLast(input));
    }

    @Test
    public void testOneTwoThreeOne() {
        int[] input = new int[]{1, 2, 3, 1};
        assertTrue(same.sameFirstLast(input));
    }

    @Test
    public void testOneTwoOne() {
        int[] input = new int[]{1, 2, 1};
        assertTrue(same.sameFirstLast(input));
    }

    @Test
    public void testZero() {
        int[] input = new int[0];
        assertFalse(same.sameFirstLast(input));
    }
}
