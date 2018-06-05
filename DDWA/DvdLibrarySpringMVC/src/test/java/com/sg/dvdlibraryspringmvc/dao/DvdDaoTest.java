/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Validator;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author Lizz
 */
public class DvdDaoTest {

    DvdDao dao;
    Validator validator;
    public DvdDaoTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
     
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        dao = ctx.getBean("DvdDao", DvdDao.class);

        List<Dvd> all = dao.getAllDvds();

        for (Dvd c : all) {
            dao.removeDvd(c.getDvdId());
        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addDvd method, of class DvdDao.
     */
    @Test
    public void testAddDvd() {
        Dvd one = new Dvd();
        one.setDirector("Hans");
        one.setRating("PG");
        String ld = "2001";
        
        one.setTitle("Stark Bars");

        Dvd added = dao.addDvd(one);
        assertEquals(one, added);
        assertEquals(1, dao.getAllDvds().size());
        
         Dvd two = new Dvd();
        two.setDirector("Solo");
        two.setRating("PG");
        String ld2 = "2002";
       
        two.setTitle("Stark Bars");
        
        Dvd second = dao.addDvd(two);
         assertEquals(two, second);
        assertEquals(2, dao.getAllDvds().size());
    }

    /**
     * Test of removeDvd method, of class DvdDao.
     */
    @Test
    public void testRemoveDvd() {
        Dvd one = new Dvd();
        one.setDirector("Hans");
        one.setRating("PG");
        String ld = "2001";
        
        one.setTitle("Stark Bars");

        Dvd added = dao.addDvd(one);
        assertEquals(one, added);

        dao.removeDvd(one.getDvdId());
        assertEquals(0, dao.getAllDvds().size());
    }
    
     @Test
    public void testRemoveBadDvd() {
    }
    /**
     * Test of updateDvd method, of class DvdDao.
     */
    @Test
    public void testUpdateDvd() {
        Dvd one = new Dvd();

        one.setDirector("Hans");
        one.setRating("PG");
        String ld = "2001";
        
        one.setTitle("Stark Bars");

        Dvd added = dao.addDvd(one);
        long addedId = added.getDvdId();

        Dvd two = new Dvd();
        two.setDirector("Solo");
        two.setRating("PG");
        String ld2 = "2001";
        
        two.setTitle("Stark Bars");
        two.setDvdId(addedId);

        dao.updateDvd(two);

        assertEquals("Solo", dao.getDvdById(addedId).getDirector());

    }
    
   
    @Test
    public void testSearchDvds() {
        Dvd one = new Dvd();

        one.setDirector("Hans");
        one.setRating("PG");
          String ld = "2001";
       
        one.setTitle("Stark Bars");

        Dvd added = dao.addDvd(one);
        Map<SearchTerm, String> search = new HashMap<>();
        search.put(SearchTerm.TITLE, "Stark Bars");

        assertEquals(added, dao.searchDvds(search).get(0));
    }
    
    @Test
    public void testSearchBadDvds() {
    Dvd one = new Dvd();

        one.setDirector("Hans");
        one.setRating("PG");
          String ld = "2001";
        
        one.setTitle("Stark Bars");

        Dvd added = dao.addDvd(one);
        Map<SearchTerm, String> search = new HashMap<>();
        search.put(SearchTerm.TITLE, "Lola");

        assertEquals(0, dao.searchDvds(search).size());
    }
}

