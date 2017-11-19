package com.chinadrtv.itom.util;

import java.util.List;
import java.util.Map;

public class MailUtil {
	
	@Deprecated
	public static String parseMessage(String message, List<String> args) throws Exception {
		StringBuffer msg = new StringBuffer();
		for(int i=0;message.indexOf("{?}")>-1;i++) {
			msg.append(message.substring(0, message.indexOf("{?}")));
			message = message.substring(message.indexOf("{?}")+3);
			msg.append(args.get(i));
		}
		msg.append(message);
		return msg.toString();
	}
	
	public static String parseMessage(String message, Map<String, String> args) {
		for(String key : args.keySet()) {
			String str = ":"+key;
			if(message.indexOf(str)>-1) {
				message = message.replace(str, args.get(key)!=null?args.get(key):"");
			}
		}
		return message;
	}
	
}
