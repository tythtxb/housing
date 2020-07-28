/*
package com.housings.util;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class LocalizedUtil {

	private static ResourceBundle rbSC;
	private static ResourceBundle rbTW;
	
	private static Map<String,String> noticeCn;
	private static Map<String,String> noticeTw;		
	private static Logger logger = Logger.getLogger(LocalizedUtil.class);
	
	static {
	
		rbSC = ResourceBundle.getBundle("messages", Locale.SIMPLIFIED_CHINESE);
		logger.info("message resource (SC) is loaded.");
		rbTW = ResourceBundle.getBundle("messages", Locale.TRADITIONAL_CHINESE);
		logger.info("message resource (EN) is loaded.");
		
	
		ResourceBundle cn = ResourceBundle.getBundle("notice", Locale.SIMPLIFIED_CHINESE);
		ResourceBundle tw = ResourceBundle.getBundle("notice", Locale.TRADITIONAL_CHINESE);
		
		
		
		logger.info("notice resource (SC) is loaded.");
		logger.info("notice resource (EN) is loaded.");
		
		Set<String> cns=cn.keySet();
		Set<String> tws=tw.keySet();
		Iterator<String> itcn=cns.iterator();
		Iterator<String> ittw=tws.iterator();
		
		noticeCn=new HashMap<String,String>();
		noticeTw=new HashMap<String,String>();
		String key=null;
		while(itcn.hasNext()){
			key=itcn.next();
			String v;
			try {
				v = new String(cn.getString(key).getBytes("ISO-8859-1"),"UTF-8");
				noticeCn.put(key, v);
			} catch (UnsupportedEncodingException e) {
			}			
		}
		while(ittw.hasNext()){
			key=ittw.next();
			String v;
			try {
				v = new String(tw.getString(key).getBytes("ISO-8859-1"),"UTF-8");
				noticeTw.put(key, v);
			} catch (UnsupportedEncodingException e) {
			}			
		}
		cns=null;
		tws=null;
		ittw=null;
		itcn=null;
		cn=null;
		tw=null;
	}
	
	public static String getWebText(String str,String lang) {
		String message = null;
		Map<String,String> rb = "tw".equals(lang) ? LocalizedUtil.getNoticeTw() : LocalizedUtil.getNoticeCn();
		if (!StringHelper.isEmptyStr(str)) {
			message=rb.get(str);
		}
		return message==null?str:message;
	}
	
	public static String getMessage(String str,String lang) {
		String message = null;
		//always init bundle by lang
		ResourceBundle rb = "tw".equals(lang) ? LocalizedUtil.getRbTW() : LocalizedUtil.getRbSC();
		if (!StringHelper.isEmptyStr(str)) {
			if (isMessageKey(str)) {
				String k = null;
				k = str.replaceAll("\\{", "");
				k = k.replaceAll("\\}", "");
				//k = k.toLowerCase();
				try {
					message =  StringHelper.toUtf8String(rb.getString(k));
				} catch (Exception e) {
					logger.error("cannot find message with key [" + k + "]");
					message = "!" + str + "!";
				}
			} else {
				message = str;
			}
		}
		return message;
	}
	
	public static boolean isMessageKey(String key) {
		boolean result = false;
		
		if (!StringHelper.isEmptyStr(key)) {
			result=true;
			//result = key.matches("^\\{.*\\}$");
		}
		
		return result;
	}

	public static ResourceBundle getRbSC() {
		return rbSC;
	}

	public static void setRbSC(ResourceBundle rbSC) {
		LocalizedUtil.rbSC = rbSC;
	}

	public static ResourceBundle getRbTW() {
		return rbTW;
	}

	public static void setRbEN(ResourceBundle rbtw) {
		LocalizedUtil.rbTW = rbtw;
	}

	public static Map<String, String> getNoticeCn() {
		return noticeCn;
	}

	public static void setNoticeCn(Map<String, String> noticeCn) {
		LocalizedUtil.noticeCn = noticeCn;
	}

	public static Map<String, String> getNoticeTw() {
		return noticeTw;
	}

	public static void setNoticeTw(Map<String, String> noticeEn) {
		LocalizedUtil.noticeTw = noticeEn;
	}
}
*/
