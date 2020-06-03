package com.iotpack.api.entity.gateway;

import com.iotpack.api.entity.device.DeviceCheckListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayRepository extends CrudRepository<GatewayEntity, Long>, JpaSpecificationExecutor<GatewayEntity>, JpaRepository<GatewayEntity, Long> {
}
