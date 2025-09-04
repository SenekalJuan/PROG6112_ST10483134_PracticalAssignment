/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.tvseriesapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class SeriesTest {
    
    private Series seed() {
    /**
     * Test of CaptureSeries method, of class Series.
     */
    Series app = new Series();
        // add one known series for most tests
        assertEquals(1, app.addSeriesDirect("101", "Extreme Sports", 12, "10"));
        return app;
    }

//=======================================================================================================================
    
    @Test
    public void testCaptureSeries_Valid() {
        Series app = new Series();
        assertEquals(1, app.addSeriesDirect("201", "Test Show", 10, "8"));
    }

    @Test
    public void testSearchSeries() {
        Series app = seed();
        SeriesModel s = app.searchById("101");
        assertNotNull(s);
        assertEquals("Extreme Sports", s.SeriesName);
        assertEquals("12", s.SeriesAge);
        assertEquals("10", s.SeriesNumberOfEpisodes);
    }

    @Test
    public void testSearchSeries_SeriesNotFound() {
        Series app = seed();
        assertNull(app.searchById("999"));
    }

    @Test
    public void testUpdateSeries() {
        Series app = seed();
        assertEquals(1, app.updateSeriesDirect("101", "Extreme Sports 2025", 10, "12"));
        SeriesModel s = app.searchById("101");
        assertEquals("Extreme Sports 2025", s.SeriesName);
        assertEquals("10", s.SeriesAge);
        assertEquals("12", s.SeriesNumberOfEpisodes);
    }

    @Test
    public void testDeleteSeries() {
        Series app = seed();
        assertEquals(1, app.deleteSeriesDirect("101"));
        assertNull(app.searchById("101"));
    }

    @Test
    public void testDeleteSeries_SeriesNotFound() {
        Series app = seed();
        assertEquals(0, app.deleteSeriesDirect("999"));
    }

    @Test
    public void testSeriesAgeRestriction_AgeValid() {
        Series app = new Series();
        assertEquals(1, app.ageIsValid(2));
        assertEquals(1, app.ageIsValid(10));
        assertEquals(1, app.ageIsValid(18));
    }

    @Test
    public void testSeriesAgeRestriction_SeriesAgeInvalid() {
        Series app = new Series();
        assertEquals(0, app.ageIsValid(1));
        assertEquals(0, app.ageIsValid(19));
    }
}