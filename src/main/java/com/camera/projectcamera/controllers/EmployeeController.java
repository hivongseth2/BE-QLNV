package com.camera.projectcamera.controllers;

import com.camera.projectcamera.entity.Employee;
import com.camera.projectcamera.entity.Salary;
import com.camera.projectcamera.model.MessageError;
import com.camera.projectcamera.model.request.EmployeeRequest;
import com.camera.projectcamera.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody EmployeeRequest requestEmployee) {
        Employee theEmployee = null;
              theEmployee=   employeeService.createEmployee(requestEmployee);

        if(theEmployee==null){
            return ResponseEntity.badRequest().body(new MessageError(400, "Create Employee Error"));
        }

        return ResponseEntity.ok(theEmployee);
    }

    @GetMapping("/getById")
    public Employee getEmployee(@RequestParam Long personId) {



        return employeeService.getEmployeeById(personId);
    }
    @PutMapping("/update/{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee) {
        Employee theEmployee = employeeService.updateEmployee(employeeId,employee);
        if(employee==null){
            return ResponseEntity.badRequest().body(new MessageError(400, "Create role error"));
        }
        return ResponseEntity.ok(theEmployee);
    }


    @GetMapping("/getByDepartment")
    public List<Employee> getSalaryByDepart(@RequestParam Long id){
        return employeeService.getEmployeeByDepartment(id);
    }
}
