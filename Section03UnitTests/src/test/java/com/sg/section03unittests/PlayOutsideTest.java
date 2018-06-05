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
public class PlayOutsideTest {

    private PlayOutside play = new PlayOutside();

    public PlayOutsideTest() {
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
    public void test70F() {
        assertTrue(play.playOutside(70, true));
    }

    @Test
    public void test95F() {
        assertFalse(play.playOutside(95, false));
    }

    @Test
    public void test95T() {
        assertTrue(play.playOutside(95, true));
    }

    @Test
    public void test59T() {
        assertFalse(play.playOutside(59, true));
    }

    @Test
    public void test59F() {
        assertFalse(play.playOutside(59, false));
    }

    @Test
    public void test60T() {
        assertTrue(play.playOutside(60, true));
    }

    @Test
    public void test60F() {
        assertTrue(play.playOutside(60, false));
    }

    @Test
    public void test90T() {
        assertTrue(play.playOutside(90, true));
    }

    @Test
    public void test90F() {
        assertTrue(play.playOutside(90, false));
    }

    @Test
    public void test91T() {
        assertTrue(play.playOutside(91, true));
    }

    @Test
    public void test91F() {
        assertFalse(play.playOutside(91, false));
    }

    @Test
    public void test100T() {
        assertTrue(play.playOutside(100, true));
    }

    @Test
    public void test100F() {
        assertFalse(play.playOutside(100, false));
    }

    @Test
    public void test101T() {
        assertFalse(play.playOutside(101, true));
    }

    @Test
    public void test101F() {
        assertFalse(play.playOutside(101, false));
    }

}
