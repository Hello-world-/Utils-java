package chen.lang.utils;

import java.util.Stack;

/**
 * 字符串和Long一一匹配和转换
 *
 */
public class AppIdMapper {
	private static char[][] mapper = {
			{ '6', 'p', 'e', '5', 'b', 'm', 'o', '0', 'd', '3', 'l', '1', 'r', 'k', 'c', 'q', 'x', 'y', 'g', 'a', 'z',
					'u', 'n', '7', 'j', '8', 's', '9', '4', 'v', 'i', 'h', '2', 'f', 'w', 't' },
			{ 'h', 'i', '1', '9', 'x', '7', 'm', 'u', 'j', 'c', 'e', 'd', '4', 'n', 'z', '3', 'a', 't', 'w', '0', 'b',
					'r', '8', '5', 'g', 'q', 's', 'y', 'l', 'p', 'v', 'o', '6', '2', 'k', 'f' },
			{ 'e', '3', 'r', '6', 'k', 'z', 'c', '2', 'v', 't', '9', 'n', 'h', '5', 'y', 'w', '8', 'o', 'x', 'b', 'l',
					'7', '1', 'i', 'p', 'g', 'f', 's', 'q', 'm', '0', 'd', 'u', '4', 'a', 'j' },
			{ 'i', 't', 'r', 's', 'e', '9', 'b', '0', '5', '1', '8', 'g', 'j', 'l', 'a', '6', 'w', '3', 'p', 'k', '4',
					'z', 'u', 'o', 'c', 'v', '2', 'n', 'y', 'x', 'q', 'h', '7', 'f', 'd', 'm' },
			{ 'i', 'k', '1', 'q', 'u', '3', 'y', '8', 'b', 'j', 'm', 'f', '7', '2', 't', 'a', 'p', 'r', 'd', 'w', 's',
					'o', 'z', 'x', '6', 'h', 'g', 'v', '4', 'c', 'n', '9', 'e', 'l', '5', '0' },
			{ '8', 'm', 'u', 'b', '5', 's', '9', 'x', 'v', 'i', 'f', 'r', '6', 'k', '2', '4', '3', 'q', '0', 'g', 'h',
					'c', 't', 'd', '1', 'a', 'z', 'e', 'o', 'j', 'w', 'p', 'n', 'l', '7', 'y' },
			{ 't', 'v', 'r', 'k', 'x', 'i', 'u', 'y', '9', 'm', 'c', '5', 'j', '7', 'w', '6', 's', 'z', 'h', '0', 'e',
					'1', '2', 'g', '3', 'o', 'a', 'l', 'b', '8', '4', 'd', 'f', 'q', 'n', 'p' },
			{ 'y', 'z', 'v', 'b', 'p', 'm', 't', 's', 'n', 'h', 'o', 'w', '8', 'r', 'x', '0', 'j', 'l', 'q', 'k', '9',
					'e', 'd', 'a', 'g', '5', '2', '7', 'i', '1', '4', '6', 'u', 'f', '3', 'c' },
			{ 'h', 'l', 'x', 'g', 'q', 'v', 'b', '9', 'p', 'y', '8', 's', 'r', 'j', 'd', 't', '2', '1', 'w', 'a', 'f',
					'n', 'o', '7', '3', 'u', '6', 'e', '5', 'i', '0', 'z', 'c', '4', 'm', 'k' },
			{ 'm', '8', 'r', 'f', 'w', 'a', 'n', 'h', 'g', '2', '4', 's', '6', 'v', '1', 'e', 'c', '5', '7', 'u', 'x',
					'9', 'y', 'k', '0', 'l', 'o', 'q', 'i', 'z', 'd', '3', 'j', 't', 'b', 'p' },
			{ 'a', '8', 'u', 'v', '3', 'e', 'z', 'q', 'c', '1', 'f', '0', 'x', 'g', '2', 'i', '9', 'y', 'p', 'k', 'n',
					'o', '7', 'h', 'd', 'w', '6', '4', 'b', 'j', 'r', 's', 't', 'm', 'l', '5' },
			{ 'c', 'u', 'd', 'x', 'y', '9', 'b', 'o', '2', '6', '3', 'j', 'l', 'n', 'i', 'z', 't', '8', '0', 's', '4',
					'm', '7', 'f', 'a', '1', 'k', '5', 'q', 'p', 'v', 'r', 'e', 'h', 'w', 'g' },
			{ 'm', 'p', 'x', 'j', 'y', '6', '4', 'a', 'q', 'r', '8', '5', '2', 'b', 'z', 's', '9', 'n', '1', '7', 't',
					'0', 'h', 'f', 'u', 'd', 'w', 'e', 'o', '3', 'i', 'c', 'g', 'k', 'v', 'l' },
			{ 'b', 'x', 'v', 'p', 'a', 'e', 'd', 's', 'o', 'c', 'r', '6', 'i', 't', 'y', 'm', 'n', '3', '1', 'q', 'j',
					'5', '8', '9', 'u', 'k', 'w', 'g', 'z', 'f', '2', '7', '0', 'h', '4', 'l' },
			{ 'w', 'x', '8', 'f', '7', 'p', 'g', 'm', '0', 'u', 'h', 'd', '2', 'e', 'o', 's', 't', 'r', 'v', 'q', '9',
					'i', 'a', 'z', 'k', 'y', '4', '5', 'c', 'b', 'n', '6', 'j', 'l', '1', '3' },
			{ 'w', 'e', 'x', 'f', 'k', 'z', 'o', 'q', 'l', '5', 'n', 'j', '7', '1', 'm', 'i', '8', 'u', 'y', 'c', '6',
					'r', '3', 's', '2', '9', 'v', 'p', 'b', '4', 't', 'g', 'h', 'a', '0', 'd' },
			{ 'g', '8', 'h', 'u', 't', 'q', 'f', 'l', '0', '4', '9', '7', 'o', 'j', 'z', 'i', 'b', 'r', 'w', '5', 'c',
					's', 'p', '6', 'n', 'e', '1', 'v', 'x', 'y', 'd', 'k', '3', 'm', '2', 'a' },
			{ 'v', '8', '7', 'b', '9', 'h', 'e', 'u', 't', '1', 'k', '0', '6', 'r', 's', 'n', 'm', 'o', '4', 'q', 'l',
					'g', '5', 'p', 'x', 'j', 'i', 'z', '3', '2', 'c', 'a', 'd', 'y', 'w', 'f' },
			{ 'k', 'm', 'b', 'n', 'z', 't', 'x', '0', '9', 'j', '5', 's', 'h', 'r', 'u', 'l', 'p', 'q', 'a', '1', 'i',
					'o', '2', 'c', '6', '7', '8', 'e', 'd', '4', 'w', 'f', 'v', 'y', 'g', '3' },
			{ 'o', 'e', 't', 'p', 'k', 'h', 'd', 'w', 'f', '0', 'x', '9', 'j', 'z', 'm', '2', 's', '7', 'u', 'v', 'l',
					'n', '3', 'y', '1', '4', '8', 'b', 'c', '6', 'q', 'i', 'a', 'g', '5', 'r' },
			{ 'p', '0', 'n', 'd', 's', '9', 'k', '2', 'w', 'f', '5', 'x', 'z', 'y', 'h', 'b', '4', '7', 'o', 'a', 'u',
					'r', 't', '1', 'm', 'j', 'l', 'i', '3', '6', 'g', 'e', 'c', '8', 'v', 'q' },
			{ '6', 'p', 'y', 'q', '7', 'w', 'l', '0', 'x', '4', 'r', 'k', 'd', '3', 'i', 'h', 'j', 'v', 'a', 't', 'z',
					'c', 'b', 's', '1', 'u', '2', 'm', '5', 'e', '9', 'o', '8', 'f', 'g', 'n' },
			{ 'x', 'c', 'j', 'l', 'z', 'n', 'b', 'g', 'd', 'e', '5', 'q', '0', 'y', 'o', 'k', '9', 'u', 'a', 'r', 'v',
					'w', 'i', '8', 'f', '2', 'm', 'h', 't', '7', '1', '3', '6', '4', 'p', 's' },
			{ 'm', '6', 'n', 'r', 'e', 'o', 'z', 'a', 'x', 'v', 's', '8', 'd', 'w', '9', '7', '2', '3', '1', 'b', '0',
					'i', 'l', 'k', 'q', 'y', 'h', 'f', 'p', '4', 'c', 'u', 'j', 'g', 't', '5' },
			{ 'b', 'c', 'k', 'd', 'l', 'g', 'i', 'u', '0', '5', 'h', '7', 'z', 'n', 't', 'w', '8', 's', '3', 'r', '1',
					'p', 'f', 'j', 'a', 'q', '6', '2', '4', 'o', 'm', 'x', 'v', 'e', '9', 'y' },
			{ 'g', 'p', 'f', 't', '6', 'l', 'b', 'd', '1', 'x', 'q', 'm', 'n', 'u', '7', 'a', '4', 'y', 'j', 's', '3',
					'v', 'h', 'e', 'i', 'c', '5', '8', 'z', 'o', '2', '0', '9', 'r', 'k', 'w' },
			{ 'h', 'b', 'd', 'p', 'o', '3', '4', 'w', 'l', 'u', 'c', 'v', '9', 'k', '0', '5', 'x', 'j', 's', '6', '7',
					'y', 'n', '2', '8', 'e', 'f', 'a', 'g', 'r', '1', 'z', 'i', 't', 'm', 'q' },
			{ 'm', 'n', '9', '5', 'u', 'g', 'z', '3', 'o', '7', 'k', 'f', 'v', '2', 't', 'p', 'q', '4', 'c', 'y', '6',
					'w', 'h', 'r', 'x', 'j', 'b', '0', 'a', '8', 's', 'l', 'e', 'd', '1', 'i' },
			{ 'i', 'p', 't', 's', 'u', 'g', 'w', 'z', '1', '3', '0', '2', 'y', '7', 'o', 'x', 'b', '8', '9', 'd', 'r',
					'f', 'c', 'a', 'k', 'v', 'l', 'q', 'e', 'n', 'h', 'm', '4', 'j', '5', '6' },
			{ 'w', 'y', '4', '8', 'k', 'x', 'e', 'a', 'b', 'p', 'z', 'i', '6', 'c', 'l', 's', 'v', '3', 'f', 'm', '0',
					'n', '9', '2', 'g', '5', 'd', 'h', 'q', 'j', '1', 'r', 't', 'u', '7', 'o' },
			{ '5', 's', 'c', '7', 'v', '2', 'n', 'z', 'b', 'p', 'h', 'r', 'u', '9', 'l', 't', 'k', 'w', '0', 'a', 'e',
					'd', 'y', 'm', 'g', 'i', 'j', 'x', '3', '8', '4', '1', 'o', 'q', 'f', '6' },
			{ '5', 'q', '3', 'j', 'y', 'u', '1', 'm', 'r', 'k', 'i', 'a', 'l', 'o', 'x', 'c', 'n', '2', 'g', 'b', 't',
					'v', 'z', '4', '7', 'd', '8', '9', 'w', 'h', 's', '0', 'e', 'p', 'f', '6' },
			{ 'w', 'k', '7', 'o', 'v', 'b', 't', '0', '6', 'r', 'c', 'z', 'd', 'e', 'l', '9', 'u', 'q', 'f', '8', '5',
					'2', 'p', 'm', 'x', 's', 'a', 'n', '3', '1', 'i', 'h', 'y', '4', 'j', 'g' },
			{ 'y', 'q', '4', 'f', 'c', '8', '7', 'j', 's', 'o', '2', 'v', 'l', 'g', 'm', 'n', 'b', '5', 'z', 'r', 't',
					'1', 'a', '9', 'k', '6', 'w', 'x', 'p', 'i', 'h', 'e', '3', '0', 'd', 'u' },
			{ 'h', '2', 'w', 'u', 'n', 'c', 'm', 'o', 'k', 'a', 'r', '6', 'x', 'b', 'y', 'p', 'z', 'i', 'l', '3', 't',
					'f', '4', 'v', 'd', 'e', '1', '0', 'g', 's', '9', '8', '7', 'q', '5', 'j' },
			{ 'l', '4', '3', 'v', '9', 'k', 'n', 't', 'i', 'm', 'c', '0', 'f', '8', 'y', 's', 'q', 'e', 'w', 'r', '1',
					'j', 'd', 'p', '6', 'h', '2', '5', 'g', 'o', 'a', 'b', '7', 'u', 'z', 'x' }, };

