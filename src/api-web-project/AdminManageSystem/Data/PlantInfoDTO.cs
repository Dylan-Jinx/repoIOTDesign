using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class PlantInfoDTO:PlantInfos
    {
        /// <summary>
        /// 
        /// </summary>
        public List<PlantInfos> plantInfos { get; set; }
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
    public class PlantInfos
    {
        /// <summary>
        /// 
        /// </summary>
        public int id { get; set; }
        /// <summary>
        /// 江西东乡
        /// </summary>
        public string seedSource { get; set; }
        /// <summary>
        /// 云霄东厦水稻种植基地东一区
        /// </summary>
        public string plantFieldNum { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string plantTime { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string harvestTime { get; set; }
        /// <summary>
        /// 受地区气候影响，估算该水稻种植到成熟的区间应该是三个月
        /// </summary>
        public string remark { get; set; }
    }
}
