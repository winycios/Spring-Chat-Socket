package com.example.demo.service;

import com.example.demo.dto.usuario.LoginResponseDto;
import com.example.demo.dto.usuario.UsuarioCadasDto;
import com.example.demo.dto.usuario.UsuarioResponseDto;
import com.example.demo.dto.usuario.mapper.UsuarioMapper;
import com.example.demo.exception.CredentialsUnauthorized;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.jwt.JwtUtil;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authManager;

    public UsuarioResponseDto cadastrarUser(UsuarioCadasDto user) {
        if (usuarioRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new CredentialsUnauthorized("Email já está sendo utilizado.");
        }

        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);

        return UsuarioMapper.toDto(usuarioRepository.save(UsuarioMapper.toEntity(user)));
    }


    public LoginResponseDto loginHandler(String email, String password) {
        Usuario user = usuarioRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFound("Dados de login inválidos."));

        authenticateUser(email, password);

        String token = jwtUtil.generateToken(email);

        return new LoginResponseDto(user.getId(), user.getEmail(), token, user.getImg());
    }

    private void authenticateUser(String email, String password) {
        Authentication authInputToken = new UsernamePasswordAuthenticationToken(email, password);

        try {
            Authentication authentication = authManager.authenticate(authInputToken);
            if (!authentication.isAuthenticated()) {
                throw new CredentialsUnauthorized("Usuário não autenticado.");
            }
        } catch (Exception e) {
            throw new CredentialsUnauthorized("Credenciais inválidas.");
        }
    }
}
