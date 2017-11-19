package com.chinadrtv.itom.util;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Process data of date . 
 */
public final class DateUtil {
	public static Date getAdd(Date date, int calendarType, int count) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(calendarType, count);
		return ca.getTime();
	}
	
	public static Date getNextDay(Date date) {
		return getAdd(date, Calendar.DAY_OF_MONTH ,1);
	}
	
	public static Date getNextDay() {
		return getAdd(new Date(), Calendar.DAY_OF_MONTH ,1);
	}
	
	public static Date getFirstDate(Date date) {
		SimpleDateFormat chcrqSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return chcrqSdf.parse(getYear(date) + "-" + getMonth(date) + "-01"
					+ " 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date getAfterMonthDateByDate(Date date) {
		return getAdd(date, 2, 1);
	}

	public static Date getAfterMonthDate() {
		return getAdd(new Date(), 2, 1);
	}
	
	public static Date getBeforeMonthDateByDate(Date date) {
		return getAdd(date, 2, -1);
	}

	public static Date getBeforeMonthDate() {
		return getAdd(new Date(), 2, -1);
	}

	public static String toString(Date date) {
		SimpleDateFormat chcrqSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return chcrqSdf.format(date);
	}
	
	public static String toString(Date date, String format) {
		SimpleDateFormat chcrqSdf = new SimpleDateFormat(format);
		return chcrqSdf.format(date);
	}

	public static Date getLastDate(Date date) {
		SimpleDateFormat chcrqSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date nextDate = getAdd(date, 2, 1);
			Date newDate = getAdd(chcrqSdf.parse(getYear(nextDate) + "-"
					+ getMonth(nextDate) + "-01" + " 00:00:00"), 5, -1);
			String newTxt = getYear(newDate) + "-" + getMonth(newDate) + "-"
					+ getDay(newDate) + " 23:59:59";
			return chcrqSdf.parse(newTxt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getDiffByMouth(Date after, Date before) {
		return (getYear(after) - getYear(before)) * 12 + getMonth(after)
				- getMonth(before);
	}

	public static int getCountDay(Date before, Date after) {
		double pc = after.getTime() - before.getTime();
		double cj = pc / 86400000.0D;
		if (pc % 86400000.0D > 0.0D) {
			return (int) (cj + 2.0D);
		}
		return (int) (cj + 1.0D);
	}

	public static int getYear(Date date) {
		SimpleDateFormat chcrqSdf = new SimpleDateFormat("yyyy");
		return Integer.parseInt(chcrqSdf.format(date));
	}

	public static int getMonth(Date date) {
		SimpleDateFormat chcrqSdf = new SimpleDateFormat("MM");
		return Integer.parseInt(chcrqSdf.format(date));
	}

	public static String getWeekDay(Date date) {
		SimpleDateFormat chcrqSdf = new SimpleDateFormat("EE");
		return chcrqSdf.format(date);
	}

	public static int getDay(Date date) {
		SimpleDateFormat chcrqSdf = new SimpleDateFormat("dd");
		return Integer.parseInt(chcrqSdf.format(date));
	}

	public static Date getLongTime(String dateStr) {
		if ((dateStr == null) || (dateStr.equals(""))) {
			return null;
		}
		SimpleDateFormat chcrqSdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return chcrqSdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date getShortTime(String dateStr) {
		if ((dateStr == null) || (dateStr.equals(""))) {
			return null;
		}
		SimpleDateFormat chcrqSdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return chcrqSdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date getTime(String dateStr, String formatStr) {
		if ((dateStr == null) || (dateStr.equals(""))) {
			return null;
		}
		SimpleDateFormat chcrqSdf = new SimpleDateFormat(formatStr);
		try {
			return chcrqSdf.parse(dateStr);
		} catch (ParseException e) {
			System.out.println(dateStr + "__" + formatStr);
		}

		return null;
	}
	
	public static Date getTime(String value) throws Exception {
		Date date = null;
		if(StringUtils.isNotBlank(value)){
			if (RegexUtil.test("\\d{4}/\\d{1,2}/\\d{1,2}", value)) {
				date = DateUtil.getTime(value, "yyyy/MM/dd");
			} else if (RegexUtil.test("\\d{4}-\\d{1,2}-\\d{1,2}", value)) {
				date = DateUtil.getTime(value, "yyyy-MM-dd");
			} else if (RegexUtil.test("\\d{1,2}/\\d{1,2}/\\d{4}", value)) {
				date =  DateUtil.getTime(value, "MM/dd/yyyy");
			}else if (RegexUtil.test("\\d{4}年\\d{1,2}月\\d{1,2}日\\s\\d{1,2}时\\d{1,2}分\\d{1,2}秒", value)) {
				date =  DateUtil.getTime(value, "yyyy年MM月dd日 HH时mm分ss秒");
			}else if (RegexUtil.test("\\d{4}年\\d{1,2}月\\d{1,2}日\\s\\d{1,2}时\\d{1,2}分", value)) {
				date =  DateUtil.getTime(value, "yyyy年MM月dd日 HH时mm分");
			}else if (RegexUtil.test("\\d{4}年\\d{1,2}月\\d{1,2}日", value)) {
				date =  DateUtil.getTime(value, "yyyy年MM月dd日");
			}else if (RegexUtil.test("\\d{8}", value)) {
				date =  DateUtil.getTime(value, "yyyyMMdd");
			} else if(RegexUtil.test("\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}", value)){
				date = DateUtil.getTime(value, "yyyy/MM/dd HH:mm:ss");
			}else if(RegexUtil.test("\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{1,2}", value)){
				date = DateUtil.getTime(value, "yyyy/MM/dd HH:mm");
			}else if(RegexUtil.test("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}", value)){
				date = DateUtil.getTime(value, "yyyy-MM-dd HH:mm");
			}else if(RegexUtil.test("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}", value)){
				date = DateUtil.getTime(value, "yyyy-MM-dd HH:mm:ss");
			}else if(RegexUtil.test("\\d{1,2}/\\d{1,2}/\\d{4}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}", value)){
				date = DateUtil.getTime(value, "MM/dd/yyyy HH:mm:ss");
			}else if(RegexUtil.test("\\d{1,2}/\\d{1,2}/\\d{4}\\s\\d{1,2}:\\d{1,2}", value)){
				date = DateUtil.getTime(value, "MM/dd/yyyy HH:mm");
			}else if (RegexUtil.test("\\d{8}\\s\\d{1,2}:\\d{1,2}", value)) {
				date =  DateUtil.getTime(value, "yyyyMMdd HH:mm");
			}else if (RegexUtil.test("\\d{8}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}", value)) {
				date =  DateUtil.getTime(value, "yyyyMMdd HH:mm:ss");
			}else if (RegexUtil.test("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}.\\d{1,3}", value)) {
				date =  DateUtil.getTime(value, "yyyy-MM-dd HH:mm:ss.SSS"); // for drtv
			}else{
				throw new Exception(value+" is invalidate.");
			}
		}
		return date;
	}
	/**
	 * 获取一天最后的时间  Date+23:59:59
	 * @author Fu Qinghui<qinghui.fu@capgemini.com>
	 * @version 2013-5-22 下午3:50:32
	 * @param date
	 * @return
	 */
	
	public static Date getLastPoint(Date date){
		String str=DateUtil.get24Point(date);
		return formatParse(str);
	}
	
	public static String get24Point(Date date) {
		String sReDate = formatDate2Str(date, "yyyy-MM-dd HH:mm:ss").substring(
				0, 11)
				+ "23:59:59";
		return sReDate;
	}
	
	public static Date formatParse(String str) {
		return formatParse(str, "yyyy-MM-dd HH:mm:ss");
	}
	public static String formatDate2Str(Date date, String datePattern){
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern, Locale.getDefault());
		return sdf.format(date);
		
	}
	
	public static Date formatParse(String str, String param) {
		SimpleDateFormat format = new SimpleDateFormat(param);
		try {
			return format.parse(str);
		} catch (ParseException e) {
			throw new RuntimeException("字符串转换错误:" + param,e);
		}
	}
	
	/**
	 * 获得该日期指定天数之前的日期
	 * @author Fu Qinghui<qinghui.fu@capgemini.com>
	 * @version 2013-5-22 下午4:47:31
	 * @param dtDate
	 * @param lDays
	 * @return
	 */
    public static Date before(Date dtDate, long lDays)
    {
        long lCurrentDate = 0;
        lCurrentDate = dtDate.getTime() - lDays * 24 * 60 * 60 * 1000;
        Date dtBefor = new Date(lCurrentDate);
        return dtBefor;
    }
    
    public static Date beforHour(long hours){
    	long current = new Date().getTime() - hours * 60 * 60 * 1000;
    	return new Date(current);
    }
}
