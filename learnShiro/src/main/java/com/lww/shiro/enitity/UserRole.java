package com.lww.shiro.enitity;

/**
 * 
 * @author hiveview
 * @date 2017-05-22 15:51:26
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
public class UserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 自营运营账号权限账号ID.
     */
    private String userName;

    /**
     * 自营运营账号权限规则ID.
     */
    private String roleSn;

    /**
     * 
     * {@linkplain #userName}
     *
     * @return the value of domy_admin_role.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * {@linkplain #userName}
     * @param userName the value for domy_admin_role.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 
     * {@linkplain #roleSn}
     *
     * @return the value of domy_admin_role.role_sn
     */
    public String getRoleSn() {
        return roleSn;
    }

    /**
     * {@linkplain #roleSn}
     * @param roleSn the value for domy_admin_role.role_sn
     */
    public void setRoleSn(String roleSn) {
        this.roleSn = roleSn == null ? null : roleSn.trim();
    }
}