package com.matusalenalves.library.config;

import com.matusalenalves.library.config.BookSeedData.BookSeed;
import com.matusalenalves.library.entities.Author;
import com.matusalenalves.library.entities.Book;
import com.matusalenalves.library.entities.Category;
import com.matusalenalves.library.entities.Loan;
import com.matusalenalves.library.entities.User;
import com.matusalenalves.library.entities.enums.LoanStatus;
import com.matusalenalves.library.entities.enums.Role;
import com.matusalenalves.library.repositories.AuthorRepository;
import com.matusalenalves.library.repositories.BookRepository;
import com.matusalenalves.library.repositories.CategoryRepository;
import com.matusalenalves.library.repositories.LoanRepository;
import com.matusalenalves.library.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Popula o banco com dados de exemplo em volume ao iniciar a aplicação,
 * útil apenas em ambiente de desenvolvimento local. Não deve rodar em
 * produção.
 * <p>
 * Cada método {@code seedX} só roda se a tabela correspondente estiver
 * vazia, evitando o erro de chave duplicada ao reiniciar a aplicação sobre
 * um banco já semeado.
 */
@Configuration
@Profile("!prod")
public class DataSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataSeeder.class);

    /**
     * Senha em texto plano compartilhada por todos os usuários gerados;
     * persistida com hash BCrypt (RNF05). Use este valor para autenticar
     * via {@code POST /auth/login} com qualquer um dos e-mails gerados.
     */
    private static final String SEED_PASSWORD = "senha123";

    private static final int TOTAL_USERS = 50;
    private static final int ADMIN_COUNT = 5;

    private static final String[] FIRST_NAMES = {
            "Ana", "Bruno", "Carla", "Diego", "Elisa", "Fabio", "Gabriela", "Hugo",
            "Isabela", "Joao", "Karina", "Lucas", "Mariana", "Nicolas", "Olivia",
            "Pedro", "Queila", "Rafael", "Sofia", "Thiago", "Ursula", "Vinicius",
            "Wesley", "Yasmin", "Zoe"
    };

    private static final String[] LAST_NAMES = {
            "Silva", "Souza", "Oliveira", "Santos", "Pereira", "Costa", "Rodrigues",
            "Almeida", "Nascimento", "Lima", "Araujo", "Fernandes", "Carvalho",
            "Gomes", "Martins", "Rocha", "Ribeiro", "Alves", "Monteiro", "Cardoso"
    };

    /**
     * Autores de literatura brasileira, sociólogos e filósofos de qualquer
     * época, e nomes associados a contos, histórias e poemas famosos de
     * qualquer lugar.
     */
    private static final String[] AUTHOR_NAMES = {
            // Literatura brasileira
            "Machado de Assis", "Clarice Lispector", "Jorge Amado", "Guimarães Rosa",
            "Carlos Drummond de Andrade", "Cecília Meireles", "Manuel Bandeira",
            "José de Alencar", "Euclides da Cunha", "Graciliano Ramos",
            "Rachel de Queiroz", "Lima Barreto", "Aluísio Azevedo", "Raul Pompeia",
            "Castro Alves", "Cora Coralina", "Adélia Prado", "Paulo Leminski",
            "Milton Hatoum", "Érico Veríssimo", "Mário de Andrade", "Oswald de Andrade",
            "Vinicius de Moraes", "Ferreira Gullar", "Ariano Suassuna", "Nélida Piñon",
            "Dalton Trevisan", "Rubem Fonseca", "João Cabral de Melo Neto",
            "Olavo Bilac", "Gonçalves Dias", "Augusto dos Anjos", "Monteiro Lobato",
            "Lygia Fagundes Telles",

            // Sociólogos
            "Émile Durkheim", "Max Weber", "Karl Marx", "Auguste Comte",
            "Pierre Bourdieu", "Zygmunt Bauman", "Gilberto Freyre",
            "Florestan Fernandes", "Darcy Ribeiro", "Anthony Giddens",
            "Erving Goffman", "Georg Simmel",

            // Filósofos de qualquer época
            "Sócrates", "Platão", "Aristóteles", "René Descartes", "Immanuel Kant",
            "Friedrich Nietzsche", "Jean-Paul Sartre", "Simone de Beauvoir",
            "Michel Foucault", "Hannah Arendt", "Baruch Spinoza", "David Hume",
            "Confúcio", "Søren Kierkegaard", "Georg Wilhelm Friedrich Hegel",
            "John Locke", "Thomas Hobbes", "Jean-Jacques Rousseau",
            "Arthur Schopenhauer", "Martin Heidegger", "Ludwig Wittgenstein",
            "Voltaire", "Nicolau Maquiavel", "Epicuro", "Sêneca",

            // Contos, histórias e poemas famosos de qualquer lugar
            "Edgar Allan Poe", "Anton Tchekhov", "Franz Kafka", "Jorge Luis Borges",
            "Gabriel García Márquez", "Guy de Maupassant", "O. Henry",
            "Pablo Neruda", "Fernando Pessoa", "Charles Baudelaire", "Walt Whitman",
            "Emily Dickinson", "Hans Christian Andersen", "Ernest Hemingway",
            "Julio Cortázar", "Rudyard Kipling", "Nikolai Gogol",
            "Rainer Maria Rilke", "William Blake", "Arthur Rimbaud",
            "Charles Perrault", "Jacob Grimm", "Wilhelm Grimm", "Homero",
            "Dante Alighieri"
    };

    /**
     * Categorias no padrão de classificação de uma biblioteca: mistura
     * nacionalidade/idioma (Literatura Brasileira/Estrangeira) com gênero
     * literário (Romance, Contos, Poesia) e área de conhecimento (Filosofia,
     * Sociologia), além de "Clássicos" para obras de relevância histórica —
     * o mesmo tipo de combinação usada, por exemplo, no sistema de
     * Classificação Decimal de Dewey (100 Filosofia, 300 Ciências Sociais,
     * 800 Literatura subdividida por forma).
     */
    private static final String[] CATEGORY_NAMES = {
            "Literatura Brasileira", "Literatura Estrangeira", "Romance", "Contos",
            "Poesia", "Filosofia", "Sociologia", "Clássicos"
    };

    private static final int TOTAL_LOANS = 150;
    private static final int RETURNED_LOANS = 90;
    private static final int OVERDUE_LOANS = 15;
    // os (TOTAL_LOANS - RETURNED_LOANS - OVERDUE_LOANS) restantes ficam ACTIVE em dia

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;

    public DataSeeder(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            AuthorRepository authorRepository,
            CategoryRepository categoryRepository,
            BookRepository bookRepository,
            LoanRepository loanRepository
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
    }

    @Override
    public void run(String... args) {
        seedUsers();
        seedAuthors();
        seedCategories();
        seedBooks();
        seedLoans();
    }

    private void seedUsers() {
        if (userRepository.count() > 0) {
            return;
        }

        String hashedPassword = passwordEncoder.encode(SEED_PASSWORD);
        List<User> users = new ArrayList<>();

        for (int i = 1; i <= TOTAL_USERS; i++) {
            String firstName = FIRST_NAMES[(i - 1) % FIRST_NAMES.length];
            String lastName = LAST_NAMES[(i - 1) % LAST_NAMES.length];
            String fullName = firstName + " " + lastName;
            String email = (firstName + "." + lastName + i).toLowerCase() + "@gmail.com";
            Role role = i <= ADMIN_COUNT ? Role.ADMIN : Role.CLIENT;

            users.add(new User(null, fullName, email, hashedPassword, role));
        }

        userRepository.saveAll(users);

        log.info("Seeded {} users ({} ADMIN, {} CLIENT). Shared password for login: {}",
                TOTAL_USERS, ADMIN_COUNT, TOTAL_USERS - ADMIN_COUNT, SEED_PASSWORD);
    }

    private void seedAuthors() {
        if (authorRepository.count() > 0) {
            return;
        }

        List<Author> authors = Arrays.stream(AUTHOR_NAMES)
                .map(name -> new Author(null, name))
                .toList();

        authorRepository.saveAll(authors);

        log.info("Seeded {} authors.", authors.size());
    }

    private void seedCategories() {
        if (categoryRepository.count() > 0) {
            return;
        }

        List<Category> categories = Arrays.stream(CATEGORY_NAMES)
                .map(name -> new Category(null, name))
                .toList();

        categoryRepository.saveAll(categories);

        log.info("Seeded {} categories.", categories.size());
    }

    /**
     * Cria os livros a partir de {@link BookSeedData#ALL}, vinculando cada
     * um ao {@link Author} e às {@link Category categorias} correspondentes
     * pelo nome. O ISBN é gerado de forma sintética (prefixo {@code 978} +
     * sequencial), suficiente para garantir unicidade em dados de
     * desenvolvimento — não corresponde a um ISBN real registrado.
     */
    private void seedBooks() {
        if (bookRepository.count() > 0) {
            return;
        }

        Map<String, Author> authorsByName = authorRepository.findAll().stream()
                .collect(Collectors.toMap(Author::getName, author -> author));
        Map<String, Category> categoriesByName = categoryRepository.findAll().stream()
                .collect(Collectors.toMap(Category::getName, category -> category));

        Random random = new Random();
        List<Book> books = new ArrayList<>();
        int isbnSequence = 1;

        for (BookSeed seed : BookSeedData.ALL) {
            Author author = authorsByName.get(seed.authorName());
            if (author == null) {
                log.warn("Skipping book '{}': unknown author '{}'.", seed.title(), seed.authorName());
                continue;
            }

            String isbn = "978" + String.format("%010d", isbnSequence++);
            int totalCopies = 1 + random.nextInt(6);

            Book book = new Book(null, seed.title(), isbn, seed.year(), totalCopies, author);

            Set<Category> categories = Arrays.stream(seed.categoryNames().split(","))
                    .map(categoriesByName::get)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toCollection(HashSet::new));
            book.setCategories(categories);

            books.add(book);
        }

        bookRepository.saveAll(books);

        log.info("Seeded {} books.", books.size());
    }

    /**
     * Cria empréstimos associando clientes ({@link Role#CLIENT}) a livros
     * disponíveis, cobrindo os três status de {@code LoanStatus}: a maioria
     * {@code RETURNED} (ciclo completo já concluído), uma parte {@code
     * ACTIVE} em atraso (data de empréstimo/prazo adiantadas manualmente,
     * para exercitar RF25/RN03) e o restante {@code ACTIVE} em dia.
     */
    private void seedLoans() {
        if (loanRepository.count() > 0) {
            return;
        }

        List<User> clients = userRepository.findAll().stream()
                .filter(user -> user.getRole() == Role.CLIENT)
                .toList();
        List<Book> books = bookRepository.findAll();

        Random random = new Random();
        List<Loan> loans = new ArrayList<>();
        Set<Book> touchedBooks = new HashSet<>();

        for (int i = 0; i < TOTAL_LOANS; i++) {
            Book book = pickAvailableBook(books, random);
            if (book == null) {
                log.warn("Stopped seeding loans early at {}/{}: no book with available copies left.", i, TOTAL_LOANS);
                break;
            }

            User client = clients.get(random.nextInt(clients.size()));
            Loan loan = new Loan(null, book, client);
            book.decreaseAvailableCopies();
            touchedBooks.add(book);

            if (i < RETURNED_LOANS) {
                loan.markAsReturned();
                book.increaseAvailableCopies();
            } else if (i < RETURNED_LOANS + OVERDUE_LOANS) {
                loan.setLoanDate(LocalDateTime.now().minusDays(30));
                loan.setDueDate(LocalDate.now().minusDays(16));
            }

            loans.add(loan);
        }

        loanRepository.saveAll(loans);
        bookRepository.saveAll(touchedBooks);

        long returned = loans.stream().filter(loan -> loan.getStatus() == LoanStatus.RETURNED).count();
        long overdue = loans.stream().filter(Loan::isOverdue).count();
        log.info("Seeded {} loans ({} RETURNED, {} ACTIVE overdue, {} ACTIVE on time).",
                loans.size(), returned, overdue, loans.size() - returned - overdue);
    }

    private Book pickAvailableBook(List<Book> books, Random random) {
        int startIndex = random.nextInt(books.size());
        for (int offset = 0; offset < books.size(); offset++) {
            Book candidate = books.get((startIndex + offset) % books.size());
            if (candidate.isAvailable()) {
                return candidate;
            }
        }
        return null;
    }
}
