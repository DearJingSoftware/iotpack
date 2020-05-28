package com.iotpack.api.entity.access;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@SQLDelete(sql = "update `user_role` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "user_role")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 用户id
     */
    Long userId;
    /**
     * 角色id
     */
    Long roleId;
}
