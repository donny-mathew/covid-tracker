package com.code.covidtracker.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationStats {
    private String state;
    private String country;
    private int latestCovidCases;
    private int diffFromPrevDay;
}
