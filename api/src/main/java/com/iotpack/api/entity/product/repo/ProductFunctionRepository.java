package com.iotpack.api.entity.product.repo;

import com.iotpack.api.entity.product.ProductEntity;
import com.iotpack.api.entity.product.ProductEventEntity;
import com.iotpack.api.entity.product.ProductFunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFunctionRepository extends CrudRepository<ProductFunctionEntity, Long>,
        JpaSpecificationExecutor<ProductFunctionEntity>,
        JpaRepository<ProductFunctionEntity, Long> {
}
