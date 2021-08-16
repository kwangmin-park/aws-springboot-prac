package com.prac.aws.springboot.awsspringbootprac.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//JpsRepository<Entity 클래스, PK 타입>
//repository : DB Layer 접근자. JpaRepository를 상속하면 @Repository를 추가할 필요도 없다.
//Entity 클래스와 Entity Repository는 함께 위치해야한다.
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
