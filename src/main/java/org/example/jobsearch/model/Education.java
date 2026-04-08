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
public class Education {
    private Long resumeId;
    private String institution;
    private String program;
    private Date startDate;
    private Date endDate;
    private EducationDegree degree;
}
