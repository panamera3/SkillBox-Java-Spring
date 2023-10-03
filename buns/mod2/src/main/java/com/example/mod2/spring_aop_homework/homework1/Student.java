package com.example.mod2.spring_aop_homework.homework1;

public class Student {
    private String surnameName;
    private int course;
    private double avgGrade;

    public Student(String surnameName, int course, double avgGrade) {
        this.surnameName = surnameName;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    public String getSurnameName() {
        return surnameName;
    }

    public void setSurnameName(String surnameName) {
        this.surnameName = surnameName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surnameName='" + surnameName + '\'' +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
