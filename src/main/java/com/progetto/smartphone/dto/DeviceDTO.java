package com.progetto.smartphone.dto;

import com.progetto.smartphone.entity.DeviceStatus;
import com.progetto.smartphone.entity.TypeDevice;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {

    @NotBlank
    private Long id;

    @NotBlank
    private TypeDevice deviceType;

    @NotBlank
    private DeviceStatus deviceStatus;

    private String employeeUsername;

}
