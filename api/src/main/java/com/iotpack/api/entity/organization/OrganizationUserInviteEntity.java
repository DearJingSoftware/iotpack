package com.iotpack.api.entity.organization;


import com.iotpack.api.entity.base.BaseUserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Data
@SQLDelete(sql = "update `organization_user_invite` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "organization_user_invite")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class OrganizationUserInviteEntity extends BaseUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long projectId;

    Long userId;
}
