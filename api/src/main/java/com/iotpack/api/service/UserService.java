package com.iotpack.api.service;

import com.iotpack.api.dto.auth.LoginDto;
import com.iotpack.api.form.auth.LoginForm;
import com.iotpack.api.form.auth.LogoutForm;

public interface UserService {
    LoginDto login(LoginForm loginForm);

    Object logout(LogoutForm logoutForm);
}
