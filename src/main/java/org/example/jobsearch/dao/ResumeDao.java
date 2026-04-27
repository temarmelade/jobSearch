package org.example.jobsearch.dao;


import lombok.RequiredArgsConstructor;
import org.example.jobsearch.dao.mapper.ResumeMapper;
import org.example.jobsearch.model.Resume;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ResumeDao {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Resume> getAllResumes() {
        String sql = "select * from resumes";
        return jdbcTemplate.query(sql, new ResumeMapper());
    }

    public List<Resume> getResumesByCategoryId(Integer categoryId) {
        String sql = "select * from resumes where category_id = :categoryId";
        return namedParameterJdbcTemplate.query(sql,
                new MapSqlParameterSource()
                        .addValue("categoryId", categoryId), new ResumeMapper());
    }

    public void createResume(Resume resume) {
        String sql = "insert into resumes(applicant_id, name, category_id, salary, is_active, created_date)" + "values(:applicantId, :name, :categoryId, :salary, :isActive, :createdDate)";
        namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource()
                        .addValue("applicantId", resume.getApplicantId())
                        .addValue("name", resume.getName())
                        .addValue("categoryId", resume.getCategoryId())
                        .addValue("salary", resume.getSalary())
                        .addValue("isActive", true)
                        .addValue("createdDate", resume.getCreatedDate())
        );
    }

    public Optional<Resume> getResumeById(Long resumeId) {
        String sql = "select * from resumes where id = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(sql, new ResumeMapper(), resumeId)
                )
        );
    }

    public Resume updateResume(Resume resume) {
        String sql = "update resumes set applicant_id = :applicantId, name = :name, category_id = :categoryId, salary = :salary, is_active = :isActive, created_date = :createdDate, update_date = :updateDate where id = :resumeId";
        namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource()
                        .addValue("applicantId", resume.getApplicantId())
                        .addValue("name", resume.getName())
                        .addValue("categoryId", resume.getCategoryId())
                        .addValue("salary", resume.getSalary())
                        .addValue("isActive", resume.isActive())
                        .addValue("createdDate", resume.getCreatedDate())
                        .addValue("updateDate", resume.getUpdatedDate())
                        .addValue("resumeId", resume.getId())
        );
        return getResumeById(resume.getId()).orElseThrow(RuntimeException::new);
    }

    public void deleteResume(Long resumeId) {
        String sql = "delete from resumes where id = ?";
        jdbcTemplate.update(sql, resumeId);
    }
}
