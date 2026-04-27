package org.example.jobsearch.controller;

import lombok.RequiredArgsConstructor;
import org.example.jobsearch.dto.ResumeDto;
import org.example.jobsearch.service.ResumeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public HttpStatus createResume(@RequestBody ResumeDto resumeDto) {
        resumeService.createResume(resumeDto);
        return HttpStatus.CREATED;
    }

    @PutMapping("{resumeId}")
    public ResponseEntity<ResumeDto> updateResume(@PathVariable Long resumeId, @RequestBody ResumeDto resumeDto) {
        ResumeDto resume = resumeService.updateResume(resumeId, resumeDto);
        return ResponseEntity.ok(resume);
    }

    @GetMapping("{categoryId}")
    public List<ResumeDto> getResumeByCategoryId(@PathVariable Integer categoryId) {
        return resumeService.getResumesByCategoryId(categoryId);
    }

    @DeleteMapping("{resumeId}")
    public HttpStatus deleteResume(@PathVariable Long resumeId) {
        resumeService.deleteResume(resumeId);
        return HttpStatus.OK;
    }
}
