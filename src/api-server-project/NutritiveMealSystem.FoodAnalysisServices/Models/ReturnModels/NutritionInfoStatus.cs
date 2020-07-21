using NutritiveMealSystem.TraceabilityServices.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.FoodAnalysisServices.Models.ReturnModels
{
    /// <summary>
    /// 返回数据的模型状态类->对应的是营养素信息表，继承Status类
    /// </summary>
    public class NutritionInfoStatus:Status
    {
        public List<TNutrientInformation> NutrientInformation { get; set; }
    }
}
