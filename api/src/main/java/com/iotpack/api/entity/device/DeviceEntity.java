package com.iotpack.api.entity.device;

import com.iotpack.api.entity.converter.HashMapConverter;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.util.HashMap;

/**
 * 设备表
 */
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
     * 经度
     */
    Double lon=113.62;
    /**
     * 纬度
     */
    Double lat=34.75;
    /**
     * 高度
     */
    Double ele=0.0;
    /**
     * 设备id
     */
    String deviceId;
    /**
     * 设备类型
     */
    Long deviceType;

    /**
     * 设备清单id
     */
    Integer deviceCheckListId;

    /**
     * 产品id
     */
    Long productId;
    /**
     * 产品id
     */
    Long gatewayId;

    /**
     * 设备缩水组织
     */
    Long organizationId;

    /**
     * 上级设备
     */
    Long superiorDeviceId;

    @Convert(converter = HashMapConverter.class)
    HashMap<String,Object> meta;
}
