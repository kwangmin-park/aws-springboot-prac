package com.prac.aws.springboot.awsspringbootprac.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_test(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

//        assertj 테스트 라이브러리의 검증 메소드. mvc, api 테스트 과정이 필요없으므로 MockMvc 테스트는 불필요 하므로 assertThat으로 테스트 진행
//        메소드 체이닝이 지원되어 isEqualTo 와 같이 메소드를 이어서 사용할 수 있다.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
