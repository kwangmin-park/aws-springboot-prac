package com.prac.aws.springboot.awsspringbootprac.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//선언된 모든 필드의 getter 메소드 생성
//선언된 모든 final 필드가 포함된 생성자 생성
//final 이 없는 필드는 생성자에 포함되지 않다.
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
