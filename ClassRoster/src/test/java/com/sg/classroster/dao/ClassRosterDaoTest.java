/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lizz
 */
public class ClassRosterDaoTest {
    private ClassRosterDao dao = new ClassRosterDaoFileImpl();
    
    public ClassRosterDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<Student> students = dao.getAllStudents();
        
        for (Student e : students) {
            dao.removeStudent(e.getStudentId());
        }
    }
    
    @After
    public void tearDown() {
 
    }

    /**
     * Test of addStudent method, of class ClassRosterDao.
     */
    @Test
    public void testAddGetStudent() throws Exception {
        Student student = new Student("0001");
        
        student.setFirstName("Joe");
        student.setLastName("Smith");
        student.setCohort("Java");
                
        dao.addStudent(student.getStudentId(), student);
        
        Student studentFromDao = dao.getStudent(student.getStudentId());
        
        assertEquals(student, studentFromDao);
                
    }

    /**
     * Test of getStudent method, of class ClassRosterDao.
     */
  

    /**
     * Test of getAllStudents method, of class ClassRosterDao.
     */
    @Test
    public void testGetAllStudents() throws Exception {
         Student stOne = new Student("0001");
     stOne.setFirstName("Joe");
     stOne.setLastName("Smith");
     stOne.setCohort("Java");
     
     dao.addStudent(stOne.getStudentId(), stOne);
     
     Student stTwo = new Student("0002");
     stTwo.setFirstName("Jimmy");
     stTwo.setLastName("John");
     stTwo.setCohort("Net");
     
     dao.addStudent(stTwo.getStudentId(), stTwo);
     
     assertEquals(2, dao.getAllStudents().size());
    }

    /**
     * Test of removeStudent method, of class ClassRosterDao.
     */
    @Test
    public void testRemoveStudent() throws Exception {
       Student stOne = new Student("0001");
     stOne.setFirstName("Joe");
     stOne.setLastName("Smith");
     stOne.setCohort("Java");
     
     dao.addStudent(stOne.getStudentId(), stOne);
     
     Student stTwo = new Student("0002");
     stTwo.setFirstName("Jimmy");
     stTwo.setLastName("John");
     stTwo.setCohort("Net");
     
     dao.addStudent(stTwo.getStudentId(), stTwo);
     
     dao.removeStudent(stOne.getStudentId());
     
     assertEquals(1, dao.getAllStudents().size());
     
     assertNull(dao.getStudent(stOne.getStudentId()));
     dao.removeStudent(stTwo.getStudentId());
     
     assertEquals(0, dao.getAllStudents().size());
     assertNull(dao.getStudent(stTwo.getStudentId()));
    }

 
    
}
