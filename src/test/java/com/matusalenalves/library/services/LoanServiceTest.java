package com.matusalenalves.library.services;

import com.matusalenalves.library.dto.request.LoanRequest;
import com.matusalenalves.library.dto.response.LoanResponse;
import com.matusalenalves.library.entities.Author;
import com.matusalenalves.library.entities.Book;
import com.matusalenalves.library.entities.Category;
import com.matusalenalves.library.entities.Loan;
import com.matusalenalves.library.entities.User;
import com.matusalenalves.library.entities.enums.Role;
import com.matusalenalves.library.repositories.BookRepository;
import com.matusalenalves.library.repositories.LoanRepository;
import com.matusalenalves.library.repositories.UserRepository;
import com.matusalenalves.library.services.exceptions.BusinessRuleException;
import com.matusalenalves.library.services.exceptions.LoanAccessDeniedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private LoanService loanService;

    private User user;
    private Book book;
    private Loan loan;

    @BeforeEach
    void setUp() {
        user = new User(1L, "João Silva", "joao@email.com", "senha123", Role.CLIENT);
        Author author = new Author(1L, "Autor Teste");
        Category category = new Category(1L, "Categoria Teste");
        book = new Book(1L, "Livro Teste", "9788535902777", 2020, 3, author);
        book.getCategories().add(category);
        loan = new Loan(1L, book, user);
    }

    @Test
    @DisplayName("create deve registrar empréstimo quando livro disponível e cliente sem atrasos")
    void create_ShouldRegisterLoan_WhenBookAvailableAndNoOverdueLoans() {
        LoanRequest request = new LoanRequest(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(loanRepository.findByUserIdAndStatus(eq(1L), any())).thenReturn(Collections.emptyList());
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);

        LoanResponse response = loanService.create(1L, request);

        assertThat(response).isNotNull();
        verify(bookRepository).save(book);
        verify(loanRepository).save(any(Loan.class));
    }

    @Test
    @DisplayName("create deve lançar BusinessRuleException quando livro sem exemplares")
    void create_ShouldThrowBusinessRuleException_WhenBookNotAvailable() {
        book.setAvailableCopies(0);
        LoanRequest request = new LoanRequest(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        assertThatThrownBy(() -> loanService.create(1L, request))
                .isInstanceOf(BusinessRuleException.class);

        verify(loanRepository, never()).save(any());
    }

    @Test
    @DisplayName("returnLoan deve lançar LoanAccessDeniedException se usuário não for dono nem admin")
    void returnLoan_ShouldThrowLoanAccessDeniedException_WhenUserNotOwnerNorAdmin() {
        when(loanRepository.findById(1L)).thenReturn(Optional.of(loan));

        assertThatThrownBy(() -> loanService.returnLoan(1L, 99L, false))
                .isInstanceOf(LoanAccessDeniedException.class);
    }
}