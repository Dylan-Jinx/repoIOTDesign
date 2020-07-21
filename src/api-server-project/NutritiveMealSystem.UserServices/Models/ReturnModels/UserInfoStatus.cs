using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NutritiveMealSystem.UserServices.Models.ReturnModels
{
    /// <summary>
    /// 返回数据的模型状态类->对应的是T_UserInfo（用户登录表）表，继承Status类
    /// </summary>
    public class UserInfoStatus: Status
    {
        public List<TUserInfo> UserInfo { get; set; }
    }
}
