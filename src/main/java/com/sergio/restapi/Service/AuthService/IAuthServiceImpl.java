package com.sergio.restapi.Service.AuthService;

import com.sergio.restapi.DTO.UserDTO;
import com.sergio.restapi.Entity.User;
import com.sergio.restapi.Repository.User.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class IAuthServiceImpl implements IAuthService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public Boolean register(UserDTO userDTO) throws Exception {
        User user = modelMapper.map(userDTO, User.class);
        userRepository.saveUser(user);
        return true;
    }

    @Override
    public Boolean login(UserDTO userDTO) {
        User user = userRepository.getUser(userDTO.getUserName());
        if(user == null) return false;
        return bcryptEncoder.matches(userDTO.getPassword(),user.getPassword());

    }
}
