# Dockerfile
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /build

# copy pom + sources
COPY pom.xml .
COPY src ./src

# download dependencies and build (skip tests)
RUN mvn -B -DskipTests clean package

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /build/target/*.jar app.jar
EXPOSE 8081
ENV JAVA_TOOL_OPTIONS="-Duser.timezone=Asia/Kolkata"
ENTRYPOINT ["sh","-c","java $JAVA_TOOL_OPTIONS -jar /app/app.jar"]
