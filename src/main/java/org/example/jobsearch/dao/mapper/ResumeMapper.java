package org.example.jobsearch.dao.mapper;

import org.example.jobsearch.model.Resume;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ResumeMapper implements RowMapper<Resume> {

    @Override
    public Resume mapRow(ResultSet rs, int rowNum) throws SQLException {
        Resume resume = new Resume();

        resume.setId(rs.getLong("id"));
        resume.setName(rs.getString("name"));
        resume.setSalary(rs.getBigDecimal("salary"));
        resume.setActive(Boolean.TRUE.equals(rs.getBoolean("is_active")));
        resume.setCreatedDate(rs.getDate("created_date").toLocalDate());

        Timestamp ts = rs.getTimestamp("update_date");
        resume.setUpdatedDate(ts != null ? ts.toLocalDateTime() : null);

        resume.setApplicantId(rs.getLong("applicant_id"));
        resume.setCategoryId(rs.getInt("category_id"));

        return resume;
    }

}
