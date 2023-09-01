package com.br.aeroapi.dto;

import com.br.aeroapi.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
