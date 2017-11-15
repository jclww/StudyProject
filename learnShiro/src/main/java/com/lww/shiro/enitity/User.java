package com.lww.shiro.enitity;

import lombok.Data;

import java.util.Date;

/**
 * 
 * @author hiveview
 * @date 2017-05-22 15:10:34
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
@Data
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 商城管理用户版本.
     */
    private Long version;

    /**
     * 商城管理用户邮箱.
     */
    private String email;

    /**
     * 状态(1:启用,0:禁用).
     */
    private Integer status;

    /**
     * 商城管理用户登录日期.
     */
    private Date loginDate;

    /**
     * 商城管理用户失败次数.
     */
    private Integer loginFailureCount;

    /**
     * 商城管理用户登录IP.
     */
    private String loginIp;

    /**
     * 商城管理用户名字.
     */
    private String name;

    /**
     * 商城管理登录用户名.
     */
    private String userName;

    /**
     * 商城管理用户登录密码.
     */
    private String password;

    /**
     * 商城管理用户头像.
     */
    private String headImg;

    /**
     * .
     */
    private String phone;

    /**
     * 默认角色 从db中得到数据
     */
    private Role defaultRole;

    /**
     * -------------------非表中字段--------------------
     */
    private String belongRole;//所属角色  这里 将角色 用户关系 用关联表   以防以后 单用户多角色

    private String partnerId;//商户ID

    private String oldPwd;
}