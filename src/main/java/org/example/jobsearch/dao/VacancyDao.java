package org.example.jobsearch.dao;

import lombok.RequiredArgsConstructor;
import org.example.jobsearch.dao.mapper.VacancyMapper;
import org.example.jobsearch.model.Vacancy;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VacancyDao {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final KeyHolder keyHolder = new GeneratedKeyHolder();

    public void createVacancy(Vacancy vacancy) {
        String sql = "insert into vacancies(name, description, category_id, salary, exp_from, exp_to, is_active, author_id, created_date)" + "values(:name, :description, :category_id, :salary, :exp_from, :exp_to, :is_active, :author_id, :created_date)";
        namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource()
                        .addValue("name", vacancy.getName())
                        .addValue("description", vacancy.getDescription())
                        .addValue("category_id", vacancy.getCategoryId())
                        .addValue("salary", vacancy.getSalary())
                        .addValue("exp_from", vacancy.getExpFrom())
                        .addValue("exp_to", vacancy.getExpTo())
                        .addValue("is_active", true)
                        .addValue("author_id", vacancy.getAuthorId())
                        .addValue("created_date", LocalDate.now())
        );
    }

    public Vacancy updateVacancy(Vacancy vacancy) {
        String sql = "update vacancies set name = :name, description = :description, category_id = :category_id, salary = :salary, exp_from = :exp_from, exp_to = :exp_to, is_active = :is_active, author_id = :author_id, update_date = :update_date where id = :id";
        namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource()
                        .addValue("name", vacancy.getName())
                        .addValue("description", vacancy.getDescription())
                        .addValue("category_id", vacancy.getCategoryId())
                        .addValue("salary", vacancy.getSalary())
                        .addValue("exp_from", vacancy.getExpFrom())
                        .addValue("exp_to", vacancy.getExpTo())
                        .addValue("is_active", vacancy.isActive())
                        .addValue("author_id", vacancy.getAuthorId())
                        .addValue("update_date", vacancy.getUpdateDate())
                        .addValue("id", vacancy.getId())
        );
        return getVacancyById(vacancy.getId()).orElseThrow(RuntimeException::new);
    }

    public Optional<Vacancy> getVacancyById(Long id) {
        String sql = "select * from vacancies where id = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(sql, new VacancyMapper(), id)
                )
        );
    }

    public void deleteVacancyById(Long id) {
        String sql = "delete from vacancies where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Vacancy> getActiveVacancies() {
        String sql = "select * from vacancies where is_active = true";
        return jdbcTemplate.query(sql, new VacancyMapper());
    }
}
