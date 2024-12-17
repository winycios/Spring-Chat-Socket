package com.example.demo.config;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class Population implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) {


        Usuario m1 = new Usuario();

        m1.setUsername("winycios");
        m1.setEmail("winycios@gmail.com");
        m1.setImg("homem_1.svg");
        m1.setPassword(passwordEncoder.encode("1234"));

        Usuario m2 = new Usuario();

        m2.setUsername("Leticia");
        m2.setEmail("lele@gmail.com");
        m2.setImg("mulher_1.svg");
        m2.setPassword(passwordEncoder.encode("1234"));


        usuarioRepository.saveAll(Arrays.asList(m1, m2));
    }
}
