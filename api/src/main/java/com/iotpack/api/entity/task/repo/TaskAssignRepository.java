package com.iotpack.api.entity.task.repo;

import com.iotpack.api.entity.task.TaskAssignEntity;
import com.iotpack.api.entity.task.TaskHandleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskAssignRepository extends CrudRepository<TaskAssignEntity, Long>, JpaSpecificationExecutor<TaskAssignEntity>, JpaRepository<TaskAssignEntity, Long> {
}
