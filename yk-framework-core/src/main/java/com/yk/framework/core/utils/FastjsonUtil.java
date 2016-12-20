package com.yk.framework.core.utils;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastjsonUtil implements java.io.Serializable {
	
    private static final long serialVersionUID = -3968924571454391535L;

    public static String object2JSON(Object obj,SerializerFeature... serializerFeature) {
		if(obj == null){
			return "{}";
		}
		return JSON.toJSONString(obj,serializerFeature);
	}
	
	public static String object2JSON(Object obj) {
		if(obj == null){
			return "{}";
		}
		return JSON.toJSONString(obj,SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue);
	}
	

	public static <T>  T json2Object(String json,Class<T> clazz) {
		if(json == null || json.isEmpty()){
			return null;
		}
		return JSON.parseObject(json, clazz);
	}
	
	public static <T> T json2Reference(String json, TypeReference<T> reference){
		if(json == null || json.isEmpty()){
			return null;
		}
		return JSON.parseObject(json, reference);
	}
	
	public static Map<String, Object> json2Map(String json, Feature... features){
		if(json == null || json.isEmpty()){
			return null;
		}
		return JSON.parseObject(json, new TypeReference<Map<String, Object>>(){}, features);
	}
	
	public static Map<String, Object> json2Map(String json){
		if(json == null || json.isEmpty()){
			return null;
		}
		return JSON.parseObject(json, new TypeReference<Map<String, Object>>(){});
	}
	
	public static <T> T json2Reference(String json, TypeReference<T> reference, Feature... features){
		if(json == null || json.isEmpty()){
			return null;
		}
		return JSON.parseObject(json, reference, features);
	}
	
	public static <T> T deserialize(byte[] bytes){
		if(bytes == null){
			return null;
		}
		return JSON.parseObject(bytes, new TypeReference<T>(){}.getType());
	}
	
	public static <T> byte[] serialize(T t){
		if(t == null){
			return null;
		}
		return JSON.toJSONBytes(t, SerializerFeature.WriteClassName);
	}
}