package com.camera.projectcamera.repository;

import com.camera.projectcamera.entity.Company;
import com.camera.projectcamera.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company,String> {





}
