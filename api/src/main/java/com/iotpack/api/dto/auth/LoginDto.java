package com.iotpack.api.dto.auth;


import com.iotpack.api.dto.menu.MenuTree;
import com.iotpack.api.dto.user.UserDto;
import com.iotpack.api.entity.access.RoleEntity;
import com.iotpack.api.entity.organization.OrganizationEntity;
import com.iotpack.api.entity.user.UserEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class LoginDto {
    String token;
    UserDto user=new UserDto();
    List<MenuTree> menus=new ArrayList<>();
}
