package com.example.nutritional.bean.safety;

import java.util.List;

/**
 * @author 69182
 */
public
class UserIdByProductSearch {

    /**
     * products : [{"id":2,"productNumber":"666","productInfo":"666","productionBase":"666","wareHouse":"666","image":"File/Uploads/666.jpg"}]
     * statusCode : 200
     * message : 操作成功
     * currentTime : 2020-07-08T15:19:59.2943846+08:00
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
         * id : 2
         * productNumber : 666
         * productInfo : 666
         * productionBase : 666
         * wareHouse : 666
         * image : File/Uploads/666.jpg
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
