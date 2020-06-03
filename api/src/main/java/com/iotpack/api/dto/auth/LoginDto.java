package com.iotpack.api.dto.auth;


import com.iotpack.api.entity.access.RoleEntity;
import com.iotpack.api.entity.organization.OrganizationEntity;
import com.iotpack.api.entity.user.UserEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class LoginDto {
    Long id;
    String token;
    UserEntity user;
    OrganizationEntity group;
    List<RoleEntity> role=new ArrayList<>();
}
