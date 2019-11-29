package com.team3.utilTest;

import com.team3.models.ListResultsNearbySearch;
import com.team3.models.Localisation;
import com.team3.models.NearbySearch;
import com.team3.util.UtilNearbySearch;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1995046
 */
public class UtilNearbySearchTest {

    public UtilNearbySearchTest() {
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

    @Test
    public void getNearbyPlacesTest() {
        Localisation loc = new Localisation("45.52048", "-73.5686184");
        NearbySearch nbObTest = new NearbySearch();
        nbObTest.setLocalisation(loc);
        nbObTest.setRadius(1500);
        ListResultsNearbySearch listResults = UtilNearbySearch.getNearbyPlaces(nbObTest);

        listResults.printList();
    }

    @Test
    public void getNearbyPlacesWithTypeTest() {
        Localisation loc = new Localisation("45.52048", "-73.5686184");
        NearbySearch nbObTest = new NearbySearch();
        nbObTest.setLocalisation(loc);
        nbObTest.setRadius(1500);
        nbObTest.setTypePlace("food");
        
        ListResultsNearbySearch listResults = UtilNearbySearch.getNearbyPlaces(nbObTest);

        listResults.printList();
    }

}
