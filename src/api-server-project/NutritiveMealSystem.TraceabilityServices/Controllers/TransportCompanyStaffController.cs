using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using NutritiveMealSystem.FoodAnalysisServices;
using NutritiveMealSystem.TraceabilityServices.Models;
using NutritiveMealSystem.TraceabilityServices.Models.ReturnModels;
using NutritiveMealSystem.TraceabilityServices.Utility;

namespace NutritiveMealSystem.TraceabilityServices.Controllers
{
    /// <summary>
    /// 对运输公司员工基本信息的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class TransportCompanyStaffController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<TransportCompanyStaffController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public TransportCompanyStaffController(ILogger<TransportCompanyStaffController> logger)
        {
            _logger = logger;
        }
        /// <summary>
        /// 查询所有信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllStaffs()
        {
            this._logger.LogWarning("The server excute GetAllStaffs    --" + DateTime.Now.ToString());
            EFHelper<TTransportCompanyStaff> eFHelper = new EFHelper<TTransportCompanyStaff>();
            var result = eFHelper.getList(a => true).ToList();
            return result.Count > 0 ? new TransportCompanyStaffStatus(true) { Staffs = result } : new Status(false);
        }
        /// <summary>
        /// 添加员工
        /// </summary>
        /// <returns></returns>
        [HttpPost]
        public Status AddStaff(string staffname,string tel,string companyname,List<IFormFile> files)
        {
            List<string> filenames = new List<string>();
            string resultfilename = string.Empty;
            bool flag;
            TTransportCompanyStaff staff = new TTransportCompanyStaff()
            {
                StaffName = staffname,
                Telephone = tel,
                TransPortCompanyName = companyname
            };
            if (staff.StaffName != "")
            {
                flag = UpLoadFile.FileSave(files, staff.StaffName, out filenames);
            }
            else
            {
                flag = UpLoadFile.FileSave(files, DateTime.Now.ToString("yyyy-MM-dd hh:mm:ss"), out filenames);
            }
            filenames.Sort();
            resultfilename = string.Join("", filenames.ToArray());
            staff.Image = resultfilename;
            EFHelper<TTransportCompanyStaff> eFHelper = new EFHelper<TTransportCompanyStaff>();
            int result = eFHelper.Add(staff);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 修改员工信息
        /// </summary>
        /// <param name="staff"></param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateStaff(TTransportCompanyStaff staff)
        {
            EFHelper<TTransportCompanyStaff> eFHelper = new EFHelper<TTransportCompanyStaff>();
            int result = eFHelper.Update(staff);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 删除员工信息
        /// </summary>
        /// <param name="staff"></param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteStaff(TTransportCompanyStaff staff)
        {
            EFHelper<TTransportCompanyStaff> eFHelper = new EFHelper<TTransportCompanyStaff>();
            int result = eFHelper.Delete(staff);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpPost]
        public Status StaffPage(int pagesize,int pageindex)
        {
            EFHelper<TTransportCompanyStaff> eFHelper = new EFHelper<TTransportCompanyStaff>();
            var result = eFHelper.getListByPage(a=>true,a=>a.Id,pagesize,pageindex);
            return result !=null ? new PageStatus<TTransportCompanyStaff>(true) : new Status(false);
        }

        /// <summary>
        /// 分页  根据公司
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <param name="companyname">公司名</param>
        /// <returns></returns>
        [HttpPost]
        public Status StaffSearchCompanyPage(int pagesize, int pageindex,string companyname)
        {
            EFHelper<TTransportCompanyStaff> eFHelper = new EFHelper<TTransportCompanyStaff>();
            var result = eFHelper.getListByPage(a => a.TransPortCompanyName==companyname, a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TTransportCompanyStaff>(true) : new Status(false);
        }
        /// <summary>
        /// 用id查询基础信息
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        [HttpPost]
        public Status UserIdBySearch(int id)
        {
            this._logger.LogWarning("The server execute UserIdBySearch   --" + DateTime.Now.ToString());
            EFHelper<TTransportCompanyStaff> eFHelper = new EFHelper<TTransportCompanyStaff>();
            var result = eFHelper.getList(a => a.Id == id).ToList();
            return result.Count > 0 ? new TransportCompanyStaffStatus(true) { Staffs = result } : new Status(false);
        }
    }
}
