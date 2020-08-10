package com.iotpack.api.service.impl;

import com.iotpack.api.dto.auth.LoginDto;
import com.iotpack.api.entity.project.ProjectEntity;
import com.iotpack.api.entity.project.ProjectUserEntity;
import com.iotpack.api.entity.project.repo.ProjectRepository;
import com.iotpack.api.entity.project.repo.ProjectUserRepository;
import com.iotpack.api.form.auth.QueryForm;
import com.iotpack.api.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ProjectUserRepository projectUserRepository;

    @Override
    public void inviteUser(Long projectId, List<Long> userId) {

    }

    @Override
    public void joinProject(Long userId, Long projectId, Long inviteId) {

    }

    @Override
    public Page<ProjectEntity> list(QueryForm query) {
        return null;
    }

    @Override
    public List<ProjectEntity> all(LoginDto userInfo) {
        List<Long> projectIds= projectUserRepository.findAllByUserId(userInfo.getUser().getId()).stream().map(ProjectUserEntity::getProjectId).collect(Collectors.toList());
        System.out.println(projectIds);
        return projectRepository.findAllByIdIn(projectIds);
    }
}
