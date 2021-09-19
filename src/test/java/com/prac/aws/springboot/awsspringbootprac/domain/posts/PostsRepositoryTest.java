package com.prac.aws.springboot.awsspringbootprac.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//별다른 설정없이 @SpringBootTest를 사용할 경우 H2 데이터베이스를 자동으로 실행
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

//    @After : Junit에서 단위 테스트가 끝날때마다 수행되는 메소드
//    보통 테스트 간 데이터 침범을 막기 위해 데이터 repo.deleteAll()로 사용
    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void load_board_save(){

        String title = "테스트 게시글";
        String content = "테스트 본문";

//        repo.save(Entity클래스.builder()) : posts 테이블에 insert/update. id 유무를 통해 upsert 결정
        postsRepository.save(Posts.builder()
                            .title(title)
                            .content(content)
                            .author("kwangmin@korea.ac.kr")
                            .build());

//        posts 테이블 모든 레코드 조회
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_regist(){
        LocalDateTime now = LocalDateTime.of(2021,8,18, 0,0,0);
        postsRepository.save(Posts.builder()
        .title("title")
        .content("content")
        .author("author")
        .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>> createDate = "+posts.getCreatedDate() + ", modifiedDate = "+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
