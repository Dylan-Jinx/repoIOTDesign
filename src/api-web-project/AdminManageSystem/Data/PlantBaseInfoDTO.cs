using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class PlantBaseInfoDTO: ProductionBaseInfos
    {
        /// <summary>
        /// 
        /// </summary>
        public List<ProductionBaseInfos> productionBaseInfos { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public int statusCode { get; set; }
        /// <summary>
        /// 操作成功
        /// </summary>
        public string message { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string currentTime { get; set; }
    }
    public class ProductionBaseInfos
    {
        /// <summary>
        /// 
        /// </summary>
        public int id { get; set; }
        /// <summary>
        /// 云霄东厦水稻种植基地
        /// </summary>
        public string name { get; set; }
        /// <summary>
        /// 蔬菜
        /// </summary>
        public string category { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string responsibleName { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string telephone { get; set; }
        /// <summary>
        /// File/Uploads/云霄东厦水稻种植基地.jpg
        /// </summary>
        public string image { get; set; }
    }
}
