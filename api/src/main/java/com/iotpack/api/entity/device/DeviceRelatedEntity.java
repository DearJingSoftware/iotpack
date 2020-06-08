package com.iotpack.api.entity.device;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 设备分组关系表
 */
@Data
@SQLDelete(sql = "update `device_related` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "device_related")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class DeviceRelatedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 设备分组id
     */
    Long deviceGroupId;

    /**
     * 设备id
     */
    Long deviceId;

}
