package com.example.nutritional.bean.food;

import java.util.List;

/**
 * @author 69182
 */
public
class GetAllFoodNutrition  {

    /**
     * foodNutritions : [{"id":1,"foodName":"egg","nutritionalIngredient":"\r\n\r\n热量（大卡）144\r\n\r\n胆固醇(毫克)585\r\n\r\n维生素A(微克)234\r\n\r\n钾(毫克)154\r\n\r\n钠(毫克)131.5\r\n\r\n磷(毫克)130\r\n\r\n钙(毫克)56\r\n\r\n硒(微克)14.34\r\n\r\n蛋白质(克)13.3\r\n\r\n镁(毫克)10\r\n\r\n脂肪(克)8.8\r\n\r\n碳水化合物(克)2.8\r\n\r\n铁(毫克)2\r\n\r\n维生素E(毫克)1.84\r\n\r\n锌(毫克)1.1\r\n\r\n维生素B2(毫克)0.27\r\n\r\n烟酸(毫克)0.2\r\n\r\n铜(毫克)0.15\r\n\r\n维生素B1(毫克)0.11\r\n\r\n锰(毫克)0.04","introduce":"鸡蛋，又名鸡卵、鸡子，是母鸡所产的卵。其外有一层硬壳，内则有气室、卵白及卵黄部分。富含胆固醇，营养丰富。一个鸡蛋重约50克，含蛋白质7-8克，脂肪5-6克。鸡蛋蛋白质的氨基酸比例很适合人体生理需要、易为机体吸收，利用率高达98%以上，营养价值很高，是人类常食用的食物之一。含有很高的蛋白质。","images":"File/Uploads/egg.jpg"},{"id":2,"foodName":"meat","nutritionalIngredient":"\r\n\r\n热量（大卡）395\r\n\r\n钾(毫克)162\r\n\r\n磷(毫克)130\r\n\r\n胆固醇(毫克)69\r\n\r\n钠(毫克)57.5\r\n\r\n脂肪(克)30.8\r\n\r\n维生素A(微克)16\r\n\r\n蛋白质(克)14.6\r\n\r\n镁(毫克)12\r\n\r\n钙(毫克)11\r\n\r\n硒(微克)2.94\r\n\r\n烟酸(毫克)2.8\r\n\r\n铁(毫克)2.4\r\n\r\n碳水化合物(克)1.1\r\n\r\n维生素C(毫克)1\r\n维生素E(毫克)0.95\r\n\r\n锌(毫克)0.84\r\n\r\n维生素B1(毫克)0.26\r\n\r\n铜(毫克)0.13\r\n\r\n维生素B2(毫克)0.11","introduce":"猪肉，又名豚肉，是猪科动物家猪的肉。其性味甘咸平，含有丰富的蛋白质及脂肪、碳水化合物、钙、铁、磷等营养成分。猪肉是日常生活的主要副食品，具有补虚强身，滋阴润燥、丰肌泽肤的作用。凡病后体弱、产后血虚、面黄肌瘦者，皆可用之作营养滋补之品。","images":"File/Uploads/meat.jpg"},{"id":3,"foodName":"milk","nutritionalIngredient":"热量（大卡）54\r\n\r\n钾(毫克)109\r\n\r\n钙(毫克)104\r\n\r\n磷(毫克)73\r\n\r\n钠(毫克)37.2\r\n\r\n维生素A(微克)24\r\n\r\n胆固醇(毫克)15\r\n\r\n镁(毫克)11\r\n\r\n碳水化合物(克)3.4\r\n\r\n脂肪(克)3.2\r\n\r\n蛋白质(克)3\r\n\r\n硒(微克)1.94\r\n\r\n维生素C(毫克)1\r\n\r\n锌(毫克)0.42\r\n\r\n铁(毫克)0.3维生素E(毫克)0.21\r\n\r\n维生素B2(毫克)0.14\r\n\r\n烟酸(毫克)0.1\r\n\r\n锰(毫克)0.03\r\n\r\n维生素B1(毫克)0.03\r\n\r\n铜(毫克)0.02\r\n\r\n","introduce":"牛奶是最古老的天然饮料之一，被誉为白色血液。\r\n牛奶中含有丰富的蛋白质、脂肪、维生素和矿物质等营养物质，乳蛋白中含有人体所必须的氨基酸；乳脂肪多为短链和中链脂肪酸，极易被人体吸收；钾、磷、钙等矿物质配比合理，易于人体吸收。","images":"File/Uploads/milk.jpg"},{"id":4,"foodName":"dragonfruit","nutritionalIngredient":"\r\n\r\n热量（大卡）51\r\n\r\n叶酸(微克)28.1\r\n\r\n碳水化合物(克)13.3\r\n\r\n膳食纤维(克)2\r\n\r\n蛋白质(克)1.1\r\n\r\n脂肪(克)0.2\r\n\r\n维生素B6(毫克)0.04\r\n","introduce":"火龙果（学名：Hylocereus undatus 'Foo-Lon'）是仙人掌科、量天尺属量天尺的栽培品种，攀援肉质灌木，具气根。分枝多数，延伸，叶片棱常翅状，边缘波状或圆齿状，深绿色至淡蓝绿色，骨质；花漏斗状，于夜间开放；鳞片卵状披针形至披针形，萼状花被片黄绿色，线形至线状披针形，瓣状花被片白色，长圆状倒披针形，花丝黄白色，花柱黄白色，浆果红色，长球形，果脐小，果肉白色、红色。种子倒卵形，黑色，种脐小。7-12月开花结果。\r\n分布中美洲至南美洲北部，世界各地广泛栽培，藉气根攀援于树干、岩石或墙上，海拔3-300米。\r\n该种分枝扦插容易成活，常作嫁接蟹爪属，仙人棒属和多种仙人球的砧木，花可作蔬菜，浆果可食，商品名\u201c火龙果\u201d。","images":"File/Uploads/dragonfruit.jpg"},{"id":5,"foodName":"banana","nutritionalIngredient":"\r\n\r\n热量（大卡）91\r\n\r\n钾(毫克)256\r\n\r\n胡萝卜素(微克)60\r\n\r\n镁(毫克)43\r\n\r\n磷(毫克)28\r\n\r\n碳水化合物(克)22\r\n\r\n维生素A(微克)10\r\n\r\n维生素C(毫克)8\r\n\r\n钙(毫克)7\r\n\r\n碘(微克)2.5\r\n\r\n蛋白质(克)1.4\r\n\r\n膳食纤维(克)1.2\r\n\r\n硒(微克)0.87\r\n\r\n钠(毫克)0.8\r\n\r\n烟酸(毫克)0.7\r\n锰(毫克)0.65\r\n\r\n铁(毫克)0.4\r\n\r\n维生素E(毫克)0.24\r\n\r\n脂肪(克)0.2\r\n\r\n锌(毫克)0.18\r\n\r\n铜(毫克)0.14\r\n\r\n维生素B2(毫克)0.04\r\n\r\n维生素B1(毫克)0.02","introduce":"蕉（学名：Musa nana Lour.）芭蕉科芭蕉属植物，又指其果实，热带地区广泛种植。香蕉味香、富含营养，植株为大型草本，从根状茎发出，由叶鞘下部形成高3～6米（10～20尺）的假杆；叶长圆形至椭圆形，有的长达3～3.5米（10～11.5尺），宽65厘米（26寸），10～20枚簇生茎顶。穗状花序下垂，由假杆顶端抽出，花多数，淡黄色；果序弯垂，结果10～20串，约50～150个。植株结果后枯死，由根状茎长出的吸根继续繁殖，每一根株可活多年。原产亚洲东南部，台湾、海南、广东、广西等均有栽培。","images":"File/Uploads/banana.jpg"},{"id":6,"foodName":"apple","nutritionalIngredient":"\r\n\r\n热量（大卡）52\r\n\r\n钾(毫克)119\r\n\r\n胡萝卜素(微克)20\r\n\r\n碳水化合物(克)13.5\r\n\r\n磷(毫克)12\r\n\r\n钙(毫克)4\r\n\r\n镁(毫克)4\r\n\r\n维生素C(毫克)4\r\n\r\n维生素A(微克)3\r\n\r\n维生素E(毫克)2.12\r\n\r\n钠(毫克)1.6\r\n\r\n膳食纤维(克)1.2\r\n\r\n铁(毫克)0.6\r\n\r\n烟酸(毫克)0.2\r\n\r\n脂肪(克)0.2\r\n蛋白质(克)0.2\r\n\r\n锌(毫克)0.19\r\n\r\n硒(微克)0.12\r\n\r\n铜(毫克)0.06\r\n\r\n维生素B1(毫克)0.06\r\n\r\n锰(毫克)0.03\r\n\r\n维生素B2(毫克)0.02\r\n\r\n","introduce":"\r\n苹果是蔷薇科苹果亚科苹果属植物，其树为落叶乔木。苹果营养价值很高，富含矿物质和维生素，含钙量丰富，有助于代谢掉体内多余盐分，苹果酸可代谢热量，防止下半身肥胖。\r\n苹果是一种低热量的食物，每100克产生大约60千卡左右的热量。苹果中营养成分可溶性大，容易被人体吸收，故有\u201c活水\u201d之称。它有利于溶解硫元素，使皮肤润滑柔嫩。\r\n","images":"File/Uploads/apple.jpg"},{"id":7,"foodName":"pear","nutritionalIngredient":"\r\n\r\n热量（大卡）44\r\n\r\n钾(毫克)92\r\n\r\n胡萝卜素(微克)33\r\n\r\n磷(毫克)14\r\n\r\n碳水化合物(克)13.3\r\n\r\n钙(毫克)9\r\n\r\n镁(毫克)8\r\n\r\n维生素C(毫克)6\r\n\r\n维生素A(微克)6\r\n\r\n膳食纤维(克)3.1\r\n\r\n钠(毫克)2.1\r\n\r\n维生素E(毫克)1.34\r\n\r\n硒(微克)1.14\r\n\r\n碘(微克)0.7\r\n\r\n铜(毫克)0.62\r\n铁(毫克)0.5\r\n\r\n锌(毫克)0.46\r\n\r\n蛋白质(克)0.4\r\n\r\n烟酸(毫克)0.3\r\n\r\n脂肪(克)0.2\r\n\r\n锰(毫克)0.07\r\n\r\n维生素B2(毫克)0.06\r\n\r\n维生素B1(毫克)0.03","introduce":"\r\n梨，通常品种是一种落叶乔木或灌木，极少数品种为常绿，属于被子植物门双子叶植物纲蔷薇科苹果亚科。叶片多呈卵形，大小因品种不同而各异。花为白色，或略带黄色、粉红色，有五瓣。果实形状有圆形的，也有基部较细尾部较粗的，即俗称的\u201c梨形\u201d；不同品种的果皮颜色大相径庭，有黄色、绿色、黄中带绿、绿中带黄、黄褐色、绿褐色、红褐色、褐色，个别品种亦有紫红色；野生梨的果径较小，在1到4厘米之间，而人工培植的品种果径可达8厘米，长度可达18厘米。\r\n梨的果实通常用来食用，不仅味美汁多，甜中带酸，而且营养丰富，含有多种维生素和纤维素，不同种类的梨味道和质感都完全不同。梨既可生食，也可蒸煮后食用。在医疗功效上，梨可以通便秘，利消化，对心血管也有好处。在民间，梨还有一种疗效，把梨去核，放入冰糖，蒸煮过后食用还可以止咳；除了作为水果食用以外，梨还可以作观赏之用。\r\n","images":"File/Uploads/pear.jpg"},{"id":8,"foodName":"chicken","nutritionalIngredient":"\r\n\r\n热量（大卡）167\r\n\r\n钾(毫克)340\r\n\r\n胆固醇(毫克)187\r\n\r\n磷(毫克)160\r\n\r\n钠(毫克)72.4\r\n\r\n维生素A(微克)42\r\n\r\n蛋白质(克)18.5\r\n\r\n钙(毫克)17\r\n\r\n脂肪(克)9.6\r\n\r\n镁(毫克)7\r\n\r\n硒(微克)5.4\r\n\r\n烟酸(毫克)5\r\n\r\n维生素C(毫克)3\r\n\r\n碳水化合物(克)1.4\r\n\r\n锌(毫克)1.29\r\n铁(毫克)0.9\r\n\r\n维生素E(毫克)0.2\r\n\r\n铜(毫克)0.08\r\n\r\n维生素B2(毫克)0.08\r\n\r\n维生素B1(毫克)0.07","introduce":"鸡肉（chicken），指鸡身上的肉，鸡的肉质细嫩，滋味鲜美，适合多种烹调方法，并富有营养，有滋补养身的作用。鸡肉不但适于热炒、炖汤，而且是比较适合冷食凉拌的肉类。","images":"File/Uploads/chicken.jpg"},{"id":9,"foodName":"corn","nutritionalIngredient":"\r\n\r\n热量（大卡）196\r\n\r\n钾(毫克)238\r\n\r\n磷(毫克)117\r\n\r\n维生素A(微克)63\r\n\r\n镁(毫克)32\r\n\r\n碳水化合物(克)22.8\r\n\r\n维生素C(毫克)16\r\n\r\n蛋白质(克)4\r\n\r\n膳食纤维(克)2.9\r\n\r\n烟酸(毫克)1.8\r\n\r\n硒(微克)1.63\r\n\r\n脂肪(克)1.2\r\n\r\n钠(毫克)1.1\r\n\r\n铁(毫克)1.1\r\n\r\n钙(毫克)1\r\n锌(毫克)0.9\r\n\r\n维生素E(毫克)0.46\r\n\r\n胡萝卜素(微克)0.34\r\n\r\n维生素B1(毫克)0.16\r\n\r\n维生素B2(毫克)0.11\r\n\r\n铜(毫克)0.09\r\n\r\n","introduce":"玉米（Zea mays L.）是禾本科的一年生草本植物。又名苞谷、苞米棒子、玉蜀黍、珍珠米等。原产于中美洲和南美洲，它是世界重要的粮食作物，广泛分布于美国、中国、巴西和其他国家。玉米与传统的水稻、小麦等粮食作物相比，玉米具有很强的耐旱性、耐寒性、耐贫瘠性以及极好的环境适应性。玉米的营养价值较高，是优良的粮食作物。作为中国的高产粮食作物，玉米是畜牧业、养殖业、水产养殖业等的重要饲料来源，也是食品、医疗卫生、轻工业、化工业等的不可或缺的原料之一。由于玉米资源极为丰富、廉价且易于获得，它们还具有许多生物活性，如抗氧化、抗肿瘤、降血糖、提高免疫力和抑菌杀菌等，其具有广阔的开发及应用前景。","images":"File/Uploads/corn.jpg"},{"id":10,"foodName":"pineapple","nutritionalIngredient":"热量(千卡)41硫胺素(毫克)0.04钙(毫克)12蛋白质(克)0.5核黄素(毫克)0.02镁(毫克)8脂肪(克)0.1烟酸(毫克)0.2铁(毫克)0.6碳水化合物(克)9.5维生素C(毫克)18锰(毫克)1.04膳食纤维(克)1.3维生素E(毫克)0锌(毫克)0.14维生素A(微克)3胆固醇(毫克)0铜(毫克)0.07胡罗卜素(微克)0.2钾(毫克)113磷(毫克)9视黄醇当量(微克)88.4钠(毫克)0.8硒(微克)0.24","introduce":"菠萝（学名：Ananas comosus），是热带水果之一。福建和台湾地区称之为旺梨或者旺来（ông-lâi），新马一带称为黄梨，大陆及香港称作菠萝。有70多个品种，岭南四大名果之一。菠萝原产于南美洲巴西、巴拉圭的亚马逊河流域一带，16世纪从巴西传入中国。 已经流传到整个热带地区。其可食部分主要由肉质增大之花序轴、螺旋状排列于外周的花组成，花通常不结实，宿存的花被裂片围成一空腔，腔内藏有萎缩的雄蕊和花柱。叶的纤维甚坚韧，可供织物、制绳、结网和造纸。凤梨与菠萝在生物学上是同一种水果。市场上，凤梨与菠萝为不同品种水果：菠萝削皮后有\u201c内刺\u201d需要剔除；而凤梨削掉外皮后没有\u201c内刺\u201d，不需要刀划出一道道沟。","images":"File/Uploads/pineapple.jpg"}]
     * statusCode : 200
     * message : 获取成功
     * returnTime : 2020-07-06T16:53:19.2148806+08:00
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
