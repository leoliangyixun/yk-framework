package com.yk.framework.validator;


public interface Validator<T> {
    boolean accept(ValidateContext context, T t);

    boolean validate(ValidateContext context, T t);

    void onException(ValidateContext context, Exception e, T t);

}
