package com.chinadrtv.itom.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

	// 数字
	public static final String REG_DECIMAL = "-?\\d+(\\.\\d)?\\d*";
	// 正数
	public static final String REG_POSITIVE_DECIMAL = "\\d+(\\.\\d)?\\d*";
	// 负数
	public static final String REG_NEGATIVE_DECIMAL = "-\\d+(\\.\\d)?\\d*";
	// 整数
	public static final String REG_INTEGER = "(-?[1-9][0-9]*)|0+";
	// 正整数和0
	public static final String REG_POSITIVE_INTEGER = "\\d+";
	// 正整
	public static final String REG_POSITIVE_INTEGER_NON_0 = "[1-9]\\d*";
	// 负整
	public static final String REG_NEGATIVE_INTEGER = "-[1-9]\\d*";
	// 正数
	public static final String REG_POSITIVE_NUM = "\\d+(\\.\\d)?\\d*";
	// 负数
	public static final String REG_NEGATIVE_NUM = "-\\d+(\\.\\d)?\\d*";

	public static Pattern getPattern(String reg) {
		return Pattern.compile(reg);
	}

	public static Matcher getMatcher(String regname, String value) {
		return getPattern(regname).matcher(value);
	}

	public static boolean test(String regname, String value) {
		Matcher ma = getMatcher(regname, value);
		return ma.matches();
	}

	public static boolean isDecimal(String value) {
		return test(REG_DECIMAL, value);
	}

	public static Double getDecimal(String value) {
		if (isDecimal(value)) {
			return Double.parseDouble(value);
		}
		return null;
	}

	public static Float getFloat(String value) {
		if (isDecimal(value)) {
			return Float.parseFloat(value);
		}
		return null;
	}

	public static boolean isPositiveDecimal(String value) {
		return test(REG_POSITIVE_DECIMAL, value);
	}

	public static Double getPositiveDecimal(String value) {
		if (isPositiveDecimal(value)) {
			return Double.parseDouble(value);
		}
		return null;
	}

	public static boolean isNegativeDecimal(String value) {
		return test(REG_NEGATIVE_DECIMAL, value);
	}

	public static Double getNegativeDecimal(String value) {
		if (isNegativeDecimal(value)) {
			return Double.parseDouble(value);
		}
		return null;
	}

	public static boolean isInteger(String value) {
		return test(REG_INTEGER, value);
	}

	public static Integer getInteger(String value) {
		if (isInteger(value)) {
			return Integer.parseInt(value);
		}
		return null;
	}

	public static Long getLong(String value) {
		if (isInteger(value)) {
			return Long.parseLong(value);
		}
		return null;
	}

	public static boolean isPositiveInteger(String value) {
		return test(REG_POSITIVE_INTEGER, value);
	}

	public static Integer getPositiveInteger(String value) {
		if (isPositiveInteger(value)) {
			return Integer.parseInt(value);
		}
		return null;
	}

	public static boolean isPositiveIntegerNon0(String value) {
		return test(REG_POSITIVE_INTEGER_NON_0, value);
	}

	public static Integer getPositiveIntegerNon0(String value) {
		if (isPositiveIntegerNon0(value)) {
			return Integer.parseInt(value);
		}
		return null;
	}

	public static boolean isNegativeInteger(String value) {
		return test(REG_NEGATIVE_INTEGER, value);
	}

	public static Integer getNegativeInteger(String value) {
		if (isNegativeInteger(value)) {
			return Integer.parseInt(value);
		}
		return null;
	}

	public static boolean isPositiveNum(String value) {
		return test(REG_POSITIVE_NUM, value);
	}

	public static Double getPositiveNum(String value) {
		if (isPositiveNum(value)) {
			return Double.parseDouble(value);
		}
		return null;
	}

	public static boolean isNegativeNum(String value) {
		return test(REG_NEGATIVE_NUM, value);
	}

	public static Double getNegativeNum(String value) {
		if (isNegativeNum(value)) {
			return Double.parseDouble(value);
		}
		return null;
	}

	public static String value(String regex, String value) {
		Matcher matcher = getMatcher(regex, value);
		if (matcher.find()) {
			return matcher.group();
		}
		return null;
	}

	public static String[] values(String regex, String value) {
		Matcher matcher = getMatcher(regex, value);
		ArrayList<String> list = null;
		while (matcher.find()) {
			list = list == null ? new ArrayList<String>(0) : list;
			list.add(matcher.group());
		}
		if (list != null) {
			list.trimToSize();
			return list.toArray(new String[list.size()]);
		}
		return null;
	}

	public static boolean has(String regex, String value) {
		Matcher matcher = getMatcher(regex, value);
		if (matcher.find())
			return true;
		return false;
	}

	public static int count(String regex, String value) {
		Matcher matcher = getMatcher(regex, value);
		int count = 0;
		while (matcher.find()) {
			count++;
		}
		return count;
	}

	public static int indexOf(String regex, String value) {
		Matcher matcher = getMatcher(regex, value);
		if (matcher.find())
			return matcher.start();
		return -1;
	}
}
