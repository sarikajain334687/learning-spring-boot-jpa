package com.ttalks.tls.learning.springbootjpa.service;


import com.ttalks.tls.learning.springbootjpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee emp);
    Employee updateEmployee(Employee emp);
    List<Employee> getEmployees();
    Employee getEmployeeById(long id);
    void deleteEmployee(long id);
}
