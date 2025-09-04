/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesapp.SectionB;

/**
 *
 * @author lab_services_student
 */
//Derived class using 2D array
public class Student extends Person{
    private final int[][] marks; //2D array
    private final String[] modules; //1D array
    
//=======================================================================================================================
    
    public Student(String id, String name, String[] modules, int assessmentsPerModule){
        super(id, name);
        this.modules = modules.clone();
        this.marks = new int[modules.length][assessmentsPerModule];
    }
    
    public int getModuleCount(){
        return modules.length;
    }
    public int getAssessmentCount(){
        return marks[0].length;
    }
    public String getModuleName(int i){
        return modules[i];
    }
    
//=======================================================================================================================
    
    //Validate and set a mark
    public boolean setMark(int moduleIndex, int assessmentIndex, int value){
        if (moduleIndex < 0 || moduleIndex >= marks.length) 
            return false;
        if (assessmentIndex < 0 || assessmentIndex >= marks[0].length)
            return false;
        if (value < 0 || value > 100)
            return false;
        marks[moduleIndex][assessmentIndex] = value;
        return true;
    }
    
    public int getMark(int moduleIndex, int assessmentIndex){
        return marks[moduleIndex][assessmentIndex];
    }
    
    public double moduleAverage(int moduleIndex){
        int sum = 0;
        for(int a = 0; a < marks[moduleIndex].length; a++){
            sum += marks[moduleIndex][a];
    }
    return sum / (double) marks[moduleIndex].length;
    }

//=======================================================================================================================

    //Unit Testing
    public int markIsValid(int value) {
    return (value >= 0 && value <= 100) ? 1 : 0;
    }

    public int indicesAreValid(int moduleIndex, int assessmentIndex) {
    return (moduleIndex >= 0 && moduleIndex < marks.length
         && assessmentIndex >= 0 && assessmentIndex < marks[0].length) ? 1 : 0;
    }

    public int setMarkInt(int moduleIndex, int assessmentIndex, int value) {
    return setMark(moduleIndex, assessmentIndex, value) ? 1 : 0;
    }

    public int moduleAverageEquals(int moduleIndex, double expected, double epsilon) {
    return Math.abs(moduleAverage(moduleIndex) - expected) <= epsilon ? 1 : 0;
    }
}

