package com.iotpack.api.entity.user;

import com.iotpack.api.entity.access.RoleEntity;
import com.iotpack.api.entity.base.BaseEntity;
import com.iotpack.api.entity.project.ProjectEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Data
@SQLDelete(sql = "update `user` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "user")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 用户所属组
     */
    Long groupId;
    /**
     * 登录账户
     */
    String account;
    /**
     * 显示的用户名
     */
    String username;
    /**
     * 密码
     */
    String password;
    /**
     * 头像
     */
    String avatar;
    /**
     * 微信openid
     */
    String openId;
    /**
     * 账号状态
     */
    Integer status;
    /**
     * 最后登录ip
     */
    String lastLoginIp;
    /**
     * 最后登录时间
     */
    Long lastLoginTime;

    /**
     * 是否需要更新密码
     */
    Boolean needResetPassword;

}
