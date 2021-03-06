package jp.afterfit.core.domain.entity.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeOffRequestCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    public TimeOffRequestCriteria() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andRequestIdIsNull() {
            addCriterion("request_id is null");
            return (Criteria) this;
        }

        public Criteria andRequestIdIsNotNull() {
            addCriterion("request_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequestIdEqualTo(Integer value) {
            addCriterion("request_id =", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotEqualTo(Integer value) {
            addCriterion("request_id <>", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThan(Integer value) {
            addCriterion("request_id >", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("request_id >=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThan(Integer value) {
            addCriterion("request_id <", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThanOrEqualTo(Integer value) {
            addCriterion("request_id <=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdIn(List<Integer> values) {
            addCriterion("request_id in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotIn(List<Integer> values) {
            addCriterion("request_id not in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdBetween(Integer value1, Integer value2) {
            addCriterion("request_id between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotBetween(Integer value1, Integer value2) {
            addCriterion("request_id not between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andTypeOffIsNull() {
            addCriterion("type_off is null");
            return (Criteria) this;
        }

        public Criteria andTypeOffIsNotNull() {
            addCriterion("type_off is not null");
            return (Criteria) this;
        }

        public Criteria andTypeOffEqualTo(String value) {
            addCriterion("type_off =", value, "typeOff");
            return (Criteria) this;
        }

        public Criteria andTypeOffNotEqualTo(String value) {
            addCriterion("type_off <>", value, "typeOff");
            return (Criteria) this;
        }

        public Criteria andTypeOffGreaterThan(String value) {
            addCriterion("type_off >", value, "typeOff");
            return (Criteria) this;
        }

        public Criteria andTypeOffGreaterThanOrEqualTo(String value) {
            addCriterion("type_off >=", value, "typeOff");
            return (Criteria) this;
        }

        public Criteria andTypeOffLessThan(String value) {
            addCriterion("type_off <", value, "typeOff");
            return (Criteria) this;
        }

        public Criteria andTypeOffLessThanOrEqualTo(String value) {
            addCriterion("type_off <=", value, "typeOff");
            return (Criteria) this;
        }

        public Criteria andTypeOffLike(String value) {
            addCriterion("type_off like", value, "typeOff");
            return (Criteria) this;
        }

        public Criteria andTypeOffNotLike(String value) {
            addCriterion("type_off not like", value, "typeOff");
            return (Criteria) this;
        }

        public Criteria andTypeOffIn(List<String> values) {
            addCriterion("type_off in", values, "typeOff");
            return (Criteria) this;
        }

        public Criteria andTypeOffNotIn(List<String> values) {
            addCriterion("type_off not in", values, "typeOff");
            return (Criteria) this;
        }

        public Criteria andTypeOffBetween(String value1, String value2) {
            addCriterion("type_off between", value1, value2, "typeOff");
            return (Criteria) this;
        }

        public Criteria andTypeOffNotBetween(String value1, String value2) {
            addCriterion("type_off not between", value1, value2, "typeOff");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andBackupUserIsNull() {
            addCriterion("backup_user is null");
            return (Criteria) this;
        }

        public Criteria andBackupUserIsNotNull() {
            addCriterion("backup_user is not null");
            return (Criteria) this;
        }

        public Criteria andBackupUserEqualTo(String value) {
            addCriterion("backup_user =", value, "backupUser");
            return (Criteria) this;
        }

        public Criteria andBackupUserNotEqualTo(String value) {
            addCriterion("backup_user <>", value, "backupUser");
            return (Criteria) this;
        }

        public Criteria andBackupUserGreaterThan(String value) {
            addCriterion("backup_user >", value, "backupUser");
            return (Criteria) this;
        }

        public Criteria andBackupUserGreaterThanOrEqualTo(String value) {
            addCriterion("backup_user >=", value, "backupUser");
            return (Criteria) this;
        }

        public Criteria andBackupUserLessThan(String value) {
            addCriterion("backup_user <", value, "backupUser");
            return (Criteria) this;
        }

        public Criteria andBackupUserLessThanOrEqualTo(String value) {
            addCriterion("backup_user <=", value, "backupUser");
            return (Criteria) this;
        }

        public Criteria andBackupUserLike(String value) {
            addCriterion("backup_user like", value, "backupUser");
            return (Criteria) this;
        }

        public Criteria andBackupUserNotLike(String value) {
            addCriterion("backup_user not like", value, "backupUser");
            return (Criteria) this;
        }

        public Criteria andBackupUserIn(List<String> values) {
            addCriterion("backup_user in", values, "backupUser");
            return (Criteria) this;
        }

        public Criteria andBackupUserNotIn(List<String> values) {
            addCriterion("backup_user not in", values, "backupUser");
            return (Criteria) this;
        }

        public Criteria andBackupUserBetween(String value1, String value2) {
            addCriterion("backup_user between", value1, value2, "backupUser");
            return (Criteria) this;
        }

        public Criteria andBackupUserNotBetween(String value1, String value2) {
            addCriterion("backup_user not between", value1, value2, "backupUser");
            return (Criteria) this;
        }

        public Criteria andTypeOffLikeInsensitive(String value) {
            addCriterion("upper(type_off) like", value.toUpperCase(), "typeOff");
            return (Criteria) this;
        }

        public Criteria andBackupUserLikeInsensitive(String value) {
            addCriterion("upper(backup_user) like", value.toUpperCase(), "backupUser");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.time_off_request
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.time_off_request
     *
     * @mbg.generated
     */
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