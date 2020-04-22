package com.sergio.restapi.Service.AuthService;

import com.sergio.restapi.Entity.User;
import com.sergio.restapi.Repository.User.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        try {
            user = userRepository.getUser(username);
            if (user != null)
                return new org.springframework.security.core.userdetails.User(
                        user.getUserName(),
                        user.getPassword(),
                        new ArrayList<>()
                );
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

}