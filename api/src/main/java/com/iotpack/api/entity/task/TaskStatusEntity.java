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
@SQLDelete(sql = "update `task_status` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "task_status")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class TaskStatusEntity {

    /**
     * 触发设备的消息id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String color;
}
