/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FMDao;
import com.sg.flooringmastery.dao.FMDaoDataPersistException;
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
public class FMServiceLayerImplTest {

 
     FMServiceLayer service;
     
        
       
    

    public FMServiceLayerImplTest() throws FMDaoDataPersistException {
         ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
         service = ctx.getBean("service", FMServiceLayer.class);
        service.setDao(ctx.getBean("stubDao", FMDao.class));
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp()  throws FMDaoDataPersistException {
    
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getOrdersOnDate method, of class FMServiceLayerImpl.
     */
    @Test
    public void testGetOrdersOnDateSuccess() throws FMNoOrderExistsException, FMDaoDataPersistException {
        FMOrder newOrder = new FMOrder();
        newOrder.setOrderNumber(1);
        newOrder.setCustomerName("Doe");
        newOrder.setState("OH");

        BigDecimal taxRate = new BigDecimal("6.25");
        newOrder.setTaxRate(taxRate);

        newOrder.setMaterialType("Wood");

        BigDecimal area = new BigDecimal("50.00");
        newOrder.setArea(area);

        BigDecimal matSq = new BigDecimal("5.15");
        newOrder.setMaterialPerSqFt(matSq);

        BigDecimal labSq = new BigDecimal("4.75");
        newOrder.setLaborPerSqFt(labSq);

        BigDecimal matTot = new BigDecimal("257.50");
        newOrder.setMaterialTotal(matTot);

        BigDecimal labTot = new BigDecimal("237.50");
        newOrder.setLaborTotal(labTot);

        BigDecimal taxTot = new BigDecimal("30.94");
        newOrder.setTaxTotal(taxTot);

        BigDecimal tot = new BigDecimal("525.94");
        newOrder.setTotal(tot);
        LocalDate date = LocalDate.parse("2014-01-01");

        List<FMOrder> only = new ArrayList<>();
        only.add(newOrder);

        List<FMOrder> fromDao = service.getOrdersOnDate(date);

        assertEquals(only, fromDao);

    }

    @Test
    public void testGetOrdersOnDateFail() throws FMDaoDataPersistException {

        LocalDate date = LocalDate.parse("2014-01-02");
        try {
            service.getOrdersOnDate(date);
            fail("NoOrderExistsExc not thrown.");
        } catch (FMNoOrderExistsException e) {
            return;
        }
    }

    /**
     * Test of addOrder method, of class FMServiceLayerImpl.
     */
    @Test
    public void testAddNewDateOrderSuccess() throws FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException {
        FMOrder anOrder = new FMOrder();
        anOrder.setOrderNumber(1);
        anOrder.setCustomerName("Doe");
        anOrder.setState("OH");
        BigDecimal taxRate1 = new BigDecimal("6.25");
        anOrder.setTaxRate(taxRate1);

        anOrder.setMaterialType("Wood");

        BigDecimal area1 = new BigDecimal("100.00");
        anOrder.setArea(area1);

        BigDecimal matSq1 = new BigDecimal("5.15");
        anOrder.setMaterialPerSqFt(matSq1);

        BigDecimal labSq1 = new BigDecimal("4.75");
        anOrder.setLaborPerSqFt(labSq1);

        BigDecimal matTot1 = new BigDecimal("515.00");
        anOrder.setMaterialTotal(matTot1);

        BigDecimal labTot1 = new BigDecimal("475.00");
        anOrder.setLaborTotal(labTot1);

        BigDecimal taxTot1 = new BigDecimal("61.88");
        anOrder.setTaxTotal(taxTot1);

        BigDecimal tot1 = new BigDecimal("1051.88");
        anOrder.setTotal(tot1);
//COMPARE AN ORDER TO NEW ORDER --------------------------------------------//
        FMOrder newOrder = new FMOrder();
        newOrder.setCustomerName("Doe");
        newOrder.setState("OH");

        newOrder.setMaterialType("Wood");

        String area = "100.00";
        newOrder.setStringArea(area);

        LocalDate date = LocalDate.parse("2014-01-02");
        service.calculateNewOrder(date, newOrder);
        FMOrder daoReturn = service.addOrder(date, newOrder);

        assertEquals(anOrder, daoReturn);

    }

    @Test
    public void testAddNewDateOrderBlankProperty() throws FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException {
        FMOrder added = null;

        FMOrder newOrder = new FMOrder();
        newOrder.setOrderNumber(1);
        newOrder.setCustomerName("");
        newOrder.setState("OH");
        BigDecimal taxRate = new BigDecimal("6.25");
        newOrder.setTaxRate(taxRate);

        newOrder.setMaterialType("Wood");

        String area = "100.00";
        newOrder.setStringArea(area);

        BigDecimal matSq = new BigDecimal("5.15");
        newOrder.setMaterialPerSqFt(matSq);

        BigDecimal labSq = new BigDecimal("4.75");
        newOrder.setLaborPerSqFt(labSq);

        BigDecimal matTot = new BigDecimal("515.00");
        newOrder.setMaterialTotal(matTot);

        BigDecimal labTot = new BigDecimal("475.00");
        newOrder.setLaborTotal(labTot);

        BigDecimal taxTot = new BigDecimal("61.88");
        newOrder.setTaxTotal(taxTot);

        BigDecimal tot = new BigDecimal("1051.88");
        newOrder.setTotal(tot);
        LocalDate date = LocalDate.parse("2014-01-02");

        FMOrder correctedOrder = new FMOrder();
        correctedOrder.setCustomerName("Briggs");

        try {
            service.calculateNewOrder(date, newOrder);
            fail("Exc not thrown");
        } catch (FMMissingPropertyException e) {
            FMOrder calcdOrder = service.correctBadOrder(date, newOrder, correctedOrder);
            added = service.addOrder(date, calcdOrder);
        }

        String expResult = "Briggs";
        String fromService = added.getCustomerName();
        assertEquals(expResult, fromService);

    }

    @Test
    public void testAddNewDateOrderNullProperty() throws FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException {
        FMOrder added = null;
        FMOrder newOrder = new FMOrder();
        newOrder.setOrderNumber(1);
        //name not set
        newOrder.setState("MI");

        newOrder.setMaterialType("Wood");
        String area = "100.00";
        newOrder.setStringArea(area);

        LocalDate date = LocalDate.parse("2014-01-02");
        FMOrder correctedOrder = new FMOrder();
        correctedOrder.setCustomerName("Briggs");
        
        try {
            service.calculateNewOrder(date, newOrder);
            service.addOrder(date, newOrder);
            fail("Exc not thrown");
        } catch (FMMissingPropertyException e) {
            FMOrder calcdOrder = service.correctBadOrder(date, newOrder, correctedOrder);
            added = service.addOrder(date, calcdOrder);
        }

        String expResult = "Briggs";
        String fromService = added.getCustomerName();
        assertEquals(expResult, fromService);
    }

    @Test
    public void testAddNewDateOrderWrongProperty() throws FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException {
        FMOrder newOrder = new FMOrder();
        newOrder.setOrderNumber(1);
        newOrder.setCustomerName("Doe");
        newOrder.setState("MN");

        newOrder.setMaterialType("Wood");
        String area = "100.00";
        newOrder.setStringArea(area);

        LocalDate date = LocalDate.parse("2014-01-02");

        try {
            service.calculateNewOrder(date, newOrder);
            service.addOrder(date, newOrder);
            fail("Exc not thrown");
        } catch (FMInvalidPropertyException e) {
            return;
        }

    }

    @Test
    public void testAddNewDateOrderCalculations() throws FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException {
        FMOrder newOrder = new FMOrder();
        newOrder.setCustomerName("Danny");
        newOrder.setState("OH");

        newOrder.setMaterialType("Wood");
        String area = "100.00";
        newOrder.setStringArea(area);

        LocalDate date = LocalDate.parse("2014-01-02");

        service.calculateNewOrder(date, newOrder);
        FMOrder fromService = service.addOrder(date, newOrder);
        BigDecimal taxTotal = new BigDecimal("61.88");
        assertEquals(taxTotal, fromService.getTaxTotal());
    }

    @Test
    public void testAddExistingDateOrderSucess() throws FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException {
        FMOrder anOrder = new FMOrder();
        anOrder.setOrderNumber(1);
        anOrder.setCustomerName("Doe");
        anOrder.setState("OH");
        BigDecimal taxRate1 = new BigDecimal("6.25");
        anOrder.setTaxRate(taxRate1);

        anOrder.setMaterialType("Wood");

        BigDecimal area1 = new BigDecimal("100.00");
        anOrder.setArea(area1);

        BigDecimal matSq1 = new BigDecimal("5.15");
        anOrder.setMaterialPerSqFt(matSq1);

        BigDecimal labSq1 = new BigDecimal("4.75");
        anOrder.setLaborPerSqFt(labSq1);

        BigDecimal matTot1 = new BigDecimal("515.00");
        anOrder.setMaterialTotal(matTot1);

        BigDecimal labTot1 = new BigDecimal("475.00");
        anOrder.setLaborTotal(labTot1);

        BigDecimal taxTot1 = new BigDecimal("61.88");
        anOrder.setTaxTotal(taxTot1);

        BigDecimal tot1 = new BigDecimal("1051.88");
        anOrder.setTotal(tot1);

        //--------------------------COMPare -------------------//
        FMOrder newOrder = new FMOrder();
        newOrder.setCustomerName("Doe");
        newOrder.setState("OH");

        newOrder.setMaterialType("Wood");
        String area = "100.00";
        newOrder.setStringArea(area);
        LocalDate date = LocalDate.parse("2014-01-01");
        service.calculateNewOrder(date, newOrder);
        FMOrder daoReturn = service.addOrder(date, newOrder);

        assertEquals(anOrder, daoReturn);
    }

    @Test
    public void testAddExistingDateOrderBlankProperty() throws FMInvalidPropertyException, FMDaoDataPersistException {
        FMOrder newOrder = new FMOrder();
        newOrder.setCustomerName("");
        newOrder.setState("MI");

        newOrder.setMaterialType("Wood");
        String area = "100.00";
        newOrder.setStringArea(area);

        LocalDate date = LocalDate.parse("2014-01-01");

        try {
            service.calculateNewOrder(date, newOrder);
            service.addOrder(date, newOrder);
            fail("Exc not thrown");
        } catch (FMMissingPropertyException e) {
            return;
        }
    }

    @Test
    public void testAddExistingDateOrderWrongProperty() throws FMMissingPropertyException, FMDaoDataPersistException {
        FMOrder newOrder = new FMOrder();
        newOrder.setCustomerName("Jones");
        newOrder.setState("MN");

        newOrder.setMaterialType("Wood");
        String area = "100.00";
        newOrder.setStringArea(area);

        LocalDate date = LocalDate.parse("2014-01-01");

        try {
            service.calculateNewOrder(date, newOrder);
            service.addOrder(date, newOrder);
            fail("Exc not thrown");
        } catch (FMInvalidPropertyException e) {
            return;
        }
    }

    @Test
    public void testAddExistingDateOrderCalculations() throws FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException {
        FMOrder newOrder = new FMOrder();
        newOrder.setCustomerName("Hill");
        newOrder.setState("OH");

        newOrder.setMaterialType("Wood");
        String area = "100.00";
        newOrder.setStringArea(area);

        LocalDate date = LocalDate.parse("2014-01-01");

        service.calculateNewOrder(date, newOrder);
        FMOrder fromService = service.addOrder(date, newOrder);
        BigDecimal taxTotal = new BigDecimal("61.88");
        assertEquals(taxTotal, fromService.getTaxTotal());
    }

    /**
     * Test of getOrder method, of class FMServiceLayerImpl.
     */
    @Test
    public void testGetOrderSuccess() throws FMNoOrderExistsException, FMDaoDataPersistException {
        FMOrder newOrder = new FMOrder();
        newOrder.setOrderNumber(1);
        newOrder.setCustomerName("Doe");
        newOrder.setState("OH");

        BigDecimal taxRate = new BigDecimal("6.25");
        newOrder.setTaxRate(taxRate);

        newOrder.setMaterialType("Wood");

        BigDecimal area = new BigDecimal("50.00");
        newOrder.setArea(area);

        BigDecimal matSq = new BigDecimal("5.15");
        newOrder.setMaterialPerSqFt(matSq);

        BigDecimal labSq = new BigDecimal("4.75");
        newOrder.setLaborPerSqFt(labSq);

        BigDecimal matTot = new BigDecimal("257.50");
        newOrder.setMaterialTotal(matTot);

        BigDecimal labTot = new BigDecimal("237.50");
        newOrder.setLaborTotal(labTot);

        BigDecimal taxTot = new BigDecimal("30.94");
        newOrder.setTaxTotal(taxTot);

        BigDecimal tot = new BigDecimal("525.94");
        newOrder.setTotal(tot);

        LocalDate date = LocalDate.parse("2014-01-01");

        FMOrder fromDao = service.getOrder(date, newOrder.getOrderNumber());

        assertEquals(newOrder, fromDao);

    }

    @Test
    public void testGetOrderFail() throws FMDaoDataPersistException {
        FMOrder newOrder = new FMOrder();
        newOrder.setCustomerName("Doe");
        newOrder.setState("Minn");
        BigDecimal bd = new BigDecimal("1");
        newOrder.setTaxRate(bd);
        newOrder.setMaterialType("Bamboo");
        BigDecimal area = new BigDecimal("50");
        newOrder.setArea(area);
        newOrder.setMaterialPerSqFt(bd);
        newOrder.setLaborPerSqFt(bd);
        newOrder.setMaterialTotal(bd);
        newOrder.setLaborTotal(bd);
        newOrder.setTaxTotal(bd);
        newOrder.setTotal(bd);
        LocalDate date = LocalDate.parse("2014-01-01");

        try {
            service.getOrder(date, newOrder.getOrderNumber());
            fail("Exc not thrown.");
        } catch (FMNoOrderExistsException e) {
            return;
        }
    }

    /**
     * Test of editOrder method, of class FMServiceLayerImpl.
     */
    @Test
    public void testEditOrderSucess() throws FMNoOrderExistsException, FMMissingPropertyException, FMInvalidPropertyException, FMDaoDataPersistException {
        LocalDate date = LocalDate.parse("2014-01-01");
        Integer orderNumber = 1;

        FMOrder orderToEdit = service.getOrder(date, orderNumber);

        FMOrder orderWithChanges = new FMOrder();
        orderWithChanges.setCustomerName("Anderson");

        service.editOrder(date, orderToEdit, orderWithChanges);

        FMOrder orderFromDao = service.getOrder(date, orderNumber);

        assertEquals("Anderson", orderFromDao.getCustomerName());
    }

    @Test
    public void testEditOrderWrongProperty() throws FMNoOrderExistsException, FMMissingPropertyException, FMDaoDataPersistException {
        LocalDate date = LocalDate.parse("2014-01-01");
        Integer orderNumber = 1;

        FMOrder orderToEdit = service.getOrder(date, orderNumber);
        FMOrder orderWithChanges = new FMOrder();
        orderWithChanges.setState("MN");

        try {
            service.editOrder(date, orderToEdit, orderWithChanges);
            fail("Exc not thrown");
        } catch (FMInvalidPropertyException e) {
            return;
        }

    }

    @Test
    public void testEditOrderCalculations() throws FMNoOrderExistsException, FMInvalidPropertyException, FMMissingPropertyException, FMDaoDataPersistException {
        LocalDate date = LocalDate.parse("2014-01-01");
        Integer orderNumber = 1;

        FMOrder orderToEdit = service.getOrder(date, orderNumber);

        FMOrder orderWithChange = new FMOrder();
        String area = "100.00";
        orderWithChange.setStringArea(area);

        FMOrder updatedOrder = service.editOrder(date, orderToEdit, orderWithChange);
        BigDecimal taxTotal = new BigDecimal("61.88");
        assertEquals(taxTotal, updatedOrder.getTaxTotal());
    }

    /**
     * Test of removeOrder method, of class FMServiceLayerImpl.
     */
    @Test
    public void testRemoveOrderFound() throws FMNoOrderExistsException, FMDaoDataPersistException {
        LocalDate date = LocalDate.parse("2014-01-01");
        Integer orderNumber = 1;

        FMOrder orderToRemove = service.getOrder(date, orderNumber);
        

        FMOrder removedOrder = service.removeOrder(date, orderToRemove.getOrderNumber());

        assertEquals(orderToRemove, removedOrder);

    }

    @Test
    public void testRemoveOrderNotFound() throws FMDaoDataPersistException {
        LocalDate date = LocalDate.parse("2014-01-01");
        Integer orderNumber = 4;
        try {
            FMOrder orderToRemove = service.getOrder(date, orderNumber);
            fail("Exc not thrown");
        } catch (FMNoOrderExistsException e) {
            return;
        }

    }

    /**
     * Test of commitChanges method, of class FMServiceLayerImpl.
     */
    @Test
    public void testCommitChangesYes() throws FMDaoDataPersistException {

        Boolean commited = service.commitChanges();

        assertTrue(commited);

    }

}
