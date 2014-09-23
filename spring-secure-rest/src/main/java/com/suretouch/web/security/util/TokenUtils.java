package com.suretouch.web.security.util;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.codec.Hex;

public class TokenUtils {

	static Logger logger = LoggerFactory.getLogger(TokenUtils.class
			.getSimpleName());

	public static String magicString() {
		byte[] resBuf = new byte[5];
		new Random().nextBytes(resBuf);
		String resStr = new String(Hex.encode(resBuf));
		logger.debug(resStr);
		return resStr.toUpperCase();
	}

	public static String createToken(UserDetails userDetails, int expMinutes) {
		/* Expires in one hour */
		long expires = System.currentTimeMillis() + 1000L * 60 * expMinutes;

		StringBuilder token = new StringBuilder();
		token.append(magicString());
		token.append(":");
		token.append(expires);
		token.append(":");
		token.append(userDetails.getPassword().substring(0, 3));

		return new String(Base64.encode(token.toString().getBytes()));
	}

	public static String decodeToken(String authToken) {

		if (null == authToken) {
			return null;
		}
		logger.debug(" authToken  ::::  " + authToken);
		byte[] valueDecoded = Base64.decode(authToken.getBytes());
		logger.debug(" decoded value is " + new String(valueDecoded));
		return new String(valueDecoded);

	}

	public static boolean validateToken(String authToken,
			UserDetails userDetails) {
		authToken = decodeToken(authToken);
		String[] parts = authToken.split(":");
		long expires = Long.parseLong(parts[1]);
		String signature = parts[2];
		// validity check
		if (expires < System.currentTimeMillis()) {
			return false;
		}
		// someone changes password in between access denied thereafter
		return signature.equals(userDetails.getPassword().substring(0, 3));
	}
}