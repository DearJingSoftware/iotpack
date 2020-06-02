package com.iotpack.api.entity.project;


import com.iotpack.api.entity.base.BaseUserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Data
@SQLDelete(sql = "update `project` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "project")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class ProjectEntity extends BaseUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 登录账户
     */
    String name;

    /**
     * 联系电话
     */
    String phone;

}
