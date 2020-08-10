package com.iotpack.api.dto.user;

import lombok.Data;

@Data
public class UserDto {

    Long id;
    /**
     * 显示名称
     */
    String username;
    /**
     * 账户
     */
    String account;
    /**
     * 头像
     */
    String avatar;
}
