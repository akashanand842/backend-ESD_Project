package com.example.esd.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    @Column(name = "userId", unique = true, nullable = false)
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "department")
    private String department;

    public Employee(String userId, String password, String department) {
        this.userId = userId;
        this.password = password;
        this.department = department;
    }

    public Employee(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public Employee() {
    }

    public Employee(int employee_id, String userId, String password, String department) {
        this.employee_id = employee_id;
        this.userId = userId;
        this.password = password;
        this.department = department;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
