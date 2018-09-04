package com.zhiyou100.crowdFunding.vo;

public class Region {
	private Integer regionId;
	private String regionCode;
	private String regionName;
	private Integer parentId;
	private Integer regionLevel;
	private Integer regionOrder;
	private String regionNameEn;
	private String regionShortnameEn;

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getRegionLevel() {
		return regionLevel;
	}

	public void setRegionLevel(Integer regionLevel) {
		this.regionLevel = regionLevel;
	}

	public Integer getRegionOrder() {
		return regionOrder;
	}

	public void setRegionOrder(Integer regionOrder) {
		this.regionOrder = regionOrder;
	}

	public String getRegionNameEn() {
		return regionNameEn;
	}

	public void setRegionNameEn(String regionNameEn) {
		this.regionNameEn = regionNameEn;
	}

	public String getRegionShortnameEn() {
		return regionShortnameEn;
	}

	public void setRegionShortnameEn(String regionShortnameEn) {
		this.regionShortnameEn = regionShortnameEn;
	}

	public Region() {
		super();
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionCode=" + regionCode + ", regionName=" + regionName
				+ ", parentId=" + parentId + ", regionLevel=" + regionLevel + ", regionOrder=" + regionOrder
				+ ", regionNameEn=" + regionNameEn + ", regionShortnameEn=" + regionShortnameEn + "\n";
	}

}
