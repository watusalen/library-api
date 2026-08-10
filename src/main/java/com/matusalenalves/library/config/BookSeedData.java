package com.matusalenalves.library.config;

import java.util.List;

/**
 * Dados brutos usados por {@link DataSeeder} para popular o acervo de
 * livros: título, ano de publicação original e categorias, associados ao
 * nome de um dos autores de {@link DataSeeder#AUTHOR_NAMES}.
 * <p>
 * Para autores cuja obra não se divide naturalmente em 5 livros distintos
 * (ex.: filósofos antigos transmitidos por discípulos, poetas com uma única
 * obra maior), os títulos usam o formato de compilação/coletânea
 * consagrado nas bibliotecas para esses casos (ex.: "Obra Poética
 * Completa", "Ditos e Máximas"), em vez de inventar títulos que nunca
 * existiram.
 * <p>
 * Mantido em um arquivo separado de {@link DataSeeder} apenas para não
 * afogar a lógica de seed em ~480 linhas de dados.
 */
final class BookSeedData {

    /**
     * @param authorName    deve corresponder exatamente a um nome em
     *                      {@link DataSeeder#AUTHOR_NAMES}
     * @param title         título do livro
     * @param year          ano de publicação original (negativo para a.C.)
     * @param categoryNames categorias separadas por vírgula, cada uma
     *                      correspondente a um nome em
     *                      {@link DataSeeder#CATEGORY_NAMES}
     */
    record BookSeed(String authorName, String title, int year, String categoryNames) {
    }

    private BookSeedData() {
    }

