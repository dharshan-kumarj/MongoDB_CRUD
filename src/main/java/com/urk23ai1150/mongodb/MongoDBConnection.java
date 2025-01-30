package com.urk23ai1150.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private MongoClient mongoClient;
    private MongoDatabase database;

    public void connect() {
        try {
            System.out.println("\n=== MongoDB Connection Setup ===");
            System.out.println("Attempting to connect to MongoDB...");
            
            // Connect to MongoDB
            mongoClient = MongoClients.create("mongodb://localhost:27017");
            System.out.println("✓ Successfully connected to MongoDB Server");
            
            // Create and access the database
            String dbName = "Students_URK23AI1150";
            database = mongoClient.getDatabase(dbName);
            System.out.println("✓ Database '" + dbName + "' created and accessed successfully");
            
            // Create a collection
            String collectionName = "students";
            database.createCollection(collectionName);
            System.out.println("✓ Collection '" + collectionName + "' created successfully");
            
            System.out.println("\nConnection Setup Complete!");
            System.out.println("================================");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void close() {
        if (mongoClient != null) {
            try {
                mongoClient.close();
                System.out.println("\n✓ MongoDB connection closed successfully");
            } catch (Exception e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}