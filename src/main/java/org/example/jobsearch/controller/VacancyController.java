package org.example.jobsearch.controller;

import lombok.RequiredArgsConstructor;
import org.example.jobsearch.dto.VacancyDto;
import org.example.jobsearch.service.VacancyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("vacancy")
public class VacancyController {

    private final VacancyService vacancyService;

    @PostMapping
    public HttpStatus createVacancy(@RequestBody VacancyDto vacancyDto) {
        vacancyService.createVacancy(vacancyDto);
        return HttpStatus.CREATED;
    }

    @PutMapping("{vacancyId}")
    public ResponseEntity<VacancyDto> updateVacancy(@RequestBody VacancyDto vacancyDto, @PathVariable Long vacancyId) {
        VacancyDto updated = vacancyService.updateVacancy(vacancyId, vacancyDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("{vacancyId}")
    public HttpStatus deleteVacancy(@PathVariable Long vacancyId) {
        vacancyService.deleteVacancy(vacancyId);
        return HttpStatus.OK;
    }
}
