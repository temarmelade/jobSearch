package org.example.jobsearch.controller;

import lombok.RequiredArgsConstructor;
import org.example.jobsearch.dto.ResumeDto;
import org.example.jobsearch.service.ResumeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("resume")
public class ResumeController {

    private final ResumeService resumeService;

    @GetMapping
    public List<ResumeDto> getAllResumes() {
        return resumeService.getAllResumes();
    }

    @GetMapping("{categoryId}")
    public List<ResumeDto> getResumeByCategoryId(@PathVariable Integer categoryId) {
        return resumeService.getResumesByCategoryId(categoryId);
    }
}
