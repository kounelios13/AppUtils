package com.AppUtils.crypto;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class CryptoUtils {

	/**
	 * 
	 * Generate a 256 Hash
	 * @param text Text to create the 256 hash from
	 * @return hash value of given text
	 * @throws NoSuchAlgorithmException Incorrect Hash Algorithm name
	 * @throws UnsupportedEncodingException Encoding is not supported
	 * */
	public static String stringTo256Hash(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		return stringToSpecificHash("SHA-256",text);
	}
	/**
	 * 
	 * Generate a 512 Hash
	 * @param text Text to create the 512 hash from
	 * @return hash value of given text
	 * @throws NoSuchAlgorithmException Incorrect Hash Algorithm name
	 * @throws UnsupportedEncodingException Encoding is not supported
	 * */
	public static String stringTo512Hash(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		return stringToSpecificHash("SHA-512",text);
	}
	/**
	 * 
	 * Generate a 384 Hash
	 * @param text Text to create the 384 hash from
	 * @return hash value of given text
	 * @throws NoSuchAlgorithmException Incorrect Hash Algorithm name
	 * @throws UnsupportedEncodingException Encoding is not supported
	 * */
	public static String stringTo384Hash(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		return stringToSpecificHash("SHA-384",text);
	}
	/**
	 * Generate hash of text
	 * @param hashAlgorithmName algorithm name
	 * @param text text to hash
	 * @return hash code of text
	 * @throws NoSuchAlgorithmException Incorrect Hash Algorithm name
	 * @throws UnsupportedEncodingException Encoding is not supported
	 * */
	private static String stringToSpecificHash(String hashAlgorithmName,String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		return DatatypeConverter.printHexBinary( 
		           MessageDigest.getInstance(hashAlgorithmName).digest(text.getBytes("UTF-8")));
	}
}
