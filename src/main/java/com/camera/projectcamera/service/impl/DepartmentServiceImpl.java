package com.camera.projectcamera.service.impl;

import com.camera.projectcamera.entity.Company;
import com.camera.projectcamera.entity.Department;
import com.camera.projectcamera.model.request.DepartmentRequest;
import com.camera.projectcamera.repository.DepartmentRepository;
import com.camera.projectcamera.service.CompanyService;
import com.camera.projectcamera.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    CompanyService companyService;


    @Override
    public Department createDepartment(DepartmentRequest request) {


        Company company = null;
        company= companyService.findCompanyById(request.getCompanyId());
        if(company!=null)
        {
            Department department = new Department();
            department.setDepartmentName(request.getDepartmentName());
            department.setCompany(company);

            return departmentRepository.save(department);
        }
        else
        {
          throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Không thể thực hiện thao tác tạo phòng ban" );        }
    }

    @Override
    public List<Department> getAll() {


        return departmentRepository.findAll();
    }

    @Override
    public Department findById(int id) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);

        if (departmentOptional.isPresent()) {
            return departmentOptional.get();
        } else {
            return null; // hoặc throw new CompanyNotFoundException("Company not found with id: " + id);
        }
    }
}
