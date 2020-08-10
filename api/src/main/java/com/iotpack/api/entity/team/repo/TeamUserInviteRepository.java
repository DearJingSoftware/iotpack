package com.iotpack.api.entity.team.repo;

import com.iotpack.api.entity.team.TeamUserEntity;
import com.iotpack.api.entity.team.TeamUserInviteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamUserInviteRepository extends CrudRepository<TeamUserInviteEntity, Long>,
        JpaSpecificationExecutor<TeamUserInviteEntity>,
        JpaRepository<TeamUserInviteEntity, Long> {
}
