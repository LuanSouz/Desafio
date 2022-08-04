FROM gradle:7.2-jdk11-hotspot AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle -Dorg.gradle.jvmargs=-Xmx1536m assemble --no-daemon

FROM amazoncorretto:11

COPY --from=build /home/gradle/src/build/libs/Ponto-Eletronico.jar Ponto-Eletronico.jar

ENTRYPOINT ["java", "-jar","/Ponto-Eletronico.jar"]