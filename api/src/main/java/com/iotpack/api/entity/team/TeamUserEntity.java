package com.iotpack.api.entity.team;


import com.iotpack.api.entity.base.BaseUserEntity;
import com.iotpack.api.entity.user.UserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 组织 用户表
 */
@Data
@SQLDelete(sql = "update `team_user` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "team_user")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class TeamUserEntity extends BaseUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 团队id
     */
    Long teamId;

    /**
     * 邀请人用户id
     */
    Long userId;
}
