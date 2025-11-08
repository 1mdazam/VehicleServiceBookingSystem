package com.azam.vehicleservicebookingsystem.controller;

import com.azam.vehicleservicebookingsystem.entity.Vehicle;
import com.azam.vehicleservicebookingsystem.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // Show page
    @GetMapping("/vehicles-page")
public String showVehiclesPage(Model model,
                               @RequestParam(value = "success", required = false) String successMsg,
                               HttpSession session) {

    // ✅ Redirect to login if session expired
    if (session.getAttribute("username") == null) {
        return "redirect:/?error=Please login first!";
    }

    List<Vehicle> vehicles = vehicleService.getAllVehicles();
    model.addAttribute("vehicles", vehicles);
    model.addAttribute("vehicle", new Vehicle());
    model.addAttribute("success", successMsg);
    model.addAttribute("username", session.getAttribute("username")); // pass username to page

    return "vehicles";
}


    // Add new vehicle
    @PostMapping("/vehicles-page")
    public String saveVehicleFromForm(@ModelAttribute Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicles-page?success=Vehicle added successfully!";
    }

    // Edit page
    @GetMapping("/edit/{id}")
    public String editVehicle(@PathVariable Long id, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "vehicles";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles-page?success=Vehicle deleted successfully!";
    }
}
