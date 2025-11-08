package com.azam.vehicleservicebookingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.azam.vehicleservicebookingsystem.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
