package com.camera.projectcamera.repository;

import com.camera.projectcamera.entity.Employee;
import com.camera.projectcamera.entity.Salary;
import com.camera.projectcamera.entity.SalaryTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalaryRepository extends JpaRepository<SalaryTime,Long>  {
    @Query("SELECT s FROM SalaryTime s WHERE s.department.id = :departmentId")
    List<SalaryTime> findByDepartmentId(@Param("departmentId") Long departmentId);


}
