package com.iotpack.api.entity.device;

import com.iotpack.api.entity.group.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceCheckListRepository extends CrudRepository<DeviceCheckListEntity, Long>, JpaSpecificationExecutor<DeviceCheckListEntity>, JpaRepository<DeviceCheckListEntity, Long> {
}
