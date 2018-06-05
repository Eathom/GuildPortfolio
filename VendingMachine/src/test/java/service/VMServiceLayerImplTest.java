/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.sg.vendingmachine.service.VMServiceLayer;
import com.sg.vendingmachine.service.VMDataValidationException;
import com.sg.vendingmachine.service.VMNoItemInvException;
import com.sg.vendingmachine.service.VMInsuffFundsException;
import com.sg.vendingmachine.dto.VMChange;
import com.sg.vendingmachine.dto.VMItem;
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
public class VMServiceLayerImplTest {

    //   private VMDao dao = new VMDaoStubImpl();
    // private VMAuditLogDao audit = new VMAuditDaoStubImpl();
    private VMServiceLayer service;

    public VMServiceLayerImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("service", VMServiceLayer.class);

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
     * Test of buyItem method, of class VMServiceLayerImpl. Will search dao for
     * item and return it.
     */
    @Test
    public void testInInvEnoughFund() throws Exception {

        String buyableItem = "Chicas";
        VMItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("8.00");

        VMChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());

        assertEquals(0, change.getPenny());
        assertEquals(0, change.getNickel());
        assertEquals(0, change.getDime());
        assertEquals(0, change.getQuarter());

    }

    @Test
    public void testMoneyTracking() throws Exception {
        BigDecimal cash = new BigDecimal("8.00");
        service.addToMoney(cash);

        assertEquals(cash, service.getCurrentMoney());

        BigDecimal extraCash = new BigDecimal("3");
        service.addToMoney(extraCash);

        BigDecimal total = cash.add(extraCash);
        assertEquals(total, service.getCurrentMoney());

        service.buyItem("Chicas", total);

        BigDecimal zero = new BigDecimal("0");
        assertEquals(zero, service.getCurrentMoney());

    }

    @Test
    public void testInInvCalcChange51() throws Exception {
        String buyableItem = "Chicas";
        VMItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("8.51");

        VMChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());
        assertEquals(1, change.getPenny());
        assertEquals(0, change.getNickel());
        assertEquals(0, change.getDime());
        assertEquals(2, change.getQuarter());
    }

    @Test
    public void testInInvCalcChange12() throws Exception {
        String buyableItem = "Chicas";
        VMItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("8.12");

        VMChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());
        assertEquals(2, change.getPenny());
        assertEquals(0, change.getNickel());
        assertEquals(1, change.getDime());
        assertEquals(0, change.getQuarter());
    }

    @Test
    public void testInInvCalcChange06() throws Exception {
        String buyableItem = "Chicas";
        VMItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("8.06");

        VMChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());
        assertEquals(1, change.getPenny());
        assertEquals(1, change.getNickel());
        assertEquals(0, change.getDime());
        assertEquals(0, change.getQuarter());
    }

    @Test
    public void testInInvCalcChange99() throws Exception {
        String buyableItem = "Chicas";
        VMItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("8.99");

        VMChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());
        assertEquals(4, change.getPenny());
        assertEquals(0, change.getNickel());
        assertEquals(2, change.getDime());
        assertEquals(3, change.getQuarter());
    }

    @Test
    public void testInInvCalcChange01() throws Exception {
        String buyableItem = "Chicas";
        VMItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("8.01");

        VMChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());
        assertEquals(1, change.getPenny());
        assertEquals(0, change.getNickel());
        assertEquals(0, change.getDime());
        assertEquals(0, change.getQuarter());
    }

    @Test
    public void testInInvCalcChange125() throws Exception {
        String buyableItem = "Chicas";
        VMItem fromDao = service.getItem(buyableItem);

        BigDecimal cash = new BigDecimal("9.25");

        VMChange change = service.buyItem(buyableItem, cash);

        assertEquals(buyableItem, fromDao.getName());
        assertEquals(0, change.getPenny());
        assertEquals(0, change.getNickel());
        assertEquals(0, change.getDime());
        assertEquals(5, change.getQuarter());
    }

    @Test
    public void testInInvInsuffFund() throws Exception {
        String buyableItem = "Chicas";
        BigDecimal cash = new BigDecimal("7.99");

        try {
            service.buyItem(buyableItem, cash);
            fail("expected insuff funds exc not thrown");
        } catch (VMInsuffFundsException e) {
            return;
        }

    }

    @Test
    public void testBuyOrRemoveNotInInv() throws Exception {
        String buyableItem = "cookies";
        BigDecimal cash = new BigDecimal("7.99");

        try {
            service.buyItem(buyableItem, cash);
            fail("expected no item in inv. exc not thrown");
        } catch (VMNoItemInvException e) {
            return;
        }
    }

    /**
     * Test of removeItems method, of class VMServiceLayerImpl.
     */
    @Test
    public void testRemoveItemInInv() throws Exception {
        String buyableItem = "Chicas";

        
        VMItem removed = service.removeItems(buyableItem);
        assertEquals(buyableItem, removed.getName());
    }

    /**
     * add method tests
     *
     *
     * @throws Exception
     */
    @Test
    public void testAddItemFieldMissing() throws Exception {
        VMItem item = new VMItem("Paperclips");
        item.setNumInStock(3);

        try {
            item.setPrice("");
            fail("Expected num format exc not thrown");
        } catch (NumberFormatException e) {
            return;
        }
        try {
            service.addItem(item);
            fail("Expected data validatn exc not thrown");
        } catch (VMDataValidationException e) {
            return;
        }
    }

    @Test
    public void testAddItemNotInInv() throws Exception {
        VMItem item = new VMItem("Paperclips");
        item.setNumInStock(3);
        item.setPrice("12.00");

        assertEquals(3, service.addItem(item));

    }

    @Test
    public void testAddItemInInv() throws Exception {
        VMItem item = new VMItem("Chicas");
        item.setNumInStock(75);
        item.setPrice("12.00");

        int newNum = service.addItem(item);

        assertEquals(78, newNum);
    }

}
