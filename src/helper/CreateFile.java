package helper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class CreateFile {
	public static void create(int i, String pass) {

		try {
			FileWriter obj = new FileWriter("password" + Integer.toString(i) + ".txt");
			FileWriter encObj = new FileWriter("encoded_password" + Integer.toString(i) + ".txt");
			String passEnc = Base64.getEncoder().encodeToString(pass.getBytes());
			obj.write(passEnc);
			passEnc = EncodedHelper.getSHA512(pass);
			encObj.write(passEnc);
			obj.close();
			encObj.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
