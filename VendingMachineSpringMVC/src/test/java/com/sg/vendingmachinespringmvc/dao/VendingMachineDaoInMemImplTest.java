/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.util.List;
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
public class VendingMachineDaoInMemImplTest {
    
    private VendingMachineDao dao;
    
    public VendingMachineDaoInMemImplTest() {
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
        dao = ctx.getBean("VendingMachineDao", VendingMachineDao.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of purchaseItem method, of class VendingMachineDaoInMemImpl.
     */
    @Test
    public void testPurchaseItem() {
        
        Item lintRoller = dao.getItemById(7);
        int inStock = lintRoller.getAmountInStock();
        
        Item purchased = dao.purchaseItem(7);
        
        assertEquals((inStock - 1), purchased.getAmountInStock());
        assertEquals("Lint Roller", purchased.getName());
    }
   
    @Test
    public void getAll(){
        List<Item> all = dao.getAllItems();
        
        assertEquals(9, all.size());
    }
}
