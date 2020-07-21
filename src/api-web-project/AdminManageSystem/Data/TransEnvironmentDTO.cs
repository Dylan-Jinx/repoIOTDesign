using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class TransEnvironmentDTO
    {
        /// <summary>
        /// 
        /// </summary>
        public List<EnvironmentInfos> environmentInfos { get; set; }
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
    public class EnvironmentInfos
    {
        /// <summary>
        /// 
        /// </summary>
        public int id { get; set; }
        /// <summary>
        /// 蔬菜
        /// </summary>
        public string plate { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string driver { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string telephone { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string dateTime { get; set; }
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
        public string productNumber { get; set; }
    }
}
