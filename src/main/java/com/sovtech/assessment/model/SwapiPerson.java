package com.sovtech.assessment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SwapiPerson {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;

}
