using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class CookHouseBillDTO
    {

        /// <summary>
        /// 
        /// </summary>
        public List<Bill> bill { get; set; }
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
    public class Bill
    {
        /// <summary>
        /// 
        /// </summary>
        public int id { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public int price { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public DateTime billDatetime { get; set; }
        /// <summary>
        /// 张三
        /// </summary>
        public string conductor { get; set; }
        /// <summary>
        /// 漳州职业技术学院-第一食堂 500元西红柿
        /// </summary>
        public string remark { get; set; }
    }

}
