package com.camera.projectcamera.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TakeOffUpdateRq {

    Long id;
    String state;
}
