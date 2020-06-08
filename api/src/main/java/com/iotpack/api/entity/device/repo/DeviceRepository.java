package com.iotpack.api.entity.device.repo;

import com.iotpack.api.entity.device.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CrudRepository<DeviceEntity, Long>, JpaSpecificationExecutor<DeviceEntity>, JpaRepository<DeviceEntity, Long> {
}
