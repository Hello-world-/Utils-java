package chen.lang.utils;

import java.security.MessageDigest;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;

/**
 * SHA1/md5 签名<br>
 * secret + Nonce + Timestamp
 *
 */
public class Signature {

	public static void main(String[] args) {
		String secret = "Pk1hXTqPb5g";
		Random random = new Random();
		String Timestamp = String.valueOf(System.currentTimeMillis());
		String Nonce = String.valueOf(random.nextInt(9999999));
		String sha1 = Hash(secret + Nonce + Timestamp, "SHA-1");
		String md5 = Hash(secret + Nonce + Timestamp, "MD5");
		System.out.println(sha1);
		System.out.println(md5);
	}

	/**
	 * hash
	 * 
	 * @param inStr 内容
	 * @param Algorithm 算法名  SHA-1 MD5
	 * @return
	 */
	public static String Hash(String inStr, String Algorithm) {
		MessageDigest md = null;
		String outStr = null;
		try {
			md = MessageDigest.getInstance(Algorithm); 
			byte[] digest = md.digest(inStr.getBytes("utf-8"));
			outStr = Hex.encodeHexString(digest);
		} catch (Exception nsae) {
			nsae.printStackTrace();
		}
		return outStr;
	}
}
