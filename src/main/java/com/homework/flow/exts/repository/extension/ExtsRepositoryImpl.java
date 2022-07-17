package com.homework.flow.exts.repository.extension;

import com.homework.flow.exts.domain.Extension;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class ExtsRepositoryImpl implements ExtsRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public ExtsRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("extension")
                .usingGeneratedKeyColumns("id");
    }


    @Override
    public Extension save(Extension extension) {
        SqlParameterSource param = new BeanPropertySqlParameterSource(extension);
        Number key = jdbcInsert.executeAndReturnKey(param);
        extension.setId(key.longValue());
        return extension;
    }

    @Override
    public void update(Extension extension) {
        String sql = "update extension set name = :name,  flag_use= :flagUse, flag_fixed = :flagFixed" +
                " where id = :id";

        SqlParameterSource param = new BeanPropertySqlParameterSource(extension);
        jdbcTemplate.update(sql, param);
    }

    @Override
    public Optional<Extension> findById(Long id) {
        String sql = "select id, name, flag_use, flag_fixed from extension where id = :id";
        try {
            Map<String, Object> param = Map.of("id", id);
            Extension extension = jdbcTemplate.queryForObject(sql, param, extensionRowMapper());
            return Optional.of(extension);

        } catch (EmptyResultDataAccessException e) {
            e.getMessage();
            return Optional.empty();
        }
    }

    @Override
    public List<Extension> findAll() {
        String sql = " select id, name, flag_use, flag_fixed from extension ";
        return jdbcTemplate.query(sql, extensionRowMapper());
    }

    private RowMapper<Extension> extensionRowMapper() {
        return BeanPropertyRowMapper.newInstance(Extension.class);
    }
}