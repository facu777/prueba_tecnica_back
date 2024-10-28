# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Copia el archivo .jar al contenedor
COPY target/tu-archivo.jar app.jar

# Expone el puerto en el que correrá la app
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
