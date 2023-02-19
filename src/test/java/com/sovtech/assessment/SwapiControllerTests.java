package com.sovtech.assessment;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sovtech.assessment.controller.PersonController;
import com.sovtech.assessment.data.payload.PeopleResponse;
import com.sovtech.assessment.model.SwapiPerson;
import com.sovtech.assessment.service.SwapiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class SwapiControllerTests {

    @Mock
    private SwapiClient swapiClient;

    @InjectMocks
    private PersonController swapiController;

    @BeforeEach
    void setUp() {
        // Set up any necessary test data or mock behavior here
    }

    @Test
    void testGetPeopleWithNoSearch() {
        // Set up mock behavior for the swapiClient
        List<SwapiPerson> people = new ArrayList<>();
        people.add(new SwapiPerson("Luke Skywalker", "male", "Tatooine","",""));
        PeopleResponse<SwapiPerson> response = new PeopleResponse<SwapiPerson>(1,"","",people);
        when(swapiClient.getPeople(any(Map.class))).thenReturn(response);

        // Call the controller method with no search term
        ResponseEntity<?> result = swapiController.getPeople(1, null);

        // Verify that the response contains the expected data
        List<SwapiPerson> resultList = (List<SwapiPerson>) result.getBody();
        assertNotNull(resultList);
        assertEquals(1, resultList.size());
        assertEquals("Luke Skywalker", resultList.get(0).getName());
    }

    @Test
    void testGetPeopleWithSearch() {
        // Set up mock behavior for the swapiClient
        List<SwapiPerson> people = new ArrayList<>();
        people.add(new SwapiPerson("Leia Organa", "female", "Alderaan","",""));
        PeopleResponse<SwapiPerson> response = new PeopleResponse<SwapiPerson>(0,"","",people);
        when(swapiClient.getPersonByName(any(Map.class))).thenReturn(response);

        // Call the controller method with a search term
        ResponseEntity<?> result = swapiController.getPeople(1, "Leia Organa");

        // Verify that the response contains the expected data
        SwapiPerson person = (SwapiPerson) result.getBody();
        assertNotNull(person);
        assertEquals("Leia Organa", person.getName());
    }
}
