package com.chinadrtv.itom.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExportUtil {
	public static String parseSQL(String sql, Map<String, Object> params) {
		Map<String, String> args = new HashMap<String, String>();
		for(String k : params.keySet()) {
			Object v = params.get(k);
			if(v instanceof String) {
				args.put(k, "'"+v.toString()+"'");
			} else if (v instanceof Date) {
				String date = DateUtil.toString((Date)v, "yyyy-MM-dd HH:mm:ss");
				String value = "to_date('"+date+"', 'yyyy-MM-dd hh24:mi:ss')";
				args.put(k, value);
			} else if (v instanceof Long || v instanceof Integer) {
				args.put(k, v.toString());
			}
		}
		sql = MailUtil.parseMessage(sql, args);
		return sql;
	}
}
