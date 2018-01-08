package com.xuechen.web.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppNoticeUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppNoticeUserExample() {
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

        public Criteria andNoticeUserIdIsNull() {
            addCriterion("notice_user_id is null");
            return (Criteria) this;
        }

        public Criteria andNoticeUserIdIsNotNull() {
            addCriterion("notice_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeUserIdEqualTo(Integer value) {
            addCriterion("notice_user_id =", value, "noticeUserId");
            return (Criteria) this;
        }

        public Criteria andNoticeUserIdNotEqualTo(Integer value) {
            addCriterion("notice_user_id <>", value, "noticeUserId");
            return (Criteria) this;
        }

        public Criteria andNoticeUserIdGreaterThan(Integer value) {
            addCriterion("notice_user_id >", value, "noticeUserId");
            return (Criteria) this;
        }

        public Criteria andNoticeUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_user_id >=", value, "noticeUserId");
            return (Criteria) this;
        }

        public Criteria andNoticeUserIdLessThan(Integer value) {
            addCriterion("notice_user_id <", value, "noticeUserId");
            return (Criteria) this;
        }

        public Criteria andNoticeUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("notice_user_id <=", value, "noticeUserId");
            return (Criteria) this;
        }

        public Criteria andNoticeUserIdIn(List<Integer> values) {
            addCriterion("notice_user_id in", values, "noticeUserId");
            return (Criteria) this;
        }

        public Criteria andNoticeUserIdNotIn(List<Integer> values) {
            addCriterion("notice_user_id not in", values, "noticeUserId");
            return (Criteria) this;
        }

        public Criteria andNoticeUserIdBetween(Integer value1, Integer value2) {
            addCriterion("notice_user_id between", value1, value2, "noticeUserId");
            return (Criteria) this;
        }

        public Criteria andNoticeUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_user_id not between", value1, value2, "noticeUserId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIsNull() {
            addCriterion("notice_id is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIsNotNull() {
            addCriterion("notice_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdEqualTo(Integer value) {
            addCriterion("notice_id =", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotEqualTo(Integer value) {
            addCriterion("notice_id <>", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThan(Integer value) {
            addCriterion("notice_id >", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_id >=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThan(Integer value) {
            addCriterion("notice_id <", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThanOrEqualTo(Integer value) {
            addCriterion("notice_id <=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIn(List<Integer> values) {
            addCriterion("notice_id in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotIn(List<Integer> values) {
            addCriterion("notice_id not in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdBetween(Integer value1, Integer value2) {
            addCriterion("notice_id between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_id not between", value1, value2, "noticeId");
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andNoticeReadTimeIsNull() {
            addCriterion("notice_read_time is null");
            return (Criteria) this;
        }

        public Criteria andNoticeReadTimeIsNotNull() {
            addCriterion("notice_read_time is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeReadTimeEqualTo(Date value) {
            addCriterion("notice_read_time =", value, "noticeReadTime");
            return (Criteria) this;
        }

        public Criteria andNoticeReadTimeNotEqualTo(Date value) {
            addCriterion("notice_read_time <>", value, "noticeReadTime");
            return (Criteria) this;
        }

        public Criteria andNoticeReadTimeGreaterThan(Date value) {
            addCriterion("notice_read_time >", value, "noticeReadTime");
            return (Criteria) this;
        }

        public Criteria andNoticeReadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("notice_read_time >=", value, "noticeReadTime");
            return (Criteria) this;
        }

        public Criteria andNoticeReadTimeLessThan(Date value) {
            addCriterion("notice_read_time <", value, "noticeReadTime");
            return (Criteria) this;
        }

        public Criteria andNoticeReadTimeLessThanOrEqualTo(Date value) {
            addCriterion("notice_read_time <=", value, "noticeReadTime");
            return (Criteria) this;
        }

        public Criteria andNoticeReadTimeIn(List<Date> values) {
            addCriterion("notice_read_time in", values, "noticeReadTime");
            return (Criteria) this;
        }

        public Criteria andNoticeReadTimeNotIn(List<Date> values) {
            addCriterion("notice_read_time not in", values, "noticeReadTime");
            return (Criteria) this;
        }

        public Criteria andNoticeReadTimeBetween(Date value1, Date value2) {
            addCriterion("notice_read_time between", value1, value2, "noticeReadTime");
            return (Criteria) this;
        }

        public Criteria andNoticeReadTimeNotBetween(Date value1, Date value2) {
            addCriterion("notice_read_time not between", value1, value2, "noticeReadTime");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadIsNull() {
            addCriterion("notice_isread is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadIsNotNull() {
            addCriterion("notice_isread is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadEqualTo(String value) {
            addCriterion("notice_isread =", value, "noticeIsread");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadNotEqualTo(String value) {
            addCriterion("notice_isread <>", value, "noticeIsread");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadGreaterThan(String value) {
            addCriterion("notice_isread >", value, "noticeIsread");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadGreaterThanOrEqualTo(String value) {
            addCriterion("notice_isread >=", value, "noticeIsread");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadLessThan(String value) {
            addCriterion("notice_isread <", value, "noticeIsread");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadLessThanOrEqualTo(String value) {
            addCriterion("notice_isread <=", value, "noticeIsread");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadLike(String value) {
            addCriterion("notice_isread like", value, "noticeIsread");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadNotLike(String value) {
            addCriterion("notice_isread not like", value, "noticeIsread");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadIn(List<String> values) {
            addCriterion("notice_isread in", values, "noticeIsread");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadNotIn(List<String> values) {
            addCriterion("notice_isread not in", values, "noticeIsread");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadBetween(String value1, String value2) {
            addCriterion("notice_isread between", value1, value2, "noticeIsread");
            return (Criteria) this;
        }

        public Criteria andNoticeIsreadNotBetween(String value1, String value2) {
            addCriterion("notice_isread not between", value1, value2, "noticeIsread");
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