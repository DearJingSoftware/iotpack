package com.iotpack.api.entity.base;

import lombok.Data;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
@Data
public class BaseEntity {
    Long deletedUserId;
    Long deletedAt;
    Long updatedUserId;
    Long updatedAt;
    Long createdUserId;
    Long createdAt;
}
