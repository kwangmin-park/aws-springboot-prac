package com.prac.aws.springboot.awsspringbootprac.service.posts;

import com.prac.aws.springboot.awsspringbootprac.domain.posts.PostsRepository;
import com.prac.aws.springboot.awsspringbootprac.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
