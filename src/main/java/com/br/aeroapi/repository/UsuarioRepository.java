package com.br.aeroapi.repository;

import com.br.aeroapi.model.Aeroporto;
import com.br.aeroapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    UserDetails findByLogin(String login);
}
