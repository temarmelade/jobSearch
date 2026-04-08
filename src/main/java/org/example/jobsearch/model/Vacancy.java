package org.example.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy {
    private Long id;
    private String name;
    private String description;
    private Integer categoryId;
    private Integer salary;
    private Integer expFrom;
    private Integer expTo;
    private boolean isActive;
    private Integer authorId;
    private Date createdDate;
    private Date updatedDate;
}
