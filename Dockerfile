# ---------- build ----------
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /build

COPY dimdim/pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline

COPY dimdim/src ./src
RUN mvn -q -DskipTests package

# ---------- runtime ----------
FROM eclipse-temurin:21-jre
ENV TZ=UTC
WORKDIR /app

# Cria usuário sem privilégios
RUN useradd -m appuser

# Copia o JAR do build
COPY --from=build /build/target/dimdim-0.0.1-SNAPSHOT.jar /app/app.jar

# Define o usuário
USER appuser

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
