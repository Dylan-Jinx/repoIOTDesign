using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class WareHouseInfoDTO
    {
        /// <summary>
        /// 
        /// </summary>
        public List<Warehouses> warehouses { get; set; }
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
    public class Warehouses
    {
        /// <summary>
        /// 
        /// </summary>
        public int id { get; set; }
        /// <summary>
        /// 这是仓库
        /// </summary>
        public string name { get; set; }
        /// <summary>
        /// 这是一个仓库
        /// </summary>
        public string location { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string responsiblePerson { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string telephone { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public int temperature { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public int humidity { get; set; }
        /// <summary>
        /// 这是一个仓库
        /// </summary>
        public string remark { get; set; }
    }
}
