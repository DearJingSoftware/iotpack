package com.iotpack.api.entity.product;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 设备属性值观测表
 */
@Data
@SQLDelete(sql = "update `product_observe` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "product_observe")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class ProductObserveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String k;

    Long v;

    Long t;
}
