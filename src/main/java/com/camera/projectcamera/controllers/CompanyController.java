package com.camera.projectcamera.controllers;

import com.camera.projectcamera.entity.Company;
import com.camera.projectcamera.entity.Employee;
import com.camera.projectcamera.entity.Role;
import com.camera.projectcamera.model.MessageError;
import com.camera.projectcamera.model.request.RoleRequest;
import com.camera.projectcamera.model.request.UpPerRequest;
import com.camera.projectcamera.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    @Autowired
    final CompanyService companyService;


    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody Company companyRequest) {
        Company company = companyService.createCompany(companyRequest);

        if(company==null){
            return ResponseEntity.badRequest().body(new MessageError(400, "Create company error"));
        }

        return ResponseEntity.ok(company);
    }

    @PutMapping("/permiss")
    public ResponseEntity<?> UpdatePermission(@RequestBody UpPerRequest request) {
        Company theCompany = companyService.updatePermission(request);
        if(theCompany==null){
            return ResponseEntity.badRequest().body(new MessageError(400, "Update Permission error"));
        }
        return ResponseEntity.ok(theCompany);
    }
    @GetMapping
    public List<Company> getAllCompany(){
        return companyService.getAll();
    }

    @GetMapping("/get")
    public Company getCompany(@RequestParam String id)
    {
        return companyService.findCompanyById(id);
    }
//    @PutMapping("/update/{roleId}")
//    public ResponseEntity<?> updateRole(@PathVariable Long roleId,@RequestBody RoleRequest request) {
//        Role role = roleService.updateRole(roleId,request.getRoleName());
//        if(role==null){
//            return ResponseEntity.badRequest().body(new MessageError(400, "Create role error"));
//        }
//        return ResponseEntity.ok(role);
//    }



    @PutMapping("/update/{companyId}")
    public ResponseEntity<?> updateEmployee(@PathVariable String companyId,@RequestBody Company company) {
//        Employee theEmployee = employeeService.updateEmployee(employeeId,employee);
        Company com = companyService.updateCompany(companyId,company);

        if(com==null){

            return ResponseEntity.badRequest().body(new MessageError(400, "update company error"));
        }
        return ResponseEntity.ok(com);
    }
}
