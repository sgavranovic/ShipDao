package com.example.project.DAO;

import com.example.project.domain.ShipDeparture;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

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
    public Optional<ShipDeparture> findByDateAndShipId(LocalDate date, String ShipId) {
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

        // Između if, while, for... dakle keywordsa i parametara dolazi razmak.
        // Samo kod deklaracije ili poziva metode nema tog razmaka.
        // To je vjerojatno napravljeno da se if, while, for... razlikuju od metoda vizualno.
        if (existingDepartureOptional.isPresent()) {
            var existingDeparture = existingDepartureOptional.get();
            existingDeparture.setNumberOfPassengers(departure.getNumberOfPassengers());
        }

        // Ovaj komad koda bio je kao blok, u vitičastim zagradama, što mislim da nije potrebno.

        var newDeparture = new ShipDeparture();
        newDeparture.setDepartureDate(departure.getDepartureDate());
        newDeparture.setShipId(departure.getShipId());
        newDeparture.setNumberOfPassengers(departure.getNumberOfPassengers());
        departures.add(newDeparture);

        return newDeparture;

    }
}
