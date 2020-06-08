package com.iotpack.api.entity.task;

import com.iotpack.api.entity.device.DeviceEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 任务分配表
 */
@Data
@SQLDelete(sql = "update `task_assign` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "task_assign")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class TaskAssignEntity {

    /**
     * 触发设备的消息id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 任务id
     */
    Long taskId;
    /**
     * 任务分配给某人
     */
    Long userId;
}
