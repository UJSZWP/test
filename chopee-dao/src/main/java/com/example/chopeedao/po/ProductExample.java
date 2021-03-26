package com.example.chopeedao.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductNumIsNull() {
            addCriterion("productNum is null");
            return (Criteria) this;
        }

        public Criteria andProductNumIsNotNull() {
            addCriterion("productNum is not null");
            return (Criteria) this;
        }

        public Criteria andProductNumEqualTo(String value) {
            addCriterion("productNum =", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumNotEqualTo(String value) {
            addCriterion("productNum <>", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumGreaterThan(String value) {
            addCriterion("productNum >", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumGreaterThanOrEqualTo(String value) {
            addCriterion("productNum >=", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumLessThan(String value) {
            addCriterion("productNum <", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumLessThanOrEqualTo(String value) {
            addCriterion("productNum <=", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumLike(String value) {
            addCriterion("productNum like", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumNotLike(String value) {
            addCriterion("productNum not like", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumIn(List<String> values) {
            addCriterion("productNum in", values, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumNotIn(List<String> values) {
            addCriterion("productNum not in", values, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumBetween(String value1, String value2) {
            addCriterion("productNum between", value1, value2, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumNotBetween(String value1, String value2) {
            addCriterion("productNum not between", value1, value2, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("productName is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("productName is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("productName =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("productName <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("productName >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("productName >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("productName <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("productName <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("productName like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("productName not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("productName in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("productName not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("productName between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("productName not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIsNull() {
            addCriterion("photoUrl is null");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIsNotNull() {
            addCriterion("photoUrl is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlEqualTo(String value) {
            addCriterion("photoUrl =", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotEqualTo(String value) {
            addCriterion("photoUrl <>", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThan(String value) {
            addCriterion("photoUrl >", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("photoUrl >=", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThan(String value) {
            addCriterion("photoUrl <", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("photoUrl <=", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLike(String value) {
            addCriterion("photoUrl like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotLike(String value) {
            addCriterion("photoUrl not like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIn(List<String> values) {
            addCriterion("photoUrl in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotIn(List<String> values) {
            addCriterion("photoUrl not in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlBetween(String value1, String value2) {
            addCriterion("photoUrl between", value1, value2, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("photoUrl not between", value1, value2, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdIsNull() {
            addCriterion("productCategoryId is null");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdIsNotNull() {
            addCriterion("productCategoryId is not null");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdEqualTo(String value) {
            addCriterion("productCategoryId =", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdNotEqualTo(String value) {
            addCriterion("productCategoryId <>", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdGreaterThan(String value) {
            addCriterion("productCategoryId >", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("productCategoryId >=", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdLessThan(String value) {
            addCriterion("productCategoryId <", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("productCategoryId <=", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdLike(String value) {
            addCriterion("productCategoryId like", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdNotLike(String value) {
            addCriterion("productCategoryId not like", value, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdIn(List<String> values) {
            addCriterion("productCategoryId in", values, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdNotIn(List<String> values) {
            addCriterion("productCategoryId not in", values, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdBetween(String value1, String value2) {
            addCriterion("productCategoryId between", value1, value2, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryIdNotBetween(String value1, String value2) {
            addCriterion("productCategoryId not between", value1, value2, "productCategoryId");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameIsNull() {
            addCriterion("productCategoryName is null");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameIsNotNull() {
            addCriterion("productCategoryName is not null");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameEqualTo(String value) {
            addCriterion("productCategoryName =", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameNotEqualTo(String value) {
            addCriterion("productCategoryName <>", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameGreaterThan(String value) {
            addCriterion("productCategoryName >", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("productCategoryName >=", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameLessThan(String value) {
            addCriterion("productCategoryName <", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("productCategoryName <=", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameLike(String value) {
            addCriterion("productCategoryName like", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameNotLike(String value) {
            addCriterion("productCategoryName not like", value, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameIn(List<String> values) {
            addCriterion("productCategoryName in", values, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameNotIn(List<String> values) {
            addCriterion("productCategoryName not in", values, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameBetween(String value1, String value2) {
            addCriterion("productCategoryName between", value1, value2, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductCategoryNameNotBetween(String value1, String value2) {
            addCriterion("productCategoryName not between", value1, value2, "productCategoryName");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNull() {
            addCriterion("productPrice is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNotNull() {
            addCriterion("productPrice is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceEqualTo(String value) {
            addCriterion("productPrice =", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotEqualTo(String value) {
            addCriterion("productPrice <>", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThan(String value) {
            addCriterion("productPrice >", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThanOrEqualTo(String value) {
            addCriterion("productPrice >=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThan(String value) {
            addCriterion("productPrice <", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThanOrEqualTo(String value) {
            addCriterion("productPrice <=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLike(String value) {
            addCriterion("productPrice like", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotLike(String value) {
            addCriterion("productPrice not like", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceIn(List<String> values) {
            addCriterion("productPrice in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotIn(List<String> values) {
            addCriterion("productPrice not in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceBetween(String value1, String value2) {
            addCriterion("productPrice between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotBetween(String value1, String value2) {
            addCriterion("productPrice not between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceIsNull() {
            addCriterion("expressPrice is null");
            return (Criteria) this;
        }

        public Criteria andExpressPriceIsNotNull() {
            addCriterion("expressPrice is not null");
            return (Criteria) this;
        }

        public Criteria andExpressPriceEqualTo(String value) {
            addCriterion("expressPrice =", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceNotEqualTo(String value) {
            addCriterion("expressPrice <>", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceGreaterThan(String value) {
            addCriterion("expressPrice >", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceGreaterThanOrEqualTo(String value) {
            addCriterion("expressPrice >=", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceLessThan(String value) {
            addCriterion("expressPrice <", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceLessThanOrEqualTo(String value) {
            addCriterion("expressPrice <=", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceLike(String value) {
            addCriterion("expressPrice like", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceNotLike(String value) {
            addCriterion("expressPrice not like", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceIn(List<String> values) {
            addCriterion("expressPrice in", values, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceNotIn(List<String> values) {
            addCriterion("expressPrice not in", values, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceBetween(String value1, String value2) {
            addCriterion("expressPrice between", value1, value2, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceNotBetween(String value1, String value2) {
            addCriterion("expressPrice not between", value1, value2, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdIsNull() {
            addCriterion("productStatusId is null");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdIsNotNull() {
            addCriterion("productStatusId is not null");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdEqualTo(String value) {
            addCriterion("productStatusId =", value, "productStatusId");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdNotEqualTo(String value) {
            addCriterion("productStatusId <>", value, "productStatusId");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdGreaterThan(String value) {
            addCriterion("productStatusId >", value, "productStatusId");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdGreaterThanOrEqualTo(String value) {
            addCriterion("productStatusId >=", value, "productStatusId");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdLessThan(String value) {
            addCriterion("productStatusId <", value, "productStatusId");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdLessThanOrEqualTo(String value) {
            addCriterion("productStatusId <=", value, "productStatusId");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdLike(String value) {
            addCriterion("productStatusId like", value, "productStatusId");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdNotLike(String value) {
            addCriterion("productStatusId not like", value, "productStatusId");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdIn(List<String> values) {
            addCriterion("productStatusId in", values, "productStatusId");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdNotIn(List<String> values) {
            addCriterion("productStatusId not in", values, "productStatusId");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdBetween(String value1, String value2) {
            addCriterion("productStatusId between", value1, value2, "productStatusId");
            return (Criteria) this;
        }

        public Criteria andProductStatusIdNotBetween(String value1, String value2) {
            addCriterion("productStatusId not between", value1, value2, "productStatusId");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameIsNull() {
            addCriterion("productStatusName is null");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameIsNotNull() {
            addCriterion("productStatusName is not null");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameEqualTo(String value) {
            addCriterion("productStatusName =", value, "productStatusName");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameNotEqualTo(String value) {
            addCriterion("productStatusName <>", value, "productStatusName");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameGreaterThan(String value) {
            addCriterion("productStatusName >", value, "productStatusName");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameGreaterThanOrEqualTo(String value) {
            addCriterion("productStatusName >=", value, "productStatusName");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameLessThan(String value) {
            addCriterion("productStatusName <", value, "productStatusName");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameLessThanOrEqualTo(String value) {
            addCriterion("productStatusName <=", value, "productStatusName");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameLike(String value) {
            addCriterion("productStatusName like", value, "productStatusName");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameNotLike(String value) {
            addCriterion("productStatusName not like", value, "productStatusName");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameIn(List<String> values) {
            addCriterion("productStatusName in", values, "productStatusName");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameNotIn(List<String> values) {
            addCriterion("productStatusName not in", values, "productStatusName");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameBetween(String value1, String value2) {
            addCriterion("productStatusName between", value1, value2, "productStatusName");
            return (Criteria) this;
        }

        public Criteria andProductStatusNameNotBetween(String value1, String value2) {
            addCriterion("productStatusName not between", value1, value2, "productStatusName");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("isDelete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("isDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("isDelete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(String value) {
            addCriterion("isDelete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(String value) {
            addCriterion("isDelete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("isDelete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(String value) {
            addCriterion("isDelete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(String value) {
            addCriterion("isDelete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLike(String value) {
            addCriterion("isDelete like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(String value) {
            addCriterion("isDelete not like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<String> values) {
            addCriterion("isDelete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<String> values) {
            addCriterion("isDelete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(String value1, String value2) {
            addCriterion("isDelete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(String value1, String value2) {
            addCriterion("isDelete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("addTime is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("addTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("addTime =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("addTime <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("addTime >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addTime >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("addTime <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("addTime <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("addTime in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("addTime not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("addTime between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("addTime not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
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