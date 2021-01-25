package helper;

import java.util.*;

public class PasswordGenerator {
	public static String createPassword(int len) {

		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";

		String values = Capital_chars + Small_chars + numbers + symbols;
		// Using random method
		Random rndm_method = new Random();

		char[] password = new char[len];

		for (int i = 0; i < len; i++) {

			password[i] = values.charAt(rndm_method.nextInt(values.length()));

		}
		String pass = "";
		for (int i = 0; i < password.length; i++)
			pass = pass + Character.toString(password[i]);
		return pass;
	}
}
