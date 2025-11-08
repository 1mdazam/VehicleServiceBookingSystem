package com.azam.vehicleservicebookingsystem.service;

import com.azam.vehicleservicebookingsystem.entity.Vehicle;
import com.azam.vehicleservicebookingsystem.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    public Vehicle getVehicleById(Long id) {
    return vehicleRepository.findById(id).orElse(null);
}

public void deleteVehicle(Long id) {
    vehicleRepository.deleteById(id);
}

}
