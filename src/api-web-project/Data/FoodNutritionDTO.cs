using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class FoodNutritionDTO : FoodNutritions
    {
        /// <summary>
        /// 
        /// </summary>
        public List<FoodNutritions> foodNutritions { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public int statusCode { get; set; }
        /// <summary>
        /// 获取成功
        /// </summary>
        public string message { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string returnTime { get; set; }
    }

    public class FoodNutritions
    {
        /// <summary>
        /// 
        /// </summary>
        public int id { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string foodName { get; set; }
        /// <summary>
        /// 热量（大卡）144胆固醇(毫克)585 维生素A(微克)234 钾(毫克)154 钠(毫克)131.5 磷(毫克)130 钙(毫克)56 硒(微克)14.34 蛋白质(克)13.3 镁(毫克)10 脂肪(克)8.8 碳水化合物(克)2.8 铁(毫克)2 维生素E(毫克)1.84 锌(毫克)1.1 维生素B2(毫克)0.27 烟酸(毫克)0.2 铜(毫克)0.15 维生素B1(毫克)0.11 锰(毫克)0.04
        /// </summary>
        public string nutritionalIngredient { get; set; }
        /// <summary>
        /// 鸡蛋，又名鸡卵、鸡子，是母鸡所产的卵。其外有一层硬壳，内则有气室、卵白及卵黄部分。富含胆固醇，营养丰富。一个鸡蛋重约50克，含蛋白质7-8克，脂肪5-6克。鸡蛋蛋白质的氨基酸比例很适合人体生理需要、易为机体吸收，利用率高达98%以上，营养价值很高，是人类常食用的食物之一。含有很高的蛋白质。
        /// </summary>
        public string introduce { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string images { get; set; }
    }


}
