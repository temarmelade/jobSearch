package org.example.jobsearch.service.implementations;

import lombok.RequiredArgsConstructor;
import org.example.jobsearch.dao.VacancyDao;
import org.example.jobsearch.dto.VacancyDto;
import org.example.jobsearch.model.Vacancy;
import org.example.jobsearch.service.VacancyService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyDao vacancyDao;

    @Override
    public void createVacancy(VacancyDto vacancyDto) {
        Vacancy vacancy = new Vacancy();
        vacancy.setName(vacancyDto.getName());
        vacancy.setDescription(vacancyDto.getDescription());
        vacancy.setCategoryId(vacancyDto.getCategoryId());
        vacancy.setSalary(vacancyDto.getSalary());
        vacancy.setAuthorId(vacancyDto.getAuthorId());
        vacancy.setActive(true);
        vacancy.setExpFrom(vacancyDto.getExpFrom());
        vacancy.setExpTo(vacancyDto.getExpTo());
        vacancyDao.createVacancy(vacancy);
    }

    @Override
    public VacancyDto updateVacancy(Long vacancyId, VacancyDto vacancyDto) {
        Vacancy vacancy = setVacancy(vacancyDto, vacancyId);
        Vacancy updatedVacancy = vacancyDao.updateVacancy(vacancy);
        return VacancyDto.builder()
                .id(updatedVacancy.getId())
                .name(updatedVacancy.getName())
                .description(updatedVacancy.getDescription())
                .categoryId(updatedVacancy.getCategoryId())
                .salary(updatedVacancy.getSalary())
                .authorId(updatedVacancy.getAuthorId())
                .expFrom(updatedVacancy.getExpFrom())
                .expTo(updatedVacancy.getExpTo())
                .isActive(updatedVacancy.isActive())
                .createdDate(updatedVacancy.getCreatedDate())
                .updateDate(updatedVacancy.getUpdateDate())
                .build();
    }

    @Override
    public void deleteVacancy(Long vacancyId) {
        vacancyDao.deleteVacancyById(vacancyId);
    }

    @Override
    public List<VacancyDto> getActiveVacancies() {
        List<Vacancy> vacancies = vacancyDao.getActiveVacancies();
        return vacancies.stream()
                .map(e -> VacancyDto.builder()
                        .id(e.getId())
                        .isActive(e.isActive())
                        .expFrom(e.getExpFrom())
                        .expTo(e.getExpTo())
                        .name(e.getName())
                        .description(e.getDescription())
                        .salary(e.getSalary())
                        .authorId(e.getAuthorId())
                        .categoryId(e.getCategoryId())
                        .createdDate(e.getCreatedDate())
                        .updateDate(e.getUpdateDate())
                        .isActive(e.isActive())
                        .build())
                .toList();
    }

    private Vacancy setVacancy(VacancyDto vacancyDto, Long vacancyId) {
        System.out.println("i get id" + vacancyId);
        Vacancy vacancy = getVacancyById(vacancyId);
        vacancy.setName(vacancyDto.getName());
        vacancy.setDescription(vacancyDto.getDescription());
        vacancy.setCategoryId(vacancyDto.getCategoryId());
        vacancy.setSalary(vacancyDto.getSalary());
        vacancy.setActive(Boolean.TRUE.equals(vacancyDto.getIsActive()));
        vacancy.setAuthorId(vacancyDto.getAuthorId());
        vacancy.setExpFrom(vacancyDto.getExpFrom());
        vacancy.setExpTo(vacancyDto.getExpTo());
        vacancy.setUpdateDate(LocalDateTime.now());
        return vacancy;
    }

    private Vacancy getVacancyById(Long vacancyId) {
        return vacancyDao.getVacancyById(vacancyId).orElseThrow();
    }
}
