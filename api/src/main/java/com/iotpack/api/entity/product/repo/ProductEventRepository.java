package com.iotpack.api.entity.product.repo;

import com.iotpack.api.entity.product.ProductEntity;
import com.iotpack.api.entity.product.ProductEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEventRepository extends CrudRepository<ProductEventEntity, Long>,
        JpaSpecificationExecutor<ProductEventEntity>,
        JpaRepository<ProductEventEntity, Long> {
}
