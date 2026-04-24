package org.example.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkExperienceDto {
    private Long resumeId;
    private Integer years;
    private String companyName;
    private String position;
    private String responsibility;
}
