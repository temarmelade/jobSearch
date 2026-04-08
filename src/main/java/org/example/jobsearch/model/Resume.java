package org.example.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
    private Long id;
    private Long applicantId;
    private String name;
    private Integer categoryId;
    private Integer salary;
    private boolean isActive;
    private Date createdDate;
    private Date updatedDate;
}
