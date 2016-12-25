package com.yk.framework.validator;

/**
 *
 * @author yangkai
 */
public class ValidateError {

    private int errorCode;
    
    private String errorMsg;

    private String field;
 
    private Object invalidValue;

    @Override
    public String toString() {
        return "ValidateError{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", field='" + field + '\'' +
                ", invalidValue=" + invalidValue +
                '}';
    }


    public static ValidateError create(Integer errorCode, String errorMsg, String field, Object invalidValue) {
        
        ValidateError error = new ValidateError();
        error.setErrorCode(errorCode);
        error.setErrorMsg(errorMsg);
        error.setField(field);
        error.setInvalidValue(invalidValue);
        return error;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public ValidateError setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public ValidateError setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public String getField() {
        return field;
    }

    public ValidateError setField(String field) {
        this.field = field;
        return this;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }

    public ValidateError setInvalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
        return this;
    }
    


}
