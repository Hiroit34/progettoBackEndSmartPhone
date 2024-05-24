package com.progetto.smartphone.repository;

import com.progetto.smartphone.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
