package com.iotpack.api.entity.gateway;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;

@Data
@SQLDelete(sql = "update `gateway` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "gateway")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
@RedisHash
public class Gateway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String Name;
}
