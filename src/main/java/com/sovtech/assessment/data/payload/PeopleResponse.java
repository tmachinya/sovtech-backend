package com.sovtech.assessment.data.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleResponse<T> {
    private int count;
    private String next;
    private String previous;
    private List<T> results;

}
