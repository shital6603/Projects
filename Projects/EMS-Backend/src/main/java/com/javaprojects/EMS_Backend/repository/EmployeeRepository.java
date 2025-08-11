package com.javaprojects.EMS_Backend.repository;

import com.javaprojects.EMS_Backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
