package com.sergio.restapi.Repository.User;

import com.sergio.restapi.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;


@Repository
public class IUserRepositoryImpl implements IUserRepository {

    @Autowired
    private JdbcTemplate jtm;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public Boolean saveUser(User user) {
        jtm.update(
                "insert into USERS (username,password,fullname) values(?, ?, ?)",
                user.getUserName(),
                bcryptEncoder.encode(user.getPassword()),
                user.getFullName());
        return true;
    }

    @Override
    public User getUser(String userName)  {
        return  jtm.queryForObject("select * from users where username=?",
                new Object[] {
                        userName
                },
                new BeanPropertyRowMapper<>(User.class));
    }
}
