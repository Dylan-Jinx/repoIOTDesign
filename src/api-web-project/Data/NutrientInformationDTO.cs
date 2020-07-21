using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class NutrientInformationDTO : NutrientInformation
    {
        /// <summary>
        /// 
        /// </summary>
        public List<NutrientInformation> nutrientInformation { get; set; }
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

    public class NutrientInformation
    {
        /// <summary>
        /// 
        /// </summary>
        [DisplayName("id")]
        public int id { get; set; }
        /// <summary>
        /// 能量
        /// </summary>
        [DisplayName("名称")]
        public string name { get; set; }
        /// <summary>
        /// 热量
        /// </summary>
        [DisplayName("别名")]
        public string otherName { get; set; }
        /// <summary>
        /// 千卡
        /// </summary>
        [DisplayName("单位")]
        public string unit { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DisplayName("介绍")]
        public string introduction { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DisplayName("缺少症状")]
        public string deSymptom { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DisplayName("过量症状")]
        public string muchHarm { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DisplayName("来源")]
        public string source { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DisplayName("重点人群")]
        public string focusGroups { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DisplayName("高含量来源")]
        public string highContentOfSource { get; set; }
    }
}
