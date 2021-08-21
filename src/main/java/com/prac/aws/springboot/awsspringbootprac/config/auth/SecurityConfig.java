package com.prac.aws.springboot.awsspringbootprac.config.auth;

import com.prac.aws.springboot.awsspringbootprac.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService;

//@EnableWebSecurity : Spring Security 설정 활성화

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{

//        h2-console 화면을 사용하기 위해 아래 옵션 비활성화
//        .csrf().disable()
//                .headers().frameOptions().disable()
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests() // URL 별 권한 관리. authorizeRequests가 선언되어야 antMatchers 사용 가능
                    .antMatchers("/","/css/**","/images/**","/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated() //설정된 값 외의 모든 URL은 인증된 사용자들에게 허용(로그인한 사용자)
                .and()
                    .logout()
                        .logoutSuccessUrl("/") //로그아웃 성공시 "/"로 이동
                .and()
                    .oauth2Login() // oauth2 로그인 설정 진입점
                        .userInfoEndpoint() // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정 담당
                            .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치 진행할 UserService 인터페이스의 구현체 등록. 데이터를 불러와 DB에 넣는 등의 처리.
    }
}
