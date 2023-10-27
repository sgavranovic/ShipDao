package com.example.projekt.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("departures")

public class ShipDeparture {

    private String ID;
    private LocalDate departureDate;
    private String shipId;
    private Long numberOfPassengers;

}
