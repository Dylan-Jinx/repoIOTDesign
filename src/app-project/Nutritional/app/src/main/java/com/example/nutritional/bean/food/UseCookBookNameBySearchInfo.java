package com.example.nutritional.bean.food;

import java.util.List;

/**
 * @author 69182
 */
public
class UseCookBookNameBySearchInfo {

    /**
     * cookBooks : [{"id":1,"name":"鱼香肉丝","material":"里脊、青笋、黑木耳、料酒、大蒜、生姜、大葱、豆瓣、淀粉、鸡蛋、花椒粒、干辣椒、水、","flavour":"酱油，精盐，白糖，蚝油(可选)、生抽、胡椒粉","image":"File/Uploads/鱼香肉丝.jpg","nutritionalIngredient":"蛋白质20.3克，bai脂肪6.2克，碳水化合物1.5克，胆固醇81毫克，维生素A44微克，视黄醇44微克，硫胺素 0.54毫克，核黄素 0.1毫克，尼克酸5.3毫克，维生素E 0.34毫克，钙6毫克，磷189毫克，钾305毫克，钠57.5毫克，铁3毫克，锌2.99毫克，硒9.50微克"}]
     * statusCode : 200
     * message : 获取成功
     * returnTime : 2020-07-06T19:09:21.6284673+08:00
     */

    private int statusCode;
    private String message;
    private String returnTime;
    private List<CookBooksBean> cookBooks;

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

    public List<CookBooksBean> getCookBooks() {
        return cookBooks;
    }

    public void setCookBooks(List<CookBooksBean> cookBooks) {
        this.cookBooks = cookBooks;
    }

    public static class CookBooksBean {
        /**
         * id : 1
         * name : 鱼香肉丝
         * material : 里脊、青笋、黑木耳、料酒、大蒜、生姜、大葱、豆瓣、淀粉、鸡蛋、花椒粒、干辣椒、水、
         * flavour : 酱油，精盐，白糖，蚝油(可选)、生抽、胡椒粉
         * image : File/Uploads/鱼香肉丝.jpg
         * nutritionalIngredient : 蛋白质20.3克，bai脂肪6.2克，碳水化合物1.5克，胆固醇81毫克，维生素A44微克，视黄醇44微克，硫胺素 0.54毫克，核黄素 0.1毫克，尼克酸5.3毫克，维生素E 0.34毫克，钙6毫克，磷189毫克，钾305毫克，钠57.5毫克，铁3毫克，锌2.99毫克，硒9.50微克
         */

        private int id;
        private String name;
        private String material;
        private String flavour;
        private String image;
        private String nutritionalIngredient;

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

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public String getFlavour() {
            return flavour;
        }

        public void setFlavour(String flavour) {
            this.flavour = flavour;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNutritionalIngredient() {
            return nutritionalIngredient;
        }

        public void setNutritionalIngredient(String nutritionalIngredient) {
            this.nutritionalIngredient = nutritionalIngredient;
        }
    }
}
