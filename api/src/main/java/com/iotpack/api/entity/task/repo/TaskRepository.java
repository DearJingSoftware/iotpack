package com.iotpack.api.entity.task.repo;

import com.iotpack.api.entity.device.DeviceCheckListEntity;
import com.iotpack.api.entity.task.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long>, JpaSpecificationExecutor<TaskEntity>, JpaRepository<TaskEntity, Long> {
}
