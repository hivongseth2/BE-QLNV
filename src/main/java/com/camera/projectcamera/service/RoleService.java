package com.camera.projectcamera.service;

import com.camera.projectcamera.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    Role create(String name);
    Role getRoleById(Long id);
//    void update(Long id, String name);
    List<Role> getAll();

   Role updateRole (Long roleId, String name);
}
