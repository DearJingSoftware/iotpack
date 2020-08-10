package com.iotpack.api.entity.gateway;

import com.iotpack.api.entity.converter.HashMapConverter;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.util.HashMap;

@Data
@SQLDelete(sql = "update `gateway` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "gateway")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class GatewayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 网关的名称
     */
    String Name;
    /**
     * 网关的类型
     */
    String type;
    /**
     * 部署到机器的位置
     */
    String hostname;
    /**
     * 设备当前的状态
     */
    Integer status;
    /**
     * 网关的配置信息
     */
    @Convert(converter = HashMapConverter.class)
    HashMap<String,String> meta;
}
