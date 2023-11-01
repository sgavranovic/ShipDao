package com.example.project.DAO;

import com.example.project.domain.ShipDeparture;

import java.time.LocalDate;
import java.util.Optional;

public interface ShipDepartureDao {
    Optional<ShipDeparture> findByDateAndShipId(LocalDate date, String ShipId);

    ShipDeparture save(ShipDeparture departure);
}
