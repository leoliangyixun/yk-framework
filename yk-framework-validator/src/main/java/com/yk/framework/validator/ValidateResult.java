package com.yk.framework.validator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class ValidateResult {

    private boolean success;

    private List<ValidateError> errors;

    private int timeElapsed;


    public void addError(ValidateError error) {
        if (CollectionUtils.isEmpty(errors)) {
            errors = new ArrayList<>();
        }
        errors.add(error);
    }
}
