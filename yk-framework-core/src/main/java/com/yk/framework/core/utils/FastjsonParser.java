package com.yk.framework.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @description:
 * @author: yangkai
 * @version: 1.0
 * @createdate: 2016年2月26日
 * Modification  History:
 * Date         Author        Version        Discription
 * -----------------------------------------------------------------------------------
 * 2016年2月26日       yangkai          1.0             Why & What is modified
 */
@Slf4j
public class FastjsonParser {

	public FastjsonParser() {
		
	}

	/**
	 * 可以转换基本类型, 如：String, Float, Boolean ......
	 * @param source
	 * @param key
	 * @param clazz
	 * @param <T>
     * @return
     */
	public static <T> T parse(String source, String key, Class<T> clazz) {
		JSONObject jo = JSONObject.parseObject(source);
		return jo.getObject(key, clazz);
	}

	/**
	 * 转换基本类型不能使用
	 * @param data  byte字节
	 * @param clazz 对象clazz引用
	 * @param <T>   泛型
	 * @return 泛型对应的具体类型
	 * @throws ClassCastException 转换异常
	 * @throws JSONException      json字符串异常，不符合json字符串
	 */
	public  static <T> T parseObject(byte[] data, Class<T> clazz) throws ClassCastException, JSONException {
		return parseObject(getString(data), clazz);
	}

	/**
	 * 转换基本类型不能使用
	 * @param data
	 * @param key
	 * @param clazz
	 * @param <T>
	 * @return
	 * @throws ClassCastException
	 * @throws JSONException
	 */
	public static <T> T parseObject(byte[] data, String key, Class<T> clazz) throws ClassCastException, JSONException {
		return parseObject(getString(data), key, clazz);
	}
	/**
	 * 转换基本类型不能使用
	 * @param source
	 * @param clazz
	 * @param <T>
	 * @return
	 * @throws ClassCastException
	 * @throws JSONException
	 */
	public static <T> T parseObject(String source, Class<T> clazz) throws ClassCastException, JSONException {
		if (StringUtils.isNotEmpty(source)) {
			try {
				return JSONObject.parseObject(source, clazz);
			} catch (ClassCastException e) {
				log.error("error:{}, source:{}", new Object[]{e, source});
			} catch (JSONException e) {
				log.error("error:{}, source:{}", new Object[]{e, source});
			}
		}

		return null;
	}

	/**
	 * 转换基本类型不能使用
	 * @param source
	 * @param key
	 * @param clazz
	 * @param <T>
	 * @return
	 * @throws ClassCastException
	 * @throws JSONException
	 */
	public static <T> T parseObject(String source, String key, Class<T> clazz) {
		if (StringUtils.isNotEmpty(source) && StringUtils.isNotEmpty(key)) {
			try {
				JSONObject jo = JSONObject.parseObject(source);
				String value = jo.getString(key);
				return parseObject(value, clazz);
			} catch (ClassCastException e) {
				log.error("error:{}, source:{}, key:{}", new Object[]{e, source, key});
			} catch (JSONException e) {
				log.error("error:{}, source:{}, key:{}", new Object[]{e, source, key});
			}
		}

		return null;
	}

	/**
	 * 转换成String，优先使用utf-8转换 ，失败获取系统默认编码转换
	 *
	 * @param data byte数据
	 * @return string
	 */
	public static String getString(byte[] data) {
		String str;
		try {
			if (null == data || data.length == 0) {
				return null;
			}
			str = new String(data, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			str = new String(data);
		}

		return str;
	}

	public static <T> List<T> parseArray(String source, Class<T> clazz) {
		if (StringUtils.isNotEmpty(source)) {
			try {
				return JSONObject.parseArray(source, clazz);
			} catch (ClassCastException e) {
				log.error("error:{}, source:{}", new Object[]{e, source});
			} catch (JSONException e) {
				log.error("error:{}, source:{}", new Object[]{e, source});
			}
		}

		return null;
	}

	public static <T> List<T> parseArray(String source, String key, Class<T> clazz) {
		if (StringUtils.isNotEmpty(source) && StringUtils.isNotEmpty(key)) {
			try{
				JSONObject jo = JSONObject.parseObject(source);
				String value = jo.getString(key);
				return parseArray(value, clazz);
			} catch (ClassCastException e) {
				log.error("error:{}, source:{}, key:{}", new Object[]{e, source, key});
			} catch (JSONException e) {
				log.error("error:{}, source:{}, key:{}", new Object[]{e, source, key});
			}
		}

		return null;
	}

	public static <T> List<T> parseArray(byte[] data, Class<T> clazz) {
		return parseArray(getString(data), clazz);
	}

	public static  <T> List<T> parseArray(byte[] data, String key, Class<T> clazz) {
		return parseArray(getString(data), key, clazz);
	}

	public static <T extends Serializable> String serialize(T source) {
		if (source == null) {
			return null;
		}

		String v = null;
		if (source instanceof String) {
			v = (String) source;
		} else {
			v = JSON.toJSONString(source, SerializerFeature.WriteClassName);
		}
		return v;
	}

    public static <T extends Serializable> T deserialize(String source, Class<T> clazz) {
		if (StringUtils.isBlank(source)) {
			return null;
		}

		try {
		    return JSONObject.parseObject(source, clazz);

		} catch (Exception e) {
			log.error("反序列化发生异常, 值:{}, 异常信息:{}", source, e.getMessage());
		}
		return null;
	}

}
