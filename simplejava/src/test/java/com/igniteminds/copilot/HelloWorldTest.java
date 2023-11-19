package com.igniteminds.copilot;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    @org.junit.jupiter.api.Test
    void calculateSimpleInterest() {
        HelloWorld helloWorld = new HelloWorld();
        assertEquals(100, helloWorld.calculateSimpleInterest(1000, 10, 1));
    }
}