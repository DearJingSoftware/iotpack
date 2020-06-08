package com.iotpack.api.entity.project;


import com.iotpack.api.entity.base.BaseUserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Data
@SQLDelete(sql = "update `project_user_invite` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "project_user_invite")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class ProjectUserInviteEntity extends BaseUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long projectId;

    Long userId;
    /**
     * 邀请的时候发送的消息
     */
    Long message;
}
