package com.example.nutritional.bean.school;

import java.util.List;

/**
 * @author 69182
 */
public class GetConditionCookHouseInfo {

    /**
     * cookHouseInfo : [{"id":1,"cookHouseName":"漳州职业技术学院-第二食堂","temperature":36,"humidity":10,"reportTime":"2020/7/1 15:18"}]
     * statusCode : 200
     * message : 查询成功
     * returnTime : 2020-07-05T15:38:08.7563293+08:00
     */

    private int statusCode;
    private String message;
    private String returnTime;
    private List<CookHouseInfoBean> cookHouseInfo;

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

    public List<CookHouseInfoBean> getCookHouseInfo() {
        return cookHouseInfo;
    }

    public void setCookHouseInfo(List<CookHouseInfoBean> cookHouseInfo) {
        this.cookHouseInfo = cookHouseInfo;
    }

    public static class CookHouseInfoBean {
        /**
         * id : 1
         * cookHouseName : 漳州职业技术学院-第二食堂
         * temperature : 36
         * humidity : 10
         * reportTime : 2020/7/1 15:18
         */

        private int id;
        private String cookHouseName;
        private int temperature;
        private int humidity;
        private String reportTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCookHouseName() {
            return cookHouseName;
        }

        public void setCookHouseName(String cookHouseName) {
            this.cookHouseName = cookHouseName;
        }

        public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public String getReportTime() {
            return reportTime;
        }

        public void setReportTime(String reportTime) {
            this.reportTime = reportTime;
        }
    }
}
