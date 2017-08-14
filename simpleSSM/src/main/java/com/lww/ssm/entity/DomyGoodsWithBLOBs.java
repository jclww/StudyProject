package com.lww.ssm.entity;

public class DomyGoodsWithBLOBs extends DomyGoods {
    private String description;

    private String parameterValues;

    private String attributeValues;

    private String productImages;

    private String productVideos;

    private String specificationItems;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getParameterValues() {
        return parameterValues;
    }

    public void setParameterValues(String parameterValues) {
        this.parameterValues = parameterValues == null ? null : parameterValues.trim();
    }

    public String getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(String attributeValues) {
        this.attributeValues = attributeValues == null ? null : attributeValues.trim();
    }

    public String getProductImages() {
        return productImages;
    }

    public void setProductImages(String productImages) {
        this.productImages = productImages == null ? null : productImages.trim();
    }

    public String getProductVideos() {
        return productVideos;
    }

    public void setProductVideos(String productVideos) {
        this.productVideos = productVideos == null ? null : productVideos.trim();
    }

    public String getSpecificationItems() {
        return specificationItems;
    }

    public void setSpecificationItems(String specificationItems) {
        this.specificationItems = specificationItems == null ? null : specificationItems.trim();
    }
}