using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class WaterQualityDTO
    {
        /// <summary>
        /// 
        /// </summary>
        public List<WaterQualityInfos> waterQualityInfos { get; set; }
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
    public class WaterQualityInfos
    {
        /// <summary>
        /// 
        /// </summary>
        public int id { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string dateOfSampling { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public double ph { get; set; }
        /// <summary>
        /// 良
        /// </summary>
        public string comprehensiveEvaluation { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string remark { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string image { get; set; }
    }
}
