package org.example.jobsearch.dao.mapper;

import org.example.jobsearch.model.Vacancy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class VacancyMapper implements RowMapper<Vacancy> {

    @Override
    public Vacancy mapRow(ResultSet rs, int rowNum) throws SQLException {

        Vacancy vacancy = new Vacancy();
        vacancy.setId(rs.getLong("id"));
        vacancy.setName(rs.getString("name"));
        vacancy.setDescription(rs.getString("description"));
        vacancy.setCategoryId(rs.getInt("category_id"));
        vacancy.setSalary(rs.getInt("salary"));
        vacancy.setAuthorId(rs.getInt("author_id"));
        vacancy.setExpFrom(rs.getInt("exp_from"));
        vacancy.setExpTo(rs.getInt("exp_to"));
        vacancy.setActive(rs.getBoolean("is_active"));

        Timestamp updated = rs.getTimestamp("update_date");
        vacancy.setUpdateDate(updated != null ? updated.toLocalDateTime() : null);

        Date created = rs.getDate("created_date");
        vacancy.setCreatedDate(created != null ? created.toLocalDate() : null);

        return vacancy;
    }

}
