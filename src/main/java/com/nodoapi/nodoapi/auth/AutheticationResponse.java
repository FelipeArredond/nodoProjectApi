package com.nodoapi.nodoapi.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutheticationResponse {
    private Long idPerson;
    private String token;
    private String message;
    private Integer status;
    private String name;
    private String rol;
    private String email;
    private  Integer age;
}
