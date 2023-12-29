package com.camera.projectcamera.controllers;

import com.camera.projectcamera.entity.SalaryProduct;
import com.camera.projectcamera.entity.SalaryTime;
import com.camera.projectcamera.model.MessageError;
import com.camera.projectcamera.model.request.SalaryProductRequest;
import com.camera.projectcamera.model.request.SalaryRequest;
import com.camera.projectcamera.service.SalaryProductService;
import com.camera.projectcamera.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/salaryProduct")
public class SalaryProductController {



        @Autowired
        SalaryProductService salaryProductService;

        @GetMapping("/getByDepart")
        public List<SalaryProduct> getSalaryByDepart(@RequestParam Long departId) {
            return salaryProductService.getSalaryByDepartment(departId);
        }


        @PostMapping("/add")
        public ResponseEntity<?> create(@RequestBody SalaryProductRequest request) {
            SalaryProduct theSalary = null;
            theSalary = salaryProductService.createSalary(request);

            if (theSalary == null) {
                return ResponseEntity.badRequest().body(new MessageError(400, "Create TakeOff Error"));
            }

            return ResponseEntity.ok(theSalary);
        }

}