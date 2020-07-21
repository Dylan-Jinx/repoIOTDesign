using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class CookHouseInfoDTO:CookHouseInfo
    {
        /// <summary>
        /// 
        /// </summary>
        public List<CookHouseInfo> cookHouseInfo { get; set; }
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

    public class CookHouseInfo
    {
        /// <summary>
        /// 
        /// </summary>
        public int id { get; set; }
        /// <summary>
        /// 漳州职业技术学院-第二食堂
        /// </summary>
        public string cookHouseName { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public int temperature { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public int humidity { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string reportTime { get; set; }
    }


}
