package com.example.demo.controller;


import com.example.demo.dto.usuario.LoginDto;
import com.example.demo.dto.usuario.LoginResponseDto;
import com.example.demo.dto.usuario.UsuarioCadasDto;
import com.example.demo.dto.usuario.UsuarioResponseDto;
import com.example.demo.dto.usuario.mapper.UsuarioMapper;
import com.example.demo.exception.CredentialsUnauthorized;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.jwt.JwtUtil;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.AuthService;
import com.example.demo.service.JwtDetailsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;


    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponseDto> registerHandler(@Valid @RequestBody UsuarioCadasDto user) {

        return ResponseEntity.ok(authService.cadastrarUser(user));
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginHandler(@Valid @RequestBody LoginDto body) {
        if (body.getEmail() == null || body.getPassword() == null) {
            throw new ResourceNotFound("Informe os dados de login.");
        }

        return ResponseEntity.ok(authService.loginHandler(body.getEmail(), body.getPassword()));
    }
}