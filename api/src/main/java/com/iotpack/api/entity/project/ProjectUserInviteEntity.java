package com.iotpack.api.entity.project;


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
    /**
     * 发起邀请人
     */
    Long fromUserId;
    /**
     * 受邀请人
     */
    Long ToUserId;

    /**
     * true 已处理 false未处理
     */
    Boolean isProcess;
    /**
     * true 接受 false 拒绝
     */
    Boolean isAccept;
    /**
     * 邀请的时候发送的消息
     */
    Long message;

//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    ProjectEntity projectEntity;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    UserEntity userEntity;
}
