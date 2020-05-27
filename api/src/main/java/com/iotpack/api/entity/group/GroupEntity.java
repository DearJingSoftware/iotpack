package com.iotpack.api.entity.group;


import com.iotpack.api.entity.base.BaseUserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;


@Data
@SQLDelete(sql = "update `group_info` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "group_info")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
@RedisHash
public class GroupEntity extends BaseUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 登录账户
     */
    String name;

    /**
     * 联系电话
     */
    String phone;

}
