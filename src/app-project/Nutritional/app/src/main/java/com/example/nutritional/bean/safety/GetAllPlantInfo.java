package com.example.nutritional.bean.safety;

import java.util.List;

/**
 * @author 69182
 */
public
class GetAllPlantInfo {

    /**
     * plantInfos : [{"id":1,"seedSource":"江西东乡","plantFieldNum":"云霄东厦水稻种植基地东一区","plantTime":"2020-07-06T11:23:58.37","harvestTime":"2020-09-06T03:21:25.477","remark":"受地区气候影响，估算该水稻种植到成熟的区间应该是三个月"},{"id":2,"seedSource":"海南三亚","plantFieldNum":"云霄东厦水稻种植基地东二区","plantTime":"2020-07-06T11:26:54.23","harvestTime":"2020-10-06T11:25:55.233","remark":"受地区气候影响，估算该水稻种植到成熟的区间应该是四个月"},{"id":3,"seedSource":"山东寿光","plantFieldNum":"云霄东厦西红柿种植基地西三区","plantTime":"2020-07-06T14:38:24.71","harvestTime":"2020-12-06T14:36:43.697","remark":"估测成熟周期应该是110天-170天"}]
     * statusCode : 200
     * message : 操作成功
     * currentTime : 2020-07-07T14:28:04.8516366+08:00
     */

    private int statusCode;
    private String message;
    private String currentTime;
    private List<PlantInfosBean> plantInfos;

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

    public List<PlantInfosBean> getPlantInfos() {
        return plantInfos;
    }

    public void setPlantInfos(List<PlantInfosBean> plantInfos) {
        this.plantInfos = plantInfos;
    }

    public static class PlantInfosBean {
        /**
         * id : 1
         * seedSource : 江西东乡
         * plantFieldNum : 云霄东厦水稻种植基地东一区
         * plantTime : 2020-07-06T11:23:58.37
         * harvestTime : 2020-09-06T03:21:25.477
         * remark : 受地区气候影响，估算该水稻种植到成熟的区间应该是三个月
         */

        private int id;
        private String seedSource;
        private String plantFieldNum;
        private String plantTime;
        private String harvestTime;
        private String remark;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSeedSource() {
            return seedSource;
        }

        public void setSeedSource(String seedSource) {
            this.seedSource = seedSource;
        }

        public String getPlantFieldNum() {
            return plantFieldNum;
        }

        public void setPlantFieldNum(String plantFieldNum) {
            this.plantFieldNum = plantFieldNum;
        }

        public String getPlantTime() {
            return plantTime;
        }

        public void setPlantTime(String plantTime) {
            this.plantTime = plantTime;
        }

        public String getHarvestTime() {
            return harvestTime;
        }

        public void setHarvestTime(String harvestTime) {
            this.harvestTime = harvestTime;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
