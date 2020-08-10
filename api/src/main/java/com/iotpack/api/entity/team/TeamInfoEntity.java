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
public class TeamInfoEntity extends TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 成员数量
     */
    Integer memberCount;
}
