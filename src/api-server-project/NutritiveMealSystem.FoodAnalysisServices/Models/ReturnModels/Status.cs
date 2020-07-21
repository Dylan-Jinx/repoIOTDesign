using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.FoodAnalysisServices.Models.ReturnModels
{
    /// <summary>
    /// 状态基类
    /// </summary>
    public class Status
    {
        /// <summary>
        /// 状态码
        /// </summary>
        public int StatusCode { get; set; }
        /// <summary>
        /// 信息
        /// </summary>
        public string Message { get; set; }
        /// <summary>
        /// 返回时间
        /// </summary>
        public DateTime ReturnTime { get; set; }
    }
}
