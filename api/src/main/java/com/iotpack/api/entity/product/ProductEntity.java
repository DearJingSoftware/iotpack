package com.iotpack.api.entity.product;


import com.iotpack.api.entity.base.BaseUserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Data
@SQLDelete(sql = "update `product` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "product")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class ProductEntity extends BaseUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 产品名称
     */
    String name;

    /**
     * 应用使用的协议
     */
    String applicationProtocol;
}
