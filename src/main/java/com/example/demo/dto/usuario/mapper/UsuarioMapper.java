package com.example.demo.dto.usuario.mapper;

import com.example.demo.dto.usuario.UsuarioCadasDto;
import com.example.demo.dto.usuario.UsuarioResponseDto;
import com.example.demo.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UsuarioMapper(ModelMapper modelMapper) {
        UsuarioMapper.modelMapper = modelMapper;
    }

    public static Usuario toEntity(UsuarioCadasDto usuario) {
        return modelMapper.map(usuario, Usuario.class);
    }

    public static UsuarioResponseDto toDto(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioResponseDto.class);
    }
}

