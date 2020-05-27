package com.iotpack.api.entity.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends CrudRepository<TokenEntity, Long>, JpaSpecificationExecutor<TokenEntity>, JpaRepository<TokenEntity, Long> {

    Optional<TokenEntity> findByToken(String token);

    Optional<TokenEntity> findByUserId(Long userId);

}
