package com.housings.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;


public class  SystemConstants{

	//TODO retrieve data from database
	
	public static final String SYSTEM_DEFAULT_ENCODE = "UTF-8";
	public static final String SYSTEM_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATABASE_DATETIME_FORMAT = "yyyy-MM-dd hh24:mi:ss";	
	
	public static String API_PATH="";
	public static String API_BASE_PATH="";
	public static String APP_ID="";
	public static String APP_KEY="";
//	public static String WEBSOCKET_SERVER="";
//	public static String WEBSOCKET_PORT="";
	
	public static final String ERROR_STR="{\"@status\":\"fail\",\"@code\":\"-100\",\"@message\":\"璋冪敤鎺ュ彛澶辫触\"}";
	public static final String LOGINED_USER="user";//鐧诲綍鍚�user session鍚�
	
	public static final String PRINT_RECORD="print_record";//鎵撳嵃鍘嗗彶璁板綍  hashmap  jobnumber-> batch/schedulenumber
	public static final List<Integer> ANDMIN_ROLE_ID = java.util.Arrays.asList(3);
	public static final String LOGINED_USER_FUNCTIONS="user_functions";
	public static final String LOCALE="locale";//璇█
	public static final String LOGINED_USERINFO="user-info";//鐧诲綍鍚�user session鍚�
	public static final String LOGINED_SERVERDATE="server-date";//鐧诲綍鍚�user session鍚�
	public static final String ADMIND_ROLE = "roleId";//鐧诲綍鍚庣鐞嗗憳 session 鍚�
	public static final String WAREHOUSE_NAME = "wareHousename";//鐧婚檰鍚庝粨搴�session 鍚�
	public static final String TASKLIST="taskList"; //鐧婚檰鍚庝换鍔℃竻鍗晄ession鍚�
	public static int cookieage=2592000;//30澶�
	public static String cookiedomian="";
	private static Properties property=new Properties();
	
	static{
		InputStream in=null;
		try {
			in=Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
			property.load(in);
			API_PATH=property.getProperty("apipath");
			API_BASE_PATH=property.getProperty("apibasepath");
			APP_ID=property.getProperty("appid");
			APP_KEY=property.getProperty("appkey");
//			WEBSOCKET_SERVER=property.getProperty("websocketserver");
//			WEBSOCKET_PORT=property.getProperty("websocketport");
			cookiedomian=property.getProperty("cookiedomian");
			cookieage=Integer.parseInt(property.getProperty("cookieage"));
			System.out.println(API_PATH+"\\"+APP_ID+"\\"+APP_KEY+"\\"+cookieage+"\\"+cookiedomian);
			
		} catch (IOException e) {			
		}
		finally{
			if(in!=null){				
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
