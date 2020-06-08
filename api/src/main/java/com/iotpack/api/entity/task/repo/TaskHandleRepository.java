package com.iotpack.api.entity.task.repo;

import com.iotpack.api.entity.task.TaskEntity;
import com.iotpack.api.entity.task.TaskHandleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskHandleRepository extends CrudRepository<TaskHandleEntity, Long>, JpaSpecificationExecutor<TaskHandleEntity>, JpaRepository<TaskHandleEntity, Long> {
}
