package org.example.jobsearch.dao;


import lombok.RequiredArgsConstructor;
import org.example.jobsearch.dao.mapper.ResumeMapper;
import org.example.jobsearch.model.Resume;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
