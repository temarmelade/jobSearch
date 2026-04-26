package org.example.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
    private Long id;
    private Long applicantId;
    private String name;
    private Integer categoryId;
    private BigDecimal salary;
    private boolean isActive;
    private LocalDate createdDate;
    private LocalDateTime updatedDate;
}
