package com.iotpack.api.dto.auth;

import com.iotpack.api.entity.access.RoleEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserInfoDto {
    Long id;
    String name;
    String username;
    String password;
    String avatar;
    Integer status;
    String lastLoginIp;
    Long lastLoginTime;
    RoleEntity role=new RoleEntity();

}
