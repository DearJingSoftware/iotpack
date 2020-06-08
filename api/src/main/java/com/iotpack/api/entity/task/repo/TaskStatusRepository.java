package com.iotpack.api.entity.task.repo;

import com.iotpack.api.entity.task.TaskLabelEntity;
import com.iotpack.api.entity.task.TaskStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusRepository extends CrudRepository<TaskStatusEntity, Long>, JpaSpecificationExecutor<TaskStatusEntity>, JpaRepository<TaskStatusEntity, Long> {
}
