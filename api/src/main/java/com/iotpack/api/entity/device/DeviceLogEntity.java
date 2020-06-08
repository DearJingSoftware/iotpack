package com.iotpack.api.entity.device;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@SQLDelete(sql = "update `device_log` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "device_log")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class DeviceLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 设备id
     */
    Long deviceId;
    /**
     * 设备原始日志
     */
    String raw;
    /**
     * 创建时间
     */
    Long createdAt;
}
