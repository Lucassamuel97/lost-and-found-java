package br.edu.utfpr.alunos.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Generator {	
	public Sha256Generator() {
		// TODO Auto-generated constructor stub
	}
	
	public static String generate(String text) {
		MessageDigest sha256 = null;
		try {
			sha256 = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {			
			e.printStackTrace();
		}
		sha256.update(StandardCharsets.UTF_8.encode(text));
		return String.format("%032x", new BigInteger(1, sha256.digest()));
	}

}
