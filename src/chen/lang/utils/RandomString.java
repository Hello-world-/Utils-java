package chen.lang.utils;

import java.util.Random;

/**
 * 生成字母加数字指定位数的随机字符串
 */
public class RandomString {
	private static Random random = new Random();
	private static String map =
			"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String generate(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(map.charAt(random.nextInt(map.length())));
		}
		return sb.toString();
	}

	public static String generate(int minLength, int maxLength) {
		int length = minLength + random.nextInt(maxLength - minLength);

		return generate(length);
	}
	
	public static void main(String[] args) {
		System.out.println(generate(10));
		System.out.println(generate(3,7));
		System.out.println(generate(3,7));
		System.out.println(generate(3,7));
		System.out.println(generate(3,7));
	}
}
