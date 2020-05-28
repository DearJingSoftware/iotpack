package com.iotpack.api.dto.auth;


import com.iotpack.api.entity.access.RoleEntity;
import com.iotpack.api.entity.group.GroupEntity;
import com.iotpack.api.entity.user.UserEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class LoginDto {
    Long id;
    String token;
    UserEntity user;
    GroupEntity group;
    List<RoleEntity> role=new ArrayList<>();
}
