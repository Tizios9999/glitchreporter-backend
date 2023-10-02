# Usa un'immagine di base con Java 19
FROM openjdk:19-jdk-alpine

# Copia il file JAR dell'applicazione nel container
COPY target/glitchreporter-0.0.1-SNAPSHOT.jar /app.jar

# Espone la porta su cui l'applicazione risponderà
EXPOSE 8080

# Comando per avviare l'applicazione quando il container viene avviato
CMD ["java", "-jar", "/app.jar"]