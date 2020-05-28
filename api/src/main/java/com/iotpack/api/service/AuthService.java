package com.iotpack.api.service;

import com.iotpack.api.dto.auth.LoginDto;
import com.iotpack.api.entity.user.UserEntity;

public interface AuthService {
   LoginDto getUserInfo();
}
