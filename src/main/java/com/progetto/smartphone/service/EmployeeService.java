package com.progetto.smartphone.service;

import com.progetto.smartphone.dto.EmployeeDTO;
import com.progetto.smartphone.entity.Employee;
import com.progetto.smartphone.errorHandling.ResourceNotFoundException;
import com.progetto.smartphone.mapper.EmployeeMapper;
import com.progetto.smartphone.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee save(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.INSTANCE.toEntity(employeeDTO);
        return employeeRepository.save(employee);
    }

    public Employee update(EmployeeDTO employeeDTO) {
        if (!employeeRepository.existsById(employeeDTO.getId())) {
            throw new ResourceNotFoundException("Employee with id " + employeeDTO.getId() + " not found");

        }
        Employee employee = EmployeeMapper.INSTANCE.toEntity(employeeDTO);
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee with id " + id + " not found");
        }
        employeeRepository.deleteById(id);
    }

    @Transactional
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.INSTANCE.toEntity(employeeDTO);
        return employeeRepository.save(employee);
    }

}
