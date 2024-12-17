package com.example.demo.service;

import com.example.demo.dto.usuario.UsuarioResponseDto;
import com.example.demo.dto.usuario.mapper.UsuarioMapper;
import com.example.demo.exception.ResourceNotFound;
import com.example.demo.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDto> getAllUsers() {
        return usuarioRepository.findAll().stream().map(UsuarioMapper::toDto).collect(Collectors.toList());
    }

    public UsuarioResponseDto getUserById(Long id) {
        return UsuarioMapper.toDto(usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Usuário não encontrado.")));
    }
}
