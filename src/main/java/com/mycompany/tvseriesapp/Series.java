/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesapp;

/**
 *
 * @author lab_services_student
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    
    public int lastCaptureResult = 0;
    public int lastSearchResult  = 0;
    public int lastUpdateResult  = 0;
    public int lastDeleteResult  = 0;
    public int lastReportResult  = 0;
    
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

//=======================================================================================================================

    //Captures a new series
    public void CaptureSeries(){
        SeriesModel s = new SeriesModel();
        
        System.out.print("Enter the series id: ");
        s.SeriesId = input.nextLine();
        
        System.out.print("Enter the series name: ");
        s.SeriesName = input.nextLine();
        
    //Age Restriction
    while (true){
        System.out.print("Enter the series age restriction: ");
        String ageInput = input.nextLine();
        
        try {
            int age = Integer.parseInt(ageInput);
            if (age >= 2 && age <= 18){
                s.SeriesAge = String.valueOf(age);
                break;
            } else{
                System.out.println("You have entered an incorrect series age.");
            }
        } catch (NumberFormatException e){
            System.out.println("You have entered a non-number age restriction.");
        }
    }
    System.out.print("Enter the number of episodes for " + s.SeriesName + ": ");
    s.SeriesNumberOfEpisodes = input.nextLine();
    
    seriesList.add(s);
    System.out.println("Series processed successfully.");
    }

//=======================================================================================================================

    //Search for a series by ID
    public void SearchSeries(){
        System.out.print("Enter the series Id to search: ");
        String id = input.nextLine();
        
        SeriesModel found = null;
        for(SeriesModel s : seriesList){
            if(s.SeriesId.equals(id)){
                found = s;
                break;
            }
        }
        
        if(found != null){
            System.out.println("SERIES ID: " + found.SeriesId);
            System.out.println("SERIES NAME: " + found.SeriesName);
            System.out.println("SERIES AGE RESTRICTION: " + found.SeriesAge);
            System.out.println("SERIES NUMBER OF EPISODES: " + found.SeriesNumberOfEpisodes);
    }else{
            System.out.println("Series with Series Id: " + id + " was not found.");
            }
    }

//=======================================================================================================================
    
    //Update a series
    public void UpdateSeries(){
        System.out.print("Enter the series Id to update: ");
        String id = input.nextLine();
        
        SeriesModel found = null;
        for(SeriesModel s : seriesList){
            if(s.SeriesId.equals(id)){
                found = s;
                break;
            }
        }
    
        if(found != null){
            System.out.print("Enter the Series name: ");
            found.SeriesName = input.nextLine();
            
            //Age Restriction
            while(true){
                System.out.print("Enter the age restriction: ");
                String ageInput = input.nextLine();
                try {
                    int age = Integer.parseInt(ageInput);
                    if(age >= 2 && age <= 18){
                        found.SeriesAge = String.valueOf(age);
                        break;
                    }else{
                        System.out.print("Enter the age restriction: ");
                        }
                    }catch (NumberFormatException e){
                        System.out.println("You have entered a non-number age restriction.");
                }
            }
            
            System.out.print("Enter the number of episodes: ");
            found.SeriesNumberOfEpisodes = input.nextLine();
            System.out.println("Series updated successfully!");
    }else{
            System.out.println("Series Id not found!");
        }
    }
    
//=======================================================================================================================
    
    //Delete a series
    public void DeleteSeries(){
        System.out.print("Enter the series Id to delete: ");
        String id = input.nextLine();
        
        SeriesModel found = null;
        for (SeriesModel s : seriesList){
            if (s.SeriesId.equals(id)){
                found = s;
                break;
            }
        }
        
        if (found != null){
            System.out.print("Are you sure you want to delete series " + id + "? (y/n): ");
            String confirm = input.nextLine();
            if(confirm.equalsIgnoreCase("y")){
                seriesList.remove(found);
                System.out.println("Series with Id: " + id + " was deleted.");
            }else{
                System.out.println("Delete cancelled.");
            }
        }else{
            System.out.println("Series Id not found!");
        }
    }

//=======================================================================================================================
    
    //Print Series Report
    public void SeriesReport(){
        if (seriesList.isEmpty()){
            System.out.println("No series captured yet.");
            return;
        }
        int count = 1;
        for (SeriesModel s : seriesList){
            System.out.println("Series " + count++);
            System.out.println("---------------------------------");
            System.out.println("SERIES ID: " + s.SeriesId);
            System.out.println("SERIES NAME: " + s.SeriesName);
            System.out.println("SERIES AGE RESTRICTION: " + s.SeriesAge);
            System.out.println("SERIES NUMBER OF EPISODES: " + s.SeriesNumberOfEpisodes);
            System.out.println("---------------------------------");
        }
    }

//=======================================================================================================================
    
    public void ExitSeriesApplication(){
        System.out.println("Exiting application.");
        System.exit(0);
    }

//=======================================================================================================================
    
    //Unit testing
    
    //Age validity check
    public int ageIsValid(int age) {
    return (age >= 2 && age <= 18) ? 1 : 0;
    }

    //Add a series directly: 1 = success, 0 = fail.
    public int addSeriesDirect(String id, String name, int age, String episodes) {
    if (id == null || id.isBlank()) return 0;
    if (name == null || name.isBlank()) return 0;
    if (ageIsValid(age) == 0) return 0;

    //Prevents duplicate IDs
    for (SeriesModel x : seriesList) {
        if (x.SeriesId.equals(id)) return 0;
    }

    SeriesModel s = new SeriesModel();
    s.SeriesId = id;
    s.SeriesName = name;
    s.SeriesAge = String.valueOf(age);
    s.SeriesNumberOfEpisodes = episodes;
    seriesList.add(s);
    return 1;
    }

    //Find by ID
    public SeriesModel searchById(String id) {
    for (SeriesModel s : seriesList) {
        if (s.SeriesId.equals(id)) return s;
    }
    return null;
    }

    //Update by ID: 1 = updated, 0 = not updated.
    public int updateSeriesDirect(String id, String name, int age, String episodes) {
    SeriesModel s = searchById(id);
    if (s == null) return 0;
    if (ageIsValid(age) == 0) return 0;

    s.SeriesName = name;
    s.SeriesAge = String.valueOf(age);
    s.SeriesNumberOfEpisodes = episodes;
    return 1;
    }

    //Delete by ID: 1 = deleted, 0 = not found.
    public int deleteSeriesDirect(String id) {
    SeriesModel s = searchById(id);
    if (s == null) return 0;
    return seriesList.remove(s) ? 1 : 0;
    }
}
