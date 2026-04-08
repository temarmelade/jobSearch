package org.example.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespondedApplicant {
    private Integer id;
    private Long resumeId;
    private Long vacancyId;
    private boolean confirmed;
}
