using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AdminManageSystem.Data
{
    public class UserLoginDTO
    {
        /// <summary>
        /// 
        /// </summary>
        public ResultObj ResultObj { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public int Status { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public int StatusCode { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string Msg { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public ErrorObj ErrorObj { get; set; }
    }
    public class ResultObj
    {
        /// <summary>
        /// 
        /// </summary>
        public int UserID { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string UserName { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string Email { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string Telphone { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public bool Gender { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public int CollegeID { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string CollegeName { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string RoleName { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public int RoleID { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string AccessToken { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public int AccessTokenErrCode { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string ReturnUrl { get; set; }
        /// <summary>
        /// 
        /// </summary>
        public string DataToken { get; set; }
    }

    public class ErrorObj
    {
    }


}
