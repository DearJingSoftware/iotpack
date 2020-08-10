package com.iotpack.api.entity.project.repo;

import com.iotpack.api.entity.project.ProjectUserEntity;
import com.iotpack.api.entity.project.ProjectUserInviteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectUserRepository extends
        CrudRepository<ProjectUserEntity, Long>,
        JpaSpecificationExecutor<ProjectUserEntity>,
        JpaRepository<ProjectUserEntity, Long> {

    List<ProjectUserEntity> findAllByUserId(Long userId);
}
