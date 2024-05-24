package com.progetto.smartphone.service;


import com.progetto.smartphone.dto.DeviceDTO;
import com.progetto.smartphone.entity.Device;
import com.progetto.smartphone.errorHandling.ResourceNotFoundException;
import com.progetto.smartphone.mapper.DeviceMapper;
import com.progetto.smartphone.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    public Optional<Device> findById(Long id) {
        return deviceRepository.findById(id);
    }

    public Device save(DeviceDTO deviceDTO) {
        Device device = DeviceMapper.INSTANCE.toEntity(deviceDTO);
        return deviceRepository.save(device);
    }

    public Device update(DeviceDTO deviceDTO) {
        if (!deviceRepository.existsById(deviceDTO.getId())) {
            throw new ResourceNotFoundException("Device not found with provided id: " + deviceDTO.getId());
        }
        Device device = DeviceMapper.INSTANCE.toEntity(deviceDTO);
        return  deviceRepository.save(device);
    }

    public void deleteById(Long id) {
        if (!deviceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Device not found with provided id: " + id);
        }
        deviceRepository.deleteById(id);
    }

}
