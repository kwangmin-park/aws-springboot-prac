package com.prac.aws.springboot.awsspringbootprac.config.auth;

import com.prac.aws.springboot.awsspringbootprac.config.auth.dto.OAuthAttributes;
import com.prac.aws.springboot.awsspringbootprac.config.auth.dto.SessionUser;
import com.prac.aws.springboot.awsspringbootprac.domain.user.User;
import com.prac.aws.springboot.awsspringbootprac.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId(); // 로그인 진행중인 서비스 구분코드. ex) 구글, 페이스북 ..

        // OAuth2 로그인 진행시 키가 되는 필드.
//        Primary Key와 같은 의미.
        String usernameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

//      OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담은 클래스.
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, usernameAttributeName, oAuth2User.getAttributes());

//        사용자 정보 db 반영
        User user = saveOrUpdate(attributes);

//        SessionUser : 사용자 정보를 세션에 저장하기 위한 Dto 클래스.
         httpSession.setAttribute("user", new SessionUser(user));

         return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())), attributes.getAttributes(), attributes.getNameAttributeKey());
    }

    private User saveOrUpdate(OAuthAttributes attributes){
        User user = userRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());
        return userRepository.save(user);
    }
}
