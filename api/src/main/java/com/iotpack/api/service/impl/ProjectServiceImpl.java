package com.iotpack.api.service.impl;

import com.iotpack.api.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Override
    public void inviteUser(Long projectId, List<Long> userId) {

    }

    @Override
    public void joinProject(Long userId, Long projectId, Long inviteId) {

    }
}
