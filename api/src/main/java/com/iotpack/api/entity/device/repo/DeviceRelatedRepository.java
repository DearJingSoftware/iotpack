package com.iotpack.api.entity.device.repo;

import com.iotpack.api.entity.device.DeviceRelatedEntity;
import com.iotpack.api.entity.device.DeviceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRelatedRepository extends CrudRepository<DeviceRelatedEntity, Long>, JpaSpecificationExecutor<DeviceRelatedEntity>, JpaRepository<DeviceRelatedEntity, Long> {
}
