/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lizz
 */
public class ClassRosterDaoStubImpl implements ClassRosterDao {

    Student only;
    List<Student> stList = new ArrayList<>();

    public ClassRosterDaoStubImpl() {
        only = new Student("0001");
        only.setFirstName("Lizz");
        only.setLastName("Thompson");
        only.setCohort("Java");

        stList.add(only);
    }

    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
        if (studentId.equals(only.getStudentId())) {
            return only;
        } else {
            return null;
        }
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        if (studentId.equals(only.getStudentId())) {
            return only;
        } else {
            return null;
        }

    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return stList;
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
       if (studentId.equals(only.getStudentId())) {
            return only;
        } else {
            return null;
        } }

}
