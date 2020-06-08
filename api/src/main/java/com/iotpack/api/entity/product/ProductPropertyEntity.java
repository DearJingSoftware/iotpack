package com.iotpack.api.entity.product;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 设备属性表
 */
@Data
@SQLDelete(sql = "update `product_property` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "product_property")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class ProductPropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long productId;

    /**
     * 属性的key
     */
    Long k;

    /**
     * 属性的名称
     */
    String name;

    /**
     * 如何定义属性
     */
    Long delimit;

    /**
     * 属性是否可观测
     */
    String observeAble;
}
