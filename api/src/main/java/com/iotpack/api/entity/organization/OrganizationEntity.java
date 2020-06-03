package com.iotpack.api.entity.organization;


import com.iotpack.api.entity.base.BaseUserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Data
@SQLDelete(sql = "update `organization` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "organization")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class OrganizationEntity extends BaseUserEntity {

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
