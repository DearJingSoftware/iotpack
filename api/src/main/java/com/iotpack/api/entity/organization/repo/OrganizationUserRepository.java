package com.iotpack.api.entity.organization.repo;


import com.iotpack.api.entity.organization.OrganizationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationUserRepository extends CrudRepository<OrganizationUserEntity, Long>, JpaSpecificationExecutor<OrganizationUserEntity>, JpaRepository<OrganizationUserEntity, Long> {
}
