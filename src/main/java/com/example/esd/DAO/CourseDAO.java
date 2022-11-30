package com.example.esd.DAO;

import com.example.esd.Bean.Course;

import java.util.List;

public interface CourseDAO {
    boolean addCourse(Course courseObj);

    List<Course> getCourseList();

    boolean updateCourse(Course course);


    boolean deleteCourse(Course course);
}
