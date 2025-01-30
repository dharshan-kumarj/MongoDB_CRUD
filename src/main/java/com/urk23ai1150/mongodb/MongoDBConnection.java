package com.urk23ai1150.mongodb;

import com.mongodb.client.*;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

import org.bson.Document;

public class MongoDBConnection {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

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
            collection = database.getCollection(collectionName);
            System.out.println("✓ Collection '" + collectionName + "' accessed successfully");
            
            System.out.println("\nConnection Setup Complete!");
            System.out.println("================================");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // public void insertStudents() {
    //     try {
    //         System.out.println("\n=== Inserting Students ===");

    //         // Create three student documents
    //         Student student1 = new Student("URK23AI1150", "Dharshan Kumar J", 19, "B.Tech AI & DS");
    //         Student student2 = new Student("URK23AI1152", "Danish Prabhu K V", 19, "B.Tech AI & DS");
    //         Student student3 = new Student("URK23AI1153", "Arun L K", 20, "B.Tech AI & DS");

    //         // Insert the documents
    //         collection.insertOne(student1.toDocument());
    //         System.out.println("✓ Inserted student: URK23AI1150");
            
    //         collection.insertOne(student2.toDocument());
    //         System.out.println("✓ Inserted student: URK23AI1152");
            
    //         collection.insertOne(student3.toDocument());
    //         System.out.println("✓ Inserted student: URK23AI1153");

    //         System.out.println("All students inserted successfully!");
            
    //     } catch (Exception e) {
    //         System.err.println("Error inserting documents: " + e.getMessage());
    //     }
    // }

    public void readAllStudents() {
        try {
            System.out.println("\n=== Reading All Students ===");
            
            FindIterable<Document> documents = collection.find();
            int count = 0;

            for (Document doc : documents) {
                count++;
                System.out.println("\nStudent #" + count + ":");
                System.out.println("Register Number: " + doc.getString("registerNumber"));
                System.out.println("Name: " + doc.getString("name"));
                System.out.println("Age: " + doc.getInteger("age"));
                System.out.println("Course: " + doc.getString("course"));
            }

            if (count == 0) {
                System.out.println("No students found in the database.");
            } else {
                System.out.println("\nTotal number of students: " + count);
            }
            
        } catch (Exception e) {
            System.err.println("Error reading documents: " + e.getMessage());
        }
    }

     public void updateStudentAge(String regNo, int newAge) {
        try {
            // System.out.println("\n=== Updating Student Age ===");
            // System.out.println("Updating age for Register Number: " + regNo);

            // Create the update operation
            Document result = collection.findOneAndUpdate(
                eq("registerNumber", regNo),  // filter by register number
                set("age", newAge)           // set new age
            );

            if (result != null) {
                System.out.println("✓ Successfully updated student age");
                System.out.println("Old age: " + result.getInteger("age"));
                System.out.println("New age: " + newAge);
            } else {
                System.out.println("× No student found with Register Number: " + regNo);
            }
            
        } catch (Exception e) {
            System.err.println("Error updating student age: " + e.getMessage());
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