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

@Data
@SQLDelete(sql = "update `menu` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "menu")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuEntity extends BaseGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 菜单名称
     */
    String name;

    /**
     *
     */
    String fid;
    /**
     *
     */
    String route;
    /**
     * icon 显示的 图标
     */
    String icon;
}
