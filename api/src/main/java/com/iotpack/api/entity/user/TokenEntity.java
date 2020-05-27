package com.iotpack.api.entity.user;

import com.iotpack.api.entity.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Data
@SQLDelete(sql = "update `token` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "user")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class TokenEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    /**
     * 所属用户id
     */
    Long userId;

    /**
     * 用户token
     */
    String token;

}
