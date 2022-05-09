package com.course.server.entity;

import java.math.BigDecimal;
import java.util.Date;

public class AssetsInfo {
    private String id;

    private String userName;

    private String userId;

    private BigDecimal alipayPrice;

    private BigDecimal wechatPrice;

    private BigDecimal depositCardPrice;

    private BigDecimal lendPrice;

    private BigDecimal fundPrice;

    private BigDecimal zlfPrice;

    private BigDecimal stocksPrice;

    private BigDecimal goldPrice;

    private BigDecimal bondsPrice;

    private BigDecimal borrowPrice;

    private BigDecimal flowersPrice;

    private BigDecimal creditPrice;

    private String remarks;

    private Date createdAt;

    private Date updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAlipayPrice() {
        return alipayPrice;
    }

    public void setAlipayPrice(BigDecimal alipayPrice) {
        this.alipayPrice = alipayPrice;
    }

    public BigDecimal getWechatPrice() {
        return wechatPrice;
    }

    public void setWechatPrice(BigDecimal wechatPrice) {
        this.wechatPrice = wechatPrice;
    }

    public BigDecimal getDepositCardPrice() {
        return depositCardPrice;
    }

    public void setDepositCardPrice(BigDecimal depositCardPrice) {
        this.depositCardPrice = depositCardPrice;
    }

    public BigDecimal getLendPrice() {
        return lendPrice;
    }

    public void setLendPrice(BigDecimal lendPrice) {
        this.lendPrice = lendPrice;
    }

    public BigDecimal getFundPrice() {
        return fundPrice;
    }

    public void setFundPrice(BigDecimal fundPrice) {
        this.fundPrice = fundPrice;
    }

    public BigDecimal getZlfPrice() {
        return zlfPrice;
    }

    public void setZlfPrice(BigDecimal zlfPrice) {
        this.zlfPrice = zlfPrice;
    }

    public BigDecimal getStocksPrice() {
        return stocksPrice;
    }

    public void setStocksPrice(BigDecimal stocksPrice) {
        this.stocksPrice = stocksPrice;
    }

    public BigDecimal getGoldPrice() {
        return goldPrice;
    }

    public void setGoldPrice(BigDecimal goldPrice) {
        this.goldPrice = goldPrice;
    }

    public BigDecimal getBondsPrice() {
        return bondsPrice;
    }

    public void setBondsPrice(BigDecimal bondsPrice) {
        this.bondsPrice = bondsPrice;
    }

    public BigDecimal getBorrowPrice() {
        return borrowPrice;
    }

    public void setBorrowPrice(BigDecimal borrowPrice) {
        this.borrowPrice = borrowPrice;
    }

    public BigDecimal getFlowersPrice() {
        return flowersPrice;
    }

    public void setFlowersPrice(BigDecimal flowersPrice) {
        this.flowersPrice = flowersPrice;
    }

    public BigDecimal getCreditPrice() {
        return creditPrice;
    }

    public void setCreditPrice(BigDecimal creditPrice) {
        this.creditPrice = creditPrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", userId=").append(userId);
        sb.append(", alipayPrice=").append(alipayPrice);
        sb.append(", wechatPrice=").append(wechatPrice);
        sb.append(", depositCardPrice=").append(depositCardPrice);
        sb.append(", lendPrice=").append(lendPrice);
        sb.append(", fundPrice=").append(fundPrice);
        sb.append(", zlfPrice=").append(zlfPrice);
        sb.append(", stocksPrice=").append(stocksPrice);
        sb.append(", goldPrice=").append(goldPrice);
        sb.append(", bondsPrice=").append(bondsPrice);
        sb.append(", borrowPrice=").append(borrowPrice);
        sb.append(", flowersPrice=").append(flowersPrice);
        sb.append(", creditPrice=").append(creditPrice);
        sb.append(", remarks=").append(remarks);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append("]");
        return sb.toString();
    }
}