/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospitalapp;

/**
 *
 * @author Administrator
 */

public class Inpatient extends Patient {//extends Patient means Inpatient inherits the variables and methods from Patient.

    public String WardNumber;
    public String BedNumber;
    //An inpatient has all the normal patient information, but also needs a ward number and bed number.

//Constructor
//The constructor takes those values and stores them in the object.
    public Inpatient(String PatientID,
                     String FirstName,
                     String LastName,
                     int Age,
                     String Gender,
                     String MedicalCondition,
                     String WardNumber,
                     String BedNumber) {

        super();// calls the constructor of the superclass, which is Patient

        this.PatientID = PatientID; //take the PatientID that was given to me and save it inside this Patient object
        this.FirstName = FirstName;//Left side = where the value goes. Right side = the value coming in.
        this.LastName = LastName;//If I don’t use this, Java may confuse the parameter with the object variable because they have 
        //the same name, so the object’s PatientID would not be assigned
        this.Age = Age;
        this.Gender = Gender;
        this.MedicalCondition = MedicalCondition;

        this.Category = PatientCategory.INPATIENT;

        this.WardNumber = WardNumber;
        this.BedNumber = BedNumber;
    }


    @Override // means that a child class is providing its own version of a method that already exists in its parent class.
    public void displayDetails() {
//Override means replacing an inherited method with a specialised version. I used it because an Inpatient needs to display
//the normal Patient information plus the Ward Number and Bed Number.
        System.out.println("Patient ID: " + PatientID);
        System.out.println("Name: " + FirstName + " " + LastName);
        System.out.println("Age: " + Age);
        System.out.println("Gender: " + Gender);
        System.out.println("Medical Condition: " + MedicalCondition);
        System.out.println("Category: " + Category);
        System.out.println("Ward Number: " + WardNumber);
        System.out.println("Bed Number: " + BedNumber);
    }
}//You use @Override when a child class inherits a method from a parent class, but the child needs that method to behave differently.