/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Address;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lizz
 */
public class DaoTest {

    Dao dao = new DaoFileImpl();

    public DaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws DaoException {

        List<Address> addresses = new ArrayList<>();

        for (Address e : addresses) {
            dao.remove(e.getlName());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Dao.
     */
    @Test
    public void testAddAndView() throws Exception {
        Address newAdd = new Address();
        newAdd.setfName("Tom");
        newAdd.setlName("Cruise");
        newAdd.setAddr("Cali");

        dao.add(newAdd);

        Address fromDao = dao.viewAddr(newAdd.getlName());

        assertEquals(newAdd, fromDao);
    }

    @Test
    public void testViewNotExists() throws Exception {
        //if getting object, it will not be null, but an address, if getting
        //a property of an object, then it is null.
        assertNull(dao.viewAddr("Test").getlName());

    }

    /**
     * Test of remove method, of class Dao.
     */
    @Test
    public void testExistsRemove() throws Exception {
        Address newAdd = new Address();
        newAdd.setfName("Tom");
        newAdd.setlName("Cruise");
        newAdd.setAddr("Cali");

        dao.add(newAdd);

        Address add2 = new Address();
        add2.setfName("John");
        add2.setlName("Doen");
        add2.setAddr("Montevideo");

        dao.add(add2);

        assertTrue(dao.remove(newAdd.getlName()));
        assertEquals(1, dao.getCount());

        assertTrue(dao.remove(add2.getlName()));
        assertEquals(0, dao.getCount());

    }

    @Test
    public void testNotExistsRemove() throws Exception {
        Address newAdd = new Address();
        newAdd.setfName("Tom");
        newAdd.setlName("Cruise");
        newAdd.setAddr("Cali");

        dao.add(newAdd);

        assertFalse(dao.remove("Thompson"));
    }

    /**
     * Test of getCount method, of class Dao.
     */
    @Test
    public void testGetCount() throws Exception {

        Address add1 = new Address();
        add1.setfName("Jane");
        add1.setlName("Doe");
        add1.setAddr("Newhaven");

        dao.add(add1);

        Address add2 = new Address();
        add2.setfName("John");
        add2.setlName("Doen");
        add2.setAddr("Montevideo");

        dao.add(add2);

        assertEquals(2, dao.getCount());
    }

    /**
     * Test of viewAddr method, of class Dao.
     *
     *
     * /**
     * Test of viewAll method, of class Dao.
     */
    @Test
    public void testViewAll() throws Exception {
        Address add1 = new Address();
        add1.setfName("Jane");
        add1.setlName("Doe");
        add1.setAddr("Newhaven");

        dao.add(add1);

        Address add2 = new Address();
        add2.setfName("John");
        add2.setlName("Doen");
        add2.setAddr("Montevideo");

        dao.add(add2);

        assertEquals(2, dao.getCount());
        assertEquals(add1, dao.viewAddr(add1.getlName()));
        assertEquals(add2, dao.viewAddr(add2.getlName()));
    }

    /**
     * Test of edit method, of class Dao.
     */
    @Test
    public void testEditExists() throws Exception {
        Address add1 = new Address();
        add1.setfName("Jane");
        add1.setlName("Doe");
        add1.setAddr("Newhaven");

        dao.add(add1);
        String newAddr = "Nevada";
        dao.edit(add1.getlName(), newAddr);

        assertEquals(add1.getAddr(), newAddr);

        assertTrue(dao.edit("Doe", newAddr));

    }

    @Test
    public void testEditNotExist() throws Exception {
        Address add1 = new Address();
        add1.setfName("Jane");
        add1.setlName("Doe");
        add1.setAddr("Newhaven");

        dao.add(add1);
        String newAddr = "Nevada";

        assertFalse(dao.edit("Thomas", newAddr));
    }

}
