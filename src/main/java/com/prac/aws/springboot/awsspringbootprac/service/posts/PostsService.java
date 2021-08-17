package com.prac.aws.springboot.awsspringbootprac.service.posts;

import com.prac.aws.springboot.awsspringbootprac.domain.posts.Posts;
import com.prac.aws.springboot.awsspringbootprac.domain.posts.PostsRepository;
import com.prac.aws.springboot.awsspringbootprac.web.dto.PostsResponseDto;
import com.prac.aws.springboot.awsspringbootprac.web.dto.PostsSaveRequestDto;
import com.prac.aws.springboot.awsspringbootprac.web.dto.PostsUpdateRequestDto;
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

//    실제 update 쿼리를 날리는 코드가 없음
//    이는 JPA 영속성 때문인데, 트랜잭션안에서 엔티티 값이 변경된 경우
//    트랜잭션 종료 시점에 변경분이 데이터베이스에 반영된다.
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }
}
