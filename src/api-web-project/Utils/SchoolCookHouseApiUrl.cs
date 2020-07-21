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
        /// 查询所有账单
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
    }
}
