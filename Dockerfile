FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /workspace/app

# Copiar archivos mvn y pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN chmod +x ./mvnw

# Descargar dependencias (capa cacheada)
RUN ./mvnw dependency:go-offline -B

# Copiar código fuente y compilar
COPY src src
RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Imagen final
FROM eclipse-temurin:21-jre-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency

# Copiar dependencias desempaquetadas
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Crear usuario no privilegiado
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Puerto y punto de entrada
EXPOSE 8080
ENTRYPOINT ["java","-cp","app:app/lib/*","com.telconova.supportsuite.TelcoNovaSupportBackendApplication"]