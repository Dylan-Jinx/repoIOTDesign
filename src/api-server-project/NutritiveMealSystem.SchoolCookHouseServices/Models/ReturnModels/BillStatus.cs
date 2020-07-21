﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.SchoolCookHouseServices.Models.ReturnModels
{
    /// <summary>
    /// 返回数据的模型状态类->对应的是T_Bill（账单表）表，继承Status类
    /// </summary>
    public class BillStatus:Status
    {
        public List<TBill> Bill { get; set; }
    }
}
