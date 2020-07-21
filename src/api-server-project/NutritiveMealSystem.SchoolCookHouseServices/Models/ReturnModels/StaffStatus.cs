using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.SchoolCookHouseServices.Models.ReturnModels
{
    /// <summary>
    /// 返回数据的模型状态类->对应的是T_Staff（员工表），继承Status类
    /// </summary>
    public class StaffStatus:Status
    {
        public List<TStaff> Staff { get; set; }
    }
}
