package com.iotpack.api.service;

import com.iotpack.api.dto.auth.LoginDto;
import com.iotpack.api.form.auth.LoginForm;

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
}
