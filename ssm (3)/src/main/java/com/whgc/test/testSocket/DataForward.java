package com.whgc.test.testSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * 从socket获取数据存入List<String> 在转存到List<BikeGPS> 并用orm插入数据库
 *
 * @author fangjun
 *
 */
public class DataForward {


	public static String logincode = "{LoginRequest,0,\"huayu\",\"hy2018\",0,}";

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket s = new Socket("221.232.149.173", 7013);// 建立socket连接

		InputStream inputStream = s.getInputStream();
		OutputStream outputStream = s.getOutputStream();
		byte[] bytes = new byte[1024 * 1024 * 10];
		int len;
		try {
			s.setSoTimeout(3 * 60 * 1000);// 设置3分钟读取超时时间

			outputStream.write(logincode.getBytes("UTF-8"));// 发送登录请求
			outputStream.write("{RequestReceive,0,4096,0}"
					.getBytes("UTF-8"));// 发送获取数据请求
			/*
			 * 前2次read： 第一次的登录返回的结果({class:wzg.user.cmd.LoginResult,0,0,,});
			 * 第二次是第二次请求返回的结束（并非数据）({class:wzg.systems.ResultArgs,0,0,})
			 * 所有要放掉2次read，从第三次开始
			 */
			for (int i = 0; i < 2; i++) {
				len=inputStream.read(bytes);
				if(i==0){
					String data=new String(bytes, 0, len, "UTF-8");
					String[] arr = data.split(",");
					if(!(arr.length>2&&arr[2].equals("0"))){
						throw new IOException("该用户名或密码错误");
					}
				}
				// len = inputStream.read(bytes);
				// System.out.println(new String(bytes, 0, len, "UTF-8"));
			}
			int count = 1;
			List<String> datas = new ArrayList<String>();
			StringBuilder lastStr = new StringBuilder();
			int lastcount=-1;
			while ((len = inputStream.read(bytes)) != -1) {
				// 注意指定编码格式，发送方和接收方一定要统一，使用UTF-8			
				String currentStr=new String(bytes, 0, len, "UTF-8");
				if(currentStr.startsWith("{BikeGps")&&(currentStr.endsWith("},0,}")||currentStr.endsWith("},1,}"))){//以{开头}结尾，是一条完整的数据
					datas.add(currentStr);
//					System.out.println(new String(bytes, 0, len,"UTF-8"));
	                //每当数据积累到200条后  开启一个线程并延时1分钟对对该数据进行处理
					if (count % 200 == 0) {
						//防止修改对象datas对调用该方法的类造成影响  eg:并发修改异常
						List<String> dataList= new ArrayList<String>();
						for(String data:datas){
							dataList.add(data);
						}
						System.out.println("666666");
						datas.clear();
					}
					count++;
				}else if(!currentStr.endsWith("},0,}")||!currentStr.endsWith("},1,}")){//不以}结尾（2种情况，1开头完整数据，2中间段数据）
					int index1=currentStr.indexOf("},0,}");
					int index2=currentStr.indexOf("},1,}");		
					if(index1>-1){
						lastStr.append(currentStr.substring(0,index1)+"},0,}");
						datas.add(lastStr.toString());
						if (count % 200 == 0) {
							//防止修改对象datas对调用该方法的类造成影响  eg:并发修改异常
							List<String> dataList= new ArrayList<String>();
							for(String data:datas){
								dataList.add(data);
							}
							System.out.println("666666");
							datas.clear();
						}
						count++;
						lastStr.setLength(0);
						lastStr.append(currentStr.substring(index1+5));
					}else if(index2>-1){
						lastStr.append(currentStr.substring(0,index2)+"},1,}");
						datas.add(lastStr.toString());
						if (count % 200 == 0) {
							//防止修改对象datas对调用该方法的类造成影响  eg:并发修改异常
							List<String> dataList= new ArrayList<String>();
							for(String data:datas){
								dataList.add(data);
							}
							System.out.println("666666");
							datas.clear();
						}
						count++;
						lastStr.setLength(0);
						lastStr.append(currentStr.substring(index2+5));
					}else					{
						lastStr.append(currentStr);
//						System.out.println("lastStr:"+currentStr);
						lastcount=count;//用于判断是否连接上一次
					}
				}else if(!currentStr.startsWith("{BikeGps")&&(currentStr.endsWith("},0,}")||currentStr.endsWith("},1,}"))&&!lastStr.equals("")){//不以{开头，以}结尾，并且lastStr有内容，和lastStr组成完整数据
					if(lastcount==count){
						lastStr.append(currentStr);
//						System.out.println("lastStr:"+currentStr);
						System.out.println(lastStr.toString());
						System.out.println(lastStr.toString().length());
						datas.add(lastStr.toString());
						
						//System.out.println(new String(bytes, 0, len,"UTF-8"));
		                //每当数据积累到200条后  开启一个线程并延时1分钟对对该数据进行处理
						if (count % 200 == 0) {
							//防止修改对象datas对调用该方法的类造成影响  eg:并发修改异常
							List<String> dataList= new ArrayList<String>();
							for(String data:datas){
								dataList.add(data);
							}
							System.out.println("666666");
							datas.clear();
						}
						count++;
					}else{
						lastStr.setLength(0);
						lastcount=-1;
					}
				}
			}
			System.out.println("main is over!");

			/*
			 * for (int i = 0; i < 100; i++) { len = inputStream.read(bytes);
			 * datas.add(new String(bytes, 0, len, "UTF-8")); } for(String
			 * data:datas){ System.out.println(data); }
			 */

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			inputStream.close();
			outputStream.close();
			s.close();
		}

	}
}