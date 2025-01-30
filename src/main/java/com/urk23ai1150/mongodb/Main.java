package com.urk23ai1150.mongodb;

public class Main {
    public static void main(String[] args) {
        System.out.println("MongoDB CRUD Operations Demo");

        MongoDBConnection mongodb = new MongoDBConnection();
        
        try {
            // Connect to MongoDB
            mongodb.connect();
            
            // // Insert three students
            // System.out.println("\n--- Initial Insert ---");
            // Student student1 = new Student("URK23AI1150", "Dharshan Kumar J", 19, "B.Tech AI & DS");
            // Student student2 = new Student("URK23AI1152", "Danish Prabhu K V", 19, "B.Tech AI & DS");
            // Student student3 = new Student("URK23AI1153", "Arun L K", 20, "B.Tech AI & DS");
            
            // mongodb.insertStudents();
            
            // Read initial data
            System.out.println("\n--- Initial Data ---");
            mongodb.readAllStudents();
            
            // Update student age
            // System.out.println("\n--- Updating Student Age ---");
            // mongodb.updateStudentAge("URK23AI1152", 20);
            
            // Read data after update
            // System.out.println("\n--- Data After Update ---");
            // mongodb.readAllStudents();

            // Delete student
            System.out.println("\n--- Deleting Student ---");
            mongodb.deleteStudent("URK23AI1153");
            
            // Read final data
            System.out.println("\n--- Final Data After Deletion ---");
            mongodb.readAllStudents();
            
        } catch (Exception e) {
            System.err.println("Main error: " + e.getMessage());
        } finally {
            mongodb.close();
        }
    }
}