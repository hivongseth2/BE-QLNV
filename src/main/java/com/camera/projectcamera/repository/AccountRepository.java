package com.camera.projectcamera.repository;

import com.camera.projectcamera.entity.Accounts;
import com.camera.projectcamera.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByUserNameAndPassword(String userName, String password);
    @Query("SELECT a FROM Accounts a WHERE a.userName = :userName")
    Accounts findByUserName(@Param("userName") String userName);
}
