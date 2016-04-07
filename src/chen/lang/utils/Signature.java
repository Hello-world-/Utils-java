package chen.lang.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;

/**
 * SHA1 签名相关操作
 * 
 * @author Lang
 *
 */
public class Signature {

	public static void main(String[] args) {
		Random random = new Random();
		String Timestamp = String.valueOf(System.currentTimeMillis());
		String Nonce = String.valueOf(random.nextInt(9999999));
		String sha1 = SHA1("Pk1hXTqPb5g" + Nonce + Timestamp);
		System.out.println(sha1);
	}
	
	private final static byte[] skey = { 108, 77, 21, 33, 16, 39, 22, 119 };
	private final static int skeyLen = skey.length;

	public static String dumpByteArray(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			byte b = bytes[i];
			int iVal = b & 0xFF;
			int byteN = Integer.parseInt(Integer.toBinaryString(iVal));
			sb.append(String.format("%1$02d: %2$08d %3$1c %3$d\n", i, byteN,
					iVal));
		}
		return sb.toString();
	}

	public static byte[] toMQttString(String s) {
		if (s == null) {
			return new byte[0];
		}
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(byteOut);
		try {
			dos.writeUTF(s);
			dos.flush();
		} catch (IOException e) {
			// SHould never happen;
			return new byte[0];
		}
		return byteOut.toByteArray();
	}

	public static String toString(byte[] data) {
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		DataInputStream dis = new DataInputStream(bais);
		try {
			return dis.readUTF();
		} catch (IOException e) {
		}
		return null;
	}

	public static byte[] obfuscation(byte[] data, int start) {
		int dataLen = data.length;
		int b = 0;
		for (int i = start; i < dataLen; i += skeyLen) {
			b = i;
			for (int j = 0; j < skeyLen && b < dataLen; j++, b++) {
				data[b] = (byte) (data[b] ^ skey[j]);
			}
		}
		return data;
	}
	
	
	public static String SHA1(String inStr) {
		 MessageDigest md = null;
		 String outStr = null;
		 try {
		 md = MessageDigest.getInstance("SHA-1"); //SHA-1，MD5
		 byte[] digest = md.digest(inStr.getBytes("utf-8")); 
		 outStr = Hex.encodeHexString(digest);
		 }
		 catch (Exception nsae) {
		 nsae.printStackTrace();
		 }
		 return outStr;
		 }
}
