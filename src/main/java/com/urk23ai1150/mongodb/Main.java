package com.urk23ai1150.mongodb;

public class Main {
    public static void main(String[] args) {
        System.out.println("MongoDB Insert, Update and Read Demo");

        
        MongoDBConnection mongodb = new MongoDBConnection();
        
        try {
            // Connect to MongoDB
            mongodb.connect();
            
           
            
            // mongodb.insertStudents();
            
            // Read initial data
            System.out.println("\n--- Initial Data ---");
            mongodb.readAllStudents();
            
            // Update student age
            System.out.println("\n--- Updating Student Age ---");
            mongodb.updateStudentAge("URK23AI1152", 20);
            
            // Read data after update
            System.out.println("\n--- Data After Update ---");
            mongodb.readAllStudents();
            
        } catch (Exception e) {
            System.err.println("Main error: " + e.getMessage());
        } finally {
            mongodb.close();
        }
    }
}