package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaDemo {
	private static String src = "sha demo";
	
	public static void main(String[] args) {
		
	}
	
	public static void jdkSHA1(){
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(src.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
