package com.iotpack.api.entity.device;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@SQLDelete(sql = "update `device_checklist` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "group_info")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
/**
 * 设备类型清单
 */
public class DeviceCheckListEntity {

    String name;

    /**
     * 设备类型 烟感 燃气 门磁 手报 温度 湿度
     */
    Integer type;

    /**
     * 型号
     */
    String model;

    /**
     * 设备相关图标
     */
    String icon;

    /**
     * 厂商
     */
    String manufacturer;

    /**
     * 提供设备相关的功能 jar 包
     */
    String function;
}
