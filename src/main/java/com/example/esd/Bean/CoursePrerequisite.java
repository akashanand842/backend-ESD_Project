package com.example.esd.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "course_prerequisite")
public class CoursePrerequisite {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "course_prerequisite")
    private String coursePrerequisite;



    public CoursePrerequisite(int ID) {
        this.ID = ID;
    }

    public CoursePrerequisite(String coursePrerequisite) {
        this.coursePrerequisite = coursePrerequisite;
    }

    public CoursePrerequisite() {
    }

    public CoursePrerequisite(int ID, Course courseForeignID) {
        this.ID = ID;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCoursePrerequisite() {
        return coursePrerequisite;
    }

    public void setCoursePrerequisite(String coursePrerequisite) {
        this.coursePrerequisite = coursePrerequisite;
    }
}
