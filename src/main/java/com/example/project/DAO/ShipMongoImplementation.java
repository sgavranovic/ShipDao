package com.example.project.DAO;

import com.example.project.domain.Ship;
import com.example.project.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Profile("mongo")
public class ShipMongoImplementation implements ShipDao {

    @Autowired
    ShipDaoRepository repository2;

    @Autowired
    Mapper mapper;

    @Override
    public Optional<Ship> findByIdNameAndMainPort(String id, String ime, String maticnaLuka) {
        return repository2.findShipByIdAndImeAndMaticnaLuka(id, ime, maticnaLuka);
    }

    @Override
    public Ship save(Ship ship) {
        var existingShipOptional = repository2.findShipByIdAndImeAndMaticnaLuka(ship.getId(), ship.getIme(), ship.getMaticnaLuka());
        if (existingShipOptional.isEmpty()) {
            return repository2.save(ship);
        }

        var existingShip = existingShipOptional.get();
        existingShip = mapper.updateShip(existingShip, ship);
        return repository2.save(existingShip);
    }
}
