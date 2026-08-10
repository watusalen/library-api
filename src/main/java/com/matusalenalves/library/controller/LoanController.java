package com.matusalenalves.library.controller;

import com.matusalenalves.library.dto.request.LoanRequest;
import com.matusalenalves.library.dto.response.LoanResponse;
import com.matusalenalves.library.security.userdetails.CustomUserDetails;
import com.matusalenalves.library.services.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Endpoints REST para registro, devolução e consulta de empréstimos (RF18-RF21).
 */
@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    /**
     * Registra o empréstimo de um livro disponível para o cliente autenticado (RF18, RN01, RN02, RN04).
     *
     * @param request     dados do empréstimo (ID do livro)
     * @param userDetails cliente autenticado obtido do token JWT
     * @return o empréstimo criado, com status HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<LoanResponse> create(
            @Valid @RequestBody LoanRequest request,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        LoanResponse response = loanService.create(userDetails.getUser().getId(), request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Registra a devolução de um empréstimo (RF19, RN09).
     *
     * @param id          identificador do empréstimo a ser devolvido
     * @param userDetails usuário autenticado obtido do token JWT
     * @return o empréstimo devolvido, com status HTTP 200 OK
     */
    @PutMapping("/{id}/return")
    public ResponseEntity<LoanResponse> returnLoan(
            @PathVariable Long id,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        LoanResponse response = loanService.returnLoan(
                id,
                userDetails.getUser().getId(),
                userDetails.getUser().isAdmin()
        );
        return ResponseEntity.ok(response);
    }

    /**
     * Lista o histórico de empréstimos do cliente atualmente autenticado (RF20).
     *
     * @param userDetails cliente autenticado obtido do token JWT
     * @return a lista de empréstimos do cliente
     */
    @GetMapping("/me")
    public ResponseEntity<List<LoanResponse>> findMyLoans(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        List<LoanResponse> response = loanService.findMyLoans(userDetails.getUser().getId());
        return ResponseEntity.ok(response);
    }

    /**
     * Lista o histórico geral de empréstimos de todos os usuários (RF21, RN08).
     *
     * @return a lista completa de empréstimos
     */
    @GetMapping
    public ResponseEntity<List<LoanResponse>> findAll() {
        List<LoanResponse> response = loanService.findAll();
        return ResponseEntity.ok(response);
    }
}