package com.camera.projectcamera.service.impl;

import com.camera.projectcamera.entity.Accounts;
import com.camera.projectcamera.entity.Employee;
import com.camera.projectcamera.model.request.EmployeeRequest;
import com.camera.projectcamera.repository.AccountRepository;
import com.camera.projectcamera.repository.EmployeeRepository;
import com.camera.projectcamera.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean login(String userName, String passWord) {
        Optional<Accounts> account = accountRepository.findByUserNameAndPassword(userName, passWord);
        return account.isPresent();
    }

    @Override
    public EmployeeRequest getUserInfo(String userName) {
        Employee employee = employeeRepository.findByUserName(userName);
        if (employee != null) {
            return new EmployeeRequest(
                    employee.getPersonId(),
                    employee.getFullName(),

                    employee.getPhone(),
                    employee.getEmail(),
                    employee.getAddress(),
                    String.valueOf(employee.getStatus()),
                    employee.getPosition(),
                    employee.getAccount().getUserName(),
                    employee.getAccount().getPassword(),
                    employee.getSalary(),

                    employee.getDepartment().getId(),
                    employee.getAccount().getRole().getRoleId()
            );
        } else {
            return null;
        }
    }

}
