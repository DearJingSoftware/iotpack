package com.iotpack.api.entity.access;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@SQLDelete(sql = "update `role_permission` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "role_permission")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class RolePermissionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 用户id
     */
    Long roleId;
    /**
     * 权限id
     */
    Long permissionId;
}
