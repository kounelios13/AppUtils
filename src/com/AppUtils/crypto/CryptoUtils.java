package com.AppUtils.crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class CryptoUtils {

	public static String stringTo256Hash(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		return stringToSpecificHash("SHA-256",text);
	}
	public static String stringTo512Hash(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		return stringToSpecificHash("SHA-512",text);
	}
	public static String stringTo384Hash(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		return stringToSpecificHash("SHA-384",text);
	}
	public static String stringToSpecificHash(String hashAlgorithm,String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		return DatatypeConverter.printHexBinary( 
		           MessageDigest.getInstance(hashAlgorithm).digest(text.getBytes("UTF-8")));
	}
}
