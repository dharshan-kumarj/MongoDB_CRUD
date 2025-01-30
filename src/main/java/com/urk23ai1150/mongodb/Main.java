package com.urk23ai1150.mongodb;

public class Main {
    public static void main(String[] args) {
        System.out.println("MongoDB Connection Demo");

        
        MongoDBConnection mongodb = new MongoDBConnection();
        
        try {
            // Connect to MongoDB and create database
            mongodb.connect();
            
            // Wait for 2 seconds to see the results
            Thread.sleep(2000);
            
        } catch (Exception e) {
            System.err.println("Main error: " + e.getMessage());
        } finally {
            mongodb.close();
        }
    }
}