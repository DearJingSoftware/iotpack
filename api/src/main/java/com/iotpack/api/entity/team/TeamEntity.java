package com.iotpack.api.entity.team;


import com.iotpack.api.entity.base.BaseUserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Data
@SQLDelete(sql = "update `team` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "team")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class TeamEntity extends BaseUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     *  组织名称
     */
    String name;
    /**
     * 团队图标
     */
    String icon;
}
