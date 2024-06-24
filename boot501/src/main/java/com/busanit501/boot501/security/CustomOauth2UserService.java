package com.busanit501.boot501.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomOauth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // userRequest, 카카오 로그인 관련 정보가 들어가 있다.
        log.info("CustomOauth2UserService : userRequest = " + userRequest);

        ClientRegistration clientRegistration = userRequest.getClientRegistration();
        String clientName = clientRegistration.getClientName();

        log.info("CustomOauth2UserService : clientRegistration : clientName = " + clientName);

        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> paramMap = oAuth2User.getAttributes();

        paramMap.forEach((k,v) -> {
            log.info("CustomOauth2UserService : k = " + k + " v = " + v);
        });

        return oAuth2User;
    }
}
