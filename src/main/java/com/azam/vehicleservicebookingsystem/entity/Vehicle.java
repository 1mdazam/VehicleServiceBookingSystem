package com.azam.vehicleservicebookingsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;
    private String vehicleNumber;
    private String vehicleType;
    private String serviceType;
    private String contactNumber;
}
