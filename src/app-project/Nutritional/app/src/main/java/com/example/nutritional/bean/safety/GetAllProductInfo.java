package com.example.nutritional.bean.safety;

import java.util.List;

public
class GetAllProductInfo {

    /**
     * products : [{"id":1,"productNumber":"5","productInfo":"5","productionBase":"65 ","wareHouse":"5656 ","image":"File/Uploads/5.jpg"}]
     * statusCode : 200
     * message : 操作成功
     * currentTime : 2020-07-08T14:53:14.6814832+08:00
     */

    private int statusCode;
    private String message;
    private String currentTime;
    private List<ProductsBean> products;

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

    public List<ProductsBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsBean> products) {
        this.products = products;
    }

    public static class ProductsBean {
        /**
         * id : 1
         * productNumber : 5
         * productInfo : 5
         * productionBase : 65
         * wareHouse : 5656
         * image : File/Uploads/5.jpg
         */

        private int id;
        private String productNumber;
        private String productInfo;
        private String productionBase;
        private String wareHouse;
        private String image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getProductNumber() {
            return productNumber;
        }

        public void setProductNumber(String productNumber) {
            this.productNumber = productNumber;
        }

        public String getProductInfo() {
            return productInfo;
        }

        public void setProductInfo(String productInfo) {
            this.productInfo = productInfo;
        }

        public String getProductionBase() {
            return productionBase;
        }

        public void setProductionBase(String productionBase) {
            this.productionBase = productionBase;
        }

        public String getWareHouse() {
            return wareHouse;
        }

        public void setWareHouse(String wareHouse) {
            this.wareHouse = wareHouse;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
