package com.nodoapi.nodoapi.auth;

import com.nodoapi.nodoapi.config.JwtService;
import com.nodoapi.nodoapi.persistence.entity.Rol;
import com.nodoapi.nodoapi.persistence.entity.User;
import com.nodoapi.nodoapi.persistence.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public RegisterResponse register(RegisterRequest registerRequest) {
        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            return RegisterResponse.builder().message("The user already exist in database").status(0).build();
        }
        var user = User.builder()
                .age(registerRequest.getAge())
                .name(registerRequest.getName())
                .idRol(registerRequest.getIdRol())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();
        var userCreated = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return RegisterResponse.builder().message("User created succesfully").status(1).idPerson(userCreated.getIdPerson()).build();
    }

    public AutheticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()
                )
        );
        var user = userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AutheticationResponse.builder().idPerson(user.getIdPerson()).token(jwtToken).age(user.getAge()).message("Found").status(1).name(user.getName()).email(user.getEmail()).rol(user.getRol().getName()).build();
    }
}
