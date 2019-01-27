package com.whgc.pojo;

import java.util.ArrayList;
import java.util.List;

public class PaymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaymentExample() {
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

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPayManIsNull() {
            addCriterion("payMan is null");
            return (Criteria) this;
        }

        public Criteria andPayManIsNotNull() {
            addCriterion("payMan is not null");
            return (Criteria) this;
        }

        public Criteria andPayManEqualTo(String value) {
            addCriterion("payMan =", value, "payMan");
            return (Criteria) this;
        }

        public Criteria andPayManNotEqualTo(String value) {
            addCriterion("payMan <>", value, "payMan");
            return (Criteria) this;
        }

        public Criteria andPayManGreaterThan(String value) {
            addCriterion("payMan >", value, "payMan");
            return (Criteria) this;
        }

        public Criteria andPayManGreaterThanOrEqualTo(String value) {
            addCriterion("payMan >=", value, "payMan");
            return (Criteria) this;
        }

        public Criteria andPayManLessThan(String value) {
            addCriterion("payMan <", value, "payMan");
            return (Criteria) this;
        }

        public Criteria andPayManLessThanOrEqualTo(String value) {
            addCriterion("payMan <=", value, "payMan");
            return (Criteria) this;
        }

        public Criteria andPayManLike(String value) {
            addCriterion("payMan like", value, "payMan");
            return (Criteria) this;
        }

        public Criteria andPayManNotLike(String value) {
            addCriterion("payMan not like", value, "payMan");
            return (Criteria) this;
        }

        public Criteria andPayManIn(List<String> values) {
            addCriterion("payMan in", values, "payMan");
            return (Criteria) this;
        }

        public Criteria andPayManNotIn(List<String> values) {
            addCriterion("payMan not in", values, "payMan");
            return (Criteria) this;
        }

        public Criteria andPayManBetween(String value1, String value2) {
            addCriterion("payMan between", value1, value2, "payMan");
            return (Criteria) this;
        }

        public Criteria andPayManNotBetween(String value1, String value2) {
            addCriterion("payMan not between", value1, value2, "payMan");
            return (Criteria) this;
        }

        public Criteria andGetManIsNull() {
            addCriterion("getMan is null");
            return (Criteria) this;
        }

        public Criteria andGetManIsNotNull() {
            addCriterion("getMan is not null");
            return (Criteria) this;
        }

        public Criteria andGetManEqualTo(String value) {
            addCriterion("getMan =", value, "getMan");
            return (Criteria) this;
        }

        public Criteria andGetManNotEqualTo(String value) {
            addCriterion("getMan <>", value, "getMan");
            return (Criteria) this;
        }

        public Criteria andGetManGreaterThan(String value) {
            addCriterion("getMan >", value, "getMan");
            return (Criteria) this;
        }

        public Criteria andGetManGreaterThanOrEqualTo(String value) {
            addCriterion("getMan >=", value, "getMan");
            return (Criteria) this;
        }

        public Criteria andGetManLessThan(String value) {
            addCriterion("getMan <", value, "getMan");
            return (Criteria) this;
        }

        public Criteria andGetManLessThanOrEqualTo(String value) {
            addCriterion("getMan <=", value, "getMan");
            return (Criteria) this;
        }

        public Criteria andGetManLike(String value) {
            addCriterion("getMan like", value, "getMan");
            return (Criteria) this;
        }

        public Criteria andGetManNotLike(String value) {
            addCriterion("getMan not like", value, "getMan");
            return (Criteria) this;
        }

        public Criteria andGetManIn(List<String> values) {
            addCriterion("getMan in", values, "getMan");
            return (Criteria) this;
        }

        public Criteria andGetManNotIn(List<String> values) {
            addCriterion("getMan not in", values, "getMan");
            return (Criteria) this;
        }

        public Criteria andGetManBetween(String value1, String value2) {
            addCriterion("getMan between", value1, value2, "getMan");
            return (Criteria) this;
        }

        public Criteria andGetManNotBetween(String value1, String value2) {
            addCriterion("getMan not between", value1, value2, "getMan");
            return (Criteria) this;
        }

        public Criteria andPayNumIsNull() {
            addCriterion("payNum is null");
            return (Criteria) this;
        }

        public Criteria andPayNumIsNotNull() {
            addCriterion("payNum is not null");
            return (Criteria) this;
        }

        public Criteria andPayNumEqualTo(String value) {
            addCriterion("payNum =", value, "payNum");
            return (Criteria) this;
        }

        public Criteria andPayNumNotEqualTo(String value) {
            addCriterion("payNum <>", value, "payNum");
            return (Criteria) this;
        }

        public Criteria andPayNumGreaterThan(String value) {
            addCriterion("payNum >", value, "payNum");
            return (Criteria) this;
        }

        public Criteria andPayNumGreaterThanOrEqualTo(String value) {
            addCriterion("payNum >=", value, "payNum");
            return (Criteria) this;
        }

        public Criteria andPayNumLessThan(String value) {
            addCriterion("payNum <", value, "payNum");
            return (Criteria) this;
        }

        public Criteria andPayNumLessThanOrEqualTo(String value) {
            addCriterion("payNum <=", value, "payNum");
            return (Criteria) this;
        }

        public Criteria andPayNumLike(String value) {
            addCriterion("payNum like", value, "payNum");
            return (Criteria) this;
        }

        public Criteria andPayNumNotLike(String value) {
            addCriterion("payNum not like", value, "payNum");
            return (Criteria) this;
        }

        public Criteria andPayNumIn(List<String> values) {
            addCriterion("payNum in", values, "payNum");
            return (Criteria) this;
        }

        public Criteria andPayNumNotIn(List<String> values) {
            addCriterion("payNum not in", values, "payNum");
            return (Criteria) this;
        }

        public Criteria andPayNumBetween(String value1, String value2) {
            addCriterion("payNum between", value1, value2, "payNum");
            return (Criteria) this;
        }

        public Criteria andPayNumNotBetween(String value1, String value2) {
            addCriterion("payNum not between", value1, value2, "payNum");
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