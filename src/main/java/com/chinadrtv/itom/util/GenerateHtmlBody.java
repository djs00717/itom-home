package com.chinadrtv.itom.util;

/**
 * 生成邮件正文
 * @author Fu Qinghui<qinghui.fu@capgemini.com>
 * @version 2013-5-15 下午2:18:24
 */

public class GenerateHtmlBody {
	public static String generateText(String content){
		int urlStartIndex = content.indexOf('<');
		int urlEndIndex = content.indexOf('>');
		String url = "";
		String beforeUrlContent = "";
		String afterUrlContent = "";
		String result = "";
		if (urlStartIndex != -1 && urlEndIndex != -1){
			url = content.substring(urlStartIndex+1, urlEndIndex);
			beforeUrlContent = content.substring(0,urlStartIndex);
			afterUrlContent = content.substring(urlEndIndex+1,content.length());
		}
		if (!"".equals(url)){
			result =  beforeUrlContent +  "<a href='"+url+"'>" +url+"</a>" + afterUrlContent; 
		}else{
			result = content;
		}
		String htmlText="<html><head>"+
		       "<meta http-equiv=\"content-type\" content=\"text/html;charset=GBK\">"+   
		        "</head><body>" +   
		        result + 
		        "</body></html>";   	
		return htmlText;
	}
}
