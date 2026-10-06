/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospitalapp;
 import java.util.Scanner;

/**
 *
 * @author Administrator
 */


public class HospitalApp {

    public static void main(String[] args) {

        Scanner MyK = new Scanner(System.in);

        PatientManagement patientManager = new PatientManagement();
        BedManagement bedManager = new BedManagement();

        int option;

        do {

            System.out.println("\nHOSPITAL PATIENT ADMISSION SYSTEM");
            System.out.println("********************************************");
            System.out.println("1. Register Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Display All Patients");
            System.out.println("6. Allocate Bed");
            System.out.println("7. Release Bed");
            System.out.println("8. Display Bed Status");
            System.out.println("9. Patient Report");
            System.out.println("10. Bed Occupancy Report");
            System.out.println("11. Exit");

            System.out.print("Enter your option: ");
            option = Integer.parseInt(MyK.nextLine());


            if (option == 1) {

                patientManager.RegisterPatient();

            } else if (option == 2) {

                patientManager.SearchPatient();

            } else if (option == 3) {

                patientManager.UpdatePatient();

            } else if (option == 4) {

                patientManager.DeletePatient();

            } else if (option == 5) {

                patientManager.DisplayAllPatients();

            } else if (option == 6) {

                bedManager.AllocateBed();

            } else if (option == 7) {

                bedManager.ReleaseBed();

            } else if (option == 8) {

                bedManager.DisplayBeds();

            } else if (option == 9) {

                patientManager.PatientReport();

            } else if (option == 10) {

                bedManager.BedOccupancyReport();

            } else if (option == 11) {

                System.out.println("Exiting Hospital Patient Admission System.");

            } else {

                System.out.println("Invalid option.");
            }

        } while (option != 11);

    }
}