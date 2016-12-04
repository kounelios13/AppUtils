package com.AppUtils.crypto;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class CryptoTest {

	@Test
	public void test() throws NoSuchAlgorithmException, UnsupportedEncodingException {

		String message = "Hello world";
		String sha256 = null,
				sha512 = null;
		sha256 = CryptoUtils.stringTo256Hash(message);
		sha512 = CryptoUtils.stringTo512Hash(message);
		boolean ok = CryptoUtils.isHashCorrect(message, sha256, "SHA-256");
		boolean valid512 = CryptoUtils.isHashCorrect(message, sha512, "SHA-512");
		assertEquals("sha 256 working",ok,true);
		assertEquals("sha 512 working",valid512,true);
	}

}
