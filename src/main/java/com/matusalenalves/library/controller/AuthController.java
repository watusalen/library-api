package com.matusalenalves.library.controller;

import com.matusalenalves.library.dto.request.LoginRequest;
import com.matusalenalves.library.dto.request.RegisterRequest;
import com.matusalenalves.library.dto.response.TokenResponse;
import com.matusalenalves.library.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoints REST públicos para cadastro (RF01) e autenticação (RF02) de usuários.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Cadastra um novo usuário com perfil CLIENT (RF01, RF03, RN07).
     *
     * @param request dados de cadastro (nome, e-mail e senha).
     * @return resposta vazia com status HTTP 201 Created.
     */
    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * Autentica um usuário e emite o token JWT de acesso (RF02, RNF04).
     *
     * @param request credenciais de login (e-mail e senha).
     * @return o token de acesso com status HTTP 200 OK.
     */
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest request) {
        TokenResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}