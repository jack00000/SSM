package com.whgc.test.hmjl;
public class HammingDistance {
	public static void main(String[] args) {
		
		String strA="大数据和人工智能";
		String strB="小数据和人工智能";
		
		System.out.println("海明距离是："+getHMJL(strA,strB));
	}
	
	
	
	public static int getHMJL(String strA,String strB) {
		String strAB=StrToBinstr(strA);
		String strBB=StrToBinstr(strB);
		//对两个二进制字符串，字符数相同，统计差异数
		int count=0;
		int len=strAB.length();
		for(int i=0;i<len;i++){
			if(strAB.charAt(i)!=strBB.charAt(i)) count++;
		}
		return count;
	}
	//将字符串转换成二进制字符串，以空格相隔
	private static String StrToBinstr(String str) {
		char[] strChar=str.toCharArray();
		String result="";
		for(int i=0;i<strChar.length;i++){
			result +=Integer.toBinaryString(strChar[i]);
		}
		return result;
	}

	
}
