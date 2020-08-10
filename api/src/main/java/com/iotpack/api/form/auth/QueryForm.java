package com.iotpack.api.form.auth;

import lombok.Data;

@Data
public class QueryForm {
    String keywords;

    Integer page;

    Integer pageSize;

    String sort;

    String order;
}
