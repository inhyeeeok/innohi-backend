# innohi-backend

[개발스택]

|컴포넌트|적용기술|날짜|작성자|버전|비고|
|---|---|------|---|---|-----|
Persistence|JPA|20211220|권인혁|2.5.0|org.springframework.boot:spring-boot-starter-data-jpa|
Backend|Spring Boot|20211220|권인혁|2.5+||
Backend|lombok|20211220|권인혁|1.18.20|org.projectlombok:lombok|
API Documentation|swagger|20211227|권인혁|2.9.2|springfox-swagger2|
API Documentation|swagger-ui|20211227|권인혁|2.9.2|springfox-swagger-ui|
Test|junit|20220103|권인혁|4.13|junit:4|
Server Build|Gradle|20220104|권인혁|||
Database|H2 Database, MySQL|20220104|권인혁||

[API Documents]

http://localhost:5000/swagger-ui.html

http://test-env-1.eba-kpdvwiie.ap-northeast-2.elasticbeanstalk.com/swagger-ui.html#/

[코드 실행]

```
$ cd <프로젝트 디렉터리>/demo
$ ./gradlew bootRun
```
