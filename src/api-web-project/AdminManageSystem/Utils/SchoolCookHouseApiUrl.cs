using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Utils
{
    public class SchoolCookHouseApiUrl
    {
        #region ——账单表操作——
        /// <summary>
        /// /api/Bill/GetAllBill 查询所有账单
        /// </summary>
        public static string getallbills = "/api/Bill/GetAllBill";


        #endregion

        #region——员工信息表——
        /// <summary>
        /// 返回所有员工
        /// </summary>
        public static string getallstaff = "/api/Staff/GetAllStaff";
        /// <summary>
        /// 查询所有员工并分页
        /// </summary>
        public static string staffpages ="/api/Staff/StaffPages";
        /// <summary>
        /// 根据员工姓名查询信息
        /// </summary>
        public static string staffpagessearch = "/api/Staff/StaffPagesSearch";
        /// <summary>
        /// 修改员工信息
        /// </summary>
        public static string updatestaff = "/api/Staff/UpdateStaffx";
        /// <summary>
        /// 用id查询员工信息
        /// </summary>
        public static string useidgetstaffinfo = "/api/Staff/GetConditionStaff";

        #endregion

        #region——厨房基本信息表——
        /// <summary>
        ///​/api​/CookHouseInfo​/GetAllCookHouseInfo 返回T_CookHouseInfo（厨房信息表）的所有信息
        /// </summary>
        public static string getallcookhouse = "/api/CookHouseInfo/GetAllCookHouseInfo";
        /// <summary>
        /// 上传厨房信息
        /// </summary>
        public static string addcookhouseinfo = "/api/CookHouseInfo/AddCookHouseInfo";
        /// <summary>
        /// 删除厨房信息
        /// </summary>
        public static string deletecookhouseinfo = "/api/CookHouseInfo/DeleteCookHouseInfo";
        /// <summary>
        /// 用厨房名称查询厨房的信息
        /// </summary>
        public static string usecookhousenamebyinfo = "/api/CookHouseInfo/GetConditionCookHouseInfo";
        /// <summary>
        /// 查询所有厨房信息并分页
        /// </summary>
        public static string cookhouseinfopages = "/api/CookHouseInfo/CookHouseInfoPages";
        /// <summary>
        /// 查询单个厨房信息
        /// </summary>
        public static string cookhouseinfopagessearch = "/api/CookHouseInfo/CookHouseInfoPagesSearch";
        #endregion
    }
}
