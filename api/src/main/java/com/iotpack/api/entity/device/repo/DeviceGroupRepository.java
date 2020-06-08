package com.iotpack.api.entity.device.repo;

import com.iotpack.api.entity.device.DeviceGroupEntity;
import com.iotpack.api.entity.device.DeviceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceGroupRepository extends CrudRepository<DeviceGroupEntity, Long>, JpaSpecificationExecutor<DeviceGroupEntity>, JpaRepository<DeviceGroupEntity, Long> {
}
