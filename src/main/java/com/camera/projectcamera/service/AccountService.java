package com.camera.projectcamera.service;

import com.camera.projectcamera.dto.AccountDTO;
import com.camera.projectcamera.entity.Accounts;
import com.camera.projectcamera.model.request.UpdateAccountRequest;

public interface AccountService {
    void addAccount(Accounts account);
    Accounts findById(Long id);
    Accounts updateRoleAccount (UpdateAccountRequest request);
    void updatePasswordAccount(Long accountId, AccountDTO accountDTO);
    Accounts   findByUsername(String username);

}
