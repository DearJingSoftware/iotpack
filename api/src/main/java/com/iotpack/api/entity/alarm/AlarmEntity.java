package com.iotpack.api.entity.alarm;

import com.iotpack.api.entity.device.DeviceEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 设备表
 */
@Data
@SQLDelete(sql = "update `alarm` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "alarm")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class AlarmEntity {

    /**
     * 触发设备的消息id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 消息id
     */
    Long mid;
    /**
     * 触发消息的设备
     */
    DeviceEntity device;

    /**
     * 文字描述;
     */
    String description;
}
