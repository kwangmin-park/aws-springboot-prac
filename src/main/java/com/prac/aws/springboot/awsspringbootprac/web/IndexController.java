package com.prac.aws.springboot.awsspringbootprac.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
//        mustache 스타터에 의해 index 앞에 /template/, 뒤에 .mustache 가 붙어 반환되어,
//        src/main/resources/templates/index.mustache로 전환되어 View Resolver 가 처리한다.
        return "index";
    }
}
