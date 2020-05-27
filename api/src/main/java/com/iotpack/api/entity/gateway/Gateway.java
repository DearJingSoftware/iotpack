package com.iotpack.api.entity.gateway;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@SQLDelete(sql = "update `gateway` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "gateway")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class Gateway {
    String Name;
}
