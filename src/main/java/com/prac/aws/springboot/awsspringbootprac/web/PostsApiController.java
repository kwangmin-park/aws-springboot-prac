package com.prac.aws.springboot.awsspringbootprac.web;

import com.prac.aws.springboot.awsspringbootprac.service.posts.PostsService;
import com.prac.aws.springboot.awsspringbootprac.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
//    Bean 주입 방법
//    1. @Autowired 2. setter 3. 생성자
//    아래는 생성자로 Bean을 주입한 방식. @RequiredArgsConstructor는 final로 선언된 모든 필드를 인자값으로 하는 생성자를 생성
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
