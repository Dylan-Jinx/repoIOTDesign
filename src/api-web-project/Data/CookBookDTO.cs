using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    /// <summary>
    /// 菜谱模型类
    /// </summary>
    public class CookBooksDTO : CookBooks
    {
        /// <summary>
        /// 
        /// </summary>
        public List<CookBooks> cookBooks { get; set; }
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
    public class CookBooks
    {
        /// <summary>
        /// 
        /// </summary>
        [DisplayName("id")]
        public int id { get; set; }
        /// <summary>
        /// 鱼香肉丝
        /// </summary>
        [DisplayName("菜名")]
        public string name { get; set; }
        /// <summary>
        /// 里脊、青笋、黑木耳、料酒、大蒜、生姜、大葱、豆瓣、淀粉、鸡蛋、花椒粒、干辣椒、水、
        /// </summary>
        [DisplayName("材料")]
        public string material { get; set; }
        /// <summary>
        /// 酱油，精盐，白糖，蚝油(可选)、生抽、胡椒粉
        /// </summary>
        [DisplayName("配料")]
        public string flavour { get; set; }
        /// <summary>
        /// File/Uploads/鱼香肉丝.jpg
        /// </summary>
        [DisplayName("图片")]
        public string image { get; set; }
        /// <summary>
        /// 蛋白质20.3克，bai脂肪6.2克，碳水化合物1.5克，胆固醇81毫克，维生素A44微克，视黄醇44微克，硫胺素 0.54毫克，核黄素 0.1毫克，尼克酸5.3毫克，维生素E 0.34毫克，钙6毫克，磷189毫克，钾305毫克，钠57.5毫克，铁3毫克，锌2.99毫克，硒9.50微克
        /// </summary>
        [DisplayName("营养价值")]
        public string nutritionalIngredient { get; set; }
    }
}
