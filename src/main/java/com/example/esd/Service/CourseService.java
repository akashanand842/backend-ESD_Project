package com.example.esd.Service;

import com.example.esd.Bean.Course;
import com.example.esd.DAO.CourseDAO;
import com.example.esd.DAO.Implement.CourseDAOImpl;

import java.util.List;

public class CourseService {
    CourseDAO coursedao = new CourseDAOImpl();

    public boolean addCourseService(Course course){
        return coursedao.addCourse(course);
    }

    public List<Course> getCourseService() {
        return coursedao.getCourseList();
    }

    public boolean deleteCourseByIdService(Course course){
        return coursedao.deleteCourse(course);
    }

    public boolean updateCourseService(Course course){
        return coursedao.updateCourse(course);
    }


}
