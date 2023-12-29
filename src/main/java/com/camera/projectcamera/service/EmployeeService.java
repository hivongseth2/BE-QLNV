package com.camera.projectcamera.service;

import com.camera.projectcamera.entity.Employee;
import com.camera.projectcamera.entity.Role;
import com.camera.projectcamera.model.request.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee createEmployee(EmployeeRequest employeeRequest);
    Employee getEmployeeById(Long employeeId);
    Employee updateEmployee (Long employeeId, Employee employee);

    EmployeeRequest getUserInfo(String userName);

    List<Employee> getEmployeeByDepartment(Long id);
    List<Employee> getAllEmployee();
}
