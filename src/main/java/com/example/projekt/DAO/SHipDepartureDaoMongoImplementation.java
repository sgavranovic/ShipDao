package com.example.projekt.DAO;

import com.example.projekt.domain.ShipDeparture;
import com.example.projekt.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
@Component
@Profile("mongo")
public class SHipDepartureDaoMongoImplementation implements ShipDepartureDao {

    @Autowired
    ShipDepartureDaoRepository repository;

    @Autowired
    Mapper mapper;
    @Override
    public Optional<ShipDeparture> FIndByDateAndShipId(LocalDate date, String ShipId) {
        return repository.findByDepartureDateAndShipId(date, ShipId);
    }

    @Override
    public ShipDeparture save(ShipDeparture departure) {
        var existingDepartureOptional = repository.findByDepartureDateAndShipId(departure.getDepartureDate(), departure.getShipId());

        if(existingDepartureOptional.isEmpty()){
            return repository.save(departure);
        }

        var existingDeparture = existingDepartureOptional.get();
        existingDeparture = mapper.update(existingDeparture, departure);
        return  repository.save(existingDeparture);
    }
}
