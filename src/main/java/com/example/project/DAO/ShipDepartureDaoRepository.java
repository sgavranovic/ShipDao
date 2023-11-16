package com.example.project.DAO;

import com.example.project.domain.ShipDeparture;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ShipDepartureDaoRepository extends MongoRepository<ShipDeparture, String> {
    Optional<ShipDeparture> findByDepartureDateAndShipId(LocalDate departureDate, String shipId);
}
