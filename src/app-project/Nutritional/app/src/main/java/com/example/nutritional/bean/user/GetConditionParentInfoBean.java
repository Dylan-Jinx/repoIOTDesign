package com.example.nutritional.bean.user;

import java.util.List;

/**
 * @author 69182
 */
public class GetConditionParentInfoBean {

    /**
     * parentInfo : [{"id":3,"parentName":"张四","userName":"54007","password":"54007","childrenNum":"1806017132","schoolName":"漳州职业技术学院"}]
     * statusCode : 200
     * message : 查询成功
     * returnTime : 2020-07-04T13:58:37.0658914+08:00
     */

    private int statusCode;
    private String message;
    private String returnTime;
    private List<ParentInfoBean> parentInfo;

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

    public List<ParentInfoBean> getParentInfo() {
        return parentInfo;
    }

    public void setParentInfo(List<ParentInfoBean> parentInfo) {
        this.parentInfo = parentInfo;
    }

    public static class ParentInfoBean {
        /**
         * id : 3
         * parentName : 张四
         * userName : 54007
         * password : 54007
         * childrenNum : 1806017132
         * schoolName : 漳州职业技术学院
         */

        private int id;
        private String parentName;
        private String userName;
        private String password;
        private String childrenNum;
        private String schoolName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getParentName() {
            return parentName;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getChildrenNum() {
            return childrenNum;
        }

        public void setChildrenNum(String childrenNum) {
            this.childrenNum = childrenNum;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }
    }
}
