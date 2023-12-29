package com.camera.projectcamera.controllers;

import com.camera.projectcamera.entity.Manager;

import com.camera.projectcamera.model.MessageError;
import com.camera.projectcamera.model.request.ManagerRequest;

import com.camera.projectcamera.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class StaffController {

    @Autowired
    private ManagerService managerService;

//    @PostMapping("/add")
//    public String addStaff(@RequestBody Staff staff){
//        staffService.addStaff(staff);
//        return "add staff success";
//    }



    @GetMapping
    public List<Manager>  getManager(){
        return managerService.getManager();
    }

    @GetMapping("/get")
    public Manager getManagerById(Long managerId){
        return managerService.getManagerById(managerId);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStaff(@RequestBody ManagerRequest managerRequest) {
        Manager manager = managerService.addManager(managerRequest);

        if(manager==null){
            return ResponseEntity.badRequest().body(new MessageError(400, "Create Staff Error"));
        }

        return ResponseEntity.ok(manager);
    }}
