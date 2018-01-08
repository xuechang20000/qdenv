package com.xuechen.web.bo;

import java.util.ArrayList;
import java.util.List;

public class AppPermissionTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppPermissionTypeExample() {
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

        public Criteria andPermissionTypeIdIsNull() {
            addCriterion("permission_type_id is null");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIdIsNotNull() {
            addCriterion("permission_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIdEqualTo(Integer value) {
            addCriterion("permission_type_id =", value, "permissionTypeId");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIdNotEqualTo(Integer value) {
            addCriterion("permission_type_id <>", value, "permissionTypeId");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIdGreaterThan(Integer value) {
            addCriterion("permission_type_id >", value, "permissionTypeId");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission_type_id >=", value, "permissionTypeId");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIdLessThan(Integer value) {
            addCriterion("permission_type_id <", value, "permissionTypeId");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("permission_type_id <=", value, "permissionTypeId");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIdIn(List<Integer> values) {
            addCriterion("permission_type_id in", values, "permissionTypeId");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIdNotIn(List<Integer> values) {
            addCriterion("permission_type_id not in", values, "permissionTypeId");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("permission_type_id between", value1, value2, "permissionTypeId");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("permission_type_id not between", value1, value2, "permissionTypeId");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameIsNull() {
            addCriterion("permission_type_name is null");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameIsNotNull() {
            addCriterion("permission_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameEqualTo(String value) {
            addCriterion("permission_type_name =", value, "permissionTypeName");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameNotEqualTo(String value) {
            addCriterion("permission_type_name <>", value, "permissionTypeName");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameGreaterThan(String value) {
            addCriterion("permission_type_name >", value, "permissionTypeName");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("permission_type_name >=", value, "permissionTypeName");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameLessThan(String value) {
            addCriterion("permission_type_name <", value, "permissionTypeName");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameLessThanOrEqualTo(String value) {
            addCriterion("permission_type_name <=", value, "permissionTypeName");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameLike(String value) {
            addCriterion("permission_type_name like", value, "permissionTypeName");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameNotLike(String value) {
            addCriterion("permission_type_name not like", value, "permissionTypeName");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameIn(List<String> values) {
            addCriterion("permission_type_name in", values, "permissionTypeName");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameNotIn(List<String> values) {
            addCriterion("permission_type_name not in", values, "permissionTypeName");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameBetween(String value1, String value2) {
            addCriterion("permission_type_name between", value1, value2, "permissionTypeName");
            return (Criteria) this;
        }

        public Criteria andPermissionTypeNameNotBetween(String value1, String value2) {
            addCriterion("permission_type_name not between", value1, value2, "permissionTypeName");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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