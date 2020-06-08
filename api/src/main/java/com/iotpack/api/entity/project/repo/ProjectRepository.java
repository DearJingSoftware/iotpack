package com.iotpack.api.entity.project.repo;

import com.iotpack.api.entity.project.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long>, JpaSpecificationExecutor<ProjectEntity>, JpaRepository<ProjectEntity, Long> {
}
