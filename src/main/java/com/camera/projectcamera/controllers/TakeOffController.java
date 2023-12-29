package com.camera.projectcamera.controllers;

import com.camera.projectcamera.entity.Employee;
import com.camera.projectcamera.entity.Salary;
import com.camera.projectcamera.entity.TakeOff;
import com.camera.projectcamera.model.MessageError;
import com.camera.projectcamera.model.request.EmployeeRequest;
import com.camera.projectcamera.model.request.TakeOffRequest;
import com.camera.projectcamera.model.request.TakeOffUpdateRq;
import com.camera.projectcamera.service.TakeOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/takeoff")
public class TakeOffController {

    @Autowired
    TakeOffService takeOffService;
    @GetMapping("/getByDepart")
    public List<TakeOff> getTakeOffByDepartment(@RequestParam Long departId){
        return takeOffService.getTakeOffByDepartment(departId);
    }

    @GetMapping
    public List<TakeOff> getAllTakeOff(){
        return takeOffService.getTakeOffList();
    }


    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody TakeOffRequest request) {
        TakeOff theTakeOff = null;
        theTakeOff=   takeOffService.createTakeOff(request);

        if(theTakeOff==null){
            return ResponseEntity.badRequest().body(new MessageError(400, "Create TakeOff Error"));
        }

        return ResponseEntity.ok(theTakeOff);
    }


    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody TakeOffUpdateRq request) {
//        Employee theEmployee = employeeService.updateEmployee(employeeId,employee);

        TakeOff takeOff =takeOffService.updateState(request);
        if(takeOff==null){

            return ResponseEntity.badRequest().body(new MessageError(400, "update take of error"));
        }
        return ResponseEntity.ok(takeOff);
    }

}
