package ru.netology.jdbc;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AppRepository {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String sql;

    public AppRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        sql = read("select_join.sql");
    }

    public List<String> getProductName(String name) {
        var params = new HashMap<String, Object>();
        params.put("name", name);

        return namedParameterJdbcTemplate.query(sql, params, (rs, rowNum) -> rs.getString("product_name"));
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
