package com.example.nutritional.bean.user;

import java.util.List;

/**
 * @author 69182
 */
public class GetAllParentInfoBean {

    /**
     * parentInfo : [{"id":0,"parentName":"珊珊","userName":"珊珊","password":"123456","childrenNum":"2","schoolName":"漳州职业技术学院"},{"id":1,"parentName":"张大","userName":"222","password":"123456","childrenNum":"2","schoolName":"福州职业技术学院"},{"id":2,"parentName":"张四","userName":"54007","password":"54007","childrenNum":"1806017132","schoolName":"漳州职业技术学院"}]
     * statusCode : 200
     * message : 获取成功
     * returnTime : 2020-07-04T13:38:13.5539564+08:00
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
         * id : 0
         * parentName : 珊珊
         * userName : 珊珊
         * password : 123456
         * childrenNum : 2
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
