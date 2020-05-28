package com.iotpack.api.entity.access;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@SQLDelete(sql = "update `role` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "role")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 角色名称
     */
    String name;
}
