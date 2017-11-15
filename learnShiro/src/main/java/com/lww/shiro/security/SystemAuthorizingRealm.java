package com.lww.shiro.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Created by Lww on 2017/10/30.
 */
public class SystemAuthorizingRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 实现自 AuthorizingRealm
     * 授权
     * 2.doGetAuthorizationInfo执行时机有三个，如下：
     *
     * 1、subject.hasRole(“admin”) 或 subject.isPermitted(“admin”)：自己去调用这个是否有什么角色或者是否有什么权限的时候；
     * 2、@RequiresRoles("admin") ：在方法上加注解的时候；
     * 3、[@shiro.hasPermission name = "admin"][/@shiro.hasPermission]：在页面上加shiro标签的时候，即进这个页面的时候扫描到有这个标签的时候。
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 因为非正常退出，即没有显式调用 SecurityUtils.getSubject().logout()
        // (可能是关闭浏览器，或超时)，但此时缓存依旧存在(principals)，所以会自己跑到授权方法里。
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            doClearCache(principalCollection);
            SecurityUtils.getSubject().logout();
            return null;
        }
//        ShiroUser shiroUser = (ShiroUser)principalCollection.getPrimaryPrincipal();
//        String userName = shiroUser.getUserName();
//        if(StringUtils.isNotBlank(userName)){
//            SimpleAuthorizationInfo sazi = new SimpleAuthorizationInfo();
//            try {
//                Set<String> roleIds= shiroUserService.getRoles(userName);
//                for (String roleId: roleIds){
//                    shiroUser.setRoleId(roleId);
//                }
//                sazi.addRoles(roleIds);
//                sazi.addStringPermissions(shiroUserService.getPermissions(userName));
//                return sazi;
//            } catch (Exception e) {
//                logger.error(e.getMessage(),e);
//            }
//        }
        return null;
    }

    /**
     * 实现自 AuthenticatingRealm
     * 认证
     * 获取认证信息方法，抽象方法子类实现
     *
     * 1.doGetAuthenticationInfo执行时机如下
     * 当调用Subject currentUser = SecurityUtils.getSubject();
     * currentUser.login(token);
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
