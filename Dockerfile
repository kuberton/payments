FROM openjdk:8-jdk-alpine as builder
RUN apk add --no-cache maven
WORKDIR /app
COPY . .
RUN mvn clean package 


FROM openjdk:8-jdk-alpine as release
WORKDIR /app
COPY --from=builder /app/target/gs-spring-boot-0.1.0.jar /app/
EXPOSE 8080
CMD java -jar /app/gs-spring-boot-0.1.0.jar