package com.yk.framework.validator;

import java.util.HashMap;
import java.util.Map;

public class ValidateContext {

    private Map<String, Object> contextData;

    public ValidateResult result;

    public void addErrorMsg(Integer errorCode, String errorMsg, String feild, Object invalidValue) {
        result.addError(ValidateError.create(errorCode,errorMsg, feild, invalidValue));
    }

    public void addError(ValidateError validateError) {
        result.addError(validateError);
    }

    public <V> V getAttribute(String key) {
        if (contextData != null && !contextData.isEmpty()) {
            return (V)contextData.get(key);
        }
        return null;
    }

    public void addContextData(String key, Object value) {
        if (contextData == null) {
        	contextData = new HashMap<String, Object>();
        }
        contextData.put(key, value);
    }

    public void setResult(ValidateResult result) {
        this.result = result;
    }
    
    public ValidateResult getResult() {
        return this.result;
    }
}
