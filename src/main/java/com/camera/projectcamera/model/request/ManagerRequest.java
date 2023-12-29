package com.camera.projectcamera.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerRequest {
    String fullName;
    String phone;
    String email;
    String address;
    String status;
    String userName;
    String passWord;
    Long roleId;
}
