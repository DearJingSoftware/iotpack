package com.iotpack.api.service.impl;


import com.iotpack.api.dto.auth.LoginDto;
import com.iotpack.api.entity.group.GroupRepository;
import com.iotpack.api.entity.user.TokenEntity;
import com.iotpack.api.entity.user.TokenRepository;
import com.iotpack.api.entity.user.UserEntity;
import com.iotpack.api.entity.user.UserRepository;
import com.iotpack.api.exception.BusinessException;
import com.iotpack.api.form.auth.LoginForm;
import com.iotpack.api.service.UserService;
import com.iotpack.api.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenRepository tokenRepository;



    @Override
    public LoginDto login(LoginForm loginForm) {

        LoginDto loginDto = new LoginDto();
        log.info("用户登录 "+loginForm.getUsername()+" "+loginForm.getPassword());

//        GroupEntity g= groupRepository.findByName(loginForm.getGroup())
//                .orElseThrow(()->new BusinessException("找不到"));
//        loginDto.setGroup(g);
        UserEntity u = userRepository.findFirstByAccountAndPassword(loginForm.getUsername(), loginForm.getPassword())
                .orElseThrow(()->new BusinessException("用户名或者密码错误"));

        loginDto.setUser(u);

        TokenEntity tokenEntity=new TokenEntity();
        tokenEntity.setUserId(u.getId());
        tokenEntity.setToken(TokenUtils.getToken());
        tokenRepository.save(tokenEntity);

        loginDto.setToken(tokenEntity.getToken());

        return loginDto;
    }

    @Override
    public Object logout(LoginDto loginDto) {
        tokenRepository.findById(loginDto.getId()).ifPresent(t->{
            tokenRepository.delete(t);
        });
        return true;
    }
}
