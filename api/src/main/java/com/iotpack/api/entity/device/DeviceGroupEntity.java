package com.iotpack.api.entity.device;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 设备分组表
 */
@Data
@SQLDelete(sql = "update `device_group` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "device_group")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class DeviceGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
}
