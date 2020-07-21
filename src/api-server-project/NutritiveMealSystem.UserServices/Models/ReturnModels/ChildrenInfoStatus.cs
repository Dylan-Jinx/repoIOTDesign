using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.UserServices.Models.ReturnModels
{
    /// <summary>
    /// 返回数据的模型状态类->对应的是T_ChildrenInfo（学校学生信息表）表，继承Status类
    /// </summary>
    public class ChildrenInfoStatus:Status
    {
        public List<TChildrenInfo> ChildrenInfo { get; set; }
    }
}
