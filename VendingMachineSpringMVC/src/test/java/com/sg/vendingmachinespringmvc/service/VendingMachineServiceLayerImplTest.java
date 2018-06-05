/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.model.Change;
import java.math.BigDecimal;
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
public class VendingMachineServiceLayerImplTest {
    VendingMachineServiceLayer service;
    
    public VendingMachineServiceLayerImplTest() {
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
        service = ctx.getBean("VendingMachineServiceLayer", VendingMachineServiceLayer.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of purchaseItem method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testPurchaseItem() throws NoInventoryException, InsufficientFundsException {
        BigDecimal money = new BigDecimal("3.00");
        String result = service.purchaseItem(1, money);
        
        String ty = "Thank you!";
        
        assertEquals(ty,result);
    }
    @Test
    public void testPurchaseNoItem() throws InsufficientFundsException{
         BigDecimal money = new BigDecimal("3.00");
         try{
             service.purchaseItem(13, money);
             fail("Expected no inventory exception not thrown");
         } catch (NoInventoryException e){
             return;
         }
        
        
    }
    @Test
    public void testPurchaseInsuffFunds()   throws NoInventoryException {
       BigDecimal money = new BigDecimal("1.00");
       try{
        service.purchaseItem(1, money);
         fail("Expected insufficient funds exception not thrown");
    } catch(InsufficientFundsException e){
        return;
    }
    }

    /**
     * Test of returnChange method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testReturnChange94(){
        BigDecimal cost = new BigDecimal("0");
        BigDecimal money = new BigDecimal("0.94");
        Change change = service.returnChange(money, cost);
        
        
        assertEquals(3, change.getQuarter());
        assertEquals(1, change.getDime());
        assertEquals(1, change.getNickel());
        assertEquals(4, change.getPenny());
        
    }
   
    
}
