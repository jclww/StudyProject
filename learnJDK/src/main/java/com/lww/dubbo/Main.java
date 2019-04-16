package com.lww.dubbo;

import com.alibaba.com.caucho.hessian.io.Hessian2Output;
import com.alibaba.dubbo.common.Version;
import com.alibaba.dubbo.common.io.Bytes;
import com.alibaba.dubbo.common.serialize.support.hessian.Hessian2ObjectInput;
import com.alibaba.dubbo.remoting.exchange.Response;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class Main {
    // header length.
    protected static final int HEADER_LENGTH = 16;

    // magic header.
    protected static final short MAGIC = (short) 0xdabb;

    public static final byte RESPONSE_VALUE = -111;
    public static final byte RESPONSE_NULL_VALUE = -110;
    public static final byte RESPONSE_WITH_EXCEPTION = -112;

    public static final String DUBBO_GENERIC_METHOD_NAME =  "$invokeWithJsonArgs";
    public static final String DUBBO_GENERIC_METHOD_PARA_TYPES  = "Ljava/lang/String;[Ljava/lang/String;[B;";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] req = encodeParamRequest2();
//        byte[] req = encodeRequest();
        System.out.println(Arrays.toString(req));
        System.out.println(new String(req));


//        String host = "10.215.31.84";
        String host = "10.215.19.215";
        int port = 7100;
        try {
            System.out.println("连接到主机：" + host + " ，端口号：" + port);
            Socket client = new Socket(host, port);
//            client.setSoTimeout(10000);

            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.write(req);
            out.flush();

            InputStream inFromServer = client.getInputStream();

            BufferedInputStream bis = new BufferedInputStream(inFromServer);

            byte[] header = new byte[HEADER_LENGTH];
            int length = bis.read(header);
            System.out.println("response header:" + Arrays.toString(header) + " length:" + length);

            byte status = header[3];
            if (status != Response.OK) {
                System.out.println("请求出错了");
            }
            byte len = (byte) Bytes.bytes2int(header, 11);
            System.out.println("data length:" + len);


            byte flag = (byte) bis.read();
            if (RESPONSE_VALUE == flag) {
                System.out.println("success");
            }
            if (RESPONSE_NULL_VALUE == flag) {
                System.out.println("NULL");
            }
            if (RESPONSE_WITH_EXCEPTION == flag) {
                System.out.println("EXCEPTION");
            }

            Hessian2ObjectInput hessian2ObjectInput = new Hessian2ObjectInput(bis);
//            泛化不适用
//            Object object = hessian2ObjectInput.readObject();
//            System.out.println("result:" + JSON.toJSONString(object));

            byte[] object = hessian2ObjectInput.readBytes();
            System.out.println(new String(object));
            //释放资源
            bis.close();

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取一个无参调用请求
     *
     * @return
     */
    private static byte[] encodeRequest() throws IOException {

        ByteArrayOutputStream outputStreams = new ByteArrayOutputStream();

        byte[] header = new byte[HEADER_LENGTH];
        // set magic number.
        Bytes.short2bytes(MAGIC, header);
        header[2] |= (byte) -62;

        Random random = new Random();
        Bytes.long2bytes(random.nextInt(), header, 4);


        ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
        Hessian2Output op = new Hessian2Output(dataStream);
        op.writeString(Version.getVersion());
        op.writeString("com.xxx.operation.api.service.SystemServiceRemote");
        op.writeString("0.0.0");
        op.writeString("sayHello");
        op.writeString("");

        Map<String, String> map = new HashMap<>();
        map.put("path", "com.xxx.operation.api.service.SystemServiceRemote");
        map.put("interface", "com.xxx.operation.api.service.SystemServiceRemote");
        map.put("version", "0.0.0");
        map.put("timeout", "6000");
        op.writeObject(map);

        op.flushBuffer();
        byte[] data = dataStream.toByteArray();

        Bytes.int2bytes(data.length, header, 12);
        outputStreams.write(header);
        // 16
        outputStreams.write(data);
        return outputStreams.toByteArray();
    }

    /**
     * 获取一个无参调用请求
     *
     * @return
     */
    private static byte[] encodeParamRequest() throws IOException {

        ByteArrayOutputStream outputStreams = new ByteArrayOutputStream();

        byte[] header = new byte[HEADER_LENGTH];
        // set magic number.
        Bytes.short2bytes(MAGIC, header);
        header[2] |= (byte) -62;

        Random random = new Random();
        Bytes.long2bytes(1232131L, header, 4);

        ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
        Hessian2Output op = new Hessian2Output(dataStream);
        op.writeString(Version.getVersion());
        op.writeString("com.xxx.crm.organization.service.api.service.department.DepartmentRemoteService");
        op.writeString("0.0.0");
        op.writeString("searchDepartment");

        op.writeString("Lcom/xxx/crm/organization/service/api/dto/department/DepartmentConditionDTO;Lcom/xxx/crm/organization/service/api/dto/common/PaginationDTO;");

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("keyword", "营销部");
        op.writeObject(jsonObject1);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("page", 1);
        jsonObject2.put("pageSize", 10);
        op.writeObject(jsonObject2);

        Map<String, String> map = new HashMap<>();
        map.put("path", "com.xxx.crm.organization.service.api.service.department.DepartmentRemoteService");
        map.put("interface", "com.xxx.crm.organization.service.api.service.department.DepartmentRemoteService");
        map.put("version", "0.0.0");
        map.put("timeout", "6000");

        op.writeObject(map);


        op.flushBuffer();
        byte[] data = dataStream.toByteArray();

        Bytes.int2bytes(data.length, header, 12);
        outputStreams.write(header);
        // 16
        outputStreams.write(data);
        return outputStreams.toByteArray();
    }

    private static byte[] encodeRequest2() throws IOException {

        ByteArrayOutputStream outputStreams = new ByteArrayOutputStream();

        byte[] header = new byte[HEADER_LENGTH];
        // set magic number.
        Bytes.short2bytes(MAGIC, header);
        header[2] |= (byte) -62;

        Random random = new Random();
        Bytes.long2bytes(12321311L, header, 4);

        ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
        Hessian2Output op = new Hessian2Output(dataStream);
        op.writeString(Version.getVersion());
        op.writeString("com.xxx.operation.api.service.SystemServiceRemote");
        op.writeString("0.0.0");
        op.writeString(DUBBO_GENERIC_METHOD_NAME);
        op.writeString(DUBBO_GENERIC_METHOD_PARA_TYPES);
        op.writeString("sayHello");


        String[] string1 = new String[0];
        op.writeObject(string1);
        op.writeBytes("[]".getBytes());



        Map<String, String> map = new HashMap<>();
        map.put("path", "com.xxx.operation.api.service.SystemServiceRemote");
        map.put("interface", "com.xxx.operation.api.service.SystemServiceRemote");
        map.put("version", "0.0.0");
        map.put("timeout", "6000");
        map.put("generic", "true");

        op.writeObject(map);


        op.flushBuffer();
        byte[] data = dataStream.toByteArray();

        Bytes.int2bytes(data.length, header, 12);
        outputStreams.write(header);
        // 16
        outputStreams.write(data);
        return outputStreams.toByteArray();
    }


    private static byte[] encodeParamRequest2() throws IOException {

        ByteArrayOutputStream outputStreams = new ByteArrayOutputStream();

        byte[] header = new byte[HEADER_LENGTH];
        // set magic number.
        Bytes.short2bytes(MAGIC, header);
        header[2] |= (byte) -62;

        Random random = new Random();
        Bytes.long2bytes(12321311L, header, 4);

        ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
        Hessian2Output op = new Hessian2Output(dataStream);
        op.writeString(Version.getVersion());
        op.writeString("com.xxx.crm.organization.service.api.service.department.DepartmentRemoteService");
        op.writeString("0.0.0");
        op.writeString(DUBBO_GENERIC_METHOD_NAME);
        op.writeString(DUBBO_GENERIC_METHOD_PARA_TYPES);
        op.writeString("searchDepartment");


        String[] string1 = new String[0];
        op.writeObject(string1);

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("keyword", "营销部");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("page", 1);
        jsonObject2.put("pageSize", 10);
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        System.out.println(jsonArray.toJSONString());
        op.writeBytes(jsonArray.toJSONString().getBytes());



        Map<String, String> map = new HashMap<>();
        map.put("path", "com.xxx.crm.organization.service.api.service.department.DepartmentRemoteService");
        map.put("interface", "com.xxx.crm.organization.service.api.service.department.DepartmentRemoteService");
        map.put("version", "0.0.0");
        map.put("timeout", "6000");
        map.put("generic", "true");

        op.writeObject(map);


        op.flushBuffer();
        byte[] data = dataStream.toByteArray();

        Bytes.int2bytes(data.length, header, 12);
        outputStreams.write(header);
        // 16
        outputStreams.write(data);
        return outputStreams.toByteArray();
    }
}
