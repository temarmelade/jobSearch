package org.example.jobsearch.service;

import org.example.jobsearch.dto.ResumeDto;

import java.util.List;

public interface ResumeService {
    List<ResumeDto> getAllResumes();

    List<ResumeDto> getResumesByCategoryId(Integer categoryId);

    void createResume(ResumeDto resumeDto);

    ResumeDto updateResume(Long resumeId, ResumeDto resumeDto);

    void deleteResume(Long resumeId);
}
