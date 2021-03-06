package com.iotpack.api.entity.organization.repo;

import com.iotpack.api.entity.organization.OrganizationUserInviteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationUserInviteRepository extends
        CrudRepository<OrganizationUserInviteEntity, Long>,
        JpaSpecificationExecutor<OrganizationUserInviteEntity>,
        JpaRepository<OrganizationUserInviteEntity, Long> {
}
