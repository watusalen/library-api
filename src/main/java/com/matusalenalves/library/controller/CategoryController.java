package com.matusalenalves.library.controller;

import com.matusalenalves.library.dto.request.CategoryRequest;
import com.matusalenalves.library.dto.response.CategoryResponse;
import com.matusalenalves.library.dto.response.PageResponse;
import com.matusalenalves.library.services.CategoryService;
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
 * Endpoints REST para consulta e gerenciamento de categorias (RF14-RF17).
 */
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Consulta a lista de categorias cadastradas, paginada (RF17, RNF12).
     *
     * @param pageable página, tamanho e ordenação solicitados.
     * @return a página de categorias correspondente.
     */
    @GetMapping
    public ResponseEntity<PageResponse<CategoryResponse>> findAll(@PageableDefault(size = 20) Pageable pageable) {
        return ResponseEntity.ok().body(categoryService.findAll(pageable));
    }

    /**
     * Busca uma categoria pelo seu id.
     *
     * @param id identificador da categoria.
     * @return a categoria correspondente.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoryService.findById(id));
    }

    /**
     * Cadastra uma nova categoria no acervo (RF14, RN08).
     *
     * @param request dados da categoria a ser cadastrada.
     * @return a categoria criada, com status HTTP 201 Created.
     */
    @PostMapping
    public ResponseEntity<CategoryResponse> create(@Valid @RequestBody CategoryRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(request));
    }

    /**
     * Edita os dados de uma categoria existente (RF15, RN08).
     *
     * @param id      identificador da categoria a ser editada.
     * @param request novos dados da categoria.
     * @return a categoria atualizada, com status HTTP 200 OK.
     */
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequest request
    ) {
        return ResponseEntity.ok().body(categoryService.update(id, request));
    }

    /**
     * Exclui uma categoria do acervo (RF16, RN06, RN08).
     *
     * @param id identificador da categoria a ser excluída.
     * @return resposta vazia com status HTTP 204 No Content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}