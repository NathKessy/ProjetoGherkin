# Usa uma imagem base do OpenJDK 17 (ou a versão que estiver utilizando)
FROM openjdk:17-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado para o contêiner
COPY target/coletaAi-0.0.1-SNAPSHOT.jar app.jar

# Define o comando para executar a aplicação quando o contêiner iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]

# Exponha a porta que sua aplicação Spring Boot está utilizando
EXPOSE 8080
