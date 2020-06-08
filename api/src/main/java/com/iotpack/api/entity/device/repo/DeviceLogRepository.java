package com.iotpack.api.entity.device.repo;

import com.iotpack.api.entity.device.DeviceEntity;
import com.iotpack.api.entity.device.DeviceLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceLogRepository extends CrudRepository<DeviceLogEntity, Long>,
        JpaSpecificationExecutor<DeviceLogEntity>,
        JpaRepository<DeviceLogEntity, Long> {
}
