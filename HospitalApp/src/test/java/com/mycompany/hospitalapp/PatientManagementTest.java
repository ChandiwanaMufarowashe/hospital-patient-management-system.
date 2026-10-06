/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.hospitalapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Administrator
 */

public class PatientManagementTest {

    // TEST 1 - Register a patient
    @Test
    public void testRegisterPatient() {

        PatientManagement manager = new PatientManagement();

        Patient patient = new Patient();

        patient.PatientID = "P001";
        patient.FirstName = "John";
        patient.LastName = "Smith";
        patient.Age = 35;
        patient.Gender = "Male";
        patient.MedicalCondition = "Flu";
        patient.Category = PatientCategory.OUTPATIENT;

        boolean result = manager.AddPatient(patient);

        assertTrue(result);
        assertEquals(1, manager.GetPatientCount());
    }

    // TEST 2 - Search for a patient
    @Test
    public void testSearchPatient() {

        PatientManagement manager = new PatientManagement();

        Patient patient = new Patient();

        patient.PatientID = "P002";
        patient.FirstName = "Mary";
        patient.LastName = "Jones";

        manager.AddPatient(patient);

        Patient result = manager.FindPatient("P002");

        assertNotNull(result);
        assertEquals("P002", result.PatientID);
    }

    // TEST 3 - Update patient details
    @Test
    public void testUpdatePatient() {

        PatientManagement manager = new PatientManagement();

        Patient patient = new Patient();

        patient.PatientID = "P003";
        patient.MedicalCondition = "Flu";

        manager.AddPatient(patient);

        boolean result = manager.UpdatePatientTest("P003", "Recovered");

        assertTrue(result);

        assertEquals( "Recovered",manager.FindPatient("P003").MedicalCondition);
    }

    // TEST 4 - Delete a patient
    @Test
    public void testDeletePatient() {

        PatientManagement manager = new PatientManagement();

        Patient patient = new Patient();

        patient.PatientID = "P004";
        patient.FirstName = "David";

        manager.AddPatient(patient);

        boolean result
                = manager.DeletePatientTest("P004");

        assertTrue(result);
        assertNull(manager.FindPatient("P004"));
        assertEquals(0, manager.GetPatientCount());
    }

    // TEST 5 - Prevent duplicate Patient IDs
    @Test
    public void testDuplicatePatientID() {

        PatientManagement manager = new PatientManagement();

        Patient patient1 = new Patient();
        patient1.PatientID = "P005";
        patient1.FirstName = "Peter";

        Patient patient2 = new Patient();
        patient2.PatientID = "P005";
        patient2.FirstName = "Sarah";

        boolean firstResult
                = manager.AddPatient(patient1);

        boolean secondResult
                = manager.AddPatient(patient2);

        assertTrue(firstResult);
         assertFalse(secondResult);
        assertEquals(
                1,
                manager.GetPatientCount()
        );
    }

    // TEST 6 - Sort patients by Patient ID
    @Test
    public void testSortPatients() {

        PatientManagement manager = new PatientManagement();

        Patient patient1 = new Patient();

        patient1.PatientID = "P003";
        patient1.FirstName = "John";

        Patient patient2 = new Patient();

        patient2.PatientID = "P001";
        patient2.FirstName = "Mary";

        Patient patient3 = new Patient();

        patient3.PatientID = "P002";
        patient3.FirstName = "David";

        manager.AddPatient(patient1);
        manager.AddPatient(patient2);
        manager.AddPatient(patient3);

        manager.SortPatients();
        
        assertEquals("P001", manager.GetPatient(0).PatientID);
        assertEquals( "P002", manager.GetPatient(1).PatientID);
        assertEquals("P003", manager.GetPatient(2).PatientID );
    }
}
