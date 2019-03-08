package com.whgc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api2db {
	private static final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws IOException {
		System.out.println(request("http://localhost:8888/ssm/getIndexData"));
	}

	public static String request(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// 默认值我GET
		con.setRequestMethod("GET");

		// 添加请求头
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// 打印结果
		// System.out.println(response.toString());
		return response.toString();
		//数据库去重 去历史记录
		

	}

}
