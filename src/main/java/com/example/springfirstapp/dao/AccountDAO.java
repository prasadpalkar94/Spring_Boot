package com.example.springfirstapp.dao;

import com.example.springfirstapp.config.SpringJdbcConfig;
import com.example.springfirstapp.model.AccountInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    // static JdbcTemplate jdbcTemplateObj = new JdbcTemplate(SpringJdbcConfig.mysqlDataSource());
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountDAO.class);

    private final String INSERT_SQL = "INSERT INTO AccountInfo(firstname,lastname,email) values(?,?,?)";
    
    private final String SELECT_SQL = "SELECT * from AccountInfo";
    
    private final String DELETE_SQL = "delete from AccountInfo where id = ? ";
    
     private final String UPDATE_SQL = "UPDATE AccountInfo SET email = 'prasadpalkar94@gmail.com' WHERE id = ? ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AccountInfo create(AccountInfo user) {
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, user.getFirstname());
                    ps.setString(2, user.getLastname());
                    ps.setString(3, user.getEmail());
                    return ps;
                }
            }, holder);

            int newUserId = holder.getKey().intValue();
            user.setId(newUserId);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return user;
    }
    
//     public AccountInfo delete(AccountInfo user) {
//        try {
//            jdbcTemplate.update(DELETE_SQL,"1");
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage(), e);
//        }
//        return user;
//    }
    
    
}
