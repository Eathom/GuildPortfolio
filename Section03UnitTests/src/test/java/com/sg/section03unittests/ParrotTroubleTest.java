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
public class ParrotTroubleTest {

    private ParrotTrouble parrot = new ParrotTrouble();

    public ParrotTroubleTest() {
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
    public void testT6() {
        assertTrue(parrot.parrotTrouble(true, 6));
    }

    @Test
    public void testT7() {
        assertFalse(parrot.parrotTrouble(true, 7));
    }

    @Test
    public void testF6() {
        assertFalse(parrot.parrotTrouble(false, 6));
    }

    @Test
    public void testF7() {
        assertFalse(parrot.parrotTrouble(false, 7));
    }

    @Test
    public void testT20() {
        assertFalse(parrot.parrotTrouble(true, 20));
    }

    @Test
    public void testF20() {
        assertFalse(parrot.parrotTrouble(false, 20));
    }

    @Test
    public void testT21() {
        assertTrue(parrot.parrotTrouble(true, 21));
    }

    @Test
    public void testF21() {
        assertFalse(parrot.parrotTrouble(false, 21));
    }

}
