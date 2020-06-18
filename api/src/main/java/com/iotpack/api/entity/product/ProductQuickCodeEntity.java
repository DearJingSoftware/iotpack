package com.iotpack.api.entity.product;


import com.iotpack.api.entity.base.BaseUserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@SQLDelete(sql = "update `product_quick_code` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "product_quick_code")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class ProductQuickCodeEntity extends BaseUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 二维码
     */
    String code;

    /**
     * 二维码绑定的数据
     */
    String data;
}
