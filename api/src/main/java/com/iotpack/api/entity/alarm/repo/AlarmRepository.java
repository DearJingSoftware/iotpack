package com.iotpack.api.entity.alarm.repo;

import com.iotpack.api.entity.alarm.AlarmEntity;
import com.iotpack.api.entity.task.TaskAssignEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmRepository extends CrudRepository<AlarmEntity, Long>, JpaSpecificationExecutor<AlarmEntity>, JpaRepository<AlarmEntity, Long> {
}
