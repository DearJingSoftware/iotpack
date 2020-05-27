package com.iotpack.api.form.auth;

import lombok.Data;

@Data
public class LogoutForm {
    Long id;
    String token;
}
