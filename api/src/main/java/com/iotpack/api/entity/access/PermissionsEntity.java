package com.iotpack.api.entity.access;

import com.iotpack.api.entity.base.BaseGroupEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Data
@SQLDelete(sql = "update `permission` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "permission")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class PermissionsEntity extends BaseGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 权限名称
     */
    String name;
}
