package com.bilawal.demo.controllers;

import com.bilawal.demo.dto.EmployeeDTO;
import com.bilawal.demo.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
//        System.out.println(employeeDTO);
        return employeeService.createNewEmployee(employeeDTO);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }
}
