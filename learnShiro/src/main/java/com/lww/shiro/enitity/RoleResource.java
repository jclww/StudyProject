package com.lww.shiro.enitity;

import lombok.Data;

/**
 * 
 * @author hiveview
 * @date 2017-05-23 11:14:43
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
@Data
public class RoleResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编码.
     */
    private String roleSn;

    /**
     * 资源编码.
     */
    private String resourceSn;

}