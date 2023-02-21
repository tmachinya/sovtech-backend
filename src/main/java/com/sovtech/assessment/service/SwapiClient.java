package com.sovtech.assessment.service;
import com.sovtech.assessment.data.payload.PeopleResponse;
import com.sovtech.assessment.model.SwapiPerson;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;


public interface SwapiClient {
    @RequestLine("GET /people/")
    PeopleResponse<SwapiPerson> getPeople(@QueryMap Map<String, String> options);
}
