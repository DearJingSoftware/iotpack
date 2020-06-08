package com.iotpack.api.entity.access.repo;

import com.iotpack.api.entity.access.RolePermissionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionsRepository extends CrudRepository<RolePermissionsEntity, Long>,
        JpaSpecificationExecutor<RolePermissionsEntity>,
        JpaRepository<RolePermissionsEntity, Long> {
}
