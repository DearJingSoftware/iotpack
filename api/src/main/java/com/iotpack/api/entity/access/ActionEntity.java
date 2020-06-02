package com.iotpack.api.entity.access;

import com.iotpack.api.entity.base.BaseGroupEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@SQLDelete(sql = "update `action` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "action")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class ActionEntity extends BaseGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 角色名称
     */
    String name;

    /**
     * 动作描述
     */
    String description;

    /**
     * 角色状态
     */
    Integer status;
}
