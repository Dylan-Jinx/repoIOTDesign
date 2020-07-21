package com.example.nutritional.bean.safety;

import java.util.List;

/**
 * @author 69182
 */
public
class UserIdByBaseInfoSearch {

    /**
     * productionBaseInfos : [{"id":1,"name":"云霄东厦水稻种植基地","category":"蔬菜","responsibleName":"Jinx","telephone":"13850526746","image":"File/Uploads/云霄东厦水稻种植基地.jpg"}]
     * statusCode : 200
     * message : 操作成功
     * currentTime : 2020-07-08T11:55:09.6857434+08:00
     */

    private int statusCode;
    private String message;
    private String currentTime;
    private List<ProductionBaseInfosBean> productionBaseInfos;

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

    public List<ProductionBaseInfosBean> getProductionBaseInfos() {
        return productionBaseInfos;
    }

    public void setProductionBaseInfos(List<ProductionBaseInfosBean> productionBaseInfos) {
        this.productionBaseInfos = productionBaseInfos;
    }

    public static class ProductionBaseInfosBean {
        /**
         * id : 1
         * name : 云霄东厦水稻种植基地
         * category : 蔬菜
         * responsibleName : Jinx
         * telephone : 13850526746
         * image : File/Uploads/云霄东厦水稻种植基地.jpg
         */

        private int id;
        private String name;
        private String category;
        private String responsibleName;
        private String telephone;
        private String image;

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

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getResponsibleName() {
            return responsibleName;
        }

        public void setResponsibleName(String responsibleName) {
            this.responsibleName = responsibleName;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
