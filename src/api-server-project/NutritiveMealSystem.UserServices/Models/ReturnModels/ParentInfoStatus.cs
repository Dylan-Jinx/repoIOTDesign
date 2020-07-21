using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.UserServices.Models.ReturnModels
{
    /// <summary>
    /// 返回数据的模型状态类->对应的是T_ParentInfo（家长表）表，继承Status类
    /// </summary>
    public class ParentInfoStatus:Status
    {
        public List<TParentInfo> ParentInfo { get; set; }
    }
}
