package com.ttalks.tls.learning.springbootjpa.repository;

import com.ttalks.tls.learning.springbootjpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
