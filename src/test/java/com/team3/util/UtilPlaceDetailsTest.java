/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.util;

import com.team3.models.Review;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aziz
 */
public class UtilPlaceDetailsTest {
    
    public UtilPlaceDetailsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPlaceDetails method, of class UtilPlaceDetails.
     */
    @Test
    public void testGetPlaceDetails() {
        System.out.println("getPlaceDetails");
        String placeID = "ChIJDbdkHFQayUwR7-8fITgxTmU";
        ArrayList<Review> expResult = UtilPlaceDetails.getPlaceDetails(placeID);
        ArrayList<Review> result = UtilPlaceDetails.getPlaceDetails(placeID);
        assertEquals(expResult, result);
    }
    
}
