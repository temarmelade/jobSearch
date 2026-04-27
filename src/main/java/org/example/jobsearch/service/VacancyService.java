package org.example.jobsearch.service;

import org.example.jobsearch.dto.VacancyDto;

import java.util.List;

public interface VacancyService {
    void createVacancy(VacancyDto vacancyDto);

    VacancyDto updateVacancy(Long vacancyId, VacancyDto vacancyDto);

    void deleteVacancy(Long vacancyId);

    List<VacancyDto> getActiveVacancies();
}
