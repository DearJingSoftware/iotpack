package com.iotpack.api.form.auth;

import lombok.Data;

@Data
public class LoginForm {
    String group;
    String account;
    String password;
}
