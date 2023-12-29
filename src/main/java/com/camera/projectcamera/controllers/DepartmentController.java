package com.camera.projectcamera.controllers;

import com.camera.projectcamera.entity.Company;
import com.camera.projectcamera.entity.Department;
import com.camera.projectcamera.model.MessageError;
import com.camera.projectcamera.model.request.DepartmentRequest;
import com.camera.projectcamera.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;


    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody DepartmentRequest departmentRequest) {
        Department department = departmentService.createDepartment(departmentRequest);

        if(department==null){
            return ResponseEntity.badRequest().body(new MessageError(400, "Create department error"));
        }

        return ResponseEntity.ok(department);
    }

    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentService.getAll();
    }
}
