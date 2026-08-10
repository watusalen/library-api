package com.matusalenalves.library.controller;

import com.matusalenalves.library.dto.request.AuthorRequest;
import com.matusalenalves.library.dto.response.AuthorResponse;
import com.matusalenalves.library.dto.response.PageResponse;
import com.matusalenalves.library.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoints REST para consulta e gerenciamento de autores (RF10-RF13).
 */
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * Consulta a lista de autores cadastrados, paginada (RF13, RNF12).
     *
     * @param pageable página, tamanho e ordenação solicitados.
     * @return a página de autores correspondente.
     */
    @GetMapping
    public ResponseEntity<PageResponse<AuthorResponse>> findAll(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok().body(authorService.findAll(pageable));
    }

    /**
     * Busca um autor pelo seu id.
     *
     * @param id identificador do autor.
     * @return o autor correspondente.
     */
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(authorService.findById(id));
    }

    /**
     * Cadastra um novo autor no acervo (RF10, RN08).
     *
     * @param request dados do autor a ser cadastrado.
     * @return o autor criado, com status HTTP 201 Created.
     */
    @PostMapping
    public ResponseEntity<AuthorResponse> create(@Valid @RequestBody AuthorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.create(request));
    }

    /**
     * Edita os dados de um autor existente (RF11, RN08).
     *
     * @param id      identificador do autor a ser editado.
     * @param request novos dados do autor.
     * @return o autor atualizado, com status HTTP 200 OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody AuthorRequest request
    ) {
        return ResponseEntity.ok().body(authorService.update(id, request));
    }

    /**
     * Exclui um autor do acervo (RF12, RN05, RN08).
     *
     * @param id identificador do autor a ser excluído.
     * @return resposta vazia com status HTTP 204 No Content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}