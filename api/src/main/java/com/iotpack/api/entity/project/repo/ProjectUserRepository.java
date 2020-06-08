package com.iotpack.api.entity.project.repo;

import com.iotpack.api.entity.project.ProjectUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectUserRepository extends CrudRepository<ProjectUserEntity, Long>, JpaSpecificationExecutor<ProjectUserEntity>, JpaRepository<ProjectUserEntity, Long> {
}
