package com.iotpack.api.entity.access.repo;

import com.iotpack.api.entity.access.UserRoleEntity;
import com.iotpack.api.entity.device.DeviceCheckListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Long>,
        JpaSpecificationExecutor<UserRoleEntity>,
        JpaRepository<UserRoleEntity, Long> {
}
