package com.iotpack.api.entity.access.repo;

import com.iotpack.api.entity.access.ActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionsRepository extends CrudRepository<ActionEntity, Long>,
        JpaSpecificationExecutor<ActionEntity>,
        JpaRepository<ActionEntity, Long> {
}
