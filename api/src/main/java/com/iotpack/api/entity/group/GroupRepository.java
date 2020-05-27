package com.iotpack.api.entity.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends CrudRepository<GroupEntity, Long>, JpaSpecificationExecutor<GroupEntity>, JpaRepository<GroupEntity, Long> {
    Optional<GroupEntity> findByName(String groupName);
}
