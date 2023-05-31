package com.nodoapi.nodoapi.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest){
        RegisterResponse response = authenticationService.register(registerRequest);
        if(response.getStatus().equals(0)){
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AutheticationResponse> register(@RequestBody AuthenticationRequest authenticationRequest){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}
