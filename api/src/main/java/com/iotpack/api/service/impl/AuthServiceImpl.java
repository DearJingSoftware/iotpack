package com.iotpack.api.service.impl;

import com.iotpack.api.dto.auth.LoginDto;
import com.iotpack.api.entity.organization.repo.OrganizationRepository;
import com.iotpack.api.entity.user.TokenEntity;
import com.iotpack.api.entity.user.repo.TokenRepository;
import com.iotpack.api.entity.user.UserEntity;
import com.iotpack.api.entity.user.repo.UserRepository;
import com.iotpack.api.exception.BusinessException;
import com.iotpack.api.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.function.Supplier;


@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Override
    public LoginDto getUserInfo() {
        LoginDto loginDto=new LoginDto();
        String token;

//        token = httpServletRequest.getHeader("Authorization").split(" ")[1];
        if (httpServletRequest.getMethod().equals("GET")) {
            token = httpServletRequest.getParameter("token");
        } else {
            token = httpServletRequest.getHeader("Authorization").split(" ")[1];
        }

        if (ObjectUtils.isEmpty(token)) {
            throw new BusinessException("token不能为空");
        }

        TokenEntity tokenEntity= tokenRepository.findByToken(token).orElseThrow((Supplier<RuntimeException>) () -> new BusinessException("token 错误"));
        UserEntity u = userRepository.findById(tokenEntity.getUserId()).orElseThrow((Supplier<RuntimeException>) () -> new BusinessException("用户不存在"));
        BeanUtils.copyProperties(u,loginDto.getUser());
        loginDto.setToken(token);
        return loginDto;
    }

}
