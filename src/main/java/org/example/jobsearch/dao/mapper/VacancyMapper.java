package org.example.jobsearch.dao.mapper;

import org.example.jobsearch.model.Vacancy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        vacancy.setUpdateDate(rs.getTimestamp("update_date") != null ? rs.getTimestamp("update_date").toLocalDateTime() : null);
        vacancy.setCreatedDate(rs.getDate("created_date").toLocalDate());
        return vacancy;
    }

}
