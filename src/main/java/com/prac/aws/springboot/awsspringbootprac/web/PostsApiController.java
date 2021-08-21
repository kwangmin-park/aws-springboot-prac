package com.prac.aws.springboot.awsspringbootprac.web;

import com.prac.aws.springboot.awsspringbootprac.service.posts.PostsService;
import com.prac.aws.springboot.awsspringbootprac.web.dto.PostsResponseDto;
import com.prac.aws.springboot.awsspringbootprac.web.dto.PostsSaveRequestDto;
import com.prac.aws.springboot.awsspringbootprac.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
