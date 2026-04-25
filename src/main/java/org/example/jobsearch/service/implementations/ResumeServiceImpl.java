package org.example.jobsearch.service.implementations;

import lombok.RequiredArgsConstructor;
import org.example.jobsearch.dao.ResumeDao;
import org.example.jobsearch.dto.ResumeDto;
import org.example.jobsearch.model.Resume;
import org.example.jobsearch.service.ResumeService;
import org.springframework.stereotype.Service;

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
}
