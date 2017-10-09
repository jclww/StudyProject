package com.lww.ssm;

public class Test {
    public static void main(String[] args) {
        /**
         * 1、数据库 3张表
         *    1.User       存放用户信息
         *    2.Role       存储角色信息一般只有（id,roleName,powerId） || (powerId)是角色绑定的权限id
         *    2.Power      存放具体权限表结构（id,powerName,power ....）
         *                 || powerName是为了看的明白中文    power是英文权限（例如图书删除权限  可以定义  book_del）
         *                 完整一行数据
         *                 (1,图书删除权限,book_del)
         *
         *                 对应Role表数据
         *                 （1,图书管理员角色,1）
         *
         *                 对应用户表
         *                 id  name  角色id
         *                 （1,张三,  1）
         *   这样就明确了
         *   一个角色有好多权限，比如：图书管理员有增、删、改等权限
         *
         *
         *   这样在你登录的时候就有用户 name 查他的角色。然后就能查出权限（这权限不是什么鬼权限就是一个字段（book_del）你规定
         *   的它就代表删除权限）
         *
         *   比如你登录后要进行删除操作就可以在  删除的方法里面判断他这个人能不能  取到book_del 字段  可以就代表他又权限删除
         *   取不到就代表没有权限
         *
         *
         *
         *   java思路：
         *
         *   1、
         *   获取登录时候的输入框用户名
         *   String userName = request.getAtr...("userName");
         *   查询数据库看能否取出  book_del
         *   这个查询语句就查三张表关联（自己想想怎么查，User->Role 1对多     Role -> Power 多对多）
         *   String power = sql.selectPowerByName(userName)
         *
         *   if(power != null) {
         *      说明能取到进行删除操作
         *   } else {
         *      取不到就没有权限
         *   }
         */
    }
}
