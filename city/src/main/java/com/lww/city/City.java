package com.lww.city;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Lww on 2017/8/25.
 */

/**
 * 城市信息
 * https://github.com/mumuy/data_location
 * */
public class City {
    private String province_location;

    private String city_location;

    public static void main(String[] a) throws SQLException, ParseException {
        int count = 0;
        File file = new File("E:\\city\\data_location-master\\list.json");
        List<HashMap<String,Object>> cityList = new ArrayList<HashMap<String,Object>>();
        InputStream in;
        String city = null;
        try {
            in = new FileInputStream(file);
            int tempbyte;
            byte[] tempbytes = new byte[(int)file.length()];

            while ((tempbyte = in.read(tempbytes)) != -1) {
                city = new String(tempbytes,"UTF-8");
                city = city.substring(2,city.length()-2);
//                System.out.println(city);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        String[] citys = city.split(",\n");

        for (int i = 0; i < citys.length; i++) {
            String[] c = citys[i].split(":");
            HashMap<String,Object> m = new HashMap<String, Object>();
            for (int j = 0; j < c.length; j++) {
                c[j] = c[j].substring(1,c[j].length()-1);
            }
            m.put("code",c[0]);
            m.put("name",c[1]);
            int level =judge(c[0]);
            m.put("level",level);

//            if (level == 1)
//                count++;


            String path = getPath(c[0]);
            m.put("path",path);
            String parent_code = getPatentCode(c[0]);
            m.put("parent_code",parent_code);
//            System.out.println(JSON.toJSONString(m));
            cityList.add(m);
            if (level == 2 || level == 3) {
//            System.out.println(JSON.toJSONString(m));
                String sonFileStr = "E:\\city\\data_location-master\\town\\" + c[0] + ".json";
//                System.out.println(sonFileStr);
                File subFile = new File(sonFileStr);
                InputStream inputStream2 = null;
                try {
                    inputStream2 = new FileInputStream(sonFileStr);
                    int tempbyte2;
                    String sonCity = null;
                    String[] sons;
                    byte[] bb = new byte[(int) subFile.length()];

                    while ((tempbyte2 = inputStream2.read(bb)) != -1) {
                        sonCity = new String(bb, "UTF-8");
                        sonCity = sonCity.substring(1, sonCity.length() - 1);
//                        System.out.println(sonCity);
                    }
//                    if (Integer.parseInt(c[0])>=470684)
//                        continue;
                    insertSon(c[0],level,path,sonCity);
                    inputStream2.close();
                } catch (IOException e) {
//                    e.printStackTrace();
//                    return;
                    continue;
                }
            }

        }
        System.out.println(count);
//        DBConnect.update(cityList);

//        System.out.println(citys.length);



    }

    private static void insertSon(String tababa, int level, String fpath, String sonCity) throws SQLException {

        List<HashMap<String,Object>> cityList = new ArrayList<HashMap<String,Object>>();
        String[] citys = sonCity.split(",");

        for (int i = 0; i < citys.length; i++) {
            String[] c = citys[i].split(":");
            HashMap<String, Object> m = new HashMap<String, Object>();
            for (int j = 0; j < c.length; j++) {
                c[j] = c[j].substring(1, c[j].length() - 1);
            }
            m.put("code", c[0]);
            m.put("name", c[1]);
//            int level =judgeSon(4);
            m.put("level", level+1);
            String path = fpath + "," + c[0];
            m.put("path", path);
//            String parent_code = getPatentCode(c[0]);
            m.put("parent_code", tababa);
            System.out.println(JSON.toJSONString(m));
            cityList.add(m);
        }
        try {
                DBConnect.update(cityList);
        } catch (ParseException e) {

        }
    }


    private static String getPatentCode(String s) {
        int num = Integer.parseInt(s);
        if (s.startsWith("11") || s.startsWith("12") || s.startsWith("31")
                || s.startsWith("50") || s.startsWith("81") || s.startsWith("82"))
        {
            if (num % 10000 == 0)
                return null;
            if (num % 10000 > 8000) {
                return num/10000+"0000";
            }
            return num/10000+"1000";
        }
        if (num % 10000 == 0)
            return null;
        if (num % 10000 > 8000) {
            return num/10000+"0000";
        }
        if (num % 100 == 0)
            return num/10000+"0000";
        return num/100+"00";
    }

    private static String getPath(String s) {
        int num = Integer.parseInt(s);
        if (s.startsWith("11") || s.startsWith("12") || s.startsWith("31")
                || s.startsWith("50") || s.startsWith("81") || s.startsWith("82")) {
            if (num % 10000 == 0) {
                return s;
            }
            if (num % 10000 > 8000) {
                return num/10000+"0000,"+num;
            }
            return num/10000+"0000,"+num/10000+"1000"+","+num;
        }
        if (num % 10000 == 0) {
            return s;
        }
        if (num % 10000 > 8000) {
            return num/10000+"0000,"+num;
        }
        if (num % 100 == 0)
            return num/10000+"0000,"+num;
        return num/10000+"0000,"+num/100+"00,"+num;
    }

    private static int judge(String s) {
        int num = Integer.parseInt(s);
        if (num % 10000 == 0)
            return 1;
        if (num % 100 == 0 || num % 10000 >8000)
            return 2;
        return 3;
    }
}
