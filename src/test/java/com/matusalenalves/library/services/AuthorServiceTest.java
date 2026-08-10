package com.matusalenalves.library.services;

import com.matusalenalves.library.dto.request.AuthorRequest;
import com.matusalenalves.library.dto.response.AuthorResponse;
import com.matusalenalves.library.dto.response.PageResponse;
import com.matusalenalves.library.entities.Author;
import com.matusalenalves.library.repositories.AuthorRepository;
import com.matusalenalves.library.repositories.BookRepository;
import com.matusalenalves.library.services.exceptions.BusinessRuleException;
import com.matusalenalves.library.services.exceptions.ResourceNotFoundException;
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
class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private AuthorService authorService;

    private Author author;

    @BeforeEach
    void setUp() {
        author = new Author(1L, "Machado de Assis");
    }

    @Test
    @DisplayName("findAll deve retornar pagina de autores quando bem sucedido")
    void findAll_ShouldReturnPageOfAuthors() {
        Pageable pageable = PageRequest.of(0, 20);
        when(authorRepository.findAll(pageable)).thenReturn(new PageImpl<>(List.of(author)));

        PageResponse<AuthorResponse> response = authorService.findAll(pageable);

        assertThat(response).isNotNull();
        assertThat(response.content()).hasSize(1);
        assertThat(response.content().get(0).name()).isEqualTo("Machado de Assis");
        verify(authorRepository).findAll(pageable);
    }

    @Test
    @DisplayName("findById deve retornar autor quando id existir")
    void findById_ShouldReturnAuthor_WhenIdExists() {
        when(authorRepository.findById(1L)).thenReturn(Optional.of(author));

        AuthorResponse response = authorService.findById(1L);

        assertThat(response).isNotNull();
        assertThat(response.id()).isEqualTo(1L);
        assertThat(response.name()).isEqualTo("Machado de Assis");
        verify(authorRepository).findById(1L);
    }

    @Test
    @DisplayName("findById deve lancar ResourceNotFoundException quando id nao existir")
    void findById_ShouldThrowResourceNotFoundException_WhenIdDoesNotExist() {
        when(authorRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> authorService.findById(99L))
                .isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    @DisplayName("create deve salvar e retornar autor")
    void create_ShouldSaveAndReturnAuthor() {
        AuthorRequest request = new AuthorRequest("Clarice Lispector");
        Author savedAuthor = new Author(2L, "Clarice Lispector");

        when(authorRepository.save(any(Author.class))).thenReturn(savedAuthor);

        AuthorResponse response = authorService.create(request);

        assertThat(response).isNotNull();
        assertThat(response.id()).isEqualTo(2L);
        assertThat(response.name()).isEqualTo("Clarice Lispector");
        verify(authorRepository).save(any(Author.class));
    }

    @Test
    @DisplayName("delete deve remover autor quando nao houver livros vinculados")
    void delete_ShouldRemoveAuthor_WhenNoBooksLinked() {
        when(authorRepository.existsById(1L)).thenReturn(true);
        when(bookRepository.existsByAuthorId(1L)).thenReturn(false);

        authorService.delete(1L);

        verify(authorRepository).deleteById(1L);
    }

    @Test
    @DisplayName("delete deve lancar BusinessRuleException quando houver livros vinculados")
    void delete_ShouldThrowBusinessRuleException_WhenBooksLinked() {
        when(authorRepository.existsById(1L)).thenReturn(true);
        when(bookRepository.existsByAuthorId(1L)).thenReturn(true);

        assertThatThrownBy(() -> authorService.delete(1L))
                .isInstanceOf(BusinessRuleException.class);

        verify(authorRepository, never()).deleteById(1L);
    }
}
