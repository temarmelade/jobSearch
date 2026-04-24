package org.example.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.jobsearch.model.EducationDegree;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
    private Long resumeId;
    private String institution;
    private String program;
    private Date startDate;
    private Date endDate;
    private EducationDegree degree;
}
