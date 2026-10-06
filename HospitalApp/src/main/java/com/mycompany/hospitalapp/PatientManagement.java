package com.mycompany.hospitalapp;

import java.util.ArrayList;
import java.util.Scanner;

public class PatientManagement {

    Scanner MyK = new Scanner(System.in);

    // ArrayList used to store all registered patients
    ArrayList<Patient> PatientList = new ArrayList<>();


    // REGISTER PATIENT
    public void RegisterPatient() {

        Patient Obj = new Patient(); 

        System.out.println("\nREGISTER A NEW PATIENT");
        System.out.println("********************************************");

        System.out.print("Enter Patient ID: ");
        Obj.PatientID = MyK.nextLine();


        // Prevent duplicate Patient IDs
        for (Patient patient : PatientList) { //Go through every patient already stored in PatientList.

            if (patient.PatientID.equals(Obj.PatientID)) {

                System.out.println("Patient ID already exists.");
                return; // It immediately exits the method.
            }
        }


        System.out.print("Enter First Name: ");
        Obj.FirstName = MyK.nextLine();

        System.out.print("Enter Last Name: ");
        Obj.LastName = MyK.nextLine();

        System.out.print("Enter Age: ");
        Obj.Age = Integer.parseInt(MyK.nextLine());

        System.out.print("Enter Gender: ");
        Obj.Gender = MyK.nextLine();

        System.out.print("Enter Medical Condition: ");
        Obj.MedicalCondition = MyK.nextLine();


        System.out.println("\nSelect Patient Category:");
        System.out.println("1. Inpatient");
        System.out.println("2. Outpatient");
        System.out.println("3. Emergency");

        System.out.print("Enter your choice: ");

        int categoryChoice = Integer.parseInt(MyK.nextLine()); //converts the text into an integer.


        if (categoryChoice == 1) {
            Obj.Category = PatientCategory.INPATIENT;

        } else if (categoryChoice == 2) {
            Obj.Category = PatientCategory.OUTPATIENT;

        } else if (categoryChoice == 3) {
            Obj.Category = PatientCategory.EMERGENCY;
        }
        
        PatientList.add(Obj);
        System.out.println("Patient registered successfully.");
    }


    // SEARCH PATIENT
    public void SearchPatient() {

        System.out.print("Enter Patient ID to search: ");
        String searchId = MyK.nextLine();

        boolean found = false;

        for (Patient Obj : PatientList) {

            if (Obj.PatientID.equals(searchId)) {
                found = true;

                System.out.println("\nPATIENT FOUND");
                System.out.println("********************************************");

                Obj.displayDetails();
                break;
            }
        }
        if (found == false) {

            System.out.println( "Patient with ID " + searchId + " was not found.");
        }
    }

