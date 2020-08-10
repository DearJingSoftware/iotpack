package com.iotpack.api.entity.team.repo;

import com.iotpack.api.entity.team.TeamEntity;
import com.iotpack.api.entity.team.TeamUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamUserRepository extends CrudRepository<TeamUserEntity, Long>, JpaSpecificationExecutor<TeamUserEntity>, JpaRepository<TeamUserEntity, Long> {

}
