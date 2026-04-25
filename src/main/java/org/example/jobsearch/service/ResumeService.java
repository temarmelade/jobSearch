package org.example.jobsearch.service;

import org.example.jobsearch.dto.ResumeDto;

import java.util.List;

public interface ResumeService {
    List<ResumeDto> getAllResumes();

    List<ResumeDto> getResumesByCategoryId(Integer categoryId);
}
