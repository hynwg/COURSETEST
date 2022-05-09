package com.course.server.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssetsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetsInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAlipayPriceIsNull() {
            addCriterion("alipay_price is null");
            return (Criteria) this;
        }

        public Criteria andAlipayPriceIsNotNull() {
            addCriterion("alipay_price is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayPriceEqualTo(BigDecimal value) {
            addCriterion("alipay_price =", value, "alipayPrice");
            return (Criteria) this;
        }

        public Criteria andAlipayPriceNotEqualTo(BigDecimal value) {
            addCriterion("alipay_price <>", value, "alipayPrice");
            return (Criteria) this;
        }

        public Criteria andAlipayPriceGreaterThan(BigDecimal value) {
            addCriterion("alipay_price >", value, "alipayPrice");
            return (Criteria) this;
        }

        public Criteria andAlipayPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("alipay_price >=", value, "alipayPrice");
            return (Criteria) this;
        }

        public Criteria andAlipayPriceLessThan(BigDecimal value) {
            addCriterion("alipay_price <", value, "alipayPrice");
            return (Criteria) this;
        }

        public Criteria andAlipayPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("alipay_price <=", value, "alipayPrice");
            return (Criteria) this;
        }

        public Criteria andAlipayPriceIn(List<BigDecimal> values) {
            addCriterion("alipay_price in", values, "alipayPrice");
            return (Criteria) this;
        }

        public Criteria andAlipayPriceNotIn(List<BigDecimal> values) {
            addCriterion("alipay_price not in", values, "alipayPrice");
            return (Criteria) this;
        }

        public Criteria andAlipayPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("alipay_price between", value1, value2, "alipayPrice");
            return (Criteria) this;
        }

        public Criteria andAlipayPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("alipay_price not between", value1, value2, "alipayPrice");
            return (Criteria) this;
        }

        public Criteria andWechatPriceIsNull() {
            addCriterion("wechat_price is null");
            return (Criteria) this;
        }

        public Criteria andWechatPriceIsNotNull() {
            addCriterion("wechat_price is not null");
            return (Criteria) this;
        }

        public Criteria andWechatPriceEqualTo(BigDecimal value) {
            addCriterion("wechat_price =", value, "wechatPrice");
            return (Criteria) this;
        }

        public Criteria andWechatPriceNotEqualTo(BigDecimal value) {
            addCriterion("wechat_price <>", value, "wechatPrice");
            return (Criteria) this;
        }

        public Criteria andWechatPriceGreaterThan(BigDecimal value) {
            addCriterion("wechat_price >", value, "wechatPrice");
            return (Criteria) this;
        }

        public Criteria andWechatPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("wechat_price >=", value, "wechatPrice");
            return (Criteria) this;
        }

        public Criteria andWechatPriceLessThan(BigDecimal value) {
            addCriterion("wechat_price <", value, "wechatPrice");
            return (Criteria) this;
        }

        public Criteria andWechatPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("wechat_price <=", value, "wechatPrice");
            return (Criteria) this;
        }

        public Criteria andWechatPriceIn(List<BigDecimal> values) {
            addCriterion("wechat_price in", values, "wechatPrice");
            return (Criteria) this;
        }

        public Criteria andWechatPriceNotIn(List<BigDecimal> values) {
            addCriterion("wechat_price not in", values, "wechatPrice");
            return (Criteria) this;
        }

        public Criteria andWechatPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wechat_price between", value1, value2, "wechatPrice");
            return (Criteria) this;
        }

        public Criteria andWechatPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wechat_price not between", value1, value2, "wechatPrice");
            return (Criteria) this;
        }

        public Criteria andDepositCardPriceIsNull() {
            addCriterion("deposit_card_price is null");
            return (Criteria) this;
        }

        public Criteria andDepositCardPriceIsNotNull() {
            addCriterion("deposit_card_price is not null");
            return (Criteria) this;
        }

        public Criteria andDepositCardPriceEqualTo(BigDecimal value) {
            addCriterion("deposit_card_price =", value, "depositCardPrice");
            return (Criteria) this;
        }

        public Criteria andDepositCardPriceNotEqualTo(BigDecimal value) {
            addCriterion("deposit_card_price <>", value, "depositCardPrice");
            return (Criteria) this;
        }

        public Criteria andDepositCardPriceGreaterThan(BigDecimal value) {
            addCriterion("deposit_card_price >", value, "depositCardPrice");
            return (Criteria) this;
        }

        public Criteria andDepositCardPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit_card_price >=", value, "depositCardPrice");
            return (Criteria) this;
        }

        public Criteria andDepositCardPriceLessThan(BigDecimal value) {
            addCriterion("deposit_card_price <", value, "depositCardPrice");
            return (Criteria) this;
        }

        public Criteria andDepositCardPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit_card_price <=", value, "depositCardPrice");
            return (Criteria) this;
        }

        public Criteria andDepositCardPriceIn(List<BigDecimal> values) {
            addCriterion("deposit_card_price in", values, "depositCardPrice");
            return (Criteria) this;
        }

        public Criteria andDepositCardPriceNotIn(List<BigDecimal> values) {
            addCriterion("deposit_card_price not in", values, "depositCardPrice");
            return (Criteria) this;
        }

        public Criteria andDepositCardPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit_card_price between", value1, value2, "depositCardPrice");
            return (Criteria) this;
        }

        public Criteria andDepositCardPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit_card_price not between", value1, value2, "depositCardPrice");
            return (Criteria) this;
        }

        public Criteria andLendPriceIsNull() {
            addCriterion("lend_price is null");
            return (Criteria) this;
        }

        public Criteria andLendPriceIsNotNull() {
            addCriterion("lend_price is not null");
            return (Criteria) this;
        }

        public Criteria andLendPriceEqualTo(BigDecimal value) {
            addCriterion("lend_price =", value, "lendPrice");
            return (Criteria) this;
        }

        public Criteria andLendPriceNotEqualTo(BigDecimal value) {
            addCriterion("lend_price <>", value, "lendPrice");
            return (Criteria) this;
        }

        public Criteria andLendPriceGreaterThan(BigDecimal value) {
            addCriterion("lend_price >", value, "lendPrice");
            return (Criteria) this;
        }

        public Criteria andLendPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lend_price >=", value, "lendPrice");
            return (Criteria) this;
        }

        public Criteria andLendPriceLessThan(BigDecimal value) {
            addCriterion("lend_price <", value, "lendPrice");
            return (Criteria) this;
        }

        public Criteria andLendPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lend_price <=", value, "lendPrice");
            return (Criteria) this;
        }

        public Criteria andLendPriceIn(List<BigDecimal> values) {
            addCriterion("lend_price in", values, "lendPrice");
            return (Criteria) this;
        }

        public Criteria andLendPriceNotIn(List<BigDecimal> values) {
            addCriterion("lend_price not in", values, "lendPrice");
            return (Criteria) this;
        }

        public Criteria andLendPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lend_price between", value1, value2, "lendPrice");
            return (Criteria) this;
        }

        public Criteria andLendPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lend_price not between", value1, value2, "lendPrice");
            return (Criteria) this;
        }

        public Criteria andFundPriceIsNull() {
            addCriterion("fund_price is null");
            return (Criteria) this;
        }

        public Criteria andFundPriceIsNotNull() {
            addCriterion("fund_price is not null");
            return (Criteria) this;
        }

        public Criteria andFundPriceEqualTo(BigDecimal value) {
            addCriterion("fund_price =", value, "fundPrice");
            return (Criteria) this;
        }

        public Criteria andFundPriceNotEqualTo(BigDecimal value) {
            addCriterion("fund_price <>", value, "fundPrice");
            return (Criteria) this;
        }

        public Criteria andFundPriceGreaterThan(BigDecimal value) {
            addCriterion("fund_price >", value, "fundPrice");
            return (Criteria) this;
        }

        public Criteria andFundPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fund_price >=", value, "fundPrice");
            return (Criteria) this;
        }

        public Criteria andFundPriceLessThan(BigDecimal value) {
            addCriterion("fund_price <", value, "fundPrice");
            return (Criteria) this;
        }

        public Criteria andFundPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fund_price <=", value, "fundPrice");
            return (Criteria) this;
        }

        public Criteria andFundPriceIn(List<BigDecimal> values) {
            addCriterion("fund_price in", values, "fundPrice");
            return (Criteria) this;
        }

        public Criteria andFundPriceNotIn(List<BigDecimal> values) {
            addCriterion("fund_price not in", values, "fundPrice");
            return (Criteria) this;
        }

        public Criteria andFundPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund_price between", value1, value2, "fundPrice");
            return (Criteria) this;
        }

        public Criteria andFundPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund_price not between", value1, value2, "fundPrice");
            return (Criteria) this;
        }

        public Criteria andZlfPriceIsNull() {
            addCriterion("zlf_price is null");
            return (Criteria) this;
        }

        public Criteria andZlfPriceIsNotNull() {
            addCriterion("zlf_price is not null");
            return (Criteria) this;
        }

        public Criteria andZlfPriceEqualTo(BigDecimal value) {
            addCriterion("zlf_price =", value, "zlfPrice");
            return (Criteria) this;
        }

        public Criteria andZlfPriceNotEqualTo(BigDecimal value) {
            addCriterion("zlf_price <>", value, "zlfPrice");
            return (Criteria) this;
        }

        public Criteria andZlfPriceGreaterThan(BigDecimal value) {
            addCriterion("zlf_price >", value, "zlfPrice");
            return (Criteria) this;
        }

        public Criteria andZlfPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zlf_price >=", value, "zlfPrice");
            return (Criteria) this;
        }

        public Criteria andZlfPriceLessThan(BigDecimal value) {
            addCriterion("zlf_price <", value, "zlfPrice");
            return (Criteria) this;
        }

        public Criteria andZlfPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("zlf_price <=", value, "zlfPrice");
            return (Criteria) this;
        }

        public Criteria andZlfPriceIn(List<BigDecimal> values) {
            addCriterion("zlf_price in", values, "zlfPrice");
            return (Criteria) this;
        }

        public Criteria andZlfPriceNotIn(List<BigDecimal> values) {
            addCriterion("zlf_price not in", values, "zlfPrice");
            return (Criteria) this;
        }

        public Criteria andZlfPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zlf_price between", value1, value2, "zlfPrice");
            return (Criteria) this;
        }

        public Criteria andZlfPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zlf_price not between", value1, value2, "zlfPrice");
            return (Criteria) this;
        }

        public Criteria andStocksPriceIsNull() {
            addCriterion("stocks_price is null");
            return (Criteria) this;
        }

        public Criteria andStocksPriceIsNotNull() {
            addCriterion("stocks_price is not null");
            return (Criteria) this;
        }

        public Criteria andStocksPriceEqualTo(BigDecimal value) {
            addCriterion("stocks_price =", value, "stocksPrice");
            return (Criteria) this;
        }

        public Criteria andStocksPriceNotEqualTo(BigDecimal value) {
            addCriterion("stocks_price <>", value, "stocksPrice");
            return (Criteria) this;
        }

        public Criteria andStocksPriceGreaterThan(BigDecimal value) {
            addCriterion("stocks_price >", value, "stocksPrice");
            return (Criteria) this;
        }

        public Criteria andStocksPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stocks_price >=", value, "stocksPrice");
            return (Criteria) this;
        }

        public Criteria andStocksPriceLessThan(BigDecimal value) {
            addCriterion("stocks_price <", value, "stocksPrice");
            return (Criteria) this;
        }

        public Criteria andStocksPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stocks_price <=", value, "stocksPrice");
            return (Criteria) this;
        }

        public Criteria andStocksPriceIn(List<BigDecimal> values) {
            addCriterion("stocks_price in", values, "stocksPrice");
            return (Criteria) this;
        }

        public Criteria andStocksPriceNotIn(List<BigDecimal> values) {
            addCriterion("stocks_price not in", values, "stocksPrice");
            return (Criteria) this;
        }

        public Criteria andStocksPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stocks_price between", value1, value2, "stocksPrice");
            return (Criteria) this;
        }

        public Criteria andStocksPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stocks_price not between", value1, value2, "stocksPrice");
            return (Criteria) this;
        }

        public Criteria andGoldPriceIsNull() {
            addCriterion("gold_price is null");
            return (Criteria) this;
        }

        public Criteria andGoldPriceIsNotNull() {
            addCriterion("gold_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoldPriceEqualTo(BigDecimal value) {
            addCriterion("gold_price =", value, "goldPrice");
            return (Criteria) this;
        }

        public Criteria andGoldPriceNotEqualTo(BigDecimal value) {
            addCriterion("gold_price <>", value, "goldPrice");
            return (Criteria) this;
        }

        public Criteria andGoldPriceGreaterThan(BigDecimal value) {
            addCriterion("gold_price >", value, "goldPrice");
            return (Criteria) this;
        }

        public Criteria andGoldPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gold_price >=", value, "goldPrice");
            return (Criteria) this;
        }

        public Criteria andGoldPriceLessThan(BigDecimal value) {
            addCriterion("gold_price <", value, "goldPrice");
            return (Criteria) this;
        }

        public Criteria andGoldPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gold_price <=", value, "goldPrice");
            return (Criteria) this;
        }

        public Criteria andGoldPriceIn(List<BigDecimal> values) {
            addCriterion("gold_price in", values, "goldPrice");
            return (Criteria) this;
        }

        public Criteria andGoldPriceNotIn(List<BigDecimal> values) {
            addCriterion("gold_price not in", values, "goldPrice");
            return (Criteria) this;
        }

        public Criteria andGoldPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gold_price between", value1, value2, "goldPrice");
            return (Criteria) this;
        }

        public Criteria andGoldPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gold_price not between", value1, value2, "goldPrice");
            return (Criteria) this;
        }

        public Criteria andBondsPriceIsNull() {
            addCriterion("bonds_price is null");
            return (Criteria) this;
        }

        public Criteria andBondsPriceIsNotNull() {
            addCriterion("bonds_price is not null");
            return (Criteria) this;
        }

        public Criteria andBondsPriceEqualTo(BigDecimal value) {
            addCriterion("bonds_price =", value, "bondsPrice");
            return (Criteria) this;
        }

        public Criteria andBondsPriceNotEqualTo(BigDecimal value) {
            addCriterion("bonds_price <>", value, "bondsPrice");
            return (Criteria) this;
        }

        public Criteria andBondsPriceGreaterThan(BigDecimal value) {
            addCriterion("bonds_price >", value, "bondsPrice");
            return (Criteria) this;
        }

        public Criteria andBondsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bonds_price >=", value, "bondsPrice");
            return (Criteria) this;
        }

        public Criteria andBondsPriceLessThan(BigDecimal value) {
            addCriterion("bonds_price <", value, "bondsPrice");
            return (Criteria) this;
        }

        public Criteria andBondsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bonds_price <=", value, "bondsPrice");
            return (Criteria) this;
        }

        public Criteria andBondsPriceIn(List<BigDecimal> values) {
            addCriterion("bonds_price in", values, "bondsPrice");
            return (Criteria) this;
        }

        public Criteria andBondsPriceNotIn(List<BigDecimal> values) {
            addCriterion("bonds_price not in", values, "bondsPrice");
            return (Criteria) this;
        }

        public Criteria andBondsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonds_price between", value1, value2, "bondsPrice");
            return (Criteria) this;
        }

        public Criteria andBondsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonds_price not between", value1, value2, "bondsPrice");
            return (Criteria) this;
        }

        public Criteria andBorrowPriceIsNull() {
            addCriterion("borrow_price is null");
            return (Criteria) this;
        }

        public Criteria andBorrowPriceIsNotNull() {
            addCriterion("borrow_price is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowPriceEqualTo(BigDecimal value) {
            addCriterion("borrow_price =", value, "borrowPrice");
            return (Criteria) this;
        }

        public Criteria andBorrowPriceNotEqualTo(BigDecimal value) {
            addCriterion("borrow_price <>", value, "borrowPrice");
            return (Criteria) this;
        }

        public Criteria andBorrowPriceGreaterThan(BigDecimal value) {
            addCriterion("borrow_price >", value, "borrowPrice");
            return (Criteria) this;
        }

        public Criteria andBorrowPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("borrow_price >=", value, "borrowPrice");
            return (Criteria) this;
        }

        public Criteria andBorrowPriceLessThan(BigDecimal value) {
            addCriterion("borrow_price <", value, "borrowPrice");
            return (Criteria) this;
        }

        public Criteria andBorrowPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("borrow_price <=", value, "borrowPrice");
            return (Criteria) this;
        }

        public Criteria andBorrowPriceIn(List<BigDecimal> values) {
            addCriterion("borrow_price in", values, "borrowPrice");
            return (Criteria) this;
        }

        public Criteria andBorrowPriceNotIn(List<BigDecimal> values) {
            addCriterion("borrow_price not in", values, "borrowPrice");
            return (Criteria) this;
        }

        public Criteria andBorrowPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("borrow_price between", value1, value2, "borrowPrice");
            return (Criteria) this;
        }

        public Criteria andBorrowPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("borrow_price not between", value1, value2, "borrowPrice");
            return (Criteria) this;
        }

        public Criteria andFlowersPriceIsNull() {
            addCriterion("flowers_price is null");
            return (Criteria) this;
        }

        public Criteria andFlowersPriceIsNotNull() {
            addCriterion("flowers_price is not null");
            return (Criteria) this;
        }

        public Criteria andFlowersPriceEqualTo(BigDecimal value) {
            addCriterion("flowers_price =", value, "flowersPrice");
            return (Criteria) this;
        }

        public Criteria andFlowersPriceNotEqualTo(BigDecimal value) {
            addCriterion("flowers_price <>", value, "flowersPrice");
            return (Criteria) this;
        }

        public Criteria andFlowersPriceGreaterThan(BigDecimal value) {
            addCriterion("flowers_price >", value, "flowersPrice");
            return (Criteria) this;
        }

        public Criteria andFlowersPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("flowers_price >=", value, "flowersPrice");
            return (Criteria) this;
        }

        public Criteria andFlowersPriceLessThan(BigDecimal value) {
            addCriterion("flowers_price <", value, "flowersPrice");
            return (Criteria) this;
        }

        public Criteria andFlowersPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("flowers_price <=", value, "flowersPrice");
            return (Criteria) this;
        }

        public Criteria andFlowersPriceIn(List<BigDecimal> values) {
            addCriterion("flowers_price in", values, "flowersPrice");
            return (Criteria) this;
        }

        public Criteria andFlowersPriceNotIn(List<BigDecimal> values) {
            addCriterion("flowers_price not in", values, "flowersPrice");
            return (Criteria) this;
        }

        public Criteria andFlowersPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flowers_price between", value1, value2, "flowersPrice");
            return (Criteria) this;
        }

        public Criteria andFlowersPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flowers_price not between", value1, value2, "flowersPrice");
            return (Criteria) this;
        }

        public Criteria andCreditPriceIsNull() {
            addCriterion("credit_price is null");
            return (Criteria) this;
        }

        public Criteria andCreditPriceIsNotNull() {
            addCriterion("credit_price is not null");
            return (Criteria) this;
        }

        public Criteria andCreditPriceEqualTo(BigDecimal value) {
            addCriterion("credit_price =", value, "creditPrice");
            return (Criteria) this;
        }

        public Criteria andCreditPriceNotEqualTo(BigDecimal value) {
            addCriterion("credit_price <>", value, "creditPrice");
            return (Criteria) this;
        }

        public Criteria andCreditPriceGreaterThan(BigDecimal value) {
            addCriterion("credit_price >", value, "creditPrice");
            return (Criteria) this;
        }

        public Criteria andCreditPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("credit_price >=", value, "creditPrice");
            return (Criteria) this;
        }

        public Criteria andCreditPriceLessThan(BigDecimal value) {
            addCriterion("credit_price <", value, "creditPrice");
            return (Criteria) this;
        }

        public Criteria andCreditPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("credit_price <=", value, "creditPrice");
            return (Criteria) this;
        }

        public Criteria andCreditPriceIn(List<BigDecimal> values) {
            addCriterion("credit_price in", values, "creditPrice");
            return (Criteria) this;
        }

        public Criteria andCreditPriceNotIn(List<BigDecimal> values) {
            addCriterion("credit_price not in", values, "creditPrice");
            return (Criteria) this;
        }

        public Criteria andCreditPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("credit_price between", value1, value2, "creditPrice");
            return (Criteria) this;
        }

        public Criteria andCreditPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("credit_price not between", value1, value2, "creditPrice");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}