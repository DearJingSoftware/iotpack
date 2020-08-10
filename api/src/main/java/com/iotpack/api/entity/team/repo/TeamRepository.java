package com.iotpack.api.entity.team.repo;

import com.iotpack.api.entity.organization.OrganizationEntity;
import com.iotpack.api.entity.team.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<TeamEntity, Long>, JpaSpecificationExecutor<TeamEntity>, JpaRepository<TeamEntity, Long> {

}
