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

public class BedManagementTest {


    // TEST 1 - Allocate a bed
    @Test
    public void testAllocateBed() {

        BedManagement manager = new BedManagement();
        boolean result =manager.AllocateBedTest(0, 0);

        assertTrue(result);
        assertEquals("Occupied", manager.GetBedStatus(0, 0) );
    }


    // TEST 2 - Release a bed
    @Test
    public void testReleaseBed() {

        BedManagement manager = new BedManagement();
        manager.AllocateBedTest(0, 0);

        boolean result =  manager.ReleaseBedTest(0, 0);

        assertTrue(result);

        assertEquals("Available", manager.GetBedStatus(0, 0) );
    }


    // TEST 3 - Prevent allocating an occupied bed
    @Test
    public void testAllocateOccupiedBed() {

        BedManagement manager = new BedManagement();

        // Allocate the bed the first time
        boolean firstResult =
                manager.AllocateBedTest(0, 0);

        // Try to allocate the same bed again
        boolean secondResult =
                manager.AllocateBedTest(0, 0);

        assertTrue(firstResult);
        assertFalse(secondResult);

        assertEquals("Occupied", manager.GetBedStatus(0, 0));
    }

    // TEST 4 - Prevent allocation when all beds are occupied
    @Test
    public void testAllBedsOccupied() {

        BedManagement manager = new BedManagement();

        // Make all 20 beds occupied
        manager.OccupyAllBedsTest();

        assertTrue( manager.AllBedsOccupied());

        // Try to allocate another bed
        boolean result =
                manager.AllocateBedTest(0, 0);
                 assertFalse(result);
    }
}