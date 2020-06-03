package com.iotpack.api.entity.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends CrudRepository<OrganizationEntity, Long>, JpaSpecificationExecutor<OrganizationEntity>, JpaRepository<OrganizationEntity, Long> {
    Optional<OrganizationEntity> findByName(String groupName);
}
