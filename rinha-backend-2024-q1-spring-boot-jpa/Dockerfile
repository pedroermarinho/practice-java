FROM ghcr.io/graalvm/jdk-community:21

WORKDIR /app

COPY ./build/libs/rinha-backend-2024-q1-spring-boot-jpa-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
