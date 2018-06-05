/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.service;

import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Lizz
 */
public class DvdServiceLayerTest {

    DvdServiceLayer service;

    public DvdServiceLayerTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        service = ctx.getBean("service", DvdServiceLayer.class);
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
     * Test of add method, of class DvdServiceLayer.
     */
    @Test
    public void testAdd() throws Exception {
        DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/07/2025", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Factory Arts");
        dvd1.setUserReview(5);

        DVD added = service.add(dvd1);
        assertEquals(dvd1, added);
    }

    @Test
    public void testAddFail() throws Exception {
        DVD dvd1 = new DVD("Scream");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/07/2025", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Factory Arts");
        dvd1.setUserReview(5);

        try {
            service.add(dvd1);
            fail("Excepted duplicate dvd exception");
        } catch (DvdAlreadyExistsException e) {
            return;
        }

    }

    /**
     * Test of remove method, of class DvdServiceLayer.
     */
    @Test
    public void testRemove() throws Exception {
        DVD removed = service.remove("Scream");

        assertEquals(removed.getTitle(), "Scream");
    }

    @Test
    public void testRemoveFail() throws Exception {
        try {
            service.remove("Halloween");
            fail("Expected dvd not found exception");
        } catch (DvdNotFoundException e) {
            return;
        }
    }

    /**
     * Test of edit method, of class DvdServiceLayer.
     */
    @Test
    public void testEditLD() throws Exception {
        DVD edited = service.edit("Scream", "01/01/2017", 1);
        assertNotNull(edited);
       

    }

    @Test
    public void testEditLDFail() throws Exception {
        try {
            service.edit("Dog", "01/01/2017", 1);
            fail("Expected not found exception");
        } catch (DvdNotFoundException e) {
            return;
        }
    }

    @Test
    public void testEditMPAA() throws Exception {
        DVD edited = service.edit("Scream", "G", 2);
        assertNotNull(edited);
    }

    @Test
    public void testEditMPAAFail() throws Exception {
        try {
            service.edit("Dog", "R", 2);
            fail("Exptected not found exception");
        } catch (DvdNotFoundException e) {
            return;
        }
    }

    @Test
    public void testEditDir() throws Exception {
        DVD edited = service.edit("Scream", "Holmes", 3);
        assertNotNull(edited);
    }

    @Test
    public void testEditDirFail() throws Exception {
        try {
            service.edit("Dog", "James", 3);
            fail("Exptected not found exception");
        } catch (DvdNotFoundException e) {
            return;
        }
    }

    @Test
    public void testEditStud() throws Exception {
        DVD edited = service.edit("Scream", "Marshall", 4);
        assertNotNull(edited);
    }

    @Test
    public void testEditStudFail() throws Exception {
        try {
            service.edit("Dog", "Univ", 4);
            fail("Expected not found exception");
        } catch (DvdNotFoundException e) {
            return;
        }
    }

    @Test
    public void testEditRating() throws Exception {
        DVD edited = service.edit("Scream", "1", 5);
        assertNotNull(edited);
    }

    @Test
    public void testEditRatingFail() throws Exception {
        try {
            service.edit("Dog", "1", 5);
            fail("Expected not found exception");
        } catch (DvdNotFoundException e) {
            return;
        }
    }

    /**
     * Test of listOne method, of class DvdServiceLayer.
     */
    @Test
    public void testListOne() throws Exception {
        DVD one = service.listOne("Scream");
        assertEquals(one.getTitle(), "Scream");
    }

    @Test
    public void testListOneFail() throws Exception {
        try {
            service.listOne("Halloween");
            fail("Expected dvd not found exception");
        } catch (DvdNotFoundException e) {
            return;
        }
    }

}
