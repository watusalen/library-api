package com.matusalenalves.library.services;

import com.matusalenalves.library.dto.request.BookRequest;
import com.matusalenalves.library.dto.response.BookResponse;
import com.matusalenalves.library.dto.response.PageResponse;
import com.matusalenalves.library.entities.Author;
import com.matusalenalves.library.entities.Book;
import com.matusalenalves.library.entities.Category;
import com.matusalenalves.library.repositories.AuthorRepository;
import com.matusalenalves.library.repositories.BookRepository;
import com.matusalenalves.library.repositories.CategoryRepository;
import com.matusalenalves.library.repositories.LoanRepository;
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
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private BookService bookService;

    private Author author;
    private Category category;
    private Book book;

    @BeforeEach
    void setUp() {
        author = new Author(1L, "Dom Casmurro Author");
        category = new Category(1L, "Romance");
        book = new Book(1L, "Dom Casmurro", "9788535902777", 1899, 5, author);
        book.getCategories().add(category);
    }

    @Test
    @DisplayName("search deve retornar pagina de livros quando bem sucedido")
    void search_ShouldReturnPageOfBooks() {
        Pageable pageable = PageRequest.of(0, 20);
        when(bookRepository.search(eq("Dom"), eq(1L), eq(1L), eq(pageable)))
                .thenReturn(new PageImpl<>(List.of(book)));

        PageResponse<BookResponse> response = bookService.search("Dom", 1L, 1L, pageable);

        assertThat(response).isNotNull();
        assertThat(response.content()).hasSize(1);
        assertThat(response.content().getFirst().title()).isEqualTo("Dom Casmurro");
    }

    @Test
    @DisplayName("findById deve retornar livro existente")
    void findById_ShouldReturnBook_WhenIdExists() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        BookResponse response = bookService.findById(1L);

        assertThat(response).isNotNull();
        assertThat(response.id()).isEqualTo(1L);
        assertThat(response.title()).isEqualTo("Dom Casmurro");
    }

    @Test
    @DisplayName("delete deve lançar BusinessRuleException quando houver emprestimo ativo")
    void delete_ShouldThrowBusinessRuleException_WhenActiveLoansExist() {
        when(bookRepository.existsById(1L)).thenReturn(true);
        when(loanRepository.existsByBookIdAndStatus(eq(1L), any())).thenReturn(true);

        assertThatThrownBy(() -> bookService.delete(1L))
                .isInstanceOf(BusinessRuleException.class);

        verify(bookRepository, never()).deleteById(1L);
    }
}