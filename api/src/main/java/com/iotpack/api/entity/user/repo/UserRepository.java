package com.iotpack.api.entity.user.repo;


import com.iotpack.api.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity>, JpaRepository<UserEntity, Long> {

    Optional<UserEntity>   findFirstByAccount(String account);
    Optional<UserEntity>   findFirstByAccountAndPassword(String account,String password);
}
