package org.example.jobsearch.service;

import org.example.jobsearch.dto.VacancyDto;

public interface VacancyService {
    void createVacancy(VacancyDto vacancyDto);

    VacancyDto updateVacancy(Long vacancyId, VacancyDto vacancyDto);

    void deleteVacancy(Long vacancyId);
}
