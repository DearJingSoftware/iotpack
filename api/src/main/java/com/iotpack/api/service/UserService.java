package com.iotpack.api.service;

import com.iotpack.api.dto.auth.LoginDto;
import com.iotpack.api.entity.user.UserEntity;
import com.iotpack.api.form.auth.LoginForm;

public interface UserService {

    LoginDto login(LoginForm loginForm);

    Object logout(LoginDto logoutForm);

}
