package com.urk23ai1150.mongodb;

import org.bson.Document;

public class Student {
    private String registerNumber;
    private String name;
    private int age;
    private String course;

    public Student(String registerNumber, String name, int age, String course) {
        this.registerNumber = registerNumber;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public Document toDocument() {
        return new Document("registerNumber", registerNumber)
                .append("name", name)
                .append("age", age)
                .append("course", course);
    }
}