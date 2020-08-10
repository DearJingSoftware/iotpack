package com.iotpack.api.service;

import com.iotpack.api.dto.auth.LoginDto;
import com.iotpack.api.entity.project.ProjectEntity;
import com.iotpack.api.form.auth.QueryForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProjectService {
    /**
     * 邀请某些人加入项目
     * @param projectId
     * @param userId
     */
    void  inviteUser(Long projectId, List<Long> userId);

    /**
     * 接收项目邀请加入项目
     * @param userId
     * @param projectId
     * @param inviteId
     */
    void  joinProject(Long userId,Long projectId,Long inviteId);

    /**
     * 获取项目列表
     * @param query
     * @return
     */
    Page<ProjectEntity> list(QueryForm query);

    /**
     * 获取我的全部项目列表
     * @param userInfo
     * @return
     */
    List<ProjectEntity> all(LoginDto userInfo);
}
