package com.lww.shiro.security;

import com.alibaba.fastjson.JSON;
import com.lww.shiro.test.Tutorial;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

/**
 * Created by lenovo on 2017/8/8.
 */
public class DefinedRealm extends AuthorizingRealm {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Tutorial.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        log.info("-----------------access doGetAuthorizationInfo----------------------");
        System.out.println("doGetAuthorizationInfo  01");
        //获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
        String currentUsername = (String)super.getAvailablePrincipal(principals);
//      这里实现自己的业务逻辑
//      根据业务逻辑，设置角色和权限

        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        //实际中可能会像上面注释的那样从数据库取得
        if(null!=currentUsername && "mike".equals(currentUsername)){
            //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
            simpleAuthorInfo.addRole("admin");
            simpleAuthorInfo.addStringPermission("admin:manage"); //添加权限return simpleAuthorInfo;
        }
        //若该方法什么都不做直接返回null的话,就会导致任何用户访问/admin/listUser.jsp时都会自动跳转到unauthorizedUrl指定的地址
        //详见applicationContext.xml中的<bean id="shiroFilter">的配置
        return null;
    }

    /**
     *   验证当前登录的Subject
     *   经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {//获取基于用户名和密码的令牌
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        //两个token的引用都是一样的
        System.out.println("AuthenticationToken -01");
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
        log.info("验证当前Subject时获取到token为" + JSON.toJSONString(token));
        //此处无需比对,比对的逻辑Shiro会做,我们只需返回一个和令牌相关的正确的验证信息
        //说白了就是第一个参数填登录用户名,第二个参数填合法的登录密码(可以是从数据库中取到的,本例中为了演示就硬编码了)
        //这样一来,在随后的登录页面上就只有这里指定的用户和密码才能通过验证
        if("mike".equals(token.getUsername())){
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo("mike", "mike", this.getName());
            authcInfo.getCredentials();
            this.setSession("currentUser", "mike");
            return authcInfo;
        }//没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
        return null;
    }
    private void setSession(Object key, Object value){
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){
            Session session = currentUser.getSession();if(null != session){
                session.setAttribute(key, value);
            }
        }
    }
}
