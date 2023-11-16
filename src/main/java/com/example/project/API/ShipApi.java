package com.example.project.API;

import com.example.project.DAO.ShipDao;
import com.example.project.domain.Ship;
import com.example.project.domain.ShipDeparture;
import com.example.project.mapper.Mapper;
import com.example.project.models.ShipDepartureModel;
import com.example.project.models.ShipModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(path="ships")
public class ShipApi {

    @Autowired
    ShipDao shipDao;
    @Autowired
    Mapper mapper;

    @GetMapping(path = "ship")
    public ShipModel getDeparture(@RequestParam(name="id") String id, @RequestParam(name="ime") String ime,
                                  @RequestParam(name = "maticnaLuka") String maticnaLuka) {


        Optional<Ship>ShipOptional = shipDao.findByIdNameAndMainPort(id, ime, maticnaLuka);


        if (ShipOptional.isEmpty()) {
            return new ShipModel();
        }

        Ship ship = ShipOptional.get();
        return mapper.mapToModelShip(ship);
    }
    @PostMapping(path = "ship")
    public ShipModel createShip(@RequestBody ShipModel model) {
        Ship ship1 = mapper.mapToShip(model);
        return mapper.mapToModelShip(shipDao.save(ship1));
    }

}
