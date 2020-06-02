package com.iotpack.api.entity.access;

import com.iotpack.api.entity.base.BaseGroupEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@SQLDelete(sql = "update `permission` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "permission")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionsEntity extends BaseGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 显示的名称
     */
    String permissionName;

    /**
     * 权限名称
     */
    String permissionId;

    /**
     * 动作列表
     */
    @Transient
    List<ActionEntity> actions=new ArrayList<>();;
}
