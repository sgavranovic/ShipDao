package com.example.projekt.DAO;

import com.example.projekt.domain.ShipDeparture;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.example.projekt.domain.ShipDeparture;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
@Profile("in-memory")
public class ShipDepartureDaoMemoryImplementation implements ShipDepartureDao {
    private final List<ShipDeparture> departures;
    public ShipDepartureDaoMemoryImplementation(){
        departures = new ArrayList<>();
    }
    @Override
    public Optional<ShipDeparture> FIndByDateAndShipId(LocalDate date, String ShipId) {
        return departures.stream()
                .filter(dat -> dat.getDepartureDate().equals(date) && dat.getShipId().equals(ShipId))
                .findFirst();
    }
    @Override
    public ShipDeparture save(ShipDeparture departure) {
        Predicate<ShipDeparture> filterPredicate = date ->
                date.getDepartureDate().equals(departure.getDepartureDate()) &&
                        date.getShipId().equals(departure.getShipId());

        Optional<ShipDeparture> existingDepartureOptional = departures.stream()
                .filter(filterPredicate)
                .findFirst();
        if(existingDepartureOptional.isPresent()){
            var existingDeparture = existingDepartureOptional.get();
            existingDeparture.setNumberOfPassengers(departure.getNumberOfPassengers());
        }{
            var NewDeparture = new ShipDeparture();
            NewDeparture.setDepartureDate(departure.getDepartureDate());
            NewDeparture.setShipId(departure.getShipId());
            NewDeparture.setNumberOfPassengers(departure.getNumberOfPassengers());
            departures.add(NewDeparture);
            return NewDeparture;
        }
    }
}
