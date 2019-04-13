package com.parrotparty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class ParrotServiceTest {
    ParrotService testService;
    List<Parrot> testParrots;

    @BeforeEach
    public void setUp() {
        testService = new ParrotService();
        testParrots  = new ArrayList<>();
    }


    @Test
    public void getAllTheParrotsSuccess() throws Exception {





    }

    @Test
    public void getAllTheCategoriesSuccess() throws Exception {


    }
}
