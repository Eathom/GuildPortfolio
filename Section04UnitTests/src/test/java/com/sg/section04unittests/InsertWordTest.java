/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

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
public class InsertWordTest {
    InsertWord iw = new InsertWord();
    public InsertWordTest() {
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
    public void testyay() {
        String expRes = "<<Yay>>";
        assertEquals(expRes, iw.insertWord("<<>>", "Yay"));
    }
        @Test
    public void testwoohoo() {
        String expRes = "<<WooHoo>>";
        assertEquals(expRes, iw.insertWord("<<>>", "WooHoo"));
    }
    
         @Test
    public void testwoohoos() {
        String expRes = "[[word]]";
        assertEquals(expRes, iw.insertWord("[[]]", "word"));
    }
    
}
