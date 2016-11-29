package com.yk.framework.model.rest;


import java.util.Date;

/**
 *API返回数据格式
 * 
 * @author yangkai
 *
 */

public class DataResult<T> {

	private int status;
	private String message;
	private T data;

	private Date time;

	public DataResult() {
	}

	public DataResult(int status, String message, T data) {
		this.data = data;
		this.status = status;
		this.message = message;
		this.setTime(new Date());
	}

	public DataResult(T data) {
		this.data = data;
	}


	public static DataResult fail(int status, String message, Object result) {
		return new DataResult(status, message, result);
	}

	public static  DataResult fail(String message) {
		DataResult result = new DataResult(message);
		result.setStatus(-1);
		return result;
	}

	public static DataResult fail(int status, String message) {
		DataResult result = new DataResult();
		result.setStatus(status);
		result.setMessage(message);
		return result;
	}
	
	public static DataResult ok() {
        DataResult result = new DataResult();
        result.setMessage("success");
        return result;
	}
	
	
	public static DataResult ok(Object data) {
		DataResult result = new DataResult();
		result.setStatus(0);
		result.setMessage("success");
		result.setData(data);
		return result;
	}
	
    public static <T> DataResult<T> ok(String message, T data) {
        DataResult result = new DataResult();
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    
    public static <T>  DataResult<T> ok(Integer status,String message, T data) {
        DataResult<T> result = new DataResult();
        result.setStatus(status);
        result.setMessage(message);
        result.setData(data);
		result.setTime(new Date());
        return result;
    }
	
	public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
	public String toString() {
		return "DataResult{" + "status =" + status + ", message =" + message + ", data ='" + data + "', time = "+ time + "}";
	}
}
