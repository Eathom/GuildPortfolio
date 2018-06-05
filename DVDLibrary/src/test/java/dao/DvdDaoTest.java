/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sg.dvdlibrary.dao.DvdDaoFileImpl;
import com.sg.dvdlibrary.dao.DvdDao;
import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class DvdDaoTest {

    private DvdDao dao = new DvdDaoFileImpl();

    public DvdDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {

        List<DVD> dvds = dao.listAll();
        for (DVD e : dvds) {
            dao.remove(e.getTitle());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class DvdDao.
     */
    @Test
    public void testAddAndShow() throws Exception {
        DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/07/2025", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Factory Arts");
        dvd1.setUserReview(5);

        dao.add(dvd1);

        DVD fromDao = dao.showDVD(dvd1.getTitle());

        assertEquals(dvd1, fromDao);
    }

    /**
     * Test of remove method, of class DvdDao.
     */
    @Test
    public void testRemove() throws Exception {
        DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/07/2025", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Factory Arts");
        dvd1.setUserReview(5);

        dao.add(dvd1);

        DVD dvd2 = new DVD("Black Bayou");
        dvd2.setDirector("Cesar");
        dvd2.setMpaaRating("R");
        LocalDate ld3 = LocalDate.parse("11/17/2002", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd2.setReleaseDate(ld3);
        dvd2.setStudio("Maritime Features");
        dvd2.setUserReview(4);

        dao.add(dvd2);

        dao.remove(dvd1.getTitle());

        assertEquals(1, dao.listAll().size());

        dao.remove(dvd2.getTitle());

        assertEquals(0, dao.listAll().size());

    }

    /**
     * Test of edit method, of class DvdDao.
     */
    @Test
    public void testEdit() throws Exception {
        DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/07/2025", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Factory Arts");
        dvd1.setUserReview(3);

        dao.add(dvd1);

        DVD edited = new DVD("Ants");
        edited.setDirector("Milo And Otis");
        edited.setMpaaRating("R");
        LocalDate editLd = LocalDate.parse("01/07/2025", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        edited.setReleaseDate(editLd);
        edited.setStudio("Dog House Arts");
        edited.setUserReview(2);

        dao.edit("Ants", edited);

        DVD inDao = dao.showDVD("Ants");
        assertEquals(1, dao.listAll().size());
        assertEquals(edited.getDirector(), inDao.getDirector());
    }

    /**
     * Test of listAll method, of class DvdDao.
     */
    @Test
    public void testListAll() throws Exception {
        DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/07/2025", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Factory Arts");
        dvd1.setUserReview(5);

        dao.add(dvd1);

        DVD dvd2 = new DVD("Black Bayou");
        dvd2.setDirector("Cesar");
        dvd2.setMpaaRating("R");
        LocalDate ld3 = LocalDate.parse("11/17/2002", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd2.setReleaseDate(ld3);
        dvd2.setStudio("Maritime Features");
        dvd2.setUserReview(5);

        dao.add(dvd2);

        assertEquals(2, dao.listAll().size());
    }

    /**
     * Test of searchLibrary method, of class DvdDao.
     *
     * To test logic of this method, will need to create service layer and Unit
     * tests for that.
     */
    @Test
    public void testSearchLibrary() throws Exception {
        DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/07/2025", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Factory Arts");
        dvd1.setUserReview(4);

        dao.add(dvd1);

        DVD dvd2 = new DVD("Black Bayou");
        dvd2.setDirector("Cesar");
        dvd2.setMpaaRating("R");
        LocalDate ld3 = LocalDate.parse("11/17/2002", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd2.setReleaseDate(ld3);
        dvd2.setStudio("Maritime Features");
        dvd2.setUserReview(5);

        dao.add(dvd2);

        DVD found = dao.searchLibrary(dvd1.getTitle());
        assertEquals(dvd1, found);
    }

    @Test
    public void listAgeRange() throws Exception {
        DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/01/2016", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Factory Arts");
        dvd1.setUserReview(2);

        dao.add(dvd1);

        DVD dvd2 = new DVD("Black Bayou");
        dvd2.setDirector("Cesar");
        dvd2.setMpaaRating("R");
        LocalDate ld3 = LocalDate.parse("11/17/2002", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd2.setReleaseDate(ld3);
        dvd2.setStudio("Maritime Features");
        dvd2.setUserReview(3);

        dao.add(dvd2);

        List<DVD> dvdInRange = dao.listInLastXYears(3);
        
        
        assertEquals(1, dvdInRange.size());
       assertEquals(dvd1, dvdInRange.get(0));
    }

    @Test
    public void listByMPAA() throws Exception {
        DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/01/2016", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Factory Arts");
        dvd1.setUserReview(3);

        dao.add(dvd1);

        DVD dvd2 = new DVD("Black Bayou");
        dvd2.setDirector("Cesar");
        dvd2.setMpaaRating("R");
        LocalDate ld2 = LocalDate.parse("11/17/2002", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd2.setReleaseDate(ld2);
        dvd2.setStudio("Maritime Features");
        dvd2.setUserReview(2);

        dao.add(dvd2);
        
         DVD dvd3 = new DVD("Gigantic Booogieman");
        dvd3.setDirector("Jerome");
        dvd3.setMpaaRating("G");
        LocalDate ld3 = LocalDate.parse("05/07/1998", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd3.setReleaseDate(ld3);
        dvd3.setStudio("Baby-Dook");
        dvd3.setUserReview(5);

        dao.add(dvd3);
        List<DVD> expDvdList = new ArrayList<>();
        expDvdList.add(dvd1);
        expDvdList.add(dvd2);
        
        List<DVD> dvdR = dao.listByMPAA("R");
        assertEquals(2, dvdR.size());
        assertEquals(expDvdList, dvdR);
    }

    @Test
    public void listByDirectorSortedByMPAA() throws Exception {
    
        DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/01/2016", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Factory Arts");
        dvd1.setUserReview(1);

        dao.add(dvd1);

        DVD dvd2 = new DVD("Black Bayou");
        dvd2.setDirector("Hancock");
        dvd2.setMpaaRating("R");
        LocalDate ld2 = LocalDate.parse("11/17/2002", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd2.setReleaseDate(ld2);
        dvd2.setStudio("Maritime Features");
        dvd2.setUserReview(5);

        dao.add(dvd2);
        
         DVD dvd3 = new DVD("Gigantic Booogieman");
        dvd3.setDirector("Hancock");
        dvd3.setMpaaRating("G");
        LocalDate ld3 = LocalDate.parse("05/07/1998", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd3.setReleaseDate(ld3);
        dvd3.setStudio("Baby-Dook");
        dvd3.setUserReview(3);

        dao.add(dvd3);
        
        Map<String, List<DVD>> directorListByMPAA = dao.listByDirectorSortedByMPAA("Hancock");
        assertEquals(2, directorListByMPAA.size() );   
    }

    @Test
    public void listByStudio() throws Exception {
    DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/01/2016", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Baby-Dook");
        dvd1.setUserReview(4);

        dao.add(dvd1);

        DVD dvd2 = new DVD("Black Bayou");
        dvd2.setDirector("Cesar");
        dvd2.setMpaaRating("R");
        LocalDate ld2 = LocalDate.parse("11/17/2002", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd2.setReleaseDate(ld2);
        dvd2.setStudio("Maritime Features");
        dvd2.setUserReview(2);

        dao.add(dvd2);
        
         DVD dvd3 = new DVD("Gigantic Booogieman");
        dvd3.setDirector("Jerome");
        dvd3.setMpaaRating("G");
        LocalDate ld3 = LocalDate.parse("05/07/1998", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd3.setReleaseDate(ld3);
        dvd3.setStudio("Baby-Dook");
        dvd3.setUserReview(1);

        dao.add(dvd3);
        List<DVD> expDvdList = new ArrayList<>();
        expDvdList.add(dvd1);
        expDvdList.add(dvd3);
        
        List<DVD> dvdR = dao.listByStudio("Baby-Dook");
        assertEquals(2, dvdR.size());
        assertEquals(expDvdList, dvdR);
    }

    @Test
    public void findAvgAge() throws Exception {
         DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/01/2016", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Baby-Dook");
        dvd1.setUserReview(2);

        dao.add(dvd1);

        DVD dvd2 = new DVD("Black Bayou");
        dvd2.setDirector("Cesar");
        dvd2.setMpaaRating("R");
        LocalDate ld2 = LocalDate.parse("11/17/2002", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd2.setReleaseDate(ld2);
        dvd2.setStudio("Maritime Features");
        dvd2.setUserReview(12);

        dao.add(dvd2);
        
         DVD dvd3 = new DVD("Gigantic Booogieman");
        dvd3.setDirector("Jerome");
        dvd3.setMpaaRating("G");
        LocalDate ld3 = LocalDate.parse("05/07/1998", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd3.setReleaseDate(ld3);
        dvd3.setStudio("Baby-Dook");
        dvd3.setUserReview(3);

        dao.add(dvd3);
        
        double expRes = (dvd1.getAge() + dvd2.getAge() + dvd3.getAge()) / 3;
      assertEquals(expRes, dao.findAvgAge(), .8) ; 
              
        
    }

    @Test
    public void viewNewest() throws Exception {
      DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/01/2016", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Baby-Dook");
        dvd1.setUserReview(5);

        dao.add(dvd1);

        DVD dvd2 = new DVD("Black Bayou");
        dvd2.setDirector("Cesar");
        dvd2.setMpaaRating("R");
        LocalDate ld2 = LocalDate.parse("11/17/2002", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd2.setReleaseDate(ld2);
        dvd2.setStudio("Maritime Features");
        dvd2.setUserReview(4);

        dao.add(dvd2);
        
         DVD dvd3 = new DVD("Gigantic Booogieman");
        dvd3.setDirector("Jerome");
        dvd3.setMpaaRating("G");
        LocalDate ld3 = LocalDate.parse("05/07/1998", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd3.setReleaseDate(ld3);
        dvd3.setStudio("Baby-Dook");
        dvd3.setUserReview(4);

        dao.add(dvd3);
        
        
        assertEquals(dvd1, dao.viewNewest());
    }

    @Test
    public void viewOldest() throws Exception {
         DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/01/2016", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Baby-Dook");
        dvd1.setUserReview(4);

        dao.add(dvd1);

        DVD dvd2 = new DVD("Black Bayou");
        dvd2.setDirector("Cesar");
        dvd2.setMpaaRating("R");
        LocalDate ld2 = LocalDate.parse("11/17/2002", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd2.setReleaseDate(ld2);
        dvd2.setStudio("Maritime Features");
        dvd2.setUserReview(5);

        dao.add(dvd2);
        
         DVD dvd3 = new DVD("Gigantic Booogieman");
        dvd3.setDirector("Jerome");
        dvd3.setMpaaRating("G");
        LocalDate ld3 = LocalDate.parse("05/07/1998", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd3.setReleaseDate(ld3);
        dvd3.setStudio("Baby-Dook");
        dvd3.setUserReview(7);

        dao.add(dvd3);
        
        assertEquals(dvd3, dao.viewOldest());
    }

    @Test
    public void averageNote() throws Exception {
      DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/01/2016", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Baby-Dook");
        dvd1.setUserReview(3);

        dao.add(dvd1);

        DVD dvd2 = new DVD("Black Bayou");
        dvd2.setDirector("Cesar");
        dvd2.setMpaaRating("R");
        LocalDate ld2 = LocalDate.parse("11/17/2002", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd2.setReleaseDate(ld2);
        dvd2.setStudio("Maritime Features");
        dvd2.setUserReview(2);

        dao.add(dvd2);
        
         DVD dvd3 = new DVD("Gigantic Booogieman");
        dvd3.setDirector("Jerome");
        dvd3.setMpaaRating("G");
        LocalDate ld3 = LocalDate.parse("05/07/1998", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd3.setReleaseDate(ld3);
        dvd3.setStudio("Baby-Dook");
        dvd3.setUserReview(1);

        dao.add(dvd3);
        
        double expResult = (dvd1.getUserReview() + dvd2.getUserReview()+ dvd3.getUserReview()) / 3;
        
        assertEquals(expResult, dao.avgStarRating(), .8);
    }

    @Test
    public void listInLastXYears() throws Exception {
      DVD dvd1 = new DVD("Ants");
        dvd1.setDirector("Hancock");
        dvd1.setMpaaRating("R");
        LocalDate ld = LocalDate.parse("01/01/2016", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd1.setReleaseDate(ld);
        dvd1.setStudio("Baby-Dook");
        dvd1.setUserReview(3);

        dao.add(dvd1);

        DVD dvd2 = new DVD("Black Bayou");
        dvd2.setDirector("Cesar");
        dvd2.setMpaaRating("R");
        LocalDate ld2 = LocalDate.parse("11/17/2002", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dvd2.setReleaseDate(ld2);
        dvd2.setStudio("Maritime Features");
        dvd2.setUserReview(2);

        dao.add(dvd2);
       
        List<DVD> result = new ArrayList<>();
        result.add(dvd1);
        
        assertEquals(result, dao.listInLastXYears(3));
        
    }
     
        
}
