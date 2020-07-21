using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class ProductNumInfoDTO:Products
    {
        /// <summary>
        /// 
        /// </summary>
        public List<Products> products { get; set; }
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
    public class Products
    {
        /// <summary>
        /// 
        /// </summary>
        public int id { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string productNumber { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string productInfo { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string productionBase { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string wareHouse { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string image { get; set; }
    }
}
