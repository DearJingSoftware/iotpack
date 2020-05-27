package com.iotpack.api.entity.device;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@SQLDelete(sql = "update `device` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "device")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class DeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    /**
     * 设备位置
     */
    String location;

    /**
     * 设备类型
     */
    Long deviceType;

    /**
     * 设备清单id
     */
    Integer deviceCheckListId;
}
