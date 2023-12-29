package com.camera.projectcamera.repository;

import com.camera.projectcamera.entity.Company;
import com.camera.projectcamera.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository  extends JpaRepository<Department,Integer> {
}
