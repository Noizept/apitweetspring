package com.sergio.restapi.Service.AuthService;

import com.sergio.restapi.DTO.UserDTO;

public interface IAuthService {
    Boolean register(UserDTO userDTO) throws Exception;
    Boolean login(UserDTO userDTO);
}
