/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalapp;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */

public class BedManagement {

    String[][] Beds = new String[4][5];

    Scanner MyK = new Scanner(System.in);


    // CONSTRUCTOR
    public BedManagement() {

        for (int row = 0; row < Beds.length; row++) {

            for (int col = 0; col < Beds[row].length; col++) {

                Beds[row][col] = "Available";
            }
        }
    }
    // DISPLAY COMPLETE WARD LAYOUT
    public void DisplayBeds() {

        System.out.println("\nHOSPITAL BED STATUS");
        System.out.println("********************************************");

        int bedNumber = 1;

        for (int row = 0; row < Beds.length; row++) {

            for (int col = 0; col < Beds[row].length; col++) {

                System.out.print( "B" + String.format("%02d", bedNumber) + "[" + Beds[row][col] + "]\t"); //This formats the bed number to always use two digits.
                 bedNumber++;
            }
            System.out.println();//moves the output onto a new line after each row.
        }
    }
    // ALLOCATE BED
    public void AllocateBed() {

        System.out.println("\nALLOCATE BED");
        System.out.println("********************************************");

        // Check if all beds are occupied
        if (AllBedsOccupied()) {

            System.out.println("No beds are available.");
            return;
        }

        System.out.print("Enter Patient Category: ");
        String category = MyK.nextLine();

        // Only Inpatients may receive beds
        if (!category.equalsIgnoreCase("Inpatient")) {

            System.out.println("Only Inpatients may be allocated a hospital bed." );
            return;
        }

        System.out.print("Enter row number (1 - 4): ");
        int row = Integer.parseInt(MyK.nextLine());

        System.out.print("Enter bed number (1 - 5): ");
        int col = Integer.parseInt(MyK.nextLine());

        row = row - 1;
        col = col - 1;

        if (Beds[row][col].equals("Available")) {

            Beds[row][col] = "Occupied";
            System.out.println("Bed allocated successfully.");

        } else {
            System.out.println("This bed is already occupied.");
        }
    }
    // RELEASE BED
    public void ReleaseBed() {

        System.out.println("\nRELEASE BED");
        System.out.println("********************************************");

        System.out.print("Enter row number (1 - 4): ");
        int row = Integer.parseInt(MyK.nextLine());

        System.out.print("Enter bed number (1 - 5): ");
        int col = Integer.parseInt(MyK.nextLine());

        row = row - 1;
        col = col - 1;


        if (Beds[row][col].equals("Occupied")) {
            Beds[row][col] = "Available";

            System.out.println("Bed released successfully.");

        } else {

            System.out.println("This bed is already available.");
        }
    }

    // DISPLAY AVAILABLE BEDS
    public void DisplayAvailableBeds() {

        System.out.println("\nAVAILABLE BEDS");
        System.out.println("********************************************");

        int bedNumber = 1;

        for (int row = 0; row < Beds.length; row++) {

            for (int col = 0; col < Beds[row].length; col++) {

                if (Beds[row][col].equals("Available")) {

                    System.out.println( "B" + String.format("%02d", bedNumber));
                }
                bedNumber++;
            }
        }
    }

    // DISPLAY OCCUPIED BEDS
    public void DisplayOccupiedBeds() {

        System.out.println("\nOCCUPIED BEDS");
        System.out.println("********************************************");

        int bedNumber = 1; //to keep track of the bed numbers


        for (int row = 0; row < Beds.length; row++) {

            for (int col = 0; col < Beds[row].length; col++) {

                if (Beds[row][col].equals("Occupied")) {

                    System.out.println("B" + String.format("%02d", bedNumber));
                }
                bedNumber++;
            }
        }
    }

    // CHECK IF ALL 20 BEDS ARE OCCUPIED
    public boolean AllBedsOccupied() {

        for (int row = 0; row < Beds.length; row++) {

            for (int col = 0; col < Beds[row].length; col++) {

                if (Beds[row][col].equals("Available")) {

                    return false;
                }
            }
        }
        return true;
    }

    // BED OCCUPANCY REPORT
    public void BedOccupancyReport() {

        int occupied = 0;
        int available = 0;


        System.out.println("\nBED OCCUPANCY REPORT");
        System.out.println("********************************************");


        for (int row = 0; row < Beds.length; row++) {

            for (int col = 0; col < Beds[row].length; col++) {

                if (Beds[row][col].equals("Occupied")) {
                    occupied++;

                } else {
                    available++;
                }
            }
        }

        int totalBeds = occupied + available;

        double occupancyPercentage =
                ((double) occupied / totalBeds) * 100;


        System.out.println("Total Beds: " + totalBeds);
        System.out.println("Occupied Beds: " + occupied);
        System.out.println("Available Beds: " + available);
        System.out.println( "Occupancy Percentage: " + occupancyPercentage + "%");
    }

    // UNIT TESTING - ALLOCATE BED
    public boolean AllocateBedTest(int row, int col) {

        if (AllBedsOccupied()) {
            return false;
        }

        if (Beds[row][col].equals("Available")) {

            Beds[row][col] = "Occupied";
            return true;
        }
        return false;
    }

    // UNIT TESTING - RELEASE BED
    public boolean ReleaseBedTest(int row, int col) {

        if (Beds[row][col].equals("Occupied")) {

            Beds[row][col] = "Available";
            return true;
        }
        return false;
    }
    // UNIT TESTING - GET BED STATUS
    public String GetBedStatus(int row, int col) {
        return Beds[row][col];
    }

    // UNIT TESTING - OCCUPY ALL BEDS
    public void OccupyAllBedsTest() {

        for (int row = 0; row < Beds.length; row++) {

            for (int col = 0; col < Beds[row].length; col++) {
                Beds[row][col] = "Occupied";
            }
        }
    }
}