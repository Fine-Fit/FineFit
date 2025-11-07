FROM amazoncorretto:21 AS builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# ./gradlew 파일 권한 변경
RUN chmod +x ./gradlew

# gradle 빌드
RUN ./gradlew bootJar
FROM amazoncorretto:21

COPY --from=builder build/libs/*.jar app.jar

ENTRYPOINT [ "java","-jar","/app.jar" ]
VOLUME /tmp