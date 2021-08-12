package com.prac.aws.springboot.awsspringbootprac.web;

import com.prac.aws.springboot.awsspringbootprac.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
//각 메소드마다 @ResponseBody 어노테이션을 선언했던 것을 한번에 사용할 수 있게 만드는 역할
@RestController
public class HelloController {

//    HTTP Method 중 Get 요청을 받을 수 있는 API로 만들어준다.
//    GET 방식으로 /hello로 요청이 오면 문자열 hello를 반환하는 기능을 갖는다.
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
