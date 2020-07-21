package com.example.nutritional.bean.safety;

import java.util.List;

/**
 * @author 69182
 */
public
class UseProductNumSearchInfo {

    /**
     * environmentInfos : [{"id":1,"plate":"蔬菜","driver":"kk","telephone":"123","dateTime":"2020-07-09T00:00:00","temperature":23,"humidity":34,"productNumber":"1"}]
     * statusCode : 200
     * message : 操作成功
     * currentTime : 2020-07-09T11:20:52.5379872+08:00
     */

    private int statusCode;
    private String message;
    private String currentTime;
    private List<EnvironmentInfosBean> environmentInfos;

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

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public List<EnvironmentInfosBean> getEnvironmentInfos() {
        return environmentInfos;
    }

    public void setEnvironmentInfos(List<EnvironmentInfosBean> environmentInfos) {
        this.environmentInfos = environmentInfos;
    }

    public static class EnvironmentInfosBean {
        /**
         * id : 1
         * plate : 蔬菜
         * driver : kk
         * telephone : 123
         * dateTime : 2020-07-09T00:00:00
         * temperature : 23
         * humidity : 34
         * productNumber : 1
         */

        private int id;
        private String plate;
        private String driver;
        private String telephone;
        private String dateTime;
        private int temperature;
        private int humidity;
        private String productNumber;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPlate() {
            return plate;
        }

        public void setPlate(String plate) {
            this.plate = plate;
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
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

        public String getProductNumber() {
            return productNumber;
        }

        public void setProductNumber(String productNumber) {
            this.productNumber = productNumber;
        }
    }
}
