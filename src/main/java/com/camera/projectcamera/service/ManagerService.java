package com.camera.projectcamera.service;

import com.camera.projectcamera.entity.Manager;

import com.camera.projectcamera.model.request.ManagerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManagerService {
//    void addStaff(Staff staff);

    List<Manager> getManager();

    Manager getManagerById(Long managerId);

    Manager addManager(ManagerRequest managerRequest);
}
