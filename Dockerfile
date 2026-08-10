# Stage 1: Compilação da aplicação com Maven Wrapper
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app

# Copia configurações do Maven Wrapper para cache das dependências
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

# Copia o código fonte e compila o pacote JAR
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Stage 2: Imagem final leve para execução em produção
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia o JAR compilado do estágio anterior
COPY --from=build /app/target/library-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão do servidor
EXPOSE 8080

# Executa a aplicação Spring Boot em perfil prod
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]