/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalapp;

/**
 *
 * @author Administrator
 */

public class Patient {

    public String PatientID;
    public String FirstName;
    public String LastName;
    public int Age;
    public String Gender;
    public String MedicalCondition;

    public PatientCategory Category; //The Category variable uses my PatientCategory enum to store whether 
//the patient is an inpatient, outpatient or emergency patient


    public void displayDetails() {
//The method is void because it performs an action and doesn’t return a value
        System.out.println("Patient ID: " + PatientID);
        System.out.println("Name: " + FirstName + " " + LastName);
        System.out.println("Age: " + Age);
        System.out.println("Gender: " + Gender);
        System.out.println("Medical Condition: " + MedicalCondition);
        System.out.println("Category: " + Category);
    }
}
//The Patient class represents a patient in the hospital system and stores the information that every patient needs.

