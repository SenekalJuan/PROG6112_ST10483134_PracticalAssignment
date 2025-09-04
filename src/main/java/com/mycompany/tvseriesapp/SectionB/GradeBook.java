/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesapp.SectionB;

/**
 *
 * @author lab_services_student
 */
public class GradeBook {
    private final Student[] students;
    private int count = 0;
    
    public GradeBook(int capacity){
        this.students = new Student[capacity];
    }
    
    public boolean addStudent(Student s){
        if (count >= students.length) return false;
        students[count++] = s;
        return true;
    }
    
    public Student findById(String id){
        for(int i = 0; i < count; i++){
            if (students[i].getId().equals(id)) return students[i];
        }
        return null;
    }
    
    private static double round1(double x){
        return Math.round(x * 10.0)/10.0;
    }
    
//=======================================================================================================================
    
    public void printReport(){
        if (count == 0){
            System.out.println("No students captured yet.\n");
            return;
        }
        
        System.out.println("==== GRADEBOOK REPORT ====");
        
        System.out.println("-----------------------------------");
        for(int i = 0; i < count; i++){
            Student s = students[i];
            System.out.println(s.getId() + " - " + s.getName());
            
            for(int m = 0; m < s.getModuleCount(); m++){
                String line = " " + s.getModuleName(m) + " -> marks:";
                for(int a = 0; a < s.getAssessmentCount(); a++){
                    line += " " + s.getMark(m, a);
                }
                
                double avg = round1(s.moduleAverage(m));
                line += " | avg: " + avg;
                System.out.println(line);
            }
            System.out.println("-----------------------------------");
        }
    }

//=======================================================================================================================
    
    //Unit Testing
    public int addStudentInt(Student s) {
    return addStudent(s) ? 1 : 0;
    }

    public int findByIdExists(String id) {
    return (findById(id) != null) ? 1 : 0;
    }

    public int printReportSafe() {
    try {
        printReport();
        return 1;
    } catch (Exception e) {
        return 0;
    }
    }
}
