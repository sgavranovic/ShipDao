package com.example.project.DAO;

import com.example.project.domain.Ship;
import com.example.project.domain.ShipDeparture;

import java.util.Optional;

public interface ShipDao {
    Optional<Ship> findByIdNameAndMainPort(String id, String ime, String maticnaLuka);
    Ship save(Ship ship);
}
