package com.example.projekt.DAO;

import com.example.projekt.domain.ShipDeparture;

import java.time.LocalDate;
import java.util.Optional;

public interface ShipDepartureDao {
    Optional<ShipDeparture> FIndByDateAndShipId(LocalDate date, String ShipId);

    ShipDeparture save(ShipDeparture departure);
}