    static final List<BookSeed> ALL = List.of(
            // ---- Literatura brasileira ----
            new BookSeed("Machado de Assis", "Dom Casmurro", 1899, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Machado de Assis", "Memórias Póstumas de Brás Cubas", 1881, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Machado de Assis", "Quincas Borba", 1891, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Machado de Assis", "O Alienista", 1882, "Literatura Brasileira,Contos,Clássicos"),
            new BookSeed("Machado de Assis", "Helena", 1876, "Literatura Brasileira,Romance,Clássicos"),

            new BookSeed("Clarice Lispector", "A Hora da Estrela", 1977, "Literatura Brasileira,Romance"),
            new BookSeed("Clarice Lispector", "Perto do Coração Selvagem", 1943, "Literatura Brasileira,Romance"),
            new BookSeed("Clarice Lispector", "A Paixão Segundo G.H.", 1964, "Literatura Brasileira,Romance"),
            new BookSeed("Clarice Lispector", "Laços de Família", 1960, "Literatura Brasileira,Contos"),
            new BookSeed("Clarice Lispector", "Água Viva", 1973, "Literatura Brasileira,Romance"),

            new BookSeed("Jorge Amado", "Gabriela, Cravo e Canela", 1958, "Literatura Brasileira,Romance"),
            new BookSeed("Jorge Amado", "Dona Flor e Seus Dois Maridos", 1966, "Literatura Brasileira,Romance"),
            new BookSeed("Jorge Amado", "Capitães da Areia", 1937, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Jorge Amado", "Tieta do Agreste", 1977, "Literatura Brasileira,Romance"),
            new BookSeed("Jorge Amado", "Tenda dos Milagres", 1969, "Literatura Brasileira,Romance"),

            new BookSeed("Guimarães Rosa", "Grande Sertão: Veredas", 1956, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Guimarães Rosa", "Sagarana", 1946, "Literatura Brasileira,Contos,Clássicos"),
            new BookSeed("Guimarães Rosa", "Primeiras Estórias", 1962, "Literatura Brasileira,Contos"),
            new BookSeed("Guimarães Rosa", "Corpo de Baile", 1956, "Literatura Brasileira,Contos"),
            new BookSeed("Guimarães Rosa", "Tutameia", 1967, "Literatura Brasileira,Contos"),

            new BookSeed("Carlos Drummond de Andrade", "Alguma Poesia", 1930, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Carlos Drummond de Andrade", "Sentimento do Mundo", 1940, "Literatura Brasileira,Poesia"),
            new BookSeed("Carlos Drummond de Andrade", "A Rosa do Povo", 1945, "Literatura Brasileira,Poesia"),
            new BookSeed("Carlos Drummond de Andrade", "Claro Enigma", 1951, "Literatura Brasileira,Poesia"),
            new BookSeed("Carlos Drummond de Andrade", "José", 1942, "Literatura Brasileira,Poesia"),

            new BookSeed("Cecília Meireles", "Romanceiro da Inconfidência", 1953, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Cecília Meireles", "Viagem", 1939, "Literatura Brasileira,Poesia"),
            new BookSeed("Cecília Meireles", "Vaga Música", 1942, "Literatura Brasileira,Poesia"),
            new BookSeed("Cecília Meireles", "Mar Absoluto", 1945, "Literatura Brasileira,Poesia"),
            new BookSeed("Cecília Meireles", "Flor de Poemas", 1972, "Literatura Brasileira,Poesia"),

            new BookSeed("Manuel Bandeira", "Libertinagem", 1930, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Manuel Bandeira", "Estrela da Manhã", 1936, "Literatura Brasileira,Poesia"),
            new BookSeed("Manuel Bandeira", "Lira dos Cinquent'anos", 1940, "Literatura Brasileira,Poesia"),
            new BookSeed("Manuel Bandeira", "A Cinza das Horas", 1917, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Manuel Bandeira", "Belo Belo", 1948, "Literatura Brasileira,Poesia"),

            new BookSeed("José de Alencar", "Iracema", 1865, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("José de Alencar", "O Guarani", 1857, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("José de Alencar", "Senhora", 1875, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("José de Alencar", "Lucíola", 1862, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("José de Alencar", "Til", 1872, "Literatura Brasileira,Romance,Clássicos"),

            new BookSeed("Euclides da Cunha", "Os Sertões", 1902, "Literatura Brasileira,Clássicos"),
            new BookSeed("Euclides da Cunha", "À Margem da História", 1909, "Literatura Brasileira"),
            new BookSeed("Euclides da Cunha", "Peru Versus Bolívia", 1907, "Literatura Brasileira"),
            new BookSeed("Euclides da Cunha", "Contrastes e Confrontos", 1907, "Literatura Brasileira"),
            new BookSeed("Euclides da Cunha", "Canudos - Diário de uma Expedição", 1939, "Literatura Brasileira"),

            new BookSeed("Graciliano Ramos", "Vidas Secas", 1938, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Graciliano Ramos", "São Bernardo", 1934, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Graciliano Ramos", "Angústia", 1936, "Literatura Brasileira,Romance"),
            new BookSeed("Graciliano Ramos", "Infância", 1945, "Literatura Brasileira,Romance"),
            new BookSeed("Graciliano Ramos", "Memórias do Cárcere", 1953, "Literatura Brasileira,Romance"),

            new BookSeed("Rachel de Queiroz", "O Quinze", 1930, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Rachel de Queiroz", "As Três Marias", 1939, "Literatura Brasileira,Romance"),
            new BookSeed("Rachel de Queiroz", "Memorial de Maria Moura", 1992, "Literatura Brasileira,Romance"),
            new BookSeed("Rachel de Queiroz", "Dôra, Doralina", 1975, "Literatura Brasileira,Romance"),
            new BookSeed("Rachel de Queiroz", "O Galo de Ouro", 1950, "Literatura Brasileira,Romance"),

            new BookSeed("Lima Barreto", "Triste Fim de Policarpo Quaresma", 1911, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Lima Barreto", "Recordações do Escrivão Isaías Caminha", 1909, "Literatura Brasileira,Romance"),
            new BookSeed("Lima Barreto", "Clara dos Anjos", 1948, "Literatura Brasileira,Romance"),
            new BookSeed("Lima Barreto", "Os Bruzundangas", 1922, "Literatura Brasileira,Contos"),
            new BookSeed("Lima Barreto", "Diário Íntimo", 1953, "Literatura Brasileira"),

            new BookSeed("Aluísio Azevedo", "O Cortiço", 1890, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Aluísio Azevedo", "Casa de Pensão", 1884, "Literatura Brasileira,Romance"),
            new BookSeed("Aluísio Azevedo", "O Mulato", 1881, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Aluísio Azevedo", "O Coruja", 1890, "Literatura Brasileira,Romance"),
            new BookSeed("Aluísio Azevedo", "Uma Lágrima de Mulher", 1879, "Literatura Brasileira,Romance"),

            new BookSeed("Raul Pompeia", "O Ateneu", 1888, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Raul Pompeia", "Canções sem Metro", 1900, "Literatura Brasileira,Poesia"),
            new BookSeed("Raul Pompeia", "As Jóias da Coroa", 1882, "Literatura Brasileira,Contos"),
            new BookSeed("Raul Pompeia", "Microscópicos", 1881, "Literatura Brasileira,Contos"),
            new BookSeed("Raul Pompeia", "Uma Tragédia no Amazonas", 1880, "Literatura Brasileira,Contos"),

            new BookSeed("Castro Alves", "Espumas Flutuantes", 1870, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Castro Alves", "Os Escravos", 1883, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Castro Alves", "Gonzaga ou a Revolução de Minas", 1875, "Literatura Brasileira,Poesia"),
            new BookSeed("Castro Alves", "Vozes d'África", 1868, "Literatura Brasileira,Poesia"),
            new BookSeed("Castro Alves", "A Cachoeira de Paulo Afonso", 1876, "Literatura Brasileira,Poesia"),

            new BookSeed("Cora Coralina", "Poemas dos Becos de Goiás", 1965, "Literatura Brasileira,Poesia"),
            new BookSeed("Cora Coralina", "Vintém de Cobre", 1983, "Literatura Brasileira,Poesia"),
            new BookSeed("Cora Coralina", "O Estranho Destino de Ramona", 1985, "Literatura Brasileira,Contos"),
            new BookSeed("Cora Coralina", "Meu Livro de Cordel", 1976, "Literatura Brasileira,Poesia"),
            new BookSeed("Cora Coralina", "Villa Boa de Goyaz", 1980, "Literatura Brasileira,Poesia"),

            new BookSeed("Adélia Prado", "Bagagem", 1976, "Literatura Brasileira,Poesia"),
            new BookSeed("Adélia Prado", "O Coração Disparado", 1978, "Literatura Brasileira,Poesia"),
            new BookSeed("Adélia Prado", "Terra de Santa Cruz", 1981, "Literatura Brasileira,Poesia"),
            new BookSeed("Adélia Prado", "O Pelicano", 1987, "Literatura Brasileira,Poesia"),
            new BookSeed("Adélia Prado", "Poesia Reunida", 1991, "Literatura Brasileira,Poesia"),

            new BookSeed("Paulo Leminski", "Catatau", 1975, "Literatura Brasileira,Romance"),
            new BookSeed("Paulo Leminski", "Distraídos Venceremos", 1987, "Literatura Brasileira,Poesia"),
            new BookSeed("Paulo Leminski", "Caprichos e Relaxos", 1983, "Literatura Brasileira,Poesia"),
            new BookSeed("Paulo Leminski", "La Vie en Close", 1991, "Literatura Brasileira,Poesia"),
            new BookSeed("Paulo Leminski", "Toda Poesia", 2013, "Literatura Brasileira,Poesia"),

            new BookSeed("Milton Hatoum", "Dois Irmãos", 2000, "Literatura Brasileira,Romance"),
            new BookSeed("Milton Hatoum", "Relato de um Certo Oriente", 1989, "Literatura Brasileira,Romance"),
            new BookSeed("Milton Hatoum", "Cinzas do Norte", 2005, "Literatura Brasileira,Romance"),
            new BookSeed("Milton Hatoum", "Órfãos do Eldorado", 2008, "Literatura Brasileira,Romance"),
            new BookSeed("Milton Hatoum", "A Noite da Espera", 2017, "Literatura Brasileira,Romance"),

            new BookSeed("Érico Veríssimo", "O Tempo e o Vento", 1949, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Érico Veríssimo", "Olhai os Lírios do Campo", 1938, "Literatura Brasileira,Romance"),
            new BookSeed("Érico Veríssimo", "Incidente em Antares", 1971, "Literatura Brasileira,Romance"),
            new BookSeed("Érico Veríssimo", "Clarissa", 1933, "Literatura Brasileira,Romance"),
            new BookSeed("Érico Veríssimo", "Um Lugar ao Sol", 1936, "Literatura Brasileira,Romance"),

            new BookSeed("Mário de Andrade", "Macunaíma", 1928, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Mário de Andrade", "Paulicéia Desvairada", 1922, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Mário de Andrade", "Amar, Verbo Intransitivo", 1927, "Literatura Brasileira,Romance"),
            new BookSeed("Mário de Andrade", "Contos Novos", 1947, "Literatura Brasileira,Contos"),
            new BookSeed("Mário de Andrade", "Café", 1955, "Literatura Brasileira,Poesia"),

            new BookSeed("Oswald de Andrade", "Memórias Sentimentais de João Miramar", 1924, "Literatura Brasileira,Romance,Clássicos"),
            new BookSeed("Oswald de Andrade", "Serafim Ponte Grande", 1933, "Literatura Brasileira,Romance"),
            new BookSeed("Oswald de Andrade", "Pau-Brasil", 1925, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Oswald de Andrade", "Manifesto Antropófago", 1928, "Literatura Brasileira,Clássicos"),
            new BookSeed("Oswald de Andrade", "Cadernos do Aluno de Poesia", 1927, "Literatura Brasileira,Poesia"),

            new BookSeed("Vinicius de Moraes", "Antologia Poética", 1954, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Vinicius de Moraes", "Livro de Sonetos", 1967, "Literatura Brasileira,Poesia"),
            new BookSeed("Vinicius de Moraes", "Para Viver um Grande Amor", 1962, "Literatura Brasileira,Poesia"),
            new BookSeed("Vinicius de Moraes", "Novos Poemas", 1959, "Literatura Brasileira,Poesia"),
            new BookSeed("Vinicius de Moraes", "O Operário em Construção", 1966, "Literatura Brasileira,Poesia"),

            new BookSeed("Ferreira Gullar", "Poema Sujo", 1976, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Ferreira Gullar", "A Luta Corporal", 1954, "Literatura Brasileira,Poesia"),
            new BookSeed("Ferreira Gullar", "Toda Poesia", 1980, "Literatura Brasileira,Poesia"),
            new BookSeed("Ferreira Gullar", "Dentro da Noite Veloz", 1975, "Literatura Brasileira,Poesia"),
            new BookSeed("Ferreira Gullar", "Muitas Vozes", 1999, "Literatura Brasileira,Poesia"),

            new BookSeed("Ariano Suassuna", "Auto da Compadecida", 1955, "Literatura Brasileira,Clássicos"),
            new BookSeed("Ariano Suassuna", "A Pedra do Reino", 1971, "Literatura Brasileira,Romance"),
            new BookSeed("Ariano Suassuna", "Farsa da Boa Preguiça", 1960, "Literatura Brasileira"),
            new BookSeed("Ariano Suassuna", "O Santo e a Porca", 1957, "Literatura Brasileira"),
            new BookSeed("Ariano Suassuna", "O Casamento Suspeitoso", 1957, "Literatura Brasileira"),

            new BookSeed("Nélida Piñon", "A República dos Sonhos", 1984, "Literatura Brasileira,Romance"),
            new BookSeed("Nélida Piñon", "A Casa da Paixão", 1972, "Literatura Brasileira,Romance"),
            new BookSeed("Nélida Piñon", "A Doce Canção de Caetana", 1987, "Literatura Brasileira,Romance"),
            new BookSeed("Nélida Piñon", "Tempo das Frutas", 1966, "Literatura Brasileira,Contos"),
            new BookSeed("Nélida Piñon", "Vozes do Deserto", 2004, "Literatura Brasileira,Romance"),

            new BookSeed("Dalton Trevisan", "O Vampiro de Curitiba", 1965, "Literatura Brasileira,Contos"),
            new BookSeed("Dalton Trevisan", "Novelas Nada Exemplares", 1959, "Literatura Brasileira,Contos"),
            new BookSeed("Dalton Trevisan", "Cemitério de Elefantes", 1964, "Literatura Brasileira,Contos"),
            new BookSeed("Dalton Trevisan", "A Guerra Conjugal", 1969, "Literatura Brasileira,Contos"),
            new BookSeed("Dalton Trevisan", "Mistérios de Curitiba", 1968, "Literatura Brasileira,Contos"),

            new BookSeed("Rubem Fonseca", "Feliz Ano Novo", 1975, "Literatura Brasileira,Contos"),
            new BookSeed("Rubem Fonseca", "A Grande Arte", 1983, "Literatura Brasileira,Romance"),
            new BookSeed("Rubem Fonseca", "Bufo & Spallanzani", 1985, "Literatura Brasileira,Romance"),
            new BookSeed("Rubem Fonseca", "O Cobrador", 1979, "Literatura Brasileira,Contos"),
            new BookSeed("Rubem Fonseca", "Agosto", 1990, "Literatura Brasileira,Romance"),

            new BookSeed("João Cabral de Melo Neto", "Morte e Vida Severina", 1955, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("João Cabral de Melo Neto", "A Educação pela Pedra", 1966, "Literatura Brasileira,Poesia"),
            new BookSeed("João Cabral de Melo Neto", "O Cão sem Plumas", 1950, "Literatura Brasileira,Poesia"),
            new BookSeed("João Cabral de Melo Neto", "Uma Faca Só Lâmina", 1955, "Literatura Brasileira,Poesia"),
            new BookSeed("João Cabral de Melo Neto", "Pedra do Sono", 1942, "Literatura Brasileira,Poesia"),

            new BookSeed("Olavo Bilac", "Poesias", 1888, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Olavo Bilac", "Tarde", 1919, "Literatura Brasileira,Poesia"),
            new BookSeed("Olavo Bilac", "Via-Láctea", 1888, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Olavo Bilac", "O Caçador de Esmeraldas", 1904, "Literatura Brasileira,Poesia"),
            new BookSeed("Olavo Bilac", "Crianças de Escola", 1902, "Literatura Brasileira,Poesia"),

            new BookSeed("Gonçalves Dias", "Primeiros Cantos", 1846, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Gonçalves Dias", "Segundos Cantos", 1848, "Literatura Brasileira,Poesia"),
            new BookSeed("Gonçalves Dias", "Últimos Cantos", 1851, "Literatura Brasileira,Poesia"),
            new BookSeed("Gonçalves Dias", "I-Juca Pirama", 1851, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Gonçalves Dias", "Canção do Exílio", 1843, "Literatura Brasileira,Poesia,Clássicos"),

            new BookSeed("Augusto dos Anjos", "Eu", 1912, "Literatura Brasileira,Poesia,Clássicos"),
            new BookSeed("Augusto dos Anjos", "Eu e Outras Poesias", 1928, "Literatura Brasileira,Poesia"),
            new BookSeed("Augusto dos Anjos", "Poesias Completas", 1940, "Literatura Brasileira,Poesia"),
            new BookSeed("Augusto dos Anjos", "Versos Escolhidos", 1948, "Literatura Brasileira,Poesia"),
            new BookSeed("Augusto dos Anjos", "Obra Poética", 1994, "Literatura Brasileira,Poesia"),

            new BookSeed("Monteiro Lobato", "Sítio do Picapau Amarelo", 1920, "Literatura Brasileira"),
            new BookSeed("Monteiro Lobato", "Reinações de Narizinho", 1931, "Literatura Brasileira"),
            new BookSeed("Monteiro Lobato", "Urupês", 1918, "Literatura Brasileira,Contos,Clássicos"),
            new BookSeed("Monteiro Lobato", "Fábulas", 1922, "Literatura Brasileira,Contos"),
            new BookSeed("Monteiro Lobato", "A Chave do Tamanho", 1942, "Literatura Brasileira"),

            new BookSeed("Lygia Fagundes Telles", "Ciranda de Pedra", 1954, "Literatura Brasileira,Romance"),
            new BookSeed("Lygia Fagundes Telles", "As Meninas", 1973, "Literatura Brasileira,Romance"),
            new BookSeed("Lygia Fagundes Telles", "Seminário dos Ratos", 1977, "Literatura Brasileira,Contos"),
            new BookSeed("Lygia Fagundes Telles", "Antes do Baile Verde", 1970, "Literatura Brasileira,Contos"),
            new BookSeed("Lygia Fagundes Telles", "Invenção e Memória", 2000, "Literatura Brasileira,Romance"),

            // ---- Sociólogos ----
            new BookSeed("Émile Durkheim", "Da Divisão do Trabalho Social", 1893, "Sociologia,Clássicos"),
            new BookSeed("Émile Durkheim", "As Regras do Método Sociológico", 1895, "Sociologia,Clássicos"),
            new BookSeed("Émile Durkheim", "O Suicídio", 1897, "Sociologia,Clássicos"),
            new BookSeed("Émile Durkheim", "As Formas Elementares da Vida Religiosa", 1912, "Sociologia,Clássicos"),
            new BookSeed("Émile Durkheim", "Educação e Sociologia", 1922, "Sociologia"),

            new BookSeed("Max Weber", "A Ética Protestante e o Espírito do Capitalismo", 1905, "Sociologia,Clássicos"),
            new BookSeed("Max Weber", "Economia e Sociedade", 1922, "Sociologia,Clássicos"),
            new BookSeed("Max Weber", "Ciência e Política: Duas Vocações", 1919, "Sociologia,Filosofia"),
            new BookSeed("Max Weber", "Ensaios de Sociologia", 1946, "Sociologia"),
            new BookSeed("Max Weber", "A Objetividade do Conhecimento", 1904, "Sociologia,Filosofia"),

            new BookSeed("Karl Marx", "O Capital", 1867, "Sociologia,Filosofia,Clássicos"),
            new BookSeed("Karl Marx", "O Manifesto Comunista", 1848, "Sociologia,Filosofia,Clássicos"),
            new BookSeed("Karl Marx", "A Ideologia Alemã", 1846, "Sociologia,Filosofia"),
            new BookSeed("Karl Marx", "O 18 de Brumário de Luís Bonaparte", 1852, "Sociologia,Filosofia"),
            new BookSeed("Karl Marx", "Contribuição à Crítica da Economia Política", 1859, "Sociologia,Filosofia"),

            new BookSeed("Auguste Comte", "Curso de Filosofia Positiva", 1842, "Sociologia,Filosofia,Clássicos"),
            new BookSeed("Auguste Comte", "Discurso sobre o Espírito Positivo", 1844, "Sociologia,Filosofia"),
            new BookSeed("Auguste Comte", "Sistema de Política Positiva", 1854, "Sociologia,Filosofia"),
            new BookSeed("Auguste Comte", "Catecismo Positivista", 1852, "Sociologia,Filosofia"),
            new BookSeed("Auguste Comte", "Opúsculos de Filosofia Social", 1819, "Sociologia,Filosofia"),

            new BookSeed("Pierre Bourdieu", "A Distinção", 1979, "Sociologia"),
            new BookSeed("Pierre Bourdieu", "O Poder Simbólico", 1989, "Sociologia"),
            new BookSeed("Pierre Bourdieu", "A Dominação Masculina", 1998, "Sociologia"),
            new BookSeed("Pierre Bourdieu", "A Miséria do Mundo", 1993, "Sociologia"),
            new BookSeed("Pierre Bourdieu", "Razões Práticas", 1994, "Sociologia"),

            new BookSeed("Zygmunt Bauman", "Modernidade Líquida", 2000, "Sociologia"),
            new BookSeed("Zygmunt Bauman", "Amor Líquido", 2003, "Sociologia"),
            new BookSeed("Zygmunt Bauman", "Medo Líquido", 2006, "Sociologia"),
            new BookSeed("Zygmunt Bauman", "Vida para Consumo", 2007, "Sociologia"),
            new BookSeed("Zygmunt Bauman", "Globalização: As Consequências Humanas", 1998, "Sociologia"),

            new BookSeed("Gilberto Freyre", "Casa-Grande & Senzala", 1933, "Sociologia,Literatura Brasileira,Clássicos"),
            new BookSeed("Gilberto Freyre", "Sobrados e Mucambos", 1936, "Sociologia,Literatura Brasileira"),
            new BookSeed("Gilberto Freyre", "Ordem e Progresso", 1959, "Sociologia,Literatura Brasileira"),
            new BookSeed("Gilberto Freyre", "Nordeste", 1937, "Sociologia,Literatura Brasileira"),
            new BookSeed("Gilberto Freyre", "Interpretação do Brasil", 1945, "Sociologia,Literatura Brasileira"),

            new BookSeed("Florestan Fernandes", "A Integração do Negro na Sociedade de Classes", 1964, "Sociologia"),
            new BookSeed("Florestan Fernandes", "A Revolução Burguesa no Brasil", 1975, "Sociologia"),
            new BookSeed("Florestan Fernandes", "Sociedade de Classes e Subdesenvolvimento", 1968, "Sociologia"),
            new BookSeed("Florestan Fernandes", "Educação e Sociedade no Brasil", 1966, "Sociologia"),
            new BookSeed("Florestan Fernandes", "Capitalismo Dependente e Classes Sociais na América Latina", 1973, "Sociologia"),

            new BookSeed("Darcy Ribeiro", "O Povo Brasileiro", 1995, "Sociologia,Literatura Brasileira"),
            new BookSeed("Darcy Ribeiro", "Os Índios e a Civilização", 1970, "Sociologia,Literatura Brasileira"),
            new BookSeed("Darcy Ribeiro", "As Américas e a Civilização", 1970, "Sociologia,Literatura Brasileira"),
            new BookSeed("Darcy Ribeiro", "Diários Índios", 1996, "Sociologia,Literatura Brasileira"),
            new BookSeed("Darcy Ribeiro", "Teoria do Brasil", 1972, "Sociologia,Literatura Brasileira"),

            new BookSeed("Anthony Giddens", "As Consequências da Modernidade", 1990, "Sociologia"),
            new BookSeed("Anthony Giddens", "A Constituição da Sociedade", 1984, "Sociologia"),
            new BookSeed("Anthony Giddens", "Modernidade e Identidade", 1991, "Sociologia"),
            new BookSeed("Anthony Giddens", "A Terceira Via", 1998, "Sociologia"),
            new BookSeed("Anthony Giddens", "Sociologia", 2001, "Sociologia"),

            new BookSeed("Erving Goffman", "A Representação do Eu na Vida Cotidiana", 1959, "Sociologia,Clássicos"),
            new BookSeed("Erving Goffman", "Estigma", 1963, "Sociologia"),
            new BookSeed("Erving Goffman", "Manicômios, Prisões e Conventos", 1961, "Sociologia"),
            new BookSeed("Erving Goffman", "Frame Analysis", 1974, "Sociologia"),
            new BookSeed("Erving Goffman", "Ritual de Interação", 1967, "Sociologia"),

            new BookSeed("Georg Simmel", "Filosofia do Dinheiro", 1900, "Sociologia,Filosofia,Clássicos"),
            new BookSeed("Georg Simmel", "Sociologia", 1908, "Sociologia,Clássicos"),
            new BookSeed("Georg Simmel", "As Grandes Cidades e a Vida do Espírito", 1903, "Sociologia"),
            new BookSeed("Georg Simmel", "O Conflito da Cultura Moderna", 1918, "Sociologia,Filosofia"),
            new BookSeed("Georg Simmel", "Sobre a Individualidade e as Formas Sociais", 1971, "Sociologia"),

            // ---- Filósofos de qualquer época ----
            new BookSeed("Sócrates", "Apologia de Sócrates", -399, "Filosofia,Clássicos"),
            new BookSeed("Sócrates", "Críton", -399, "Filosofia,Clássicos"),
            new BookSeed("Sócrates", "Ditos e Máximas de Sócrates", -399, "Filosofia,Clássicos"),
            new BookSeed("Sócrates", "Testemunhos sobre Sócrates", -399, "Filosofia,Clássicos"),
            new BookSeed("Sócrates", "A Vida e a Morte de Sócrates", -399, "Filosofia,Clássicos"),

            new BookSeed("Platão", "A República", -380, "Filosofia,Clássicos"),
            new BookSeed("Platão", "O Banquete", -385, "Filosofia,Clássicos"),
            new BookSeed("Platão", "Fédon", -385, "Filosofia,Clássicos"),
            new BookSeed("Platão", "Fedro", -370, "Filosofia,Clássicos"),
            new BookSeed("Platão", "Timeu", -360, "Filosofia,Clássicos"),

            new BookSeed("Aristóteles", "Ética a Nicômaco", -340, "Filosofia,Clássicos"),
            new BookSeed("Aristóteles", "Política", -330, "Filosofia,Clássicos"),
            new BookSeed("Aristóteles", "Metafísica", -330, "Filosofia,Clássicos"),
            new BookSeed("Aristóteles", "Poética", -335, "Filosofia,Clássicos"),
            new BookSeed("Aristóteles", "Órganon", -330, "Filosofia,Clássicos"),

            new BookSeed("René Descartes", "Discurso do Método", 1637, "Filosofia,Clássicos"),
            new BookSeed("René Descartes", "Meditações Metafísicas", 1641, "Filosofia,Clássicos"),
            new BookSeed("René Descartes", "Princípios da Filosofia", 1644, "Filosofia,Clássicos"),
            new BookSeed("René Descartes", "As Paixões da Alma", 1649, "Filosofia,Clássicos"),
            new BookSeed("René Descartes", "Regras para a Direção do Espírito", 1628, "Filosofia,Clássicos"),

            new BookSeed("Immanuel Kant", "Crítica da Razão Pura", 1781, "Filosofia,Clássicos"),
            new BookSeed("Immanuel Kant", "Crítica da Razão Prática", 1788, "Filosofia,Clássicos"),
            new BookSeed("Immanuel Kant", "Crítica da Faculdade do Juízo", 1790, "Filosofia,Clássicos"),
            new BookSeed("Immanuel Kant", "Fundamentação da Metafísica dos Costumes", 1785, "Filosofia,Clássicos"),
            new BookSeed("Immanuel Kant", "À Paz Perpétua", 1795, "Filosofia,Clássicos"),

            new BookSeed("Friedrich Nietzsche", "Assim Falou Zaratustra", 1883, "Filosofia,Clássicos"),
            new BookSeed("Friedrich Nietzsche", "Além do Bem e do Mal", 1886, "Filosofia,Clássicos"),
            new BookSeed("Friedrich Nietzsche", "A Gaia Ciência", 1882, "Filosofia,Clássicos"),
            new BookSeed("Friedrich Nietzsche", "O Nascimento da Tragédia", 1872, "Filosofia,Clássicos"),
            new BookSeed("Friedrich Nietzsche", "Genealogia da Moral", 1887, "Filosofia,Clássicos"),

            new BookSeed("Jean-Paul Sartre", "O Ser e o Nada", 1943, "Filosofia"),
            new BookSeed("Jean-Paul Sartre", "A Náusea", 1938, "Filosofia,Romance"),
            new BookSeed("Jean-Paul Sartre", "O Existencialismo é um Humanismo", 1946, "Filosofia"),
            new BookSeed("Jean-Paul Sartre", "As Moscas", 1943, "Filosofia"),
            new BookSeed("Jean-Paul Sartre", "Crítica da Razão Dialética", 1960, "Filosofia"),

            new BookSeed("Simone de Beauvoir", "O Segundo Sexo", 1949, "Filosofia"),
            new BookSeed("Simone de Beauvoir", "Memórias de uma Moça Bem-Comportada", 1958, "Filosofia"),
            new BookSeed("Simone de Beauvoir", "A Convidada", 1943, "Filosofia,Romance"),
            new BookSeed("Simone de Beauvoir", "A Força da Idade", 1960, "Filosofia"),
            new BookSeed("Simone de Beauvoir", "Uma Morte Muito Suave", 1964, "Filosofia"),

            new BookSeed("Michel Foucault", "Vigiar e Punir", 1975, "Filosofia,Sociologia"),
            new BookSeed("Michel Foucault", "As Palavras e as Coisas", 1966, "Filosofia"),
            new BookSeed("Michel Foucault", "História da Loucura", 1961, "Filosofia,Sociologia"),
            new BookSeed("Michel Foucault", "A Arqueologia do Saber", 1969, "Filosofia"),
            new BookSeed("Michel Foucault", "História da Sexualidade", 1976, "Filosofia,Sociologia"),

            new BookSeed("Hannah Arendt", "Origens do Totalitarismo", 1951, "Filosofia,Sociologia"),
            new BookSeed("Hannah Arendt", "A Condição Humana", 1958, "Filosofia"),
            new BookSeed("Hannah Arendt", "Eichmann em Jerusalém", 1963, "Filosofia,Sociologia"),
            new BookSeed("Hannah Arendt", "Sobre a Revolução", 1963, "Filosofia"),
            new BookSeed("Hannah Arendt", "Entre o Passado e o Futuro", 1961, "Filosofia"),

            new BookSeed("Baruch Spinoza", "Ética", 1677, "Filosofia,Clássicos"),
            new BookSeed("Baruch Spinoza", "Tratado Teológico-Político", 1670, "Filosofia,Clássicos"),
            new BookSeed("Baruch Spinoza", "Tratado Político", 1677, "Filosofia,Clássicos"),
            new BookSeed("Baruch Spinoza", "Tratado da Correção do Intelecto", 1662, "Filosofia,Clássicos"),
            new BookSeed("Baruch Spinoza", "Princípios da Filosofia de Descartes", 1663, "Filosofia,Clássicos"),

            new BookSeed("David Hume", "Tratado da Natureza Humana", 1739, "Filosofia,Clássicos"),
            new BookSeed("David Hume", "Investigação sobre o Entendimento Humano", 1748, "Filosofia,Clássicos"),
            new BookSeed("David Hume", "Diálogos sobre a Religião Natural", 1779, "Filosofia,Clássicos"),
            new BookSeed("David Hume", "Investigação sobre os Princípios da Moral", 1751, "Filosofia,Clássicos"),
            new BookSeed("David Hume", "História da Inglaterra", 1754, "Filosofia,Clássicos"),

            new BookSeed("Confúcio", "Analectos", -479, "Filosofia,Clássicos"),
            new BookSeed("Confúcio", "Grande Aprendizado", -479, "Filosofia,Clássicos"),
            new BookSeed("Confúcio", "Doutrina do Meio", -479, "Filosofia,Clássicos"),
            new BookSeed("Confúcio", "Livro das Odes", -479, "Filosofia,Clássicos"),
            new BookSeed("Confúcio", "Livro das Mutações - Comentários", -479, "Filosofia,Clássicos"),

            new BookSeed("Søren Kierkegaard", "O Conceito de Angústia", 1844, "Filosofia,Clássicos"),
            new BookSeed("Søren Kierkegaard", "Ou-Ou", 1843, "Filosofia,Clássicos"),
            new BookSeed("Søren Kierkegaard", "Temor e Tremor", 1843, "Filosofia,Clássicos"),
            new BookSeed("Søren Kierkegaard", "A Doença até a Morte", 1849, "Filosofia,Clássicos"),
            new BookSeed("Søren Kierkegaard", "Migalhas Filosóficas", 1844, "Filosofia,Clássicos"),

            new BookSeed("Georg Wilhelm Friedrich Hegel", "Fenomenologia do Espírito", 1807, "Filosofia,Clássicos"),
            new BookSeed("Georg Wilhelm Friedrich Hegel", "Ciência da Lógica", 1812, "Filosofia,Clássicos"),
            new BookSeed("Georg Wilhelm Friedrich Hegel", "Princípios da Filosofia do Direito", 1820, "Filosofia,Clássicos"),
            new BookSeed("Georg Wilhelm Friedrich Hegel", "Enciclopédia das Ciências Filosóficas", 1817, "Filosofia,Clássicos"),
            new BookSeed("Georg Wilhelm Friedrich Hegel", "Lições sobre a Filosofia da História", 1837, "Filosofia,Clássicos"),

            new BookSeed("John Locke", "Segundo Tratado sobre o Governo", 1689, "Filosofia,Clássicos"),
            new BookSeed("John Locke", "Ensaio Acerca do Entendimento Humano", 1689, "Filosofia,Clássicos"),
            new BookSeed("John Locke", "Carta Acerca da Tolerância", 1689, "Filosofia,Clássicos"),
            new BookSeed("John Locke", "Alguns Pensamentos Concernentes à Educação", 1693, "Filosofia,Clássicos"),
            new BookSeed("John Locke", "Primeiro Tratado sobre o Governo", 1689, "Filosofia,Clássicos"),

            new BookSeed("Thomas Hobbes", "Leviatã", 1651, "Filosofia,Clássicos"),
            new BookSeed("Thomas Hobbes", "Do Cidadão", 1642, "Filosofia,Clássicos"),
            new BookSeed("Thomas Hobbes", "Elementos da Lei Natural e Política", 1640, "Filosofia,Clássicos"),
            new BookSeed("Thomas Hobbes", "Behemoth", 1681, "Filosofia,Clássicos"),
            new BookSeed("Thomas Hobbes", "Diálogo entre um Filósofo e um Jurista", 1681, "Filosofia,Clássicos"),

            new BookSeed("Jean-Jacques Rousseau", "O Contrato Social", 1762, "Filosofia,Clássicos"),
            new BookSeed("Jean-Jacques Rousseau", "Emílio ou Da Educação", 1762, "Filosofia,Clássicos"),
            new BookSeed("Jean-Jacques Rousseau", "Discurso sobre a Origem da Desigualdade", 1755, "Filosofia,Clássicos"),
            new BookSeed("Jean-Jacques Rousseau", "As Confissões", 1782, "Filosofia,Clássicos"),
            new BookSeed("Jean-Jacques Rousseau", "Devaneios do Caminhante Solitário", 1782, "Filosofia,Clássicos"),

            new BookSeed("Arthur Schopenhauer", "O Mundo como Vontade e Representação", 1818, "Filosofia,Clássicos"),
            new BookSeed("Arthur Schopenhauer", "Sobre a Liberdade da Vontade", 1839, "Filosofia,Clássicos"),
            new BookSeed("Arthur Schopenhauer", "Parerga e Paralipomena", 1851, "Filosofia,Clássicos"),
            new BookSeed("Arthur Schopenhauer", "A Arte de Ter Razão", 1830, "Filosofia,Clássicos"),
            new BookSeed("Arthur Schopenhauer", "Metafísica do Amor", 1819, "Filosofia,Clássicos"),

            new BookSeed("Martin Heidegger", "Ser e Tempo", 1927, "Filosofia"),
            new BookSeed("Martin Heidegger", "Que é Metafísica?", 1929, "Filosofia"),
            new BookSeed("Martin Heidegger", "Carta sobre o Humanismo", 1946, "Filosofia"),
            new BookSeed("Martin Heidegger", "A Origem da Obra de Arte", 1935, "Filosofia"),
            new BookSeed("Martin Heidegger", "Introdução à Metafísica", 1935, "Filosofia"),

            new BookSeed("Ludwig Wittgenstein", "Tractatus Logico-Philosophicus", 1921, "Filosofia"),
            new BookSeed("Ludwig Wittgenstein", "Investigações Filosóficas", 1953, "Filosofia"),
            new BookSeed("Ludwig Wittgenstein", "Da Certeza", 1969, "Filosofia"),
            new BookSeed("Ludwig Wittgenstein", "Observações Filosóficas", 1930, "Filosofia"),
            new BookSeed("Ludwig Wittgenstein", "Cadernos Azul e Marrom", 1958, "Filosofia"),

            new BookSeed("Voltaire", "Cândido", 1759, "Filosofia,Clássicos"),
            new BookSeed("Voltaire", "Cartas Filosóficas", 1734, "Filosofia,Clássicos"),
            new BookSeed("Voltaire", "Dicionário Filosófico", 1764, "Filosofia,Clássicos"),
            new BookSeed("Voltaire", "Tratado sobre a Tolerância", 1763, "Filosofia,Clássicos"),
            new BookSeed("Voltaire", "Zadig", 1747, "Filosofia,Clássicos"),

            new BookSeed("Nicolau Maquiavel", "O Príncipe", 1532, "Filosofia,Clássicos"),
            new BookSeed("Nicolau Maquiavel", "Discursos sobre a Primeira Década de Tito Lívio", 1531, "Filosofia,Clássicos"),
            new BookSeed("Nicolau Maquiavel", "A Arte da Guerra", 1521, "Filosofia,Clássicos"),
            new BookSeed("Nicolau Maquiavel", "História de Florença", 1532, "Filosofia,Clássicos"),
            new BookSeed("Nicolau Maquiavel", "Mandrágora", 1518, "Filosofia,Clássicos"),

            new BookSeed("Epicuro", "Carta sobre a Felicidade", -300, "Filosofia,Clássicos"),
            new BookSeed("Epicuro", "Máximas Principais", -300, "Filosofia,Clássicos"),
            new BookSeed("Epicuro", "Carta a Meneceu", -300, "Filosofia,Clássicos"),
            new BookSeed("Epicuro", "Carta a Heródoto", -300, "Filosofia,Clássicos"),
            new BookSeed("Epicuro", "Sentenças Vaticanas", -300, "Filosofia,Clássicos"),

            new BookSeed("Sêneca", "Cartas a Lucílio", -65, "Filosofia,Clássicos"),
            new BookSeed("Sêneca", "Da Vida Breve", -49, "Filosofia,Clássicos"),
            new BookSeed("Sêneca", "Da Tranquilidade da Alma", -49, "Filosofia,Clássicos"),
            new BookSeed("Sêneca", "Da Ira", -45, "Filosofia,Clássicos"),
            new BookSeed("Sêneca", "Consolação a Márcia", -40, "Filosofia,Clássicos"),

            // ---- Contos, histórias e poemas famosos de qualquer lugar ----
            new BookSeed("Edgar Allan Poe", "O Corvo", 1845, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Edgar Allan Poe", "Contos de Imaginação e Mistério", 1839, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Edgar Allan Poe", "O Gato Preto", 1843, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Edgar Allan Poe", "O Coração Delator", 1843, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Edgar Allan Poe", "Os Crimes da Rua Morgue", 1841, "Literatura Estrangeira,Contos,Clássicos"),

            new BookSeed("Anton Tchekhov", "A Dama do Cachorrinho", 1899, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Anton Tchekhov", "A Gaivota", 1896, "Literatura Estrangeira,Clássicos"),
            new BookSeed("Anton Tchekhov", "As Três Irmãs", 1901, "Literatura Estrangeira,Clássicos"),
            new BookSeed("Anton Tchekhov", "Contos Escolhidos", 1886, "Literatura Estrangeira,Contos"),
            new BookSeed("Anton Tchekhov", "O Jardim das Cerejeiras", 1904, "Literatura Estrangeira,Clássicos"),

            new BookSeed("Franz Kafka", "A Metamorfose", 1915, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Franz Kafka", "O Processo", 1925, "Literatura Estrangeira,Romance,Clássicos"),
            new BookSeed("Franz Kafka", "O Castelo", 1926, "Literatura Estrangeira,Romance,Clássicos"),
            new BookSeed("Franz Kafka", "Carta ao Pai", 1919, "Literatura Estrangeira"),
            new BookSeed("Franz Kafka", "Um Artista da Fome", 1922, "Literatura Estrangeira,Contos"),

            new BookSeed("Jorge Luis Borges", "Ficções", 1944, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Jorge Luis Borges", "O Aleph", 1949, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Jorge Luis Borges", "Elogio da Sombra", 1969, "Literatura Estrangeira,Poesia"),
            new BookSeed("Jorge Luis Borges", "História Universal da Infâmia", 1935, "Literatura Estrangeira,Contos"),
            new BookSeed("Jorge Luis Borges", "O Livro de Areia", 1975, "Literatura Estrangeira,Contos"),

            new BookSeed("Gabriel García Márquez", "Cem Anos de Solidão", 1967, "Literatura Estrangeira,Romance,Clássicos"),
            new BookSeed("Gabriel García Márquez", "O Amor nos Tempos do Cólera", 1985, "Literatura Estrangeira,Romance"),
            new BookSeed("Gabriel García Márquez", "Ninguém Escreve ao Coronel", 1961, "Literatura Estrangeira,Contos"),
            new BookSeed("Gabriel García Márquez", "Doze Contos Peregrinos", 1992, "Literatura Estrangeira,Contos"),
            new BookSeed("Gabriel García Márquez", "Crônica de uma Morte Anunciada", 1981, "Literatura Estrangeira,Romance"),

            new BookSeed("Guy de Maupassant", "Bola de Sebo", 1880, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Guy de Maupassant", "O Horla", 1887, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Guy de Maupassant", "Contos da Noite", 1885, "Literatura Estrangeira,Contos"),
            new BookSeed("Guy de Maupassant", "Uma Vida", 1883, "Literatura Estrangeira,Romance"),
            new BookSeed("Guy de Maupassant", "O Colar", 1884, "Literatura Estrangeira,Contos,Clássicos"),

            new BookSeed("O. Henry", "A Última Folha", 1907, "Literatura Estrangeira,Contos"),
            new BookSeed("O. Henry", "O Presente dos Reis Magos", 1905, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("O. Henry", "Contos Escolhidos", 1904, "Literatura Estrangeira,Contos"),
            new BookSeed("O. Henry", "Repolhos e Reis", 1904, "Literatura Estrangeira,Contos"),
            new BookSeed("O. Henry", "Quatro Milhões", 1906, "Literatura Estrangeira,Contos"),

            new BookSeed("Pablo Neruda", "Vinte Poemas de Amor e uma Canção Desesperada", 1924, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Pablo Neruda", "Canto Geral", 1950, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Pablo Neruda", "Cem Sonetos de Amor", 1959, "Literatura Estrangeira,Poesia"),
            new BookSeed("Pablo Neruda", "Confesso que Vivi", 1974, "Literatura Estrangeira"),
            new BookSeed("Pablo Neruda", "Odes Elementares", 1954, "Literatura Estrangeira,Poesia"),

            new BookSeed("Fernando Pessoa", "Mensagem", 1934, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Fernando Pessoa", "O Livro do Desassossego", 1982, "Literatura Estrangeira,Clássicos"),
            new BookSeed("Fernando Pessoa", "Odes de Ricardo Reis", 1946, "Literatura Estrangeira,Poesia"),
            new BookSeed("Fernando Pessoa", "Poemas de Álvaro de Campos", 1944, "Literatura Estrangeira,Poesia"),
            new BookSeed("Fernando Pessoa", "Cancioneiro", 1942, "Literatura Estrangeira,Poesia"),

            new BookSeed("Charles Baudelaire", "As Flores do Mal", 1857, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Charles Baudelaire", "Pequenos Poemas em Prosa", 1869, "Literatura Estrangeira,Poesia"),
            new BookSeed("Charles Baudelaire", "O Pintor da Vida Moderna", 1863, "Literatura Estrangeira"),
            new BookSeed("Charles Baudelaire", "Os Paraísos Artificiais", 1860, "Literatura Estrangeira"),
            new BookSeed("Charles Baudelaire", "Diários Íntimos", 1887, "Literatura Estrangeira"),

            new BookSeed("Walt Whitman", "Folhas de Relva", 1855, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Walt Whitman", "Canção de Mim Mesmo", 1855, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Walt Whitman", "Democratic Vistas", 1871, "Literatura Estrangeira"),
            new BookSeed("Walt Whitman", "Cálamo", 1860, "Literatura Estrangeira,Poesia"),
            new BookSeed("Walt Whitman", "Espécimes de Dias", 1882, "Literatura Estrangeira"),

            new BookSeed("Emily Dickinson", "Poemas Escolhidos", 1890, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Emily Dickinson", "Não Sou Ninguém", 1890, "Literatura Estrangeira,Poesia"),
            new BookSeed("Emily Dickinson", "Cartas", 1894, "Literatura Estrangeira"),
            new BookSeed("Emily Dickinson", "Só a Alma Escolhe", 1890, "Literatura Estrangeira,Poesia"),
            new BookSeed("Emily Dickinson", "Um Certo Alguém Chega", 1890, "Literatura Estrangeira,Poesia"),

            new BookSeed("Hans Christian Andersen", "A Pequena Sereia", 1837, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Hans Christian Andersen", "O Patinho Feio", 1843, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Hans Christian Andersen", "A Roupa Nova do Imperador", 1837, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Hans Christian Andersen", "A Pequena Vendedora de Fósforos", 1845, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Hans Christian Andersen", "A Rainha da Neve", 1844, "Literatura Estrangeira,Contos,Clássicos"),

            new BookSeed("Ernest Hemingway", "O Velho e o Mar", 1952, "Literatura Estrangeira,Romance,Clássicos"),
            new BookSeed("Ernest Hemingway", "Homens Sem Mulheres", 1927, "Literatura Estrangeira,Contos"),
            new BookSeed("Ernest Hemingway", "Paris é uma Festa", 1964, "Literatura Estrangeira"),
            new BookSeed("Ernest Hemingway", "Adeus às Armas", 1929, "Literatura Estrangeira,Romance"),
            new BookSeed("Ernest Hemingway", "Os Assassinos", 1927, "Literatura Estrangeira,Contos"),

            new BookSeed("Julio Cortázar", "Bestiário", 1951, "Literatura Estrangeira,Contos"),
            new BookSeed("Julio Cortázar", "O Jogo da Amarelinha", 1963, "Literatura Estrangeira,Romance"),
            new BookSeed("Julio Cortázar", "As Armas Secretas", 1959, "Literatura Estrangeira,Contos"),
            new BookSeed("Julio Cortázar", "Final de Jogo", 1956, "Literatura Estrangeira,Contos"),
            new BookSeed("Julio Cortázar", "Histórias de Cronópios e de Famas", 1962, "Literatura Estrangeira,Contos"),

            new BookSeed("Rudyard Kipling", "O Livro da Selva", 1894, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Rudyard Kipling", "Kim", 1901, "Literatura Estrangeira,Romance"),
            new BookSeed("Rudyard Kipling", "Just So Stories", 1902, "Literatura Estrangeira,Contos"),
            new BookSeed("Rudyard Kipling", "Se", 1910, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Rudyard Kipling", "Capitães Corajosos", 1897, "Literatura Estrangeira,Romance"),

            new BookSeed("Nikolai Gogol", "O Capote", 1842, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Nikolai Gogol", "Almas Mortas", 1842, "Literatura Estrangeira,Romance,Clássicos"),
            new BookSeed("Nikolai Gogol", "O Nariz", 1836, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Nikolai Gogol", "O Retrato", 1835, "Literatura Estrangeira,Contos"),
            new BookSeed("Nikolai Gogol", "Diário de um Louco", 1835, "Literatura Estrangeira,Contos,Clássicos"),

            new BookSeed("Rainer Maria Rilke", "Cartas a um Jovem Poeta", 1929, "Literatura Estrangeira,Clássicos"),
            new BookSeed("Rainer Maria Rilke", "Elegias de Duíno", 1923, "Literatura Estrangeira,Poesia"),
            new BookSeed("Rainer Maria Rilke", "Sonetos a Orfeu", 1923, "Literatura Estrangeira,Poesia"),
            new BookSeed("Rainer Maria Rilke", "O Livro de Horas", 1905, "Literatura Estrangeira,Poesia"),
            new BookSeed("Rainer Maria Rilke", "Os Cadernos de Malte Laurids Brigge", 1910, "Literatura Estrangeira,Romance"),

            new BookSeed("William Blake", "Canções da Inocência e da Experiência", 1794, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("William Blake", "O Casamento do Céu e do Inferno", 1793, "Literatura Estrangeira,Poesia"),
            new BookSeed("William Blake", "Milton", 1811, "Literatura Estrangeira,Poesia"),
            new BookSeed("William Blake", "Jerusalém", 1820, "Literatura Estrangeira,Poesia"),
            new BookSeed("William Blake", "O Livro de Thel", 1789, "Literatura Estrangeira,Poesia"),

            new BookSeed("Arthur Rimbaud", "Uma Temporada no Inferno", 1873, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Arthur Rimbaud", "Iluminações", 1886, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Arthur Rimbaud", "O Barco Bêbado", 1871, "Literatura Estrangeira,Poesia"),
            new BookSeed("Arthur Rimbaud", "Poesias Completas", 1895, "Literatura Estrangeira,Poesia"),
            new BookSeed("Arthur Rimbaud", "Cartas do Vidente", 1871, "Literatura Estrangeira"),

            new BookSeed("Charles Perrault", "Contos da Mamãe Gansa", 1697, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Charles Perrault", "Chapeuzinho Vermelho", 1697, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Charles Perrault", "Cinderela", 1697, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Charles Perrault", "A Bela Adormecida", 1697, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Charles Perrault", "O Gato de Botas", 1697, "Literatura Estrangeira,Contos,Clássicos"),

            new BookSeed("Jacob Grimm", "Contos de Fadas dos Irmãos Grimm", 1812, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Jacob Grimm", "Branca de Neve", 1812, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Jacob Grimm", "João e Maria", 1812, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Jacob Grimm", "Rapunzel", 1812, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Jacob Grimm", "Gramática Alemã", 1819, "Literatura Estrangeira"),

            new BookSeed("Wilhelm Grimm", "O Lobo e os Sete Cabritinhos", 1812, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Wilhelm Grimm", "Os Músicos de Bremen", 1819, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Wilhelm Grimm", "O Rei Sapo", 1812, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Wilhelm Grimm", "Rumpelstiltskin", 1812, "Literatura Estrangeira,Contos,Clássicos"),
            new BookSeed("Wilhelm Grimm", "A Bela Adormecida - Versão dos Irmãos Grimm", 1812, "Literatura Estrangeira,Contos"),

            new BookSeed("Homero", "Ilíada", -800, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Homero", "Odisseia", -800, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Homero", "Hino a Deméter", -700, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Homero", "Hino a Apolo", -700, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Homero", "Batracomiomaquia", -700, "Literatura Estrangeira,Poesia"),

            new BookSeed("Dante Alighieri", "A Divina Comédia: Inferno", 1314, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Dante Alighieri", "A Divina Comédia: Purgatório", 1315, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Dante Alighieri", "A Divina Comédia: Paraíso", 1320, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Dante Alighieri", "A Vida Nova", 1294, "Literatura Estrangeira,Poesia,Clássicos"),
            new BookSeed("Dante Alighieri", "Convívio", 1307, "Literatura Estrangeira,Clássicos")
    );
}
