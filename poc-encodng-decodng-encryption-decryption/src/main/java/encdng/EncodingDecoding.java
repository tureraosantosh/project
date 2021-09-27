package encdng;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncodingDecoding {

	public static String encode(String text) {
		Encoder encoder = Base64.getEncoder();
		String encodeToString = encoder.encodeToString(text.getBytes());
		return encodeToString;
	}

	public static String decode(String encodedString) {
		Decoder decoder = Base64.getDecoder();
		byte[] decode = decoder.decode(encodedString.getBytes());
		return new String(decode);
	}
	
	
	public static void main(String[] args) {
		String encode = encode("Santosh@1234");
		System.out.println("Encoded :: "+encode);		
		String decode = decode(encode);
		System.out.println("Decoded :: "+decode);
	}

}
