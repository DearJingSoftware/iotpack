package com.iotpack.api.entity.project;


import com.iotpack.api.entity.base.BaseUserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 项目邀请表
 */
@Data
@SQLDelete(sql = "update `project_user` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "project_user")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class ProjectUserEntity extends BaseUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 项目id
     */
    Long projectId;

    /**
     * 邀请人用户id
     */
    Long userId;


    /**
     * 默认项目
     */
    Boolean isPrimary;

}
