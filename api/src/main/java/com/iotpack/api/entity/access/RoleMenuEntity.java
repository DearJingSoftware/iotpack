package com.iotpack.api.entity.access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@SQLDelete(sql = "update `role_menu` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "role_menu")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleMenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 用户id
     */
    Long roleId;
    /**
     * 菜单id;
     */
    Long menuId;
}
