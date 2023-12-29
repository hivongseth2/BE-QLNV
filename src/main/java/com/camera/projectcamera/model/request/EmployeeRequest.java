package com.camera.projectcamera.model.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class EmployeeRequest {
    private Long personId;
    String fullName;
    String phone;
    String email;
    String address;
    String status;
    String position;
    String userName;
    String passWord;
    Long salary;
    int departmentId;
    Long roleId;

}
