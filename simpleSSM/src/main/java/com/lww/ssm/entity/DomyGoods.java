package com.lww.ssm.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DomyGoods {
    private Long id;

    private Long version;

    private String name;

    private Date createDate;

    private Date lastUpdateDate;

    private String lastUpdateBy;

    private String createBy;

    private String caption;

    private Boolean isList;

    private Integer marketStatus;

    private Boolean isTop;

    private Boolean isDelivery;

    private String keyword;

    private BigDecimal marketPrice;

    private String unit;

    private Long hits;

    private Integer type;

    private BigDecimal weight;

    private BigDecimal price;

    private String image;

    private String video;

    private Long sales;

    private Boolean isValid;

    private String remark;

    private String errorImage;

    private String overrideImage;

    private Integer productType;

    private Integer apply;

    private String applyExplain;

    private String link;

    private String productTitle;

    private String sn;

    private String platform;

    private String brandSn;

    private Boolean isReturn;

    private String supportSn;

    private Boolean isVirtual;

    private Date marketUpDate;

    private Date marketDownDate;

    private Date expectMarketDownDate;

    private BigDecimal minPrice;

    private BigDecimal maxPrice;

    private String deliveryTemplateSn;

    private String sellerId;

    private String categoryTreePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
    }

    public Boolean getIsList() {
        return isList;
    }

    public void setIsList(Boolean isList) {
        this.isList = isList;
    }

    public Integer getMarketStatus() {
        return marketStatus;
    }

    public void setMarketStatus(Integer marketStatus) {
        this.marketStatus = marketStatus;
    }

    public Boolean getIsTop() {
        return isTop;
    }

    public void setIsTop(Boolean isTop) {
        this.isTop = isTop;
    }

    public Boolean getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(Boolean isDelivery) {
        this.isDelivery = isDelivery;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Long getHits() {
        return hits;
    }

    public void setHits(Long hits) {
        this.hits = hits;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getErrorImage() {
        return errorImage;
    }

    public void setErrorImage(String errorImage) {
        this.errorImage = errorImage == null ? null : errorImage.trim();
    }

    public String getOverrideImage() {
        return overrideImage;
    }

    public void setOverrideImage(String overrideImage) {
        this.overrideImage = overrideImage == null ? null : overrideImage.trim();
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getApply() {
        return apply;
    }

    public void setApply(Integer apply) {
        this.apply = apply;
    }

    public String getApplyExplain() {
        return applyExplain;
    }

    public void setApplyExplain(String applyExplain) {
        this.applyExplain = applyExplain == null ? null : applyExplain.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle == null ? null : productTitle.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getBrandSn() {
        return brandSn;
    }

    public void setBrandSn(String brandSn) {
        this.brandSn = brandSn == null ? null : brandSn.trim();
    }

    public Boolean getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Boolean isReturn) {
        this.isReturn = isReturn;
    }

    public String getSupportSn() {
        return supportSn;
    }

    public void setSupportSn(String supportSn) {
        this.supportSn = supportSn == null ? null : supportSn.trim();
    }

    public Boolean getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Boolean isVirtual) {
        this.isVirtual = isVirtual;
    }

    public Date getMarketUpDate() {
        return marketUpDate;
    }

    public void setMarketUpDate(Date marketUpDate) {
        this.marketUpDate = marketUpDate;
    }

    public Date getMarketDownDate() {
        return marketDownDate;
    }

    public void setMarketDownDate(Date marketDownDate) {
        this.marketDownDate = marketDownDate;
    }

    public Date getExpectMarketDownDate() {
        return expectMarketDownDate;
    }

    public void setExpectMarketDownDate(Date expectMarketDownDate) {
        this.expectMarketDownDate = expectMarketDownDate;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getDeliveryTemplateSn() {
        return deliveryTemplateSn;
    }

    public void setDeliveryTemplateSn(String deliveryTemplateSn) {
        this.deliveryTemplateSn = deliveryTemplateSn == null ? null : deliveryTemplateSn.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getCategoryTreePath() {
        return categoryTreePath;
    }

    public void setCategoryTreePath(String categoryTreePath) {
        this.categoryTreePath = categoryTreePath == null ? null : categoryTreePath.trim();
    }
}