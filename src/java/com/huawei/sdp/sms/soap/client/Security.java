package com.huawei.sdp.sms.soap.client;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

	public class Security {
		
		private static MessageDigest MD;
		static
		{
		try
		{
		MD = MessageDigest.getInstance("MD5");
		}
		catch (Exception e)
		{
		throw new RuntimeException("Get MD5 instance failed.");
		}
		}
		
		public final static String md5(String s)
		{
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
		'E', 'F' };
		try
		{
		byte[] strTemp = s.getBytes();
		MD.update(strTemp);
		byte[] md = MD.digest();
		int j = md.length;
		char str[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++)
		{
		byte byte0 = md[i];
		str[k++] = hexDigits[byte0 >>> 4 & 0xf];
		str[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(str);
		}
		catch (Exception e)
		{
		return null;
		}
		}
		public static byte[] encryptSHA1(String source) {
			try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			messageDigest.update(source.getBytes());
			return messageDigest.digest();
			} catch (NoSuchAlgorithmException e) {
			return null;
			} }
		public static String encryptBase64(byte[] source) {
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(source);
			}
		public static String encryptS1B(String srcPwd) {
			return encryptBase64(encryptSHA1(srcPwd));
			}
	}
