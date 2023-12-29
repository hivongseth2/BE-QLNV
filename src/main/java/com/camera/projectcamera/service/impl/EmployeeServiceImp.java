package com.camera.projectcamera.service.impl;

import com.camera.projectcamera.entity.Accounts;
import com.camera.projectcamera.entity.Employee;
import com.camera.projectcamera.entity.Role;
import com.camera.projectcamera.model.request.AccountRequest;
import com.camera.projectcamera.model.request.EmployeeRequest;
import com.camera.projectcamera.repository.AccountRepository;
import com.camera.projectcamera.repository.EmployeeRepository;
import com.camera.projectcamera.responsentory.RoleRepo;
import com.camera.projectcamera.service.AccountService;
import com.camera.projectcamera.service.DepartmentService;
import com.camera.projectcamera.service.EmployeeService;
import com.camera.projectcamera.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor


public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final AccountRepository accountRepository;
    private final AccountService accountService;
    private final RoleService roleService;
    private final DepartmentService departmentService;


    @Override
    public Employee createEmployee(EmployeeRequest employeeRequest) {


        if (!isValidPhoneNumber(employeeRequest.getPhone())) {
            System.out.println("Invalid phone number");
            return null;
        }

        if (!isValidEmail(employeeRequest.getEmail())) {
            System.out.println("Invalid email");
            return null;
        }
        Accounts account = new Accounts();
        try
        {
            try
            {
                Role role = roleService.getRoleById(employeeRequest.getRoleId());
                account.setUserName(employeeRequest.getUserName());
                account.setPassword(employeeRequest.getPassWord());
                account.setRole(role);
                accountRepository.save(account);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("Error when save account");
            }
            finally
            {
                Employee employee = new Employee();
                employee.setFullName(employeeRequest.getFullName());
                employee.setPhone(employeeRequest.getPhone());
                employee.setEmail(employeeRequest.getEmail());
                employee.setAddress(employeeRequest.getAddress());
                employee.setStatus(1);
                employee.setSalary(employeeRequest.getSalary());
                employee.setPosition(employeeRequest.getPosition());
                employee.setDepartment(departmentService.findById(employeeRequest.getDepartmentId()));
                employee.setAccount(account);
                return employeeRepo.save(employee);
            }

        }
       catch(Exception e)
       {
           e.printStackTrace();
           return null;
       }
    }
    @Override
    public Employee getEmployeeById(Long employeeId) {
       Employee employee = employeeRepo
                .findById(employeeId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Khong tim thay Khach hang"));
        return employee;
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employeeBefore = optionalEmployee.get();
            employee.setAccount(employeeBefore.getAccount());

            employee.setPersonId(employeeBefore.getPersonId());
            employee.setDepartment(employeeBefore.getDepartment());
            updateUsernamePasswordAccount(employeeBefore.getAccount().getUserId(), new AccountRequest(
                    employee.getAccount().getUserName(),
                    employee.getAccount().getPassword()
            ));

            // Save the updated employee
            return employeeRepo.save(employee);
        } else {
            return null;
        }
    }

    public void updateUsernamePasswordAccount(Long accountId, AccountRequest accountRequest) {
        Accounts accounts = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Account with id " + accountId + " not found"));

        // Update username and password
        accounts.setUserName(accountRequest.getUserName());
        accounts.setPassword(accountRequest.getPassword());

        // Save the updated account
        accountRepository.save(accounts);
    }

    @Override
    public EmployeeRequest getUserInfo(String userName) {
        Employee employee = employeeRepo.findByUserName(userName);
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

    @Override
    public List<Employee> getEmployeeByDepartment(Long id) {
        return employeeRepo.findByDepartment(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\d{10}$"; // Kiểm tra số điện thoại có 10 chữ số
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"; // Kiểm tra định dạng email theo chuẩn RFC 5322
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



}
