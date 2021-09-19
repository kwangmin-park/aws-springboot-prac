package com.prac.aws.springboot.awsspringbootprac.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

//@RunWith - 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
//여기서는 SpringRunner라는 스프링 실행자를 실행
//스프링 부트 테스트와 JUnit 사이에서 연결자 역할

//@WebMvcTest - MVC에 집중할 수 있는 테스트 어노테이션
//@Controller, @ControllerAdvice 등을 사용할 수 있다.
//MVC이므로 @Service, @Component, @Repository 등은 사용 불가
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

//    스프링이 관리하는 Bean 주입
//    웹 API 테스틑 용. MockMvc 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트 가능
    @Autowired
    private MockMvc mvc;

//    @Test
//    public void hello_return() throws Exception{
//        String hello = "hello";
//        mvc.perform(get("/hello")) // /hello API를 GET방식으로 요청. 체이닝 지원.
//                .andExpect(status().isOk()) //HTTP Header의 status ok(200)인지 확인
//                .andExpect(content().string(hello)); //결과가 hello인지 확인
//    }

//    @Test
//    public void helloDto_return() throws Exception{
//        String name = "hello";
//        int amount = 1000;
//
////        param은 API 테스트할때 요청파라미터 설정. String만 허용하므로 int, date 등은 String 으로 변경 필요
////        jsonPath는 JSon 응답값을 필드별로 검증할 수 있는 메소드. $. 을 기준으로 필드명 명시
//        mvc.perform(get("/hello/dto")
//                        .param("name", name)
//                        .param("amount", String.valueOf(amount)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is(name)))
//                .andExpect(jsonPath("$.amount", is(amount)));
//
//    }
}
