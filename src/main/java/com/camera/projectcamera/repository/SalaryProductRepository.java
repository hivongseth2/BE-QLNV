package com.camera.projectcamera.repository;

import com.camera.projectcamera.entity.SalaryProduct;
import com.camera.projectcamera.entity.SalaryTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalaryProductRepository extends JpaRepository<SalaryProduct,Long> {
    @Query("SELECT s FROM SalaryProduct s WHERE s.department.id = :departmentId")
    List<SalaryProduct> findByDepartmentId(@Param("departmentId") Long departmentId);


}

