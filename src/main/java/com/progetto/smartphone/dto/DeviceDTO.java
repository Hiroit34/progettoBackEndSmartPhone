package com.progetto.smartphone.dto;

import com.progetto.smartphone.entity.DeviceStatus;
import com.progetto.smartphone.entity.TypeDevice;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {

    private Long id;

    @NotNull
    private TypeDevice deviceType;

    @NotNull
    private DeviceStatus deviceStatus;

    @NotBlank
    private String employeeUsername;

    public String getEmployeeUsername() {
        return employeeUsername;
    }
}
