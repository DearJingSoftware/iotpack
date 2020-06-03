package com.iotpack.api.entity.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectUserInviteRepository extends
        CrudRepository<ProjectUserInviteEntity, Long>,
        JpaSpecificationExecutor<ProjectUserInviteEntity>,
        JpaRepository<ProjectUserInviteEntity, Long> {
}
