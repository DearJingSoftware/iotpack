package com.iotpack.api.entity.access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@SQLDelete(sql = "update `role` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "role")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 角色名称
     */
    String name;

    /**
     * 角色描述
     */
    String description;

    /**
     * 角色状态
     */
    Integer status;

    /**
     * 角色权限
     */
    @Transient
    List<PermissionsEntity> permissions=new ArrayList<>();

    @Transient
    List<String> permissionList=new ArrayList<>();
}
