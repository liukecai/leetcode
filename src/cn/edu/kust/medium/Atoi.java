package cn.edu.kust.medium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 8. String to Integer (atoi)
 * pass
 */
public class Atoi {
	public int myAtoi2(String str) {
		String str1 = str.trim();
		if (str1.equals(""))
			return 0;

		String reg = "^(-|\\+)\\d*|^\\d*";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str1);
		String digit = null;
		boolean unnegative = true;
		while (m.find()) {
			if (!m.group().equals(""))
				digit = m.group();
		}
		if (digit == null || digit.isEmpty() || digit.equals("+") || digit.equals("-"))
			return 0;

		String sub = digit;
		if (digit.charAt(0) == '+') {
			unnegative = true;
			sub = digit.substring(1, digit.length());
		}

		if (digit.charAt(0) == '-') {
			unnegative = false;
			sub = digit.substring(1, digit.length());
		}

		Pattern p2 = Pattern.compile("[1-9]\\d*");
		Matcher m2 = p2.matcher(sub);
		if (m2.find())
			sub = m2.group();
		else
			return 0;

		if (sub.length() > 15)
			return unnegative ? Integer.MAX_VALUE : Integer.MIN_VALUE;

		long l = Long.parseLong(sub);
		if (l > Integer.MAX_VALUE)
			return unnegative ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		else
			return unnegative ? (int) l : (int) -l;

	}

	public int myAtoi(String str) {
		if (str.replace(" ", "").isEmpty())
			return 0;
		boolean start = false;
		StringBuilder sb = new StringBuilder();
		char temp;
		for (int i = 0; i < str.toCharArray().length; i++) {
			temp = str.charAt(i);
			if (!start) {
				if (temp == ' ') {
					continue;
				} else if ((temp - '0' > 9 || temp - '0' < 0) && (temp != '-' && temp != '+')) {
					return 0;
				} else {
					sb.append(temp);
					start = true;
				}
			} else {
				if (temp - '0' > 9 || temp - '0' < 0)
					break;
				sb.append(temp);
			}
		}

		int result;
		String num = sb.toString().trim();
		if (num.equals("+") || num.equals("-"))
			return 0;

		try {
			result = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			if (!num.contains("-"))
				return Integer.MAX_VALUE;
			else
				return Integer.MIN_VALUE;
		}

		return result;
	}
}
