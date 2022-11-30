package com.example.esd.Controller;

import com.example.esd.Bean.Employee;
import com.example.esd.Service.EmployeeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("employee")
public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();

    @POST
    @Path("/addEmployee")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployeeController(Employee employee){
        System.out.println("***************Add Employee Service******************");
        if(employeeService.addEmployeeService(employee)){
            return Response.ok().build();
        }
        return Response.status(203).build();
    }

    @POST
    @Path("/employeeLogin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response loginService(Employee admin){
        System.out.println("***************login Service******************");
        if(employeeService.verifyEmployeeService(admin))
            return Response.ok().build();
        return Response.status(203).build();
    }

}
