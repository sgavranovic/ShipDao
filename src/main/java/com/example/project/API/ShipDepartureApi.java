package com.example.project.API;
import com.example.project.DAO.ShipDao;
import com.example.project.DAO.ShipDepartureDao;
import com.example.project.domain.Ship;
import com.example.project.domain.ShipDeparture;
import com.example.project.mapper.Mapper;
import com.example.project.models.ShipDepartureModel;
import com.example.project.models.ShipModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(path="shipdepartures")

public class ShipDepartureApi {

    @Autowired
    ShipDepartureDao shipDepartureDao;

    @Autowired
    ShipDao shipDao;

    @Autowired
    Mapper mapper;

    @GetMapping(path = "departure")
    public ShipDepartureModel getDeparture(@RequestParam(name="date") String date, @RequestParam(name="shipId") String shipId) {

        LocalDate localDate = LocalDate.parse(date);
        Optional<ShipDeparture>departureOptional = shipDepartureDao.findByDateAndShipId(localDate, shipId);

        // Razmišljam da je tu bolje vratiti null, nego prazan model. Budemo prodiskutirali.
        if (departureOptional.isEmpty()) {
            return new ShipDepartureModel();
        }

        ShipDeparture departure = departureOptional.get();
        return mapper.mapToModel(departure);
    }

    // Razmišljam da je tu bolje vratiti ono što smo kreirali, zato jer prilikom kreiranja objekt dobije ID, pa da pozivatelj
    // može znati koji je ID.
    @PostMapping(path = "departure")
    public ShipDepartureModel createDeparture(@RequestBody ShipDepartureModel model) {
        ShipDeparture departure = mapper.mapToDeparture(model);
        return mapper.mapToModel(shipDepartureDao.save(departure));
    }
}
