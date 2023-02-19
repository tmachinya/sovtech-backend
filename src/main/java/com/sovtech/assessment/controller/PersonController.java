package com.sovtech.assessment.controller;

import com.sovtech.assessment.data.payload.PeopleResponse;
import com.sovtech.assessment.model.SwapiPerson;
import com.sovtech.assessment.service.SwapiClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PersonController {
    private final SwapiClient swapiClient;

    public PersonController(SwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @GetMapping("/people")
    public ResponseEntity<?> getPeople(@RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value = "search",required=false) String search) {
        if(search==null){
            PeopleResponse<SwapiPerson> response = swapiClient.getPeople(Map.of("page", String.valueOf(page)));
            return ResponseEntity.ok(response.getResults());
        }
        else return ResponseEntity.ok(swapiClient.getPersonByName(Map.of("search", search)).getResults().get(0));
    }

}