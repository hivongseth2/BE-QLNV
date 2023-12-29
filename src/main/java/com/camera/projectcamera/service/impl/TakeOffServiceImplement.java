package com.camera.projectcamera.service.impl;

import com.camera.projectcamera.entity.Department;
import com.camera.projectcamera.entity.Employee;
import com.camera.projectcamera.entity.TakeOff;
import com.camera.projectcamera.model.request.TakeOffRequest;
import com.camera.projectcamera.model.request.TakeOffUpdateRq;
import com.camera.projectcamera.repository.TakeOffRepository;
import com.camera.projectcamera.service.DepartmentService;
import com.camera.projectcamera.service.EmployeeService;
import com.camera.projectcamera.service.TakeOffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TakeOffServiceImplement implements TakeOffService {
    @Autowired
    TakeOffRepository takeOffRepository;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;

    @Override
    public List<TakeOff> getTakeOffList() {
       return takeOffRepository.findAll();
    }

    @Override
    public List<TakeOff> getTakeOffByDepartment(Long departmentId) {
      return takeOffRepository.findByDepartmentId(departmentId);
    }

    @Override
    public TakeOff createTakeOff(TakeOffRequest request) {

        Employee employee = employeeService.getEmployeeById(request.getPersonId());
        Department department = departmentService.findById(request.getDepartmentId());


        TakeOff takeOff = new TakeOff();
        takeOff.setDateTakeOff(request.getTakeOffDate());
        takeOff.setDepartment(department);
        takeOff.setEmployee(employee);
        takeOff.setDateSubmit(request.getSubmitDate());
        takeOff.setQuantity(request.getQuantity());
        takeOff.setReason(request.getReason());
        takeOff.setState(request.getState());

       return takeOffRepository.save(takeOff);

    }

    @Override
    public TakeOff findById(Long id) {
        Optional<TakeOff> optionalTakeOff = takeOffRepository.findById(id);
        return optionalTakeOff.orElse(null); // or handle the absence as needed
    }


    @Override
    public TakeOff updateState(TakeOffUpdateRq request) {
        TakeOff takeOff = findById(request.getId());

        takeOff.setState(request.getState());
        System.out.println(takeOff.toString());
        return takeOffRepository.save(takeOff);

    }
}
