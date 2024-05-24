package com.progetto.smartphone.controller;

import com.progetto.smartphone.dto.DeviceDTO;
import com.progetto.smartphone.entity.Device;
import com.progetto.smartphone.errorHandling.ResourceNotFoundException;
import com.progetto.smartphone.repository.EmployeeRepository;
import com.progetto.smartphone.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
@Validated
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Optional<Device> device = deviceService.findById(id);
        return device.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@Validated @RequestBody DeviceDTO deviceDTO) {
        Device device = deviceService.createDevice(deviceDTO);
        return new ResponseEntity<>(device, HttpStatus.CREATED);

    }
        @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @Validated @RequestBody DeviceDTO deviceDTO) {
        if (!deviceService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        deviceDTO.setId(id);
        return ResponseEntity.ok(deviceService.save(deviceDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        try {
            deviceService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
