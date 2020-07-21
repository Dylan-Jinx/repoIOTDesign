using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class CookHouseBillPageDTO : Bill
    {
        /// <summary>
        /// 
        /// </summary>
        public List<CookBooks> pageList { get; set; }
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
}
