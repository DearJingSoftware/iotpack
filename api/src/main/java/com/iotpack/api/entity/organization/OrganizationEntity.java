package com.iotpack.api.entity.organization;


import com.iotpack.api.entity.base.BaseUserEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;


@Data
@SQLDelete(sql = "update `organization` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "organization")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
public class OrganizationEntity extends BaseUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     *  组织名称
     */
    String name;

    /**
     *  组织电话
     */
    String phone;

    /**
     * 组织机构的fid;
     */
    Long pid;

    /**
     * organization path
     */
    String path;


    /**
     * 组织机构的位置
     */
    String location;

    /**
     * 经度
     */
    Double lon=113.62;
    /**
     * 纬度
     */
    Double lat=34.75;
    /**
     * 高度
     */
    Double ele=0.0;

}
