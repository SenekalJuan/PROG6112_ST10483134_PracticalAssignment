/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tvseriesapp;

/**
 *
 * @author lab_services_student
 */
import java.util.Scanner;
public class MainApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Series series = new Series();
        
        System.out.println("LATEST SERIES - 2025");
        System.out.println("*************************");
        System.out.println("Enter (1) to launch menu or any other key to exit: ");
        String choice = input.nextLine();
        
        if (!choice.equals("1")){
            System.out.println("Exiting...");
            return;
        }
        
        while(true){
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025.");
            System.out.println("(6) Exit Application.");
            System.out.print("Choose option: ");
            
            String option = input.nextLine();
            
            switch (option){
                case "1" -> series.CaptureSeries();
                case "2" -> series.SearchSeries();
                case "3" -> series.UpdateSeries();
                case "4" -> series.DeleteSeries();
                case "5" -> series.SeriesReport();
                case "6" -> series.ExitSeriesApplication();
                default -> System.out.println("Invalid option! Try again.");
            }
        }
    }
}
