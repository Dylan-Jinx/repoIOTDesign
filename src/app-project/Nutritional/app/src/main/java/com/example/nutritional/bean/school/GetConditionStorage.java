package com.example.nutritional.bean.school;

import java.util.List;

/**
 * @author 69182
 */
public class GetConditionStorage {

    /**
     * userInfo : [{"id":1,"productInfo":"西红柿","price":5.800000190734863,"storageTime":"2020-06-30T16:55:00","remark":"新鲜的"}]
     * statusCode : 200
     * message : 查询成功
     * returnTime : 2020-07-05T15:43:58.4560991+08:00
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
         * productInfo : 西红柿
         * price : 5.800000190734863
         * storageTime : 2020-06-30T16:55:00
         * remark : 新鲜的
         */

        private int id;
        private String productInfo;
        private double price;
        private String storageTime;
        private String remark;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getProductInfo() {
            return productInfo;
        }

        public void setProductInfo(String productInfo) {
            this.productInfo = productInfo;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getStorageTime() {
            return storageTime;
        }

        public void setStorageTime(String storageTime) {
            this.storageTime = storageTime;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
