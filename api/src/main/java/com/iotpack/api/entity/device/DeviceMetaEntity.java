package com.iotpack.api.entity.device;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 设备表
 */
@Data
@SQLDelete(sql = "update `device_meta` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "device_meta")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class DeviceMetaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    /**
     *  设备的非检索配置信息
     */
    @Column(columnDefinition = "json" )
    String meta;
}
