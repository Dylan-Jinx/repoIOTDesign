package com.example.nutritional.bean.safety;

import java.util.List;

/**
 * @author 69182
 */
public class UserIdByBaseStaffSearch {

    /**
     * staffs : [{"id":1,"staffName":"彭震川","telephone":"15856040835","productionBaseName":"云霄东厦水稻种植基地","image":"File/Uploads/彭震川.png","position":"普通员工"}]
     * statusCode : 200
     * message : 操作成功
     * currentTime : 2020-07-08T13:53:30.0730414+08:00
     */

    private int statusCode;
    private String message;
    private String currentTime;
    private List<StaffsBean> staffs;

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

    public List<StaffsBean> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<StaffsBean> staffs) {
        this.staffs = staffs;
    }

    public static class StaffsBean {
        /**
         * id : 1
         * staffName : 彭震川
         * telephone : 15856040835
         * productionBaseName : 云霄东厦水稻种植基地
         * image : File/Uploads/彭震川.png
         * position : 普通员工
         */

        private int id;
        private String staffName;
        private String telephone;
        private String productionBaseName;
        private String image;
        private String position;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStaffName() {
            return staffName;
        }

        public void setStaffName(String staffName) {
            this.staffName = staffName;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getProductionBaseName() {
            return productionBaseName;
        }

        public void setProductionBaseName(String productionBaseName) {
            this.productionBaseName = productionBaseName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }
}
