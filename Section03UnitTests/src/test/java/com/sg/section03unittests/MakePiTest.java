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
public class MakePiTest {

    private MakePi pi = new MakePi();

    public MakePiTest() {
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
     * Test of makePi method, of class MakePi.
     */
    @Test
    public void test3() {
        int[] expResult = new int[]{3, 1, 4};
        assertArrayEquals(expResult, pi.makePi(3));
    }

    @Test
    public void test7() {
        int[] expResult = new int[]{3, 1, 4, 1, 5, 9, 2};
        assertArrayEquals(expResult, pi.makePi(7));
    }

}
