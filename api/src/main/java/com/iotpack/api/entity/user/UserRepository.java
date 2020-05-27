package com.iotpack.api.entity.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity>, JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByToken(String token);

    Optional<UserEntity>   findByAccountAndPasswordAndGroupId(String account,String password,Long groupId);

}
