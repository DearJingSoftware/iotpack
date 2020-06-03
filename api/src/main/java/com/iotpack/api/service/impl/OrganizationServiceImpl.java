package com.iotpack.api.service.impl;

import com.iotpack.api.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {

    @Override
    public void inviteUser(Long organizationId, List<Long> userId) {

    }

    @Override
    public void joinOrganization(Long userId, Long organizationId, Long inviteId) {

    }
}
