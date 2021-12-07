package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/signup")
    public String signUp(@RequestBody Employee employee)
    {
        employeeServiceImpl.signUp(employee);
        return "Data Saved successfully";
    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public boolean signIn(@PathVariable String empEmailId,@PathVariable String empPassword)
    {
       return employeeServiceImpl.signIn(empEmailId,empPassword);
    }
}
