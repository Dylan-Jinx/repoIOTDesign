package com.example.nutritional.bean.food;

import java.util.List;

/**
 * @author 69182
 */
public
class UseFoodNameBySearchInfo {

    /**
     * foodNutritions : [{"id":1,"foodName":"egg","nutritionalIngredient":"\r\n\r\n热量（大卡）144\r\n\r\n胆固醇(毫克)585\r\n\r\n维生素A(微克)234\r\n\r\n钾(毫克)154\r\n\r\n钠(毫克)131.5\r\n\r\n磷(毫克)130\r\n\r\n钙(毫克)56\r\n\r\n硒(微克)14.34\r\n\r\n蛋白质(克)13.3\r\n\r\n镁(毫克)10\r\n\r\n脂肪(克)8.8\r\n\r\n碳水化合物(克)2.8\r\n\r\n铁(毫克)2\r\n\r\n维生素E(毫克)1.84\r\n\r\n锌(毫克)1.1\r\n\r\n维生素B2(毫克)0.27\r\n\r\n烟酸(毫克)0.2\r\n\r\n铜(毫克)0.15\r\n\r\n维生素B1(毫克)0.11\r\n\r\n锰(毫克)0.04","introduce":"鸡蛋，又名鸡卵、鸡子，是母鸡所产的卵。其外有一层硬壳，内则有气室、卵白及卵黄部分。富含胆固醇，营养丰富。一个鸡蛋重约50克，含蛋白质7-8克，脂肪5-6克。鸡蛋蛋白质的氨基酸比例很适合人体生理需要、易为机体吸收，利用率高达98%以上，营养价值很高，是人类常食用的食物之一。含有很高的蛋白质。","images":"File/Uploads/egg.jpg"}]
     * statusCode : 200
     * message : 获取成功
     * returnTime : 2020-07-06T18:23:33.7165522+08:00
     */

    private int statusCode;
    private String message;
    private String returnTime;
    private List<FoodNutritionsBean> foodNutritions;

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

    public List<FoodNutritionsBean> getFoodNutritions() {
        return foodNutritions;
    }

    public void setFoodNutritions(List<FoodNutritionsBean> foodNutritions) {
        this.foodNutritions = foodNutritions;
    }

    public static class FoodNutritionsBean {
        /**
         * id : 1
         * foodName : egg
         * nutritionalIngredient :

         热量（大卡）144

         胆固醇(毫克)585

         维生素A(微克)234

         钾(毫克)154

         钠(毫克)131.5

         磷(毫克)130

         钙(毫克)56

         硒(微克)14.34

         蛋白质(克)13.3

         镁(毫克)10

         脂肪(克)8.8

         碳水化合物(克)2.8

         铁(毫克)2

         维生素E(毫克)1.84

         锌(毫克)1.1

         维生素B2(毫克)0.27

         烟酸(毫克)0.2

         铜(毫克)0.15

         维生素B1(毫克)0.11

         锰(毫克)0.04
         * introduce : 鸡蛋，又名鸡卵、鸡子，是母鸡所产的卵。其外有一层硬壳，内则有气室、卵白及卵黄部分。富含胆固醇，营养丰富。一个鸡蛋重约50克，含蛋白质7-8克，脂肪5-6克。鸡蛋蛋白质的氨基酸比例很适合人体生理需要、易为机体吸收，利用率高达98%以上，营养价值很高，是人类常食用的食物之一。含有很高的蛋白质。
         * images : File/Uploads/egg.jpg
         */

        private int id;
        private String foodName;
        private String nutritionalIngredient;
        private String introduce;
        private String images;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFoodName() {
            return foodName;
        }

        public void setFoodName(String foodName) {
            this.foodName = foodName;
        }

        public String getNutritionalIngredient() {
            return nutritionalIngredient;
        }

        public void setNutritionalIngredient(String nutritionalIngredient) {
            this.nutritionalIngredient = nutritionalIngredient;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }
    }
}
