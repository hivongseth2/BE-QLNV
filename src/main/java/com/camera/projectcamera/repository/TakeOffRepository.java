package com.camera.projectcamera.repository;

import com.camera.projectcamera.entity.Salary;
import com.camera.projectcamera.entity.TakeOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TakeOffRepository extends JpaRepository<TakeOff,Long> {

    @Query("SELECT t FROM TakeOff t WHERE t.department.id = :departmentId")
    List<TakeOff> findByDepartmentId(@Param("departmentId") Long departmentId);
}
