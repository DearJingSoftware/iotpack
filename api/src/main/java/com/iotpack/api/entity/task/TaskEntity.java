package com.iotpack.api.entity.task;

import com.iotpack.api.entity.device.DeviceEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 任务表
 */
@Data
@SQLDelete(sql = "update `task` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "task")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class TaskEntity {

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
    @Transient
    DeviceEntity device;

    /**
     * 触发设备的描述;
     */
    String description;
}
