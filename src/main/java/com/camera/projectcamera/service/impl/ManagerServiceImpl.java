    package com.camera.projectcamera.service.impl;

    import com.camera.projectcamera.entity.Accounts;
    import com.camera.projectcamera.entity.Role;
    import com.camera.projectcamera.entity.Manager;
    import com.camera.projectcamera.model.request.ManagerRequest;
    import com.camera.projectcamera.repository.AccountRepository;
    import com.camera.projectcamera.repository.EmployeeRepository;
    import com.camera.projectcamera.repository.ManagerRepository;
    import com.camera.projectcamera.service.AccountService;
    import com.camera.projectcamera.service.RoleService;
    import com.camera.projectcamera.service.ManagerService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.stereotype.Service;
    import org.springframework.web.server.ResponseStatusException;

    import java.util.List;

    @Service
    @RequiredArgsConstructor
    public class ManagerServiceImpl implements ManagerService {

        @Autowired
        private ManagerRepository ManagerRepository;

        @Override
        public List<Manager> getManager() {
            return ManagerRepository.findAll();
        }

        @Override
        public Manager getManagerById(Long ManagerId) {
            Manager Manager = ManagerRepository
                    .findById(ManagerId)
                    .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Mặt hàng không được tìm thấy với id" + ManagerId));
            return Manager;
        }



        private final EmployeeRepository employeeRepo;
        private final AccountRepository accountRepository;
        private final AccountService accountService;
        private final RoleService roleService;

        @Override
        public Manager addManager(ManagerRequest ManagerRequest) {
            Accounts account = new Accounts();
            try{
                try{
                    Role role = roleService.getRoleById(ManagerRequest.getRoleId());

                    account.setUserName(ManagerRequest.getUserName());
                    account.setPassword(ManagerRequest.getPassWord());
                    account.setRole(role);
                    accountRepository.save(account);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.println("Error when save account");
                }
                finally {
                    Manager Manager = new Manager();
                    Manager.setFullName(ManagerRequest.getFullName());
                    Manager.setPhone(ManagerRequest.getPhone());
                    Manager.setEmail(ManagerRequest.getEmail());
                    Manager.setAddress(ManagerRequest.getAddress());
                    Manager.setStatus(1);
                    Manager.setAccount(account);
                    return ManagerRepository.save(Manager);
                }
            }catch(Exception e)
            {
                e.printStackTrace();
                return null;
            }
        }
    }
