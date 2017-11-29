package com.lww.smsbao;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Lww on 2017/11/27.
 */
public class SMSApp2e {

    /**
     * 短信宝Api  接口
     * http://api.smsbao.com/sms?u=USERNAME&p=PASSWORD&m=PHONE&c=CODE
     */
//    private String apiUrl = "http://api.smsbao.com/sms";
    private final String apiUrl = "http://api.app2e.com/smsBigSend.api.php";
// pwd：密码  username：账号
// p：需要发送的短信号码 多个用,隔开  msg：发送内容
//
// pwd= 665e8568e26144bbfe34687ffd57dc&
// username=test&
// p=15000000000,15777777777,15888888888,15999999999&
// msg=本次短信的发送内容

    // 短信宝 成功发送返回的判断标志
    public static final String SEND_SUCCESS = "0";
    // 短信宝 发送异常自定义错误标志（lww）
    public static final String SEND_ERROR = "ERROR";

    // 短信宝api
    public String sendMessage(String httpArg) {
//        StringBuffer httpArg = new StringBuffer();
        httpArg="pwd= 665e8568e26144bbfe34687ffd57dc" +
                "&username=test" +
                "&p=18720594171" +
                "&msg=【家视天下】短信提醒";
        return request(apiUrl, httpArg);
    }
    private String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        InputStream in = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;
        PrintWriter out = null;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);

            connection.setRequestMethod("POST");
            connection.connect();

            out = new PrintWriter(connection.getOutputStream());
            // 发送请求参数
            out.print(httpArg);
            // flush输出流的缓冲
            out.flush();


            in = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String strRead = reader.readLine();
            if (strRead != null) {
                sbf.append(strRead);
                while ((strRead = reader.readLine()) != null) {
                    sbf.append("\n");
                    sbf.append(strRead);
                }
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);

//            logger.error(e.getMessage());
        }finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        System.out.println(result);
        if (result.equals(SEND_SUCCESS)) {
            return result;
        } else {
//            logger.error("短信发送错误"+result);
            result = SEND_ERROR;
            return result;
        }
    }
}
