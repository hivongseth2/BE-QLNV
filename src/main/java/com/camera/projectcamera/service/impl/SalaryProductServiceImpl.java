package com.camera.projectcamera.service.impl;

import com.camera.projectcamera.entity.Department;
import com.camera.projectcamera.entity.Employee;
import com.camera.projectcamera.entity.SalaryProduct;
import com.camera.projectcamera.entity.SalaryTime;
import com.camera.projectcamera.model.request.SalaryProductRequest;
import com.camera.projectcamera.model.request.SalaryRequest;
import com.camera.projectcamera.repository.SalaryProductRepository;
import com.camera.projectcamera.service.DepartmentService;
import com.camera.projectcamera.service.EmployeeService;
import com.camera.projectcamera.service.SalaryProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SalaryProductServiceImpl implements SalaryProductService {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;

    @Autowired
    SalaryProductRepository salaryProductRepository;
    @Override
    public List<SalaryProduct> getSalaryList() {
            return salaryProductRepository.findAll();
        }



    @Override
    public List<SalaryProduct> getSalaryByDepartment(Long departmentId) {
        return salaryProductRepository.findByDepartmentId(departmentId);

    }

    @Override
    public SalaryProduct createSalary(SalaryProductRequest request) {
        Employee employee = employeeService.getEmployeeById(request.getEmployeeId());
        Department department = departmentService.findById(request.getDepartmentId());
        SalaryProduct theSalary = new SalaryProduct();

        theSalary.setEmployee(employee);
        theSalary.setDepartment(department);
        theSalary.setNumberOfProducts(request.getNumberOfProducts());
        theSalary.setUnitPrice(request.getUnitPrice());
        theSalary.setDate(request.getDate());
        theSalary.setSum(request.getSum());

        return salaryProductRepository.save(theSalary);


    }
}
