package com.example.project.DAO;

import com.example.project.domain.Ship;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ShipDaoRepository extends MongoRepository<Ship, String> {

    Optional<Ship> findShipByIdAndImeAndMaticnaLuka(String id, String ime, String maticnaLuka);
}
