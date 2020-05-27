package com.iotpack.api.entity.group;


import com.iotpack.api.entity.base.BaseUserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Data
@SQLDelete(sql = "update `group_info` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "group_info")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class GroupEntity extends BaseUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 登录账户
     */
    String name;
    /**
     * 客户登录账号
     */
    String groupAccount;

    /**
     * 联系电话
     */
    String phone;

    /**
     * 客户已经使用的设备数量
     */
    Integer deviceUseCount;

    /**
     * group 下面账户的数量
     */
    Long userCount;
    /**
     * 客户能使用的设备数量
     */
    Integer deviceCount;
    /**
     * 账户到期时间
     */
    Long startTime;
    /**
     * 账户到期时间
     */
    Long expireTime;

    /**
     * 客户类型  0 客户 1 服务商
     */
    @Column(nullable = false,columnDefinition = "integer default 1" )
    Integer type;

    /**
     * 代理商的用户id;
     */
    Long agentId;
    /**
     * 代理商的名称;
     */
    String agentName;

    /**
     * 授权协议
     */
    String LicenseInfo;
}
