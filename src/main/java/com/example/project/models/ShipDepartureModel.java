package com.example.project.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ShipDepartureModel {
    private LocalDate departureDate;
    private String shipId;
    private Long numberOfPassengers;

}
