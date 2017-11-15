package com.lww.shiro.enitity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author leo
 * 基类
 */
public class BaseEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 5557663618469589569L;
	/**
	 * 主键ID
	 */
    private String id;

	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 创建人
	 */
	private DomyAdmin createBy;
	
	/**
	 * 最新更新
	 */
	private DomyAdmin lastUpdateBy;

	/**
	 * 更新时间
	 */
    private Date lastUpdateDate;

	/**
	 * 排序字段
	 */
	private Integer orders;

	/**
	 * 表示当前页页码，即当前页是第几页
	 *
	 * **/
	//private int pageIndex;

	/**
	 * 每页显示记录数，即一页要显示多少条记录
	 * **/
	//private int pageSize;
	

	public DomyAdmin getCreateBy() {
		return createBy;
	}

	public void setCreateBy(DomyAdmin createBy) {
		this.createBy = createBy;
	}

	public DomyAdmin getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(DomyAdmin lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}
}
