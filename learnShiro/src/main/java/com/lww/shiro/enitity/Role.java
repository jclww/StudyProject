package com.lww.shiro.enitity;

import lombok.Data;

import java.util.List;

/**
 * 
 * @author hiveview
 * @date 2017-05-22 10:47:38
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
@Data
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编码.
     */
    private String sn;

    /**
     * 角色名称.
     */
    private String name;

    /**
     * 角色分类.RoleTypeEnum
     */
    private String roleType;

    /**
     * 状态 (1:启用,0:禁用).
     */
    private Integer status;

    /**
     * 备注.
     */
    private String remark;
    
    /**
     * -------------非表中字段-----------------
     */
    
    
    
    /**
     * 角色关联 资源
     */
    private List<Resource> resourceList;

}