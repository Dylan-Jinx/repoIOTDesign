package com.example.nutritional.bean.user;

import java.util.List;

/**
 * @author 69182
 */
public class GetAllUserInfoBean {

    /**
     * userInfo : [{"id":1,"name":"张三","userName":"张三","password":"123456","userType":"厨房登记员"},{"id":3,"name":"王五","userName":"123","password":"123456","userType":"厨师"},{"id":4,"name":"赵七","userName":"赵七","password":"123456","userType":"厨师"},{"id":5,"name":"赵七","userName":"456","password":"1","userType":"厨师"},{"id":6,"name":"历时","userName":"2","password":"2","userType":"2"}]
     * statusCode : 200
     * message : 获取成功
     * returnTime : 2020-07-04T13:49:38.288492+08:00
     */

    private int statusCode;
    private String message;
    private String returnTime;
    private List<UserInfoBean> userInfo;

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

    public List<UserInfoBean> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(List<UserInfoBean> userInfo) {
        this.userInfo = userInfo;
    }

    public static class UserInfoBean {
        /**
         * id : 1
         * name : 张三
         * userName : 张三
         * password : 123456
         * userType : 厨房登记员
         */

        private int id;
        private String name;
        private String userName;
        private String password;
        private String userType;

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

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }
    }
}
