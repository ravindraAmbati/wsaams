package edu.nhs.wsaams.repository.mapper;

import edu.nhs.wsaams.entity.LoginUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUserRowMapper implements RowMapper<LoginUser> {
    @Override
    public LoginUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println(rs.toString());
        return new LoginUser(rs.getString("username"),rs.getString("password"));
    }
}
