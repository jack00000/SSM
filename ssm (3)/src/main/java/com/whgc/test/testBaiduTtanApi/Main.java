package com.whgc.test.testBaiduTtanApi;
import java.io.UnsupportedEncodingException;

public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20190327000281671";
    private static final String SECURITY_KEY = "E4avOmUMi_8YC93GZmGS";

    public static void main(String[] args) throws UnsupportedEncodingException {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "Height 600 meters";
        System.out.println(api.getTransResult(query, "auto", "zh"));
    }

}
