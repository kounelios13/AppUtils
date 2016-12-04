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
	
	/**
	 * Check if a given hash belongs to a given message
	 * 
	 * e.g. is the SHA-512 hash of foo F7FBBA6E0636F890E56FBBF3283E524C6FA3204AE298382D624741D0DC6638326E282C41BE5E4254D8820772C5518A2C5A8C0C7F7EDA19594A7EB539453E1ED7 ?
	 * @param text The text to produce the hash from
	 * @param hash the hash to compare to
	 * @param hashAlgorithm the name of the hash algorithm to be used
	 * @return true if the generated hash of text matches the given hash
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public boolean isHashCorrect(String text,String hash ,String hashAlgorithm) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		return stringToSpecificHash(hashAlgorithm,text).equals(hash);
		
	}
	private static String stringToSpecificHash(String hashAlgorithmName,String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		return DatatypeConverter.printHexBinary( 
		           MessageDigest.getInstance(hashAlgorithmName).digest(text.getBytes("UTF-8")));
	}
	
}
