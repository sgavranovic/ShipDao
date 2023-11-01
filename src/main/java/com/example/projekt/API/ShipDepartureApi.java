package com.example.projekt.API;

import com.example.projekt.DAO.ShipDepartureDao;
import com.example.projekt.domain.ShipDeparture;
import com.example.projekt.mapper.Mapper;
import com.example.projekt.models.ShipDepartureModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(path="shipdepartures")

public class ShipDepartureApi {

    @Autowired
    ShipDepartureDao shipDepartureDao;

    @Autowired
    Mapper mapper;

    @GetMapping(path = "departure")
    public ShipDepartureModel getDeparture(@RequestParam(name="date") String date, @RequestParam(name="shipId") String shipId) {
        LocalDate localDate = LocalDate.parse(date);
        Optional<ShipDeparture> departureOptional = shipDepartureDao.findByDateAndShipId(localDate, shipId);
        if (departureOptional.isEmpty()){
            return new ShipDepartureModel();
        }
        ShipDeparture departure = departureOptional.get();
        ShipDepartureModel model = mapper.mapToModel(departure);
        return model;
    }

    @PostMapping(path = "departure")
    public void createDeparture(@RequestBody ShipDepartureModel model) {
        ShipDeparture departure = mapper.mapToDeparture(model);
        shipDepartureDao.save(departure);
    }
}
