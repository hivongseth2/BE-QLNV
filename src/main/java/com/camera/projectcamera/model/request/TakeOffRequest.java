package com.camera.projectcamera.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TakeOffRequest {

    private Long personId;
    private int departmentId;
    private Date submitDate;
    private Date takeOffDate;
    private String reason;
    private int quantity;
    private String state;

}
