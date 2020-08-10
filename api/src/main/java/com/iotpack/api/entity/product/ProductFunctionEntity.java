package com.iotpack.api.entity.product;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 设备功能特性表
 */
@Data
@SQLDelete(sql = "update `product_function` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "product_function")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class ProductFunctionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long productId;
    /**
     * 属性的名称
     */
    String name;
}
