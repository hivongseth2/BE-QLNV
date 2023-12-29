package com.camera.projectcamera.service;

import com.camera.projectcamera.entity.Salary;
import com.camera.projectcamera.entity.SalaryTime;
import com.camera.projectcamera.model.request.SalaryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface SalaryService {

    List<SalaryTime> getSalaryList();
    List<SalaryTime> getSalaryByDepartment(Long departmentId);
    SalaryTime createSalary(SalaryRequest request);


}
