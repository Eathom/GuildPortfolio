/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sg.vendingmachine.dao.VMDaoFileImpl;
import com.sg.vendingmachine.dao.VMDaoDataPersistException;
import com.sg.vendingmachine.dao.VMDao;
import com.sg.vendingmachine.dto.VMItem;
import java.util.List;
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
public class VMDaoFileImplTest {

    //made dao instantiation static because constructor loads file, which could cause exception. wrote try catch w/in static
    //because try catch can only be written inside a method??
    public static VMDao dao;

    static {
        try {
            dao = new VMDaoFileImpl();
        } catch (VMDaoDataPersistException e) {
            System.out.println("Error");
        }
    }

    public VMDaoFileImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws VMDaoDataPersistException {
        List<VMItem> itemList = dao.getAllItems();

        for (VMItem i : itemList) {
            dao.removeItem(i.getName());
        }

    }

    @After
    public void tearDown() {
    }
//setUp is testing getAll and remove.

    /**
     * Test of buyItem method, of class VMDaoFileImpl.
     */
    @Test
    public void testBuyItem() throws VMDaoDataPersistException {
        VMItem toAdd = new VMItem("candy");
        toAdd.setNumInStock(2);
        toAdd.setPrice("8");

        dao.addNewItem(toAdd);

        dao.buyItem(toAdd.getName());

        VMItem fromDao = dao.getItem(toAdd.getName());

        assertEquals(1, fromDao.getNumInStock());
        assertEquals(toAdd, fromDao);

    }

    /**
     * Test of removeItems method, of class VMDaoFileImpl.
     */
    @Test
    public void testRemoveItems() throws VMDaoDataPersistException {
        VMItem toAdd = new VMItem("candy");
        toAdd.setNumInStock(2);
        toAdd.setPrice("8");

        dao.addNewItem(toAdd);

        VMItem toAdd1 = new VMItem("cola");
        toAdd.setNumInStock(7);
        toAdd1.setPrice("3");

        dao.addNewItem(toAdd1);

        dao.removeItem(toAdd.getName());

        assertEquals(1, dao.getAllItems().size());
        assertNull(dao.getItem("candy"));

        dao.removeItem(toAdd1.getName());

        assertEquals(0, dao.getAllItems().size());
        assertNull(dao.getItem("cola"));
    }

    @Test
    public void testAddToItem() throws Exception {
        VMItem toAdd = new VMItem("candy");
        toAdd.setNumInStock(1);
        toAdd.setPrice("8");

        dao.addNewItem(toAdd);

        VMItem toAdd1 = new VMItem("candy");
        toAdd1.setNumInStock(7);
        toAdd1.setPrice("3");

        dao.addToItem(toAdd1);

        assertEquals(1, dao.getAllItems().size());
        assertEquals(8, dao.getItem(toAdd.getName()).getNumInStock());
    }

    @Test

    public void testAddNewItem() throws Exception {

        VMItem toAdd = new VMItem("candy");
        toAdd.setNumInStock(1);
        toAdd.setPrice("8");

        dao.addNewItem(toAdd);

        VMItem toAdd1 = new VMItem("cola");
        toAdd.setNumInStock(7);
        toAdd1.setPrice("3");

        dao.addNewItem(toAdd1);

        assertEquals(2, dao.getAllItems().size());

    }

}
