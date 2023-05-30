package com.nodoapi.nodoapi.auth;

import com.nodoapi.nodoapi.config.JwtService;
import com.nodoapi.nodoapi.persistence.entity.User;
import com.nodoapi.nodoapi.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AutheticationResponse register(RegisterRequest registerRequest) {
        User user = User.builder()
                .age(registerRequest.getAge())
                .name(registerRequest.getName())
                .idRol(registerRequest.getIdRole())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AutheticationResponse.builder().token(jwtToken).build();
    }

    public AutheticationResponse autheticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()
                )
        );
        var user = userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AutheticationResponse.builder().token(jwtToken).build();
    }
}
