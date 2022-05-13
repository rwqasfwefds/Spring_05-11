package com.example.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @Configuration, @ComponentScan, @EnableAutoConfiguration 의 3개 묶음이 @SpringBootApplication <= 얘임

// @Configuration : 스프링에 등록 될 객체들을 위한 자바 설정 파일(feat. @Bean)
// @ComponentScan : @Component 붙은 클래스들을 검색해서 자동으로 @Bean으로 등록
// @EnableAutoConfiguration : 스프링에서 내부 라이브러리들을 등록해줌
@SpringBootApplication
// Controller : RestController, Controller
// 컨트롤러 역할 : 메뉴 만들기, URL 이동 처리(Vue 라우터 : 메뉴) 스프링에서 메뉴 달기
// Rest API 작성을 위한 어노테이션
// 비교 @Controller : 일반 JSP / 타임리프 파일 로딩
@RestController
public class HelloSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }

//    @GetMapping : Get 방식(요청)에 /hello URL 연결(라우팅, 메뉴달기)
//    뜻 : Get 방식으로 메뉴를 연결하겠다 라는 뜻
//    Get : Select
//    예시) http://localhost:8080/hello/myName=tae
//    URL : http://localhost:8080 => 도메인 주소
//         hello => 메뉴
//         tae => myName의 데이터 값
//    myName => parameter(웹 매개변수) parameter 얘 뜻이 매개변수임
//    myName 자체가 파라메터임 그 값이 tae라는 거고
//    defaultValue => 웹 매개변수의 값이 null 이면 디폴트 값으로 대체
    @GetMapping("/hello")
//    defaultValue = myName에 값이 없을 수도 있잖슴 그래서 없으면 이걸 저장해라 라는 뜻
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World")String name){
//        String.format : printf 구문과 유사, %s, %d에 문자, 숫자를 대입
        return String.format("Hello %s!", name);
    }
}
