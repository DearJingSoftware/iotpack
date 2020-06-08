package com.iotpack.api.entity.organization;


import com.iotpack.api.entity.base.BaseUserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 组织 用户表
 */
@Data
@SQLDelete(sql = "update `organization_user` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "organization_user")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class OrganizationUserEntity extends BaseUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 项目id
     */
    Long organizationId;

    /**
     * 邀请人用户id
     */
    Long userId;

    /**
     * 邀请的时候发送的消息
     */
    Long message;
}
