package org.example.jobsearch.service.implementations;

import lombok.RequiredArgsConstructor;
import org.example.jobsearch.dao.ResumeDao;
import org.example.jobsearch.dto.ResumeDto;
import org.example.jobsearch.model.Resume;
import org.example.jobsearch.service.ResumeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ResumeServiceImpl implements ResumeService {

    private final ResumeDao resumeDao;

    @Override
    public List<ResumeDto> getAllResumes() {
        List<Resume> resumes = resumeDao.getAllResumes();
        return resumes.stream()
                .map(e -> ResumeDto.builder()
                        .name(e.getName())
                        .id(e.getId())
                        .applicantId(e.getApplicantId())
                        .salary(e.getSalary())
                        .isActive(e.isActive())
                        .categoryId(e.getCategoryId())
                        .updatedDate(e.getUpdatedDate())
                        .createdDate(e.getCreatedDate())
                        .build()
                ).toList();
    }

    @Override
    public List<ResumeDto> getResumesByCategoryId(Integer categoryId) {
        List<Resume> resumes = resumeDao.getResumesByCategoryId(categoryId);
        return resumes.stream()
                .map(e -> ResumeDto.builder()
                        .name(e.getName())
                        .id(e.getId())
                        .applicantId(e.getApplicantId())
                        .salary(e.getSalary())
                        .isActive(e.isActive())
                        .categoryId(e.getCategoryId())
                        .updatedDate(e.getUpdatedDate())
                        .createdDate(e.getCreatedDate())
                        .build()
                ).toList();
    }

    @Override
    public void createResume(ResumeDto resumeDto) {
        Resume resume = new Resume();
        resume.setName(resumeDto.getName());
        resume.setApplicantId(resumeDto.getApplicantId());
        resume.setSalary(resumeDto.getSalary());
        resume.setCategoryId(resumeDto.getCategoryId());
        resume.setCreatedDate(LocalDate.now());
        resume.setActive(true);
        resumeDao.createResume(resume);
    }

    @Override
    public ResumeDto updateResume(Long resumeId, ResumeDto resumeDto) {

        Resume resume = getResumeById(resumeId);
        resume.setName(resumeDto.getName());
        resume.setApplicantId(resumeDto.getApplicantId());
        resume.setSalary(resumeDto.getSalary());
        resume.setCategoryId(resumeDto.getCategoryId());
        resume.setUpdatedDate(LocalDateTime.now());

        Resume updated = resumeDao.updateResume(resume);
        return ResumeDto.builder()
                .id(updated.getId())
                .name(updated.getName())
                .applicantId(updated.getApplicantId())
                .categoryId(updated.getCategoryId())
                .salary(updated.getSalary())
                .isActive(updated.isActive())
                .updatedDate(updated.getUpdatedDate())
                .createdDate(updated.getCreatedDate())
                .build();
    }

    @Override
    public void deleteResume(Long resumeId) {
        resumeDao.deleteResume(resumeId);
    }

    private Resume getResumeById(Long resumeId) {
        return resumeDao.getResumeById(resumeId).orElseThrow(RuntimeException::new);
    }


}
