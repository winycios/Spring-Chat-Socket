package com.example.demo.dto.usuario.mapper;

import com.example.demo.dto.usuario.UsuarioCadasDto;
import com.example.demo.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioMapper {

    @Autowired
    private static ModelMapper modelMapper;

    public static Usuario toEntity(UsuarioCadasDto usuario) {
        return modelMapper.map(usuario, Usuario.class);
    }
}
