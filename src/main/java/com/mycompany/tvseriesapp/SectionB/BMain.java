/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tvseriesapp.SectionB;

/**
 *
 * @author lab_services_student
 */
import java.util.Scanner;

public class BMain {
    // Keep it small: 2 modules × 2 assessments
    private static final String[] MODULES = { "Programming", "Maths" };
    private static final int ASSESSMENTS = 2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GradeBook gb = new GradeBook(20); // fixed-size array

        while (true) {
            System.out.println("\n=== SECTION B — Gradebook ===");
            System.out.println("1.) Add student");
            System.out.println("2.) Capture marks for student");
            System.out.println("3.) Print report");
            System.out.println("4.) Exit");
            System.out.print("Choose: ");
            String choice = in.nextLine().trim();

            if (choice.equals("1")) {
                addStudent(in, gb);
            } else if (choice.equals("2")) {
                captureMarks(in, gb);
            } else if (choice.equals("3")) {
                gb.printReport();
            } else if (choice.equals("4")) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    //Adds student
    private static void addStudent(Scanner in, GradeBook gb) {
        System.out.print("Student ID: ");
        String id = in.nextLine().trim();
        System.out.print("Student Name: ");
        String name = in.nextLine().trim();

        Student s = new Student(id, name, MODULES, ASSESSMENTS);
        boolean added = gb.addStudent(s);
        System.out.println(added ? "Student added." : "Gradebook full.");
    }

    //Captures marks
    private static void captureMarks(Scanner in, GradeBook gb) {
        System.out.print("Student ID to capture marks for: ");
        String id = in.nextLine().trim();
        Student s = gb.findById(id);
        if (s == null) {
            System.out.println("Not found.");
            return;
        }

        for (int m = 0; m < s.getModuleCount(); m++) {
            System.out.println("Entering marks for: " + s.getModuleName(m));
            for (int a = 0; a < s.getAssessmentCount(); a++) {
                while (true) {
                    System.out.print("  Assessment " + (a + 1) + " (0-100): ");
                    String text = in.nextLine().trim();
                    try {
                        int mark = Integer.parseInt(text);
                        if (s.setMark(m, a, mark)) break;
                        System.out.println("  Invalid (0-100).");
                    } catch (NumberFormatException e) {
                        System.out.println("  Please enter a number.");
                    }
                }
            }
        }
        System.out.println("Marks captured.");
    }
}
