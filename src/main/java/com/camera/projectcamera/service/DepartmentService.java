package com.camera.projectcamera.service;

import com.camera.projectcamera.entity.Company;
import com.camera.projectcamera.entity.Department;
import com.camera.projectcamera.model.request.DepartmentRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface DepartmentService {
    Department createDepartment(DepartmentRequest request);
    List<Department> getAll();
    Department findById(int id);
}
