package com.iotpack.api.entity.product.repo;

import com.iotpack.api.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPropertyRepository extends CrudRepository<ProductEntity, Long>,
        JpaSpecificationExecutor<ProductEntity>,
        JpaRepository<ProductEntity, Long> {
}
