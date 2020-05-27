package com.iotpack.api.service;

import com.iotpack.api.entity.group.GroupEntity;
import com.iotpack.api.entity.group.GroupRepository;
import com.iotpack.api.entity.user.TokenEntity;
import com.iotpack.api.entity.user.TokenRepository;
import com.iotpack.api.entity.user.UserEntity;
import com.iotpack.api.entity.user.UserRepository;
import com.iotpack.api.exception.BusinessException;
import com.iotpack.api.form.auth.LogoutForm;
import lombok.extern.slf4j.Slf4j;
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
    GroupRepository groupRepository;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Override
    public UserEntity getUserInfo() {
        String token = "";
        if (httpServletRequest.getMethod().equals("GET")) {
            token = httpServletRequest.getParameter("token");
        } else {
            token = httpServletRequest.getHeader("Authorization").split(" ")[1];
        }

        if (ObjectUtils.isEmpty(token)) {
            throw new BusinessException("token不能为空");
        }


        TokenEntity tokenEntity= tokenRepository.findByToken(token).orElseThrow((Supplier<RuntimeException>) () -> new BusinessException("用户不存在"));
        UserEntity u = userRepository.findById(tokenEntity.getId()).orElseThrow((Supplier<RuntimeException>) () -> new BusinessException("用户不存在"));

        GroupEntity g = groupRepository.findById(u.getGroupId()).orElseThrow((Supplier<RuntimeException>) () -> new BusinessException("账户到用户组"));
        u.setGroup(g);
        return u;
    }

}
