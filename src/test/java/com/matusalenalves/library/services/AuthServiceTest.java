package com.matusalenalves.library.services;

import com.matusalenalves.library.dto.request.LoginRequest;
import com.matusalenalves.library.dto.request.RegisterRequest;
import com.matusalenalves.library.dto.response.TokenResponse;
import com.matusalenalves.library.entities.User;
import com.matusalenalves.library.repositories.UserRepository;
import com.matusalenalves.library.security.jwt.JwtService;
import com.matusalenalves.library.services.exceptions.EmailAlreadyExistsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthService authService;

    @Test
    @DisplayName("register deve salvar usuário quando email não existir")
    void register_ShouldSaveUser_WhenEmailDoesNotExist() {
        RegisterRequest request = new RegisterRequest("Maria Santos", "maria@email.com", "senha12345");

        when(userRepository.existsByEmail("maria@email.com")).thenReturn(false);
        when(passwordEncoder.encode("senha12345")).thenReturn("encodedPassword");

        authService.register(request);

        verify(userRepository).save(any(User.class));
    }

    @Test
    @DisplayName("register deve lançar EmailAlreadyExistsException quando email já cadastrado")
    void register_ShouldThrowEmailAlreadyExistsException_WhenEmailExists() {
        RegisterRequest request = new RegisterRequest("Maria Santos", "maria@email.com", "senha12345");

        when(userRepository.existsByEmail("maria@email.com")).thenReturn(true);

        assertThatThrownBy(() -> authService.register(request))
                .isInstanceOf(EmailAlreadyExistsException.class);

        verify(userRepository, never()).save(any());
    }

    @Test
    @DisplayName("login deve autenticar e retornar token JWT")
    void login_ShouldAuthenticateAndReturnToken() {
        LoginRequest request = new LoginRequest("maria@email.com", "senha12345");

        when(jwtService.generateToken("maria@email.com")).thenReturn("fake-jwt-token");

        TokenResponse response = authService.login(request);

        assertThat(response).isNotNull();
        assertThat(response.token()).isEqualTo("fake-jwt-token");
        verify(authenticationManager).authenticate(any());
    }
}