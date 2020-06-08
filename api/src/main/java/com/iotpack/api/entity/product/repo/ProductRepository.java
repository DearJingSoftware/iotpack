package com.iotpack.api.entity.product.repo;

import com.iotpack.api.entity.device.DeviceEntity;
import com.iotpack.api.entity.device.DeviceLogEntity;
import com.iotpack.api.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long>,
        JpaSpecificationExecutor<ProductEntity>,
        JpaRepository<ProductEntity, Long> {
}
