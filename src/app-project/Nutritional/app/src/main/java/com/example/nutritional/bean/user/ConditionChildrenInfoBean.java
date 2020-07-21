package com.example.nutritional.bean.user;

import java.util.List;

/**
 * @author 69182
 */
public class ConditionChildrenInfoBean {

    /**
     * childrenInfo : [{"id":5,"name":"无敌","stuNo":"7","address":"重庆","parentName":"kkk","schoolName":"漳州职业技术学院"}]
     * statusCode : 200
     * message : 查询成功
     * returnTime : 2020-07-04T15:36:39.0166565+08:00
     */

    private int statusCode;
    private String message;
    private String returnTime;
    private List<ChildrenInfoBean> childrenInfo;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public List<ChildrenInfoBean> getChildrenInfo() {
        return childrenInfo;
    }

    public void setChildrenInfo(List<ChildrenInfoBean> childrenInfo) {
        this.childrenInfo = childrenInfo;
    }

    public static class ChildrenInfoBean {
        /**
         * id : 5
         * name : 无敌
         * stuNo : 7
         * address : 重庆
         * parentName : kkk
         * schoolName : 漳州职业技术学院
         */

        private int id;
        private String name;
        private String stuNo;
        private String address;
        private String parentName;
        private String schoolName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStuNo() {
            return stuNo;
        }

        public void setStuNo(String stuNo) {
            this.stuNo = stuNo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getParentName() {
            return parentName;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }
    }
}
