package com.urk23ai1150.mongodb;

public class Main {
    public static void main(String[] args) {
        System.out.println("MongoDB Insert and Read Demo");
        
        MongoDBConnection mongodb = new MongoDBConnection();
        
        try {
            // Connect to MongoDB
            mongodb.connect();
            
            // Insert three students
            mongodb.insertStudents();
            
            // Read all students
            mongodb.readAllStudents();
            
        } catch (Exception e) {
            System.err.println("Main error: " + e.getMessage());
        } finally {
            mongodb.close();
        }
    }
}