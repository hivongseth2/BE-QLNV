package com.camera.projectcamera.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryProductRequest {

    private Long employeeId;
    private int departmentId;
    private Long numberOfProducts;
    private Long  unitPrice;
    private Date date;
    private Long sum;
}
