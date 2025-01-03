package com.example.demo.dto.usuario;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCadasDto {


    @NotBlank
    private String username;

    @NotBlank
    @NotBlank
    @Size(min = 3, max = 20)
    private String password;

    @NotBlank
    private String img;

    @NotBlank
    @Email
    private String email;
}

