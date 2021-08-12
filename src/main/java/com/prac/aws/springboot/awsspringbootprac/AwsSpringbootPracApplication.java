package com.prac.aws.springboot.awsspringbootprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBoot 자동 설정, Bean 읽기 생성 자동 설정. 아래 Annotation  위치부터 설정을 읽어가기 때문에 항상 프로젝트의 최상단에 위치해야한다.
@SpringBootApplication
public class AwsSpringbootPracApplication {

//	내장 WAS(Web Application Server) 실행. 서버에 톰캣을 설치할 필요 없고 스프링부트로 만등러진 Jar 파일로 실행가능 -> 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있다.
	public static void main(String[] args) {
		SpringApplication.run(AwsSpringbootPracApplication.class, args);
	}

}
