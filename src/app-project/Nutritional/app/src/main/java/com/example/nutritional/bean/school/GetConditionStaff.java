package com.example.nutritional.bean.school;

import java.util.List;

/**
 * @author 69182
 */
public
class GetConditionStaff {

    /**
     * staff : [{"id":10,"staffName":"吴克俭","telephone":" 15140454253 ","image":"File/Uploads/吴克俭.jpg","position":"漳州职业技术学院-第二食堂-负责人"}]
     * statusCode : 200
     * message : 查询成功
     * returnTime : 2020-07-16T13:24:35.2092068+08:00
     */

    private int statusCode;
    private String message;
    private String returnTime;
    private List<StaffBean> staff;

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

    public List<StaffBean> getStaff() {
        return staff;
    }

    public void setStaff(List<StaffBean> staff) {
        this.staff = staff;
    }

    public static class StaffBean {
        /**
         * id : 10
         * staffName : 吴克俭
         * telephone :  15140454253
         * image : File/Uploads/吴克俭.jpg
         * position : 漳州职业技术学院-第二食堂-负责人
         */

        private int id;
        private String staffName;
        private String telephone;
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
