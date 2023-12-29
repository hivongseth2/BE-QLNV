package com.camera.projectcamera.service.impl;

import com.camera.projectcamera.entity.Department;
import com.camera.projectcamera.entity.Employee;
import com.camera.projectcamera.entity.Salary;
import com.camera.projectcamera.entity.SalaryTime;
import com.camera.projectcamera.model.request.SalaryRequest;
import com.camera.projectcamera.repository.SalaryRepository;
import com.camera.projectcamera.service.DepartmentService;
import com.camera.projectcamera.service.EmployeeService;
import com.camera.projectcamera.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    SalaryRepository salaryRepository;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Override
    public List<SalaryTime> getSalaryList() {
      return salaryRepository.findAll();
    }

    @Override
    public List<SalaryTime> getSalaryByDepartment(Long departmentId) {
       return salaryRepository.findByDepartmentId(departmentId);
    }

    @Override
    public SalaryTime createSalary(SalaryRequest request) {

        Employee employee = employeeService.getEmployeeById(request.getEmployeeId());
        Department department = departmentService.findById(request.getDepartmentId());
        SalaryTime theSalary = new SalaryTime();


        theSalary.setEmployee(employee);
        theSalary.setDepartment(department);
        theSalary.setAllow(request.getAllow());
        theSalary.setSum(request.getSum());
        theSalary.setDate(request.getDate());

        System.out.println(theSalary);
        return salaryRepository.save(theSalary);



    }
}
