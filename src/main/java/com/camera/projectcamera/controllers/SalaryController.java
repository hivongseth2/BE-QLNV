package com.camera.projectcamera.controllers;

import com.camera.projectcamera.entity.Manager;
import com.camera.projectcamera.entity.Salary;
import com.camera.projectcamera.entity.SalaryTime;
import com.camera.projectcamera.entity.TakeOff;
import com.camera.projectcamera.model.MessageError;
import com.camera.projectcamera.model.request.SalaryRequest;
import com.camera.projectcamera.model.request.TakeOffRequest;
import com.camera.projectcamera.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @GetMapping("/getByDepart")
    public List<SalaryTime> getSalaryByDepart(@RequestParam Long departId){
        return salaryService.getSalaryByDepartment(departId);
    }


    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody SalaryRequest request) {
        System.out.println("request"+ request);
        SalaryTime theSalary = null;
        theSalary=   salaryService.createSalary(request);

        if(theSalary==null){
            return ResponseEntity.badRequest().body(new MessageError(400, "Create TakeOff Error"));
        }

        return ResponseEntity.ok(theSalary);
    }
}
