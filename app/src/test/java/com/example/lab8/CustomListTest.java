package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        list = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }
    @Test
    void testDeleteCity() {
        list = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(city);
        });
        list.addCity(city);
        assertTrue(list.hasCity(city));
        list.delete(city);
        assertFalse(list.hasCity(city));
    }

    @Test
    void testCountCities() {
        list = MockCityList();
        assertEquals(0, list.countCities());
        City city = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city);
        assertEquals(1, list.countCities());
        CustomList emptyCity = new CustomList(null,new ArrayList<>());
        assertEquals(0, emptyCity.countCities());
    }


}
