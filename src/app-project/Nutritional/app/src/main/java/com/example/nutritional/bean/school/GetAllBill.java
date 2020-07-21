package com.example.nutritional.bean.school;

import java.util.List;

/**
 * @author 69182
 */
public class GetAllBill {

    /**
     * bill : [{"id":1,"price":500,"billDatetime":"2020-07-01T15:20:00","conductor":"张三","remark":"漳州职业技术学院-第一食堂 500元西红柿"}]
     * statusCode : 200
     * message : 获取成功
     * returnTime : 2020-07-05T15:34:50.1722484+08:00
     */

    private int statusCode;
    private String message;
    private String returnTime;
    private List<BillBean> bill;

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

    public List<BillBean> getBill() {
        return bill;
    }

    public void setBill(List<BillBean> bill) {
        this.bill = bill;
    }

    public static class BillBean {
        /**
         * id : 1
         * price : 500
         * billDatetime : 2020-07-01T15:20:00
         * conductor : 张三
         * remark : 漳州职业技术学院-第一食堂 500元西红柿
         */

        private int id;
        private int price;
        private String billDatetime;
        private String conductor;
        private String remark;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getBillDatetime() {
            return billDatetime;
        }

        public void setBillDatetime(String billDatetime) {
            this.billDatetime = billDatetime;
        }

        public String getConductor() {
            return conductor;
        }

        public void setConductor(String conductor) {
            this.conductor = conductor;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
