package com.iotpack.api.entity.project;


import com.iotpack.api.entity.base.BaseUserEntity;
import com.iotpack.api.entity.converter.HashMapConverter;
import com.iotpack.api.entity.user.UserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Set;

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

    String icon;


    /**
     * 简介
     */
    String remark;

    /**
     * 项目的配置信息
     */
//    @Convert(converter = HashMapConverter.class)
    HashMap<String,String> meta;
}
