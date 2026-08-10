package com.matusalenalves.library.services;

import com.matusalenalves.library.dto.request.CategoryRequest;
import com.matusalenalves.library.dto.response.CategoryResponse;
import com.matusalenalves.library.dto.response.PageResponse;
import com.matusalenalves.library.entities.Category;
import com.matusalenalves.library.repositories.BookRepository;
import com.matusalenalves.library.repositories.CategoryRepository;
import com.matusalenalves.library.services.exceptions.BusinessRuleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private CategoryService categoryService;

    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category(1L, "Romance");
    }

    @Test
    @DisplayName("findAll deve retornar pagina de categorias")
    void findAll_ShouldReturnPageOfCategories() {
        Pageable pageable = PageRequest.of(0, 20);
        when(categoryRepository.findAll(pageable)).thenReturn(new PageImpl<>(List.of(category)));

        PageResponse<CategoryResponse> response = categoryService.findAll(pageable);

        assertThat(response).isNotNull();
        assertThat(response.content()).hasSize(1);
        assertThat(response.content().get(0).name()).isEqualTo("Romance");
        verify(categoryRepository).findAll(pageable);
    }

    @Test
    @DisplayName("findById deve retornar categoria existente")
    void findById_ShouldReturnCategory_WhenIdExists() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        CategoryResponse response = categoryService.findById(1L);

        assertThat(response).isNotNull();
        assertThat(response.id()).isEqualTo(1L);
        assertThat(response.name()).isEqualTo("Romance");
    }

    @Test
    @DisplayName("create deve criar nova categoria")
    void create_ShouldCreateCategory() {
        CategoryRequest request = new CategoryRequest("Ficção Científica");
        Category savedCategory = new Category(2L, "Ficção Científica");

        when(categoryRepository.save(any(Category.class))).thenReturn(savedCategory);

        CategoryResponse response = categoryService.create(request);

        assertThat(response).isNotNull();
        assertThat(response.name()).isEqualTo("Ficção Científica");
    }

    @Test
    @DisplayName("delete deve lancar BusinessRuleException se houver livros vinculados")
    void delete_ShouldThrowBusinessRuleException_WhenBooksLinked() {
        when(categoryRepository.existsById(1L)).thenReturn(true);
        when(bookRepository.existsByCategoriesId(1L)).thenReturn(true);

        assertThatThrownBy(() -> categoryService.delete(1L))
                .isInstanceOf(BusinessRuleException.class);

        verify(categoryRepository, never()).deleteById(1L);
    }
}
