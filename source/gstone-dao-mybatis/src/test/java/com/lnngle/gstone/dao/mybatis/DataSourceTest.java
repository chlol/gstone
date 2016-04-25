package com.lnngle.gstone.dao.mybatis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:config/spring/**/*.xml" })
public class DataSourceTest {

    private static final String TEST_QUERY = "SELECT * FROM test_table1";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("rawtypes")
	@Test
    public void test() {
        List<List> list = jdbcTemplate.query(TEST_QUERY, new RowMapper<List>() {
            @SuppressWarnings("unchecked")
			@Override
            public List mapRow(ResultSet rs, int i) throws SQLException {
                List record = new ArrayList();
                record.add(rs.getString("id"));
                record.add(rs.getString("name"));
                record.add(rs.getInt("age"));
                return record;
            }
        });

        assert list != null;
        assert list.size() > 0;
    }

}
