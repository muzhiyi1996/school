package com.yang.o2o.entity;
import java.util.Date;
public class Area {
	private Integer areaId;			//ID
	private String areaName;		//区域名称
	//private String areaDesc;		//
	private Integer priority;		//权重
	private Date createTime;		//创建时间
	private Date lastEditTime;		//修改时间

	

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/*
	 * public String getAreaDesc() { return areaDesc; }
	 * 
	 * public void setAreaDesc(String areaDesc) { this.areaDesc = areaDesc; }
	 */

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

}
