FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY ./target/java-maven-app-*.jar /usr/app/
WORKDIR /usr/app

#ENTRYPOINT ["java", "-jar", "java-maven-app-*.jar"] it's not a shell so same command can be like below
CMD java -jar java-maven-app-*.jar
