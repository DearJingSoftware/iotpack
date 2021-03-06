package com.iotpack.api.entity.device.repo;

import com.iotpack.api.entity.device.DeviceCheckListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceCheckListRepository extends CrudRepository<DeviceCheckListEntity, Long>, JpaSpecificationExecutor<DeviceCheckListEntity>, JpaRepository<DeviceCheckListEntity, Long> {
}
