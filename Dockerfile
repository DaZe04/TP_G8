FROM amazoncorretto:17-alpine-jdk
WORKDIR /app

COPY target/demoSI61-0.0.1-SNAPSHOT.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]
# Etapa de build: usar Maven + Java
FROM maven:3.9.3-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar archivos necesarios para Maven
COPY mvnw ./
COPY .mvn .mvn
COPY pom.xml ./
COPY src ./src

# Dar permisos a mvnw
RUN chmod +x mvnw

# Construir el proyecto y saltar tests
RUN ./mvnw clean package -DskipTests

# Etapa final: imagen ligera de Java
FROM amazoncorretto:17-alpine-jdk
WORKDIR /app

# Copiar el JAR generado con el nombre correcto
COPY --from=build /app/target/AWeb_G08-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
