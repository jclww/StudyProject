package com.lww.shiro.enitity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * 
 * @author hiveview
 * @date 2017-05-22 17:25:54
 * @version 1.0.0
 * @copyright www.hiveview.com
 */
@Data
public class Resource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 资源编码.
     */
    private String sn;

    /**
     * 资源名称.
     */
    private String name;

    /**
     * 资源路径.
     */
    private String url;

    /**
     * 是否是菜单(1:菜单,2:权限项).
     */
    private Integer isMenu;

    /**
     * 排序字段.
     */
    private Integer orders;

    /**
     * 父资源编码.
     */
    private String parentSn;

    /**
     * 级别.
     */
    private Integer level;

    /**
     * 样式编号,用于菜单显示图标.
     */
    private String iconCode;

    /**
     * 状态(1:启用,0:禁用).
     */
    private Integer status;
    
    /**
     * 权限标识
     */
    private String permission;

    /**
     * 备注.
     */
    private String remark;

    /**
     * 长编码.
     */
    private String treePath;

    /**
     * --------------------非表中字段-------------------
     */
    private String roleSn;//用于区分 权限 属于哪一个 角色

    /**
     * 下级数据
     */
    //@JsonIgnore
    @JSONField(serialize = false)
    private List<Resource> childList;

}