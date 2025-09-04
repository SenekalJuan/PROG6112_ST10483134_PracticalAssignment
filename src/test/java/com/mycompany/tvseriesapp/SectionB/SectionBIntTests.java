/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesapp.SectionB;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class SectionBIntTests {

    private static final String[] MODULES = {"Programming", "Maths"};
    private static final int ASSESSMENTS = 2;

//=======================================================================================================================
    
    @Test
    void TestAddStudent_And_FindById() {
        GradeBook gb = new GradeBook(2);
        Student s = new Student("ST1", "Alice", MODULES, ASSESSMENTS);

        assertEquals(1, gb.addStudentInt(s));
        assertEquals(1, gb.findByIdExists("ST1"));
    }

    @Test
    void TestAddStudent_CapacityFull_Returns0() {
        GradeBook gb = new GradeBook(1);
        assertEquals(1, gb.addStudentInt(new Student("ST1", "A", MODULES, ASSESSMENTS)));
        assertEquals(0, gb.addStudentInt(new Student("ST2", "B", MODULES, ASSESSMENTS)));
    }

    @Test
    void TestSetMark_Valid_And_GetMark() {
        Student s = new Student("ST1", "A", MODULES, ASSESSMENTS);
        assertEquals(1, s.setMarkInt(0, 0, 75));
        assertEquals(1, s.setMarkInt(0, 1, 65));
        assertEquals(75, s.getMark(0, 0));
        assertEquals(65, s.getMark(0, 1));
    }

    @Test
    void TestSetMark_InvalidIndex_Or_Range_Returns0() {
        Student s = new Student("ST1", "A", MODULES, ASSESSMENTS);
        // bad indices
        assertEquals(0, s.setMarkInt(-1, 0, 50));
        assertEquals(0, s.setMarkInt( 2, 0, 50));
        assertEquals(0, s.setMarkInt(0, -1, 50));
        assertEquals(0, s.setMarkInt(0,  2, 50));
        // out-of-range marks
        assertEquals(0, s.setMarkInt(0, 0, -5));
        assertEquals(0, s.setMarkInt(0, 0, 101));
    }

    @Test
    void TestModuleAverage_EqualsExpected() {
        Student s = new Student("ST1", "A", MODULES, ASSESSMENTS);
        assertEquals(1, s.setMarkInt(1, 0, 80));
        assertEquals(1, s.setMarkInt(1, 1, 60));
        // average should be 70.0; epsilon 1e-9
        assertEquals(1, s.moduleAverageEquals(1, 70.0, 1e-9));
    }

    @Test
    void TestPerson_Encapsulation_And_SetName() {
        Person p = new Person("P1", "Bob");
        assertEquals(1, "P1".equals(p.getId()) ? 1 : 0);
        assertEquals(1, "Bob".equals(p.getName()) ? 1 : 0);
        p.setName("Bobby");
        assertEquals(1, "Bobby".equals(p.getName()) ? 1 : 0);
    }

    @Test
    void TestPrintReport_Safe() {
        GradeBook gb = new GradeBook(2);
        Student s = new Student("S1", "Alice", MODULES, ASSESSMENTS);
        s.setMarkInt(0, 0, 50); s.setMarkInt(0, 1, 60);
        s.setMarkInt(1, 0, 70); s.setMarkInt(1, 1, 80);
        gb.addStudentInt(s);

        assertEquals(1, gb.printReportSafe());
    }
}