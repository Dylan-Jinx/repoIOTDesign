using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.SchoolCookHouseServices.Models.ReturnModels
{
    /// <summary>
    /// 返回数据的模型状态类->对应的是T_CookHouseInfo（厨房信息表），继承Status类
    /// </summary>
    public class CookHouseInfoStatus:Status
    {
        public List<TCookHouseInfo> CookHouseInfo { get; set; }
    }
}
