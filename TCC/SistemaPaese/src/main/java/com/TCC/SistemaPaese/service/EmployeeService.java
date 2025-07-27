package com.TCC.SistemaPaese.service;

import com.TCC.SistemaPaese.dto.CreateEmployeeDTO;
import com.TCC.SistemaPaese.models.entities.Employee;
import com.TCC.SistemaPaese.repositories.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmailValidatorService emailValidatorService;
    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmailValidatorService emailValidatorService, EmployeeRepository employeeRepository) {
        this.emailValidatorService = emailValidatorService;
        this.employeeRepository = employeeRepository;
    }


    public Employee registerEmployee(@Valid CreateEmployeeDTO employeeDTO) {

        var email = employeeDTO.email();
        var isValid = emailValidatorService.isEmailValidFormat(email);

        if(!isValid){
            throw new IllegalArgumentException("Formato de e-mail inválido.");
        }
       var employee =  employeeRepository.save(new Employee(employeeDTO));
        return employee;
    }


}
