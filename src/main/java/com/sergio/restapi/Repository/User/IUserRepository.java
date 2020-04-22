package com.sergio.restapi.Repository.User;

import com.sergio.restapi.Entity.User;

public interface IUserRepository {
    Boolean saveUser(User user) throws Exception;
    User getUser(String userName);
}
