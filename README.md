# Translate and Comprehend Api Server with AWS

AWS의 Translate, Comprehend 서비스를 이용하여 번역 및 감정분석 기능을 제공하는 Spring Boot 기반의 API Server

## Getting Started


### Installing

gradle 기반으로 Excutable Jar 생성 후 실행 시 아래 명령어 수행

```
./gradlew bootJar
java -jar ./build/libs/aws-test-0.0.1-SNAPSHOT.jar
```

바로 실행 시킬 시 아래 명령어 수행

```
./gradlew bootRun
```

실행 후 아래 주소로 접속하여 api 확인 가능
```
http://localhost:8080/swagger-ui.html
```

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Gradle](https://gradle.org) - Dependency Management
* [Lombok](https://projectlombok.org) - Annotation based plugin what add a code like Getter, Setter, Builder etc

## Authors

* **Kiuk Lee** - *Initial work* - [lko0901](https://github.com/lko0901)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
