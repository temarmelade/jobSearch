package org.example.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkExperience {
    private Long resumeId;
    private Integer years;
    private String companyName;
    private String position;
    private String responsibility;
}
