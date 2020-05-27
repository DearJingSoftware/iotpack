package com.iotpack.api.dto.auth;


import com.iotpack.api.entity.group.GroupEntity;
import com.iotpack.api.entity.user.UserEntity;
import lombok.Data;


@Data
public class LoginDto {
    Long id;
    String token;
    UserEntity user;
    GroupEntity group;
}
