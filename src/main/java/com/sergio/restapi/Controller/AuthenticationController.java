package com.sergio.restapi.Controller;


import com.sergio.restapi.DTO.UserDTO;
import com.sergio.restapi.Service.AuthService.IAuthService;
import com.sergio.restapi.Service.AuthService.JwtUserDetailsService;
import com.sergio.restapi.Utils.Jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private IAuthService authService;

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) throws Exception {
        authService.register(userDTO);
        return ResponseEntity.ok("register");
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) throws Exception {

        authenticate(userDTO.getUserName(), userDTO.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(userDTO.getUserName());

        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}

