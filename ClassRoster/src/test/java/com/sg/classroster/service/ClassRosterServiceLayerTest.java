/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.service;

import com.sg.classroster.dto.Student;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Lizz
 */
public class ClassRosterServiceLayerTest {
    
   private ClassRosterServiceLayer service;
   
   
    
    public ClassRosterServiceLayerTest() {
      /*  ClassRosterDao dao = new ClassRosterDaoStubImpl();
        ClassRosterAuditDao audit = new ClassRosterAuditDaoStubImpl();
        
        service = new ClassRosterServiceLayerImpl(dao, audit); */
      ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
      
      service = ctx.getBean("serviceLayer", ClassRosterServiceLayer.class);
      
      
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
     * Test of createStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testCreateStudent() throws Exception {
        Student st = new Student("0002");
        st.setFirstName("Lizz");
        st.setLastName("Tho");
        st.setCohort("Java");
        
        service.createStudent(st);
        
        
    }
    
    @Test
    public void testCreateStudentDupId() throws Exception {
    Student st = new Student("0001");
        st.setFirstName("Lizz");
        st.setLastName("Tho");
        st.setCohort("Java");
       try{ 
        service.createStudent(st);
        fail("Expected duplicate id exception was not thrown");
       } catch (ClassRosterDuplicateIdException e) {
           return;
       }
        
    }
    
    @Test
    public void testCreateStudentInvalidData() throws Exception {
        Student st = new Student("0002");
        st.setFirstName("Lizz");
        st.setLastName("Tho");
        
       try{ 
        service.createStudent(st);
        fail("Expected data validation id exception was not thrown");
       } catch (ClassRosterDataValidationException e) {
           return;
       }
    }

    /**
     * Test of getAllStudents method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        assertEquals(1, service.getAllStudents().size());
        
    }

    /**
     * Test of getStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetStudent() throws Exception {
        Student stu = service.getStudent("0001");
        assertNotNull(stu);
        
        stu = service.getStudent("0009");
        assertNull(stu);
    }

    /**
     * Test of removeStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testRemoveStudent() throws Exception {
      Student stu = service.removeStudent("0001");
        assertNotNull(stu);
        
        stu = service.removeStudent("0009");
        assertNull(stu);   
    }

   
    
}
