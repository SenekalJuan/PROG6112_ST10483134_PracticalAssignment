/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesapp.SectionB;

/**
 *
 * @author lab_services_student
 */
//Base Class
public class Person {
    private String id;
    private String name;
    
    public Person(String id, String name){
        this.id = id;
        this.name = name;
    }
    
    //Encapsulated access
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
