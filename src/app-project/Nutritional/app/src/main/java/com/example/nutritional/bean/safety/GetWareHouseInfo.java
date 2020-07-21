package com.example.nutritional.bean.safety;

import java.util.List;

/**
 * @author 69182
 */
public
class GetWareHouseInfo {

    /**
     * warehouses : [{"id":1,"name":"这是仓库","location":"这是一个仓库","responsiblePerson":"pzc","telephone":"15856040835","temperature":23,"humidity":23,"remark":"这是一个仓库"}]
     * statusCode : 200
     * message : 操作成功
     * currentTime : 2020-07-09T12:17:41.3386821+08:00
     */

    private int statusCode;
    private String message;
    private String currentTime;
    private List<WarehousesBean> warehouses;

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

    public List<WarehousesBean> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<WarehousesBean> warehouses) {
        this.warehouses = warehouses;
    }

    public static class WarehousesBean {
        /**
         * id : 1
         * name : 这是仓库
         * location : 这是一个仓库
         * responsiblePerson : pzc
         * telephone : 15856040835
         * temperature : 23
         * humidity : 23
         * remark : 这是一个仓库
         */

        private int id;
        private String name;
        private String location;
        private String responsiblePerson;
        private String telephone;
        private int temperature;
        private int humidity;
        private String remark;

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

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getResponsiblePerson() {
            return responsiblePerson;
        }

        public void setResponsiblePerson(String responsiblePerson) {
            this.responsiblePerson = responsiblePerson;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
