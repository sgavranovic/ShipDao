package com.example.project.API;

import com.example.project.domain.ShipDeparture;
import com.example.project.mapper.Mapper;
import com.example.project.models.ShipDepartureModel;
import com.example.project.models.ShipModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(path="ships")
public class ShipApi {

    @Autowired
    Mapper mapper;


}
