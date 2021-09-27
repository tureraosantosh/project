package encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionAndDecrption {
	
	public static void main(String[] args) {
		
		try {
			String pwd="Santosh@123";
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			messageDigest.reset();
			messageDigest.update(pwd.getBytes());
			byte[] digest = messageDigest.digest();			
			String encrptedPass = new String(digest);
			System.out.println(encrptedPass);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
