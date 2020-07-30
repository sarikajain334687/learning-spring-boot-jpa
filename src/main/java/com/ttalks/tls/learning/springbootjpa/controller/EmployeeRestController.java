package com.ttalks.tls.learning.springbootjpa.controller;

import com.ttalks.tls.learning.springbootjpa.entity.Employee;
import com.ttalks.tls.learning.springbootjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok().body(employeeService.getEmployees());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeebyId(@PathVariable long id){
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.createEmployee(employee));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        employee.setId(id);
        return ResponseEntity.ok().body(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/employees/{id}")
    public HttpStatus deleteEmployee(@PathVariable long id) {
        this.employeeService.deleteEmployee(id);
        return HttpStatus.OK;
    }

}
