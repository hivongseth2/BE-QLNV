package com.camera.projectcamera.service;

import com.camera.projectcamera.entity.SalaryProduct;
import com.camera.projectcamera.entity.SalaryTime;
import com.camera.projectcamera.model.request.SalaryProductRequest;
import com.camera.projectcamera.model.request.SalaryRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SalaryProductService {
    List<SalaryProduct> getSalaryList();
    List<SalaryProduct> getSalaryByDepartment(Long departmentId);
    SalaryProduct createSalary(SalaryProductRequest request);
}
