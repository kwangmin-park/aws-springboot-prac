package com.prac.aws.springboot.awsspringbootprac.domain.posts;

import com.prac.aws.springboot.awsspringbootprac.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Getter: 클래스 내 모든 필드의 Getter Method 생성
//@NoArgsConstructor : 기본 생성자 자동 추가
//@Entity : DB의 테이블과 매칭되는 클래스. !주의! Entity Class는 Setter를 생성하지 않는다.
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

//    @Id : 테이블의 PK
//    @GeneratedValue : PK 생성 규칙. GenerationType.IDENTITY : Auto Increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column 사용하지 않은 경우 기본적으로 VARCHAR(255)
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

//    @Builder : 해당 클래스의 빌더 패턴 클래스 생성. 생성자와 달리 값을 설정할 필드를 명시할 수 있음.
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
