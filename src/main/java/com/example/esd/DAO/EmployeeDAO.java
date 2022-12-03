package com.example.esd.DAO;

import com.example.esd.Bean.Employee;

public interface EmployeeDAO {
    boolean addEmployee(Employee employee);

    boolean verifyEmployee(Employee employee);

}
