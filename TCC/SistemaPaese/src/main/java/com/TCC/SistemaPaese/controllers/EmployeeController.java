package com.TCC.SistemaPaese.controllers;

import com.TCC.SistemaPaese.dto.CreateEmployeeDTO;
import com.TCC.SistemaPaese.dto.EmployeeDTO;
import com.TCC.SistemaPaese.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<?> createEmplyee(@RequestBody @Valid CreateEmployeeDTO employeeDTO,
                                           UriComponentsBuilder uriComponentsBuilder){
        var employee = employeeService.registerEmployee(employeeDTO);
        var uri = uriComponentsBuilder.path("/employees/{id}").buildAndExpand(employee.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmployeeDTO(employee));
    }
}
