package com.matusalenalves.library.controller;

import com.matusalenalves.library.dto.request.BookRequest;
import com.matusalenalves.library.dto.response.BookResponse;
import com.matusalenalves.library.dto.response.PageResponse;
import com.matusalenalves.library.services.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Endpoints REST para consulta e gerenciamento do acervo de livros (RF04-RF09).
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Consulta o acervo combinando filtros opcionais de título, autor e categoria, paginados (RF07, RF09, RNF12).
     *
     * @param title      trecho do título a ser buscado, ou null para não filtrar.
     * @param authorId   identificador do autor, ou null para não filtrar.
     * @param categoryId identificador da categoria, ou null para não filtrar.
     * @param pageable   página, tamanho e ordenação solicitados.
     * @return a página de livros correspondente.
     */
    @GetMapping
    public ResponseEntity<PageResponse<BookResponse>> search(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Long authorId,
            @RequestParam(required = false) Long categoryId,
            @PageableDefault(size = 20) Pageable pageable
    ) {
        return ResponseEntity.ok(bookService.search(title, authorId, categoryId, pageable));
    }

    /**
     * Busca um livro pelo seu id (RF08).
     *
     * @param id identificador do livro.
     * @return o livro correspondente.
     */
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    /**
     * Cadastra um novo livro no acervo (RF04, RN08, RN11).
     *
     * @param request dados do livro a ser cadastrado.
     * @return o livro criado, com status HTTP 201 Created.
     */
    @PostMapping
    public ResponseEntity<BookResponse> create(@Valid @RequestBody BookRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(request));
    }

    /**
     * Edita os dados de um livro existente (RF05, RN08, RN11).
     *
     * @param id      identificador do livro a ser editado.
     * @param request novos dados do livro.
     * @return o livro atualizado, com status HTTP 200 OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody BookRequest request
    ) {
        return ResponseEntity.ok(bookService.update(id, request));
    }

    /**
     * Exclui um livro do acervo (RF06, RN08, RN10).
     *
     * @param id identificador do livro a ser excluído
     * @return resposta vazia com status HTTP 204 No Content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}