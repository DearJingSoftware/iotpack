package com.iotpack.api.entity.device.repo;

import com.iotpack.api.entity.device.DeviceEntity;
import com.iotpack.api.entity.device.DeviceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTypeRepository extends CrudRepository<DeviceTypeEntity, Long>, JpaSpecificationExecutor<DeviceTypeEntity>, JpaRepository<DeviceTypeEntity, Long> {
}
