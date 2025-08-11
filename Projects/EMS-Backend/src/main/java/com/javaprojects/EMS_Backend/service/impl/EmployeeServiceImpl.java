package com.javaprojects.EMS_Backend.service.impl;

import com.javaprojects.EMS_Backend.dto.EmployeeDto;
import com.javaprojects.EMS_Backend.entity.Employee;
import com.javaprojects.EMS_Backend.mapper.EmployeeMapper;
import com.javaprojects.EMS_Backend.repository.EmployeeRepository;
import com.javaprojects.EMS_Backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
