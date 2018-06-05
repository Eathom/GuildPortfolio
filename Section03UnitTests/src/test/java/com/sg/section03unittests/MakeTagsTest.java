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
public class MakeTagsTest {

    private MakeTags tags = new MakeTags();

    public MakeTagsTest() {
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
    public void testIYay() {
        String expRes = "<i>Yay</i>";
        assertEquals(expRes, tags.makeTags("i", "Yay"));
    }

    @Test
    public void testIHello() {
        String expRes = "<i>Hello</i>";
        assertEquals(expRes, tags.makeTags("i", "Hello"));
    }

    @Test
    public void testCiteYay() {
        String expRes = "<cite>Yay</cite>";
        assertEquals(expRes, tags.makeTags("cite", "Yay"));
    }

}
