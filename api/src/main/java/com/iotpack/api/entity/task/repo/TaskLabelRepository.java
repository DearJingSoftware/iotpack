package com.iotpack.api.entity.task.repo;

import com.iotpack.api.entity.task.TaskLabelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskLabelRepository extends CrudRepository<TaskLabelEntity, Long>, JpaSpecificationExecutor<TaskLabelEntity>, JpaRepository<TaskLabelEntity, Long> {
}
