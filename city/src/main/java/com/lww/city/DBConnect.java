package com.lww.city;

import com.mysql.jdbc.PreparedStatement;

import java.sql.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

public class DBConnect {
    private static Connection con;
    static String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    static String url = "jdbc:mysql://172.16.0.89:3306/domyshop?useUnicode=true&characterEncoding=utf-8";
    //MySQL配置时的用户名
    static String user = "root";
    //MySQL配置时的密码
    static String password = "root";

    public static void main(String[] args) {
        //声明Connection对象
        //驱动程序名

        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from domy_city";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
//            System.out.println("-----------------");
//            System.out.println("执行结果如下所示:");
//            System.out.println("-----------------");
//            System.out.println("姓名" + "\t" + "职称");
//            System.out.println("-----------------");

            String job = null;
            String id = null;
            while(rs.next()){
                //获取stuname这列数据
                job = rs.getString("job");
                //获取stuid这列数据
                id = rs.getString("ename");

                //输出结果
                System.out.println(id + "\t" + job);
            }
            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
    }
    public static void update(List<HashMap<String,Object>> cityList) throws SQLException, ParseException {
        String name;
        String id;

        PreparedStatement psql;
        ResultSet res;
        con = DriverManager.getConnection(url,user,password);

        //预处理添加数据，其中有两个参数--“？”
        psql = (PreparedStatement) con.prepareStatement("insert into domy_city_2 (code,name,tree_path,parent_code,zone,level) "
                + "values(?,?,?,?,?,?)");

        for (int i = 0; i < cityList.size(); i++) {
            psql.setString(1, (String) cityList.get(i).get("code"));
            psql.setString(2, (String) cityList.get(i).get("name"));
            psql.setString(3, (String) cityList.get(i).get("path"));
            psql.setString(4, (String) cityList.get(i).get("parent_code"));
            psql.setString(5, "100");
            psql.setInt(6, (Integer) cityList.get(i).get("level"));

            psql.addBatch();
        }
        psql.executeBatch();

        con.close();
    }

}