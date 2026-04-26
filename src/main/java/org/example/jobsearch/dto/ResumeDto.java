package org.example.jobsearch.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ResumeDto {
    private Long id;
    private Long applicantId;
    private String name;
    private Integer categoryId;
    private BigDecimal salary;
    @JsonProperty("isActive")
    private Boolean isActive;
    private LocalDate createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedDate;
}
