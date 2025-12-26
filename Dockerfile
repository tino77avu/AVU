# Multi-stage build para optimizar el tamaño de la imagen
# Stage 1: Build
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar archivos de configuración de Maven
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Descargar dependencias (se cachean si no cambia el pom.xml)
RUN mvn dependency:go-offline -B

# Copiar el código fuente
COPY src ./src

# Compilar la aplicación
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Crear usuario no-root para seguridad
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copiar el JAR desde el stage de build
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto (Render usará la variable PORT)
EXPOSE 8080

# Ejecutar la aplicación
# Render inyecta la variable PORT automáticamente
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

