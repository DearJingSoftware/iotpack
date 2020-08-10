package com.iotpack.api.controller.product.form;

import com.iotpack.api.form.auth.QueryForm;
import lombok.Data;
import lombok.NonNull;

@Data
public class ProductListQueryForm  extends QueryForm {
    String keywords;

    @NonNull
    Integer page;

    @NonNull
    Integer pageSize;
}
