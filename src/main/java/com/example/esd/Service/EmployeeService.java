package com.example.esd.Service;

import com.example.esd.Bean.Employee;
import com.example.esd.DAO.EmployeeDAO;
import com.example.esd.DAO.Implement.EmployeeDAOImpl;

public class EmployeeService {
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public boolean addEmployeeService(Employee employee){
        return employeeDAO.addEmployee(employee);
    }

    public boolean verifyEmployeeService(Employee employee){
        return employeeDAO.verifyEmployee(employee);
    }
}
