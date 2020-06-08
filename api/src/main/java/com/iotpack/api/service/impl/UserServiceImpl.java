package com.iotpack.api.service.impl;


import com.iotpack.api.dto.auth.LoginDto;
import com.iotpack.api.dto.auth.UserInfoDto;
import com.iotpack.api.entity.access.PermissionsEntity;
import com.iotpack.api.entity.access.RoleEntity;
import com.iotpack.api.entity.organization.repo.OrganizationRepository;
import com.iotpack.api.entity.user.TokenEntity;
import com.iotpack.api.entity.user.repo.TokenRepository;
import com.iotpack.api.entity.user.UserEntity;
import com.iotpack.api.entity.user.repo.UserRepository;
import com.iotpack.api.exception.BusinessException;
import com.iotpack.api.form.auth.LoginForm;
import com.iotpack.api.service.UserService;
import com.iotpack.api.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    OrganizationRepository organizationRepository;

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

    @Override
    public Object getInfo(LoginDto userInfo) {
        UserInfoDto  userInfoDto=new UserInfoDto();

        getRole(userInfoDto);
        BeanUtils.copyProperties(userInfo.getUser(),userInfoDto);
        userInfoDto.setName(userInfo.getUser().getAccount());

        List<String> p= new ArrayList<>();
        p.add("dashboard");
        p.add("exception");
        p.add("result");
        p.add("profile");
        p.add("table");
        p.add("form");
        p.add("permission");
        p.add("role");
        p.add("user");
        p.add("support");

        RoleEntity role= RoleEntity.builder().id(1L).name("管理员").status(1).permissionList(p).description("管理员").build();
        role.setName("admin");

        List<PermissionsEntity> permissionsEntities=new ArrayList<>();
        permissionsEntities.add(PermissionsEntity.builder().permissionId("dashboard").actions(new ArrayList<>()).permissionName("permissionName").build());
        permissionsEntities.add(PermissionsEntity.builder().permissionId("exception").actions(new ArrayList<>()).permissionName("permissionName").build());
        permissionsEntities.add(PermissionsEntity.builder().permissionId("profile").actions(new ArrayList<>()).permissionName("permissionName").build());
        permissionsEntities.add(PermissionsEntity.builder().permissionId("result").actions(new ArrayList<>()).permissionName("permissionName").build());
        permissionsEntities.add(PermissionsEntity.builder().permissionId("table").actions(new ArrayList<>()).permissionName("permissionName").build());
        permissionsEntities.add(PermissionsEntity.builder().permissionId("form").actions(new ArrayList<>()).permissionName("permissionName").build());
        permissionsEntities.add(PermissionsEntity.builder().permissionId("permission").actions(new ArrayList<>()).permissionName("permissionName").build());
        permissionsEntities.add(PermissionsEntity.builder().permissionId("role").actions(new ArrayList<>()).permissionName("permissionName").build());
        permissionsEntities.add(PermissionsEntity.builder().permissionId("user").actions(new ArrayList<>()).permissionName("permissionName").build());
        permissionsEntities.add(PermissionsEntity.builder().permissionId("support").actions(new ArrayList<>()).permissionName("permissionName").build());

        role.setPermissions(permissionsEntities);
        userInfoDto.setRole(role);

        return  userInfoDto;
    }
    void  getRole(UserInfoDto userInfoDto){

    }
    void getPermissions(){
//        PermissionsEntity permissionsEntity=new PermissionsEntity();
//        permissionsEntity.
    }
}
