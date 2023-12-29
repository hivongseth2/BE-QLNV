package com.camera.projectcamera.service;

import com.camera.projectcamera.entity.Salary;
import com.camera.projectcamera.entity.TakeOff;
import com.camera.projectcamera.model.request.SalaryRequest;
import com.camera.projectcamera.model.request.TakeOffRequest;
import com.camera.projectcamera.model.request.TakeOffUpdateRq;

import java.util.List;

public interface TakeOffService {

    List<TakeOff> getTakeOffList();
    List<TakeOff> getTakeOffByDepartment(Long departmentId);
    TakeOff createTakeOff(TakeOffRequest request);
    TakeOff findById(Long id);
    TakeOff updateState(TakeOffUpdateRq request);
}
