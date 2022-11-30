package com.example.esd.Bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseID;

    @Column(name = "course_code", unique = true,nullable = false)
    private int courseCode;

    @Column(name = "course_name",nullable = false)
    private String courseName;

    @Column(name = "course_description")
    private String courseDescription;

    @Column(name = "course_credits", nullable = false)
    private int credits;

    @Column(name = "course_capacity", nullable = false)
    private int capacity;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<CoursePrerequisite> coursePrerequisiteListForID;


    public List<CoursePrerequisite> getCoursePrerequisiteListForID() {
        return coursePrerequisiteListForID;
    }

    public void setCoursePrerequisiteListForID(List<CoursePrerequisite> coursePrerequisiteListForID) {
        this.coursePrerequisiteListForID = coursePrerequisiteListForID;
    }

    public Course() {

    }

    public  Course(int courseCode){
        this.courseCode = courseCode;
    }

    public Course(int courseCode, String courseDescription, int credits, int capacity) {
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
        this.credits = credits;
        this.capacity = capacity;
    }

    public Course(int courseCode, String courseDescription) {
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
    }

    public Course(int courseCode, int credits, int capacity) {
        this.courseCode = courseCode;
        this.credits = credits;
        this.capacity = capacity;
    }

    public Course(String courseName, String courseDescription, int credits, int capacity) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.credits = credits;
        this.capacity = capacity;
    }

    public Course(int courseCode, String courseName, String courseDescription, int credits, int capacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.credits = credits;
        this.capacity = capacity;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }




}
