package com.iotpack.api.entity.access.repo;

import com.iotpack.api.entity.access.RoleEntity;
import com.iotpack.api.entity.device.DeviceCheckListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long>,
        JpaSpecificationExecutor<RoleEntity>,
        JpaRepository<RoleEntity, Long> {
}
