package com.prac.aws.springboot.awsspringbootprac.web;

import com.prac.aws.springboot.awsspringbootprac.service.posts.PostsService;
import com.prac.aws.springboot.awsspringbootprac.web.dto.PostsResponseDto;
import com.prac.aws.springboot.awsspringbootprac.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model){
//        mustache 스타터에 의해 index 앞에 /template/, 뒤에 .mustache 가 붙어 반환되어,
//        src/main/resources/templates/index.mustache로 전환되어 View Resolver 가 처리한다.
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
