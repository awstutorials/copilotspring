package com.igniteminds.copilot;


public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("HelloWorld");
    }

    public double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
}