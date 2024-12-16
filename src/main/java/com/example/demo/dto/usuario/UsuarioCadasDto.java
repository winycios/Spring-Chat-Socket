package com.example.demo.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCadasDto {

    private String username;
    private String password;
    private String img;
    private String email;
}

