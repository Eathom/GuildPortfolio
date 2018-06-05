/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.FMOrder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class FMDaoFileImplTest {
    
   
     public  FMDao dao; 
     

  


   // FMDao dao = new FMDaoFileImpl();
    
    public FMDaoFileImplTest()  {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = ctx.getBean("trainingDao", FMDao.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        List<LocalDate> orderDates = new ArrayList<>();
    
        for (LocalDate currentDate : orderDates) {
            dao.removeOrdersOnDate(currentDate);
        
     
     }
      
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getOrdersOnDate method, of class FMDaoFileImpl.
     * List<FMOrder> getOrdersOnDate(LocalDate orderDate);
    
    
     */
  
    @Test
    public void testGetOrdersOnDate() throws FMDaoDataPersistException{
        FMOrder newOrder = new FMOrder();
        newOrder.setOrderNumber(1);
        newOrder.setCustomerName("Doe");
        newOrder.setState("Minn");
        BigDecimal bd = new BigDecimal("1");
        newOrder.setTaxRate(bd);
        newOrder.setMaterialType("Bamboo");
        newOrder.setArea(bd);
        newOrder.setMaterialPerSqFt(bd);
        newOrder.setLaborPerSqFt(bd);
        newOrder.setMaterialTotal(bd);
        newOrder.setLaborTotal(bd);
        newOrder.setTaxTotal(bd);
        newOrder.setTotal(bd);
        LocalDate date = LocalDate.parse("2014-01-01");
        
     dao.addNewDateOrder(date, newOrder);
     
     
     
     List<FMOrder> expectedResult = new ArrayList<>();
    expectedResult.add(newOrder);
    
    assertEquals(expectedResult, dao.getOrdersOnDate(date));
    
     
    }

    /**
     * Test of addNewDateOrder method, of class FMDaoFileImpl.
     * 
     * FMOrder addNewDateOrder(FMOrder newOrder);
   
     */
    
    @Test
    public void testAddNewDateOrder() throws FMDaoDataPersistException{
       FMOrder newOrder = new FMOrder();
        newOrder.setOrderNumber(1);
        newOrder.setCustomerName("Doe");
        newOrder.setState("Minn");
        BigDecimal bd = new BigDecimal("1");
        newOrder.setTaxRate(bd);
        newOrder.setMaterialType("Bamboo");
        newOrder.setArea(bd);
        newOrder.setMaterialPerSqFt(bd);
        newOrder.setLaborPerSqFt(bd);
        newOrder.setMaterialTotal(bd);
        newOrder.setLaborTotal(bd);
        newOrder.setTaxTotal(bd);
        newOrder.setTotal(bd);
        
        LocalDate date = LocalDate.parse("2011-01-01");
    FMOrder added = dao.addNewDateOrder(date, newOrder);
    
     
     assertEquals(newOrder, added);
     
     assertEquals(1, dao.getOrdersOnDate(date).size());
     
     List<FMOrder> expectedResult = new ArrayList<>();
     expectedResult.add(newOrder);
     
     assertEquals(expectedResult, dao.getOrdersOnDate(date));
     
     FMOrder newOrder2 = new FMOrder();
      newOrder2.setOrderNumber(2);
        newOrder2.setCustomerName("Smith");
        newOrder2.setState("Texas");
        newOrder2.setTaxRate(bd);
        newOrder2.setMaterialType("Sheepskin");
        newOrder2.setArea(bd);
        newOrder2.setMaterialPerSqFt(bd);
        newOrder2.setLaborPerSqFt(bd);
        newOrder2.setMaterialTotal(bd);
        newOrder2.setLaborTotal(bd);
        newOrder2.setTaxTotal(bd);
        newOrder2.setTotal(bd);
        
        LocalDate date2 = LocalDate.parse("2019-01-01");
     FMOrder addedOrder2 = dao.addNewDateOrder(date2, newOrder2);
     
     assertEquals(newOrder2, addedOrder2);
     
      assertEquals(1, dao.getOrdersOnDate(date2).size());
     List<FMOrder> expectedResult2 = new ArrayList<>();
     expectedResult2.add(newOrder2);
     
     
     
     assertEquals(expectedResult2, dao.getOrdersOnDate(date2));
 
    }

   
    @Test
    public void testAddExistingDateOrder() throws FMDaoDataPersistException{
        FMOrder newOrder = new FMOrder();
        newOrder.setOrderNumber(1);
        newOrder.setCustomerName("Doe");
        newOrder.setState("Minn");
        BigDecimal bd = new BigDecimal("1");
        newOrder.setTaxRate(bd);
        newOrder.setMaterialType("Bamboo");
        newOrder.setArea(bd);
        newOrder.setMaterialPerSqFt(bd);
        newOrder.setLaborPerSqFt(bd);
        newOrder.setMaterialTotal(bd);
        newOrder.setLaborTotal(bd);
        newOrder.setTaxTotal(bd);
        newOrder.setTotal(bd);
        
        LocalDate date = LocalDate.parse("2011-01-01");
        dao.addNewDateOrder(date, newOrder);
     
     FMOrder newOrder2 = new FMOrder();
    
        newOrder2.setOrderNumber(2);
        newOrder2.setCustomerName("Smith");
        newOrder2.setState("Texas");
        newOrder2.setTaxRate(bd);
        newOrder2.setMaterialType("Sheepskin");
        newOrder2.setArea(bd);
        newOrder2.setMaterialPerSqFt(bd);
        newOrder2.setLaborPerSqFt(bd);
        newOrder2.setMaterialTotal(bd);
        newOrder2.setLaborTotal(bd);
        newOrder2.setTaxTotal(bd);
        newOrder2.setTotal(bd);
        
       
     FMOrder addedOrder2 = dao.addExistingDateOrder(date, newOrder2);
     
     assertEquals(newOrder2, addedOrder2);
     
      assertEquals(2, dao.getOrdersOnDate(date).size());
     List<FMOrder> expectedResult = new ArrayList<>();
     expectedResult.add(newOrder);
     expectedResult.add(newOrder2);
     
     
     
     assertEquals(expectedResult, dao.getOrdersOnDate(date));
    }
    
    /**
     * Test of editOrder method, of class FMDaoFileImpl.
     * 
     *  FMOrder editOrder(LocalDate orderDate, String orderNumber);
   */ 
   
     
    @Test
    public void testEditOrder() throws FMDaoDataPersistException{
   
        FMOrder newOrder = new FMOrder();
        newOrder.setOrderNumber(2);
        newOrder.setCustomerName("Doe");
        newOrder.setState("Minn");
         BigDecimal bd = new BigDecimal("1");
        newOrder.setTaxRate(bd);
        newOrder.setMaterialType("Bamboo");
        newOrder.setArea(bd);
        newOrder.setMaterialPerSqFt(bd);
        newOrder.setLaborPerSqFt(bd);
        newOrder.setMaterialTotal(bd);
        newOrder.setLaborTotal(bd);
        newOrder.setTaxTotal(bd);
        newOrder.setTotal(bd);
        LocalDate date = LocalDate.parse("2013-01-01");
        
        String expectedName = "Doe";
    
        FMOrder addedOrder = dao.addNewDateOrder(date, newOrder);
     
     List<FMOrder> daoList = dao.getOrdersOnDate(date);
     
     
     assertEquals(expectedName, daoList.get(0).getCustomerName());
     
    addedOrder.setCustomerName("Jenkins");
     
    dao.editOrder(date, addedOrder);
     String expectedNameChange = "Jenkins";
     
      List<FMOrder> daoList2 = dao.getOrdersOnDate(date);
     assertEquals(expectedNameChange, daoList2.get(0).getCustomerName());
     
    } 

    /*
     * Test of removeOrder method, of class FMDaoFileImpl.
     * 
     *  FMOrder removeOrder(LocalDate orderDate, String orderNumber);
     */
    @Test
    public void testRemoveOrder() throws FMDaoDataPersistException{
       FMOrder newOrder = new FMOrder();
        newOrder.setOrderNumber(1);
        newOrder.setCustomerName("Doe");
        newOrder.setState("Minn");
         BigDecimal bd = new BigDecimal("1");
        newOrder.setTaxRate(bd);
        newOrder.setMaterialType("Bamboo");
        newOrder.setArea(bd);
        newOrder.setMaterialPerSqFt(bd);
        newOrder.setLaborPerSqFt(bd);
        newOrder.setMaterialTotal(bd);
        newOrder.setLaborTotal(bd);
        newOrder.setTaxTotal(bd);
        newOrder.setTotal(bd);
        
        LocalDate date = LocalDate.parse("2014-01-01");
        dao.addNewDateOrder(date, newOrder);
 
    List<FMOrder> expectedResult = new ArrayList<>();
     expectedResult.add(newOrder);
     
    
     
     FMOrder newOrder2 = new FMOrder();
        newOrder2.setOrderNumber(2);
        newOrder2.setCustomerName("Smith");
        newOrder2.setState("Texas");
        newOrder2.setTaxRate(bd);
        newOrder2.setMaterialType("Sheepskin");
        newOrder2.setArea(bd);
        newOrder2.setMaterialPerSqFt(bd);
        newOrder2.setLaborPerSqFt(bd);
        newOrder2.setMaterialTotal(bd);
        newOrder2.setLaborTotal(bd);
        newOrder2.setTaxTotal(bd);
        newOrder2.setTotal(bd);
        
    dao.addExistingDateOrder(date, newOrder2);
     int sizeFromDao = dao.getOrdersOnDate(date).size();
   
    assertEquals(2, sizeFromDao);
     
    assertEquals(newOrder2, dao.removeOrder(date, newOrder2.getOrderNumber()));
 
     assertEquals(expectedResult, dao.getOrdersOnDate(date));
    }
    
}
