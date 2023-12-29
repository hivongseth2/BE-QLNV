package com.camera.projectcamera.service;

import com.camera.projectcamera.model.request.EmployeeRequest;

public interface AuthService {
    boolean login(String userName, String password);

    EmployeeRequest getUserInfo(String userName);
}
