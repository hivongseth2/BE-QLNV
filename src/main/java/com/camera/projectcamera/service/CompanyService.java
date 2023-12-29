package com.camera.projectcamera.service;

import com.camera.projectcamera.entity.Company;
import com.camera.projectcamera.model.request.UpPerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

   Company createCompany(Company company);
   List<Company> getAll();

   Company findCompanyById(String id);

   Company updatePermission(UpPerRequest request);


   Company updateCompany(String id, Company com);

}
