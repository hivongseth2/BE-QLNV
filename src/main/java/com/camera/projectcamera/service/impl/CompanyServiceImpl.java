package com.camera.projectcamera.service.impl;

import com.camera.projectcamera.entity.Company;
import com.camera.projectcamera.entity.Employee;
import com.camera.projectcamera.model.request.UpPerRequest;
import com.camera.projectcamera.repository.CompanyRepository;
import com.camera.projectcamera.repository.EmployeeRepository;
import com.camera.projectcamera.service.CompanyService;
import com.camera.projectcamera.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Array;
import java.util.*;

@Service
@RequiredArgsConstructor

public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private final CompanyRepository comRepo;


    private final EmployeeRepository employeeRepository;
    @Override
    public Company createCompany(Company company) {
        return comRepo.save(company);
    }

    @Override
    public List<Company> getAll() {
    return comRepo.findAll();
    }

    @Override
    public Company findCompanyById(String id) {
        Optional<Company> companyOption = comRepo.findById(id);

        if (companyOption.isPresent()) {
            return companyOption.get();
        } else {
            return null; // hoặc throw new CompanyNotFoundException("Company not found with id: " + id);
        }
    }
    @Override
    @Lazy
    public Company updatePermission(UpPerRequest request) {
        System.out.println(request.getIdCompany());
        Company company = findCompanyById(request.getIdCompany());

        Set<Employee> listEmps = new HashSet<>();

        request.getListIdEmp().forEach(item -> {
            Employee employee = employeeRepository
                    .findById(item)
                    .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Khong tim thay Khach hang"));

            listEmps.add(employee);
        });

        company.setListPerson(listEmps);

        return comRepo.save(company);
    }

    @Override
    public Company updateCompany(String id, Company com) {
        Company preCompany = findCompanyById(id);
        preCompany.setCompanyName(com.getCompanyName());
        preCompany.setCompanyAddress(com.getCompanyAddress());
        preCompany.setBuildYear(com.getBuildYear());
        preCompany.setAcreage(com.getAcreage());
        preCompany.setYearOperation(com.getYearOperation());
        preCompany.setType(com.getType());
        return comRepo.save(preCompany);
    }

}
