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
public class CanHazTableTest {

    CanHazTable haz = new CanHazTable();

    public CanHazTableTest() {
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
    public void test5And10() {
        assertEquals(2, haz.canHazTable(5, 10));
    }

    @Test
    public void test5And2() {
        assertEquals(0, haz.canHazTable(5, 2));
    }

    @Test
    public void test5And5() {
        assertEquals(1, haz.canHazTable(5, 5));
    }

    @Test
    public void test5And8() {
        assertEquals(2, haz.canHazTable(5, 8));
    }

    @Test
    public void test5And3() {
        assertEquals(1, haz.canHazTable(5, 3));
    }

    @Test
    public void test5And7() {
        assertEquals(1, haz.canHazTable(5, 7));
    }
}
