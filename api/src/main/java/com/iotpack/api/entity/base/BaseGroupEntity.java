package com.iotpack.api.entity.base;

import lombok.Data;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
@Data
public class BaseGroupEntity extends BaseEntity {
    Long groupId;
}
