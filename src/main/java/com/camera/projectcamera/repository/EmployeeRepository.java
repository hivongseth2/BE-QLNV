package com.camera.projectcamera.repository;

import com.camera.projectcamera.entity.Company;
import com.camera.projectcamera.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT c FROM Employee c JOIN c.account a WHERE a.userName = :userName")
    Employee findByUserName(@Param("userName") String userName);


//    SELECT e FROM Employee e JOIN e.department d WHERE d.id = 1


    @Query("   SELECT e FROM Employee e JOIN e.department d WHERE d.id  = :departmentId")
    List<  Employee> findByDepartment(@Param("departmentId") Long departmentId);
}
