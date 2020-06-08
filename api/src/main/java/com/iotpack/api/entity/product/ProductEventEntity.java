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
@SQLDelete(sql = "update `product_event` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "product_property")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class ProductEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long productId;


    String name;

}
