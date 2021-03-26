package com.example.chopeeservice.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class EncryptionUtil {
	/**
	 * Base64 encode
	 * */
	public static String base64Encode(String data){
		return Base64.encodeBase64String(data.getBytes());
	}
	
	/**
	 * Base64 decode
	 * @throws UnsupportedEncodingException 
	 * */
	public static String base64Decode(String data) throws UnsupportedEncodingException{
		// url格式编码转换
		String newData = URLDecoder.decode(data, "UTF-8");
		return new String(Base64.decodeBase64(newData.getBytes()),"utf-8");
	}
	
	/**
	 * md5
	 * */
	public static String md5Hex(String data){
		return DigestUtils.md5Hex(data);
	}
	
	/**
	 * sha1
	 * */
	public static String sha1Hex(String data){
		return DigestUtils.sha1Hex(data);
	}
	
	/**
	 * sha256
	 * */
	public static String sha256Hex(String data){
		return DigestUtils.sha256Hex(data);
	}

	/**
	 * 获取用户id
	 * @throws
	 * */
	public static Integer getUserIdFromCookie(HttpServletRequest request) {
		// 从cookie取用户信息
		Cookie[] cookies = request.getCookies();
		if (null == cookies) {
			return null;
		}
		String userInfo = null;
		for (Cookie item : cookies) {
			if ("userInfo".equals(item.getName())) {
				userInfo = item.getValue();
				break;
			}
		}

		if (null == userInfo) {
			return null;
		}
		Integer userId = null;
		try {
			userId = Integer.valueOf(EncryptionUtil.base64Decode(userInfo));

		} catch (IOException e) {
		}
		return userId;
	}


}
