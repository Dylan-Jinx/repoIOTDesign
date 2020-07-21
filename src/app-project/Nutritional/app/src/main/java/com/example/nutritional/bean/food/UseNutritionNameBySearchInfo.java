package com.example.nutritional.bean.food;

import java.util.List;

/**
 * @author 69182
 */
public
class UseNutritionNameBySearchInfo {

    /**
     * nutrientInformation : [{"id":3,"name":"脂肪","otherName":null,"unit":"克","introduction":"脂肪是身体组织的重要成分，也是供给热量的主要原料。细胞中的原生质和细胞膜均含有脂肪化合物，食物中的脂类95％以上是甘油三酯，此外还有胆固醇脂和磷脂。","deSymptom":"必需脂肪酸缺乏，可引起生长迟缓、生殖障碍、皮肤受损等；另外，还可引起肝脏、肾脏、神经和视觉等多种疾病。","muchHarm":"脂肪摄入过量将产生肥胖，并导致一些慢性病的发生；膳食脂肪总量增加，还会增大某些癌症的发生几率。","source":"高脂肪的食物有坚果类（花生，芝麻，开心果，核桃，松仁等）还有动物类皮肉（肥猪肉，猪油，黄油，酥油，植物油等）还有些油炸食品，面食，点心，蛋糕等等。低脂肪的食物有水果类（苹果，柠檬，等），蔬菜类（冬瓜，黄瓜，丝瓜，白萝卜，苦瓜，韭菜，绿豆芽，辣椒等），鸡肉，鱼肉，紫菜，木耳，荷叶茶，醋等等。","focusGroups":"少年、儿童、孕妇","highContentOfSource":"食用油、松子、腊肉、芝麻酱、杏仁、猪肉"}]
     * statusCode : 200
     * message : 获取成功
     * returnTime : 2020-07-06T15:49:59.2428344+08:00
     */

    private int statusCode;
    private String message;
    private String returnTime;
    private List<NutrientInformationBean> nutrientInformation;

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

    public List<NutrientInformationBean> getNutrientInformation() {
        return nutrientInformation;
    }

    public void setNutrientInformation(List<NutrientInformationBean> nutrientInformation) {
        this.nutrientInformation = nutrientInformation;
    }

    public static class NutrientInformationBean {
        /**
         * id : 3
         * name : 脂肪
         * otherName : null
         * unit : 克
         * introduction : 脂肪是身体组织的重要成分，也是供给热量的主要原料。细胞中的原生质和细胞膜均含有脂肪化合物，食物中的脂类95％以上是甘油三酯，此外还有胆固醇脂和磷脂。
         * deSymptom : 必需脂肪酸缺乏，可引起生长迟缓、生殖障碍、皮肤受损等；另外，还可引起肝脏、肾脏、神经和视觉等多种疾病。
         * muchHarm : 脂肪摄入过量将产生肥胖，并导致一些慢性病的发生；膳食脂肪总量增加，还会增大某些癌症的发生几率。
         * source : 高脂肪的食物有坚果类（花生，芝麻，开心果，核桃，松仁等）还有动物类皮肉（肥猪肉，猪油，黄油，酥油，植物油等）还有些油炸食品，面食，点心，蛋糕等等。低脂肪的食物有水果类（苹果，柠檬，等），蔬菜类（冬瓜，黄瓜，丝瓜，白萝卜，苦瓜，韭菜，绿豆芽，辣椒等），鸡肉，鱼肉，紫菜，木耳，荷叶茶，醋等等。
         * focusGroups : 少年、儿童、孕妇
         * highContentOfSource : 食用油、松子、腊肉、芝麻酱、杏仁、猪肉
         */

        private int id;
        private String name;
        private Object otherName;
        private String unit;
        private String introduction;
        private String deSymptom;
        private String muchHarm;
        private String source;
        private String focusGroups;
        private String highContentOfSource;

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

        public Object getOtherName() {
            return otherName;
        }

        public void setOtherName(Object otherName) {
            this.otherName = otherName;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getDeSymptom() {
            return deSymptom;
        }

        public void setDeSymptom(String deSymptom) {
            this.deSymptom = deSymptom;
        }

        public String getMuchHarm() {
            return muchHarm;
        }

        public void setMuchHarm(String muchHarm) {
            this.muchHarm = muchHarm;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getFocusGroups() {
            return focusGroups;
        }

        public void setFocusGroups(String focusGroups) {
            this.focusGroups = focusGroups;
        }

        public String getHighContentOfSource() {
            return highContentOfSource;
        }

        public void setHighContentOfSource(String highContentOfSource) {
            this.highContentOfSource = highContentOfSource;
        }
    }
}
