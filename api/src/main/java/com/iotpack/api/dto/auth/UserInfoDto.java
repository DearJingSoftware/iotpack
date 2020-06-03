package com.iotpack.api.dto.auth;

import com.iotpack.api.entity.access.RoleEntity;
import com.iotpack.api.entity.project.ProjectEntity;
import lombok.Data;

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
    /**
     * 用户项目列表
     */
    List<ProjectEntity> project;

}
