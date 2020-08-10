package com.iotpack.api.entity.project;


import com.iotpack.api.entity.base.BaseEntity;
import com.iotpack.api.entity.base.BaseUserEntity;
import com.iotpack.api.entity.user.UserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 用户邀请表
 */
@Data
@SQLDelete(sql = "update `project_user` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "project_user")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class ProjectUserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long projectId;

//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    ProjectEntity projectEntity;


    Long userId;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    UserEntity userEntity;
}
