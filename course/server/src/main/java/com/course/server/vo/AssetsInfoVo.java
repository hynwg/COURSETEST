package com.course.server.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AssetsInfoVo {

    /**
     * id
     */
    private String id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 支付宝
     */
    private BigDecimal alipayPrice;

    /**
     * 微信
     */
    private BigDecimal wechatPrice;

    /**
     * 储蓄卡
     */
    private BigDecimal depositCardPrice;

    /**
     * 借出
     */
    private BigDecimal lendPrice;

    /**
     * 基金
     */
    private BigDecimal fundPrice;

    /**
     * 涨乐富
     */
    private BigDecimal zlfPrice;

    /**
     * 股票
     */
    private BigDecimal stocksPrice;

    /**
     * 黄金
     */
    private BigDecimal goldPrice;

    /**
     * 借入
     */
    private BigDecimal bondsPrice;

    /**
     * 债券
     */
    private BigDecimal borrowPrice;

    /**
     * 花呗
     */
    private BigDecimal flowersPrice;

    /**
     * 信用卡
     */
    private BigDecimal creditPrice;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdAt;

    /**
     * 修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedAt;

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
