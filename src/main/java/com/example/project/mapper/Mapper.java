package com.example.project.mapper;

import com.example.project.domain.Ship;
import com.example.project.domain.ShipDeparture;
import com.example.project.models.ShipDepartureModel;
import com.example.project.models.ShipModel;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public ShipDepartureModel mapToModel(ShipDeparture source) {

        var model = new ShipDepartureModel();
        model.setDepartureDate(source.getDepartureDate());
        model.setShipId(source.getShipId());
        model.setNumberOfPassengers(source.getNumberOfPassengers());
        return model;

    }

    public ShipDeparture mapToDeparture(ShipDepartureModel model) {

        var departure = new ShipDeparture();
        departure.setDepartureDate(model.getDepartureDate());
        departure.setShipId(model.getShipId());
        departure.setNumberOfPassengers(model.getNumberOfPassengers());
        return departure;

    }

    public ShipDeparture update(ShipDeparture existingDeparture, ShipDeparture newDeparture) {

        if(newDeparture.getDepartureDate() != null){
            existingDeparture.setDepartureDate(existingDeparture.getDepartureDate());
        }

        if(newDeparture.getDepartureDate() != null){
            existingDeparture.setShipId(existingDeparture.getShipId());
        }

        if(newDeparture.getDepartureDate() != null){
            existingDeparture.setNumberOfPassengers(existingDeparture.getNumberOfPassengers());
        }

        return existingDeparture;
    }

    // SHIPS

    public ShipModel mapToModel(Ship source) {

        var model = new ShipModel();
        model.setId(source.getId());
        model.setIme(source.getIme());
        model.setMaticnaLuka(source.getMaticnaLuka());
        return model;

    }

    public Ship mapToDeparture(ShipModel model) {

        var departure = new Ship();
        departure.setId(model.getId());
        departure.setIme(model.getIme());
        departure.setMaticnaLuka(model.getMaticnaLuka());
        return departure;

    }
    public Ship update(Ship existingShip, Ship newShip) {

        if(newShip.getId() != null){
            existingShip.setId(existingShip.getId());
        }

        if(newShip != null){
            existingShip.setIme(existingShip.getIme());
        }

        if(newShip != null){
            existingShip.setMaticnaLuka(existingShip.getMaticnaLuka());
        }
        return existingShip;
    }
}