    // UPDATE PATIENT
    public void UpdatePatient() {

        System.out.print("Enter Patient ID to update: ");
        String updateId = MyK.nextLine();

        boolean found = false;


        for (Patient Obj : PatientList) {

            if (Obj.PatientID.equals(updateId)) {
                found = true;

                System.out.print("Enter new First Name: ");
                Obj.FirstName = MyK.nextLine();

                System.out.print("Enter new Last Name: ");
                Obj.LastName = MyK.nextLine();

                System.out.print("Enter new Age: ");
                Obj.Age = Integer.parseInt(MyK.nextLine());

                System.out.print("Enter new Gender: ");
                Obj.Gender = MyK.nextLine();

                System.out.print("Enter new Medical Condition: ");
                Obj.MedicalCondition = MyK.nextLine();


                System.out.println("\nSelect new Patient Category:");
                System.out.println("1. Inpatient");
                System.out.println("2. Outpatient");
                System.out.println("3. Emergency");

                System.out.print("Enter your choice: ");

                int categoryChoice =
                        Integer.parseInt(MyK.nextLine());

                if (categoryChoice == 1) {
                    Obj.Category = PatientCategory.INPATIENT;

                } else if (categoryChoice == 2) {
                    Obj.Category = PatientCategory.OUTPATIENT;

                } else if (categoryChoice == 3) {                 
                    Obj.Category = PatientCategory.EMERGENCY;
                }
                
                System.out.println("Patient updated successfully.");

                break;
            }
        }
        if (found == false) {

            System.out.println("Patient with ID " + updateId + " was not found.");
        }
    }
    // DELETE PATIENT
    public void DeletePatient() {

        System.out.print("Enter Patient ID to delete: ");
        String deleteId = MyK.nextLine();

        boolean found = false;

          for (int i = 0; i < PatientList.size(); i++) {

            if (PatientList.get(i).PatientID.equals(deleteId)) { //Get the Patient ID of the patient at that position.
                //“If this patient’s ID is the same as the ID the user entered…”
                found = true;

                PatientList.remove(i);//This removes the patient at position i from the ArrayList.
                System.out.println("Patient deleted successfully.");
                break;//stops the loop because there is no reason to keep searching after the patient has been deleted.
            }
        }
        if (found == false) {

            System.out.println( "Patient with ID " + deleteId + " was not found.");
        }
    }
    // DISPLAY ALL PATIENTS
    public void DisplayAllPatients() {

        if (PatientList.isEmpty()) {
            System.out.println("No patients have been registered.");

        } else {
            System.out.println("\nALL REGISTERED PATIENTS");
            System.out.println("********************************************");


            for (Patient Obj : PatientList) {//“Go through every Patient object stored in PatientList.”
                Obj.displayDetails();

                System.out.println("--------------------------------------------");
            }
        }
    }

    // PATIENT REPORT
    public void PatientReport() {

        System.out.println("\nPATIENT REPORT");
        System.out.println("********************************************");

        if (PatientList.isEmpty()) {
            System.out.println("No patients have been registered.");

        } else{ SortPatients(); // Sort patients by Patient ID

            for (Patient Obj : PatientList) { //“Go through every Patient object stored in PatientList.”
                Obj.displayDetails();
                
                System.out.println("--------------------------------------------");
            }
            System.out.println("Total Patients: " + PatientList.size());

        }
    }

    // ADD PATIENT
    // Also used for unit testing
    //The purpose of this method is to add a Patient object to PatientList, but only if that Patient ID does not already exist.
    public boolean AddPatient(Patient patient) {

        // Prevent duplicate Patient IDs
        for (Patient existingPatient : PatientList) { //Go through every patient that is already stored in PatientList.

            if (existingPatient.PatientID.equals(patient.PatientID)) {
                return false;
            }
        }

        PatientList.add(patient);
        return true;
    }
    // FIND PATIENT
    // Used for unit testing
    public Patient FindPatient(String patientID) {

        for (Patient patient : PatientList) {

            if (patient.PatientID.equals(patientID)) {
                return patient;
            }
        }

        return null;
    }

    // UPDATE PATIENT
    // Used for unit testing
    public boolean UpdatePatientTest(
            String patientID,
            String newCondition) {

        Patient patient = FindPatient(patientID);

        if (patient != null) { 
            patient.MedicalCondition = newCondition;
            return true;
        }
        return false;
    }
    // DELETE PATIENT
    // Used for unit testing
    public boolean DeletePatientTest(String patientID) {

        Patient patient = FindPatient(patientID);


        if (patient != null) {
            PatientList.remove(patient);
            return true;
        }
        return false;
    }
    // SORT PATIENTS BY PATIENT ID
    // Required by assignment and used for unit testing
    public void SortPatients() {

        PatientList.sort(
                (patient1, patient2)
                -> patient1.PatientID.compareTo(patient2.PatientID)
        );
    }
    // GET PATIENT
    // Used for testing sorted order
    public Patient GetPatient(int index) { //index means the position of a patient inside your PatientList ArrayList

        return PatientList.get(index);//Go to this position in the ArrayList and return the Patient object stored there
    }
    // GET TOTAL NUMBER OF PATIENTS
    public int GetPatientCount() {

        return PatientList.size();
    }
}