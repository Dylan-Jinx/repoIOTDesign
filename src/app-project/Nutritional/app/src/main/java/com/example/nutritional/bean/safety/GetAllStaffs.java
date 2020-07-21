package com.example.nutritional.bean.safety;

import java.util.List;

/**
 * @author 69182
 */
public
class GetAllStaffs {

    /**
     * staffs : [{"id":1,"staffName":"wjx","telephone":"13855555555","transPortCompanyName":"漳大","image":"File/Uploads/wjx.jpg"},{"id":2,"staffName":"sxl","telephone":"13355555522","transPortCompanyName":"漳大","image":"File/Uploads/sxl.jpg"}]
     * statusCode : 200
     * message : 操作成功
     * currentTime : 2020-07-09T14:03:48.3547565+08:00
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
         * staffName : wjx
         * telephone : 13855555555
         * transPortCompanyName : 漳大
         * image : File/Uploads/wjx.jpg
         */

        private int id;
        private String staffName;
        private String telephone;
        private String transPortCompanyName;
        private String image;

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

        public String getTransPortCompanyName() {
            return transPortCompanyName;
        }

        public void setTransPortCompanyName(String transPortCompanyName) {
            this.transPortCompanyName = transPortCompanyName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
