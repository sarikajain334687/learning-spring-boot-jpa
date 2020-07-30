package com.ttalks.tls.learning.springbootjpa.service;

import com.ttalks.tls.learning.springbootjpa.entity.Employee;
import com.ttalks.tls.learning.springbootjpa.exception.ResourceNotFoundException;
import com.ttalks.tls.learning.springbootjpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Override
    public Employee createEmployee(Employee emp) {
        return empRepo.save(emp);
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        Optional<Employee> employeeDb = this.empRepo.findById(emp.getId());
        if(employeeDb.isPresent()){
            Employee empUpdate = employeeDb.get();
            empUpdate.setId(emp.getId());
            empUpdate.setEmail(emp.getEmail());
            empUpdate.setName(emp.getName());
            empRepo.save(empUpdate);
            return empUpdate;
        }
        else{
            throw new ResourceNotFoundException("Record not found for "+emp.getId());
        }
    }

    @Override
    public List<Employee> getEmployees() {
        return (List<Employee>) empRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employeeDb = this.empRepo.findById(id);
        if(employeeDb.isPresent()){
            return employeeDb.get();
        }
        else{
            throw new ResourceNotFoundException("Record not found for "+id);
        }
    }

    @Override
    public void deleteEmployee(long id) {
        Optional<Employee> employeeDb = this.empRepo.findById(id);
        if(employeeDb.isPresent()){
            empRepo.delete(employeeDb.get());
        }
        else{
            throw new ResourceNotFoundException("Record not found for "+id);
        }
    }
}
