package com.example.esd.Controller;

import com.example.esd.Bean.Course;
import com.example.esd.Service.CourseService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
@Path("course")
public class CourseController {
    CourseService courseService = new CourseService();

    //Course List
    @GET
    @Path("/getCourse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseController(){
        System.out.println("-------in Get Course-----");
        List<Course> courses = courseService.getCourseService();
        System.out.println(courses);
        return Response.ok().entity(courses).build();
    }

    //     
    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCourse(Course course){
        if(courseService.addCourseService(course))
            return Response.ok().build();
        return Response.status(203).build();
    }

    @POST
    @Path("/deleteCourse")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCourse(Course course){
        if(courseService.deleteCourseByIdService(course))
            return Response.ok().build();
        return Response.status(203).build();
    }

    @PUT
    @Path("/updateCourse")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCourse(Course course){
        if(courseService.updateCourseService(course))
            return Response.ok().build();
        return Response.status(203).build();
    }



}
