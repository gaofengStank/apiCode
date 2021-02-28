package com.jeesite.modules.tab.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
 

public class HttpPostUtil {
	private static HttpClient client = new HttpClient();

	public static String  url  =   "http://39.98.43.234:7079/";

	public static   String getHanYuanUtils3(String url, String method, Map<String, String> map) throws Exception {
		HttpPost post = new HttpPost(url );
		DefaultHttpClient client = new DefaultHttpClient();


		Set<String> sets = map.keySet();
		List<org.apache.http.NameValuePair> data = new ArrayList<>();
		int i = 0;
		System.out.println(sets.size());
		post.addHeader("Content-Type", "application/json");
 
		post.addHeader("appId", "8079764");
		post.addHeader("appKey", "0dde7d315cf31227724a01aa99d24bbf");
//		post.addre
		for (Iterator iterator = sets.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			data.add(new BasicNameValuePair(key, map.get(key)));
		}
		String reString = "";
		
        HttpEntity entity = new  UrlEncodedFormEntity(data);


		try {
			post.setEntity(entity);
		HttpResponse httpResponse = 	client.execute(post);
		System.err.println(httpResponse.getEntity());
		 
//			reString = post.getResponseBodyAsString();
		reString =  EntityUtils.toString(httpResponse.getEntity(), "utf-8");;
//			System.out.println(reString);
		} catch (Exception e) {
			
		}finally {
//			post.c
//			post.d
			post.releaseConnection();
		}

		return reString;
	}
	public static String getHanYuanUtilsPost2(String url, Map<String, String> map) {
		PostMethod post = new PostMethod(url );
		Set<String> sets = map.keySet();
		NameValuePair[] data = new NameValuePair[sets.size()];
		int i = 0;
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		for (Iterator iterator = sets.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			data[i++] = new NameValuePair(key, map.get(key));
		}
		String reString = "";
		post.setRequestBody(data);
		try {
			client.executeMethod(post);
			reString = post.getResponseBodyAsString();
			System.out.println(reString);
		} catch (Exception e) {
		}

		return reString;
	}
	
	public static String getHanYuanUtils(String url) throws Exception {
		 
		 
		HttpPost post = new HttpPost(url );
		DefaultHttpClient client = new DefaultHttpClient();


		List<org.apache.http.NameValuePair> data = new ArrayList<>();
		int i = 0;
		post.addHeader("Content-Type", "application/x-www-form-urlencoded");
 
		//post.addHeader("cookie", "Token=0d64f216b64f1a1f3b2cc3f9110823bb; hhz_token=0d64f216b64f1a1f3b2cc3f9110823bb; visitor_token=vid_31f2a76a4a7ecb1babbd40b2f686bb71; isg=BM3NGNrLkYBXSTWs08Vn7cba1u1HqgF8uO8kzw9SCWTTBu241_oRTBuEdhxg3Rk0; cna=xpqzGIDbkTICASSXAo6ICgq4; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2211624649%22%2C%22%24device_id%22%3A%22177ae82766a324-083303bf1bf26f8-4f514e71-304704-177ae82766b24a%22%2C%22props%22%3A%7B%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%7D%2C%22first_id%22%3A%22177ae82766a324-083303bf1bf26f8-4f514e71-304704-177ae82766b24a%22%7D; Hm_lvt_08cdc64454583146c3c3fd3b443c0ac3=1613540518,1613540528,1613540548; b83fa60863bff9fd_gr_cs1=11624649; b83fa60863bff9fd_gr_last_sent_cs1=11624649; b83fa60863bff9fd_gr_last_sent_sid_with_cs1=407be2ed-2a83-4377-860d-9792c145e90c; b83fa60863bff9fd_gr_session_id=407be2ed-2a83-4377-860d-9792c145e90c; b83fa60863bff9fd_gr_session_id_407be2ed-2a83-4377-860d-9792c145e90c=true; gr_user_id=32046ef0-9317-43bf-8bff-9f1136e29c26; sajssdk_2015_cross_new_user=1; grwng_uid=875e6fe7-af62-4b91-8eda-b472b0590280");
		
		  post.addHeader("cookie", "Token=0d64f216b64f1a1f3b2cc3f9110823bb; hhz_token=0d64f216b64f1a1f3b2cc3f9110823bb; visitor_token=vid_31f2a76a4a7ecb1babbd40b2f686bb71; isg=BM3NGNrLkYBXSTWs08Vn7cba1u1HqgF8uO8kzw9SCWTTBu241_oRTBuEdhxg3Rk0; cna=xpqzGIDbkTICASSXAo6ICgq4; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%2211624649%22%2C%22%24device_id%22%3A%22177ae82766a324-083303bf1bf26f8-4f514e71-304704-177ae82766b24a%22%2C%22props%22%3A%7B%22%24latest_referrer%22%3A%22%22%2C%22%24latest_referrer_host%22%3A%22%22%2C%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%7D%2C%22first_id%22%3A%22177ae82766a324-083303bf1bf26f8-4f514e71-304704-177ae82766b24a%22%7D; Hm_lvt_08cdc64454583146c3c3fd3b443c0ac3=1613540518,1613540528,1613540548; b83fa60863bff9fd_gr_cs1=11624649; b83fa60863bff9fd_gr_last_sent_cs1=11624649; gr_user_id=32046ef0-9317-43bf-8bff-9f1136e29c26; sajssdk_2015_cross_new_user=1; grwng_uid=875e6fe7-af62-4b91-8eda-b472b0590280");
		
		
 //		post.addre
		String reString = "";
		
        HttpEntity entity = new  UrlEncodedFormEntity(data);


		try {
			post.setEntity(entity);
		HttpResponse httpResponse = 	client.execute(post);
		System.err.println(httpResponse.getEntity());
		 
//			reString = post.getResponseBodyAsString();
		reString =  EntityUtils.toString(httpResponse.getEntity(), "utf-8");;
//			System.out.println(reString);
		} catch (Exception e) {
			
		}finally {
//			post.c
//			post.d
			post.releaseConnection();
		}


		return reString;
	}
	public static InputStream hanYuanUtils(String turl, String xmlData) {
		// 此处改为自己想要的结构体，替换即可
		InputStream 	message  = null;
		try {
			URL url = new URL(turl);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();

			http.setRequestMethod("POST");
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

			http.connect();
			OutputStream os = http.getOutputStream();
			os.write(xmlData.getBytes("UTF-8"));// 传入参数
			os.flush();
			os.close();

			message = http.getInputStream();
			  
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return   message;
	}
}
