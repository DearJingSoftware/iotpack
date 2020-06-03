package com.iotpack.api.service;

import java.util.List;

public interface OrganizationService {

    /**
     * 邀请某人加入组织
     * @param organizationId
     * @param userId
     */
    void  inviteUser(Long organizationId, List<Long> userId);

    /**
     * 接收邀请加入组织
     * @param userId
     * @param organizationId
     * @param inviteId
     */
    void  joinOrganization(Long userId, Long organizationId, Long inviteId);
}