	private static char[] normalMap = mapper[0];

	private static final int LENGTH = 36;

	public static String long2String(long appId) throws Exception {
		if (appId < 0) {
			throw new Exception("appId is negative!");
		}
		int[] num = _10_to_62(Long.MAX_VALUE - appId);
		StringBuffer buffer = new StringBuffer();
		int index = getIndexByInt(num);

		int end = num.length - 1;
		for (int i = 0; i < end; i++) {
			buffer.append(mapper[index][num[i]]);
		}

		buffer.append(normalMap[index]);

		return buffer.toString();
	}

	public static long string2long(String appId) throws Exception {
		if (appId == null) {
			throw new Exception("must has a appId");
		}
		int index = getNormalIndexByCharactor(appId.charAt(appId.length() - 1));
		long num = 0;
		for (int i = 0; i < appId.length() - 1; i++) {
			num = num * LENGTH + getIndex(appId.charAt(i), index);
		}
		num = num * LENGTH + index;

		num = Long.MAX_VALUE - num;

		if (!appId.equals(AppIdMapper.long2String(num))) {// ä¸åçstrå¯ä»¥çæç¸åçæ°å­ï¼å æ­¤éè¦åè¿æ¥éªè¯æ¯å¦æ¯æ¶ææ»å»
			throw new Exception("appId " + appId + " is fake.");
		}
		if (num < 10000 || num > 10000000) {
			throw new Exception("appId " + appId + " is fake.");
		}
		return num;
	}

	private static int getIndexByInt(int[] num) {
		return num[num.length - 1];
	}

	private static long getIndex(char c, int index) throws Exception {
		for (int i = 0; i < LENGTH; i++) {
			if (mapper[index][i] == c) {
				return i;
			}
		}
		throw new Exception((int) c + " is not a valid key char!");
	}

	private static int getNormalIndexByCharactor(char c) throws Exception {
		for (int i = 0; i < LENGTH; i++) {
			if (normalMap[i] == c) {
				return i;
			}
		}
		throw new Exception((int) c + " is not a valid key char!");
	}

	private static int[] _10_to_62(long number) {
		long rest = number;
		Stack<Integer> stack = new Stack<>();

		if (0 == rest) {
			stack.push(new Integer(0));
		}
		while (rest != 0) {
			stack.add(Integer.valueOf((int) (rest - (rest / LENGTH) * LENGTH)));
			rest = rest / LENGTH;
		}

		int num[] = new int[stack.size()];
		int i = 0;
		for (; !stack.isEmpty();) {
			num[i++] = stack.pop().intValue();
		}
		return num;

	}

	public static void main(String[] args) {

		try {
			System.out.println(long2String(365386L));
			System.out.println(string2long("sfci50a7cz12i"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}