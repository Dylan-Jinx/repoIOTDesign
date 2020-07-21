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
    /// 对生产基地员工表的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class ProductionBaseStaffController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<ProductionBaseStaffController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public ProductionBaseStaffController(ILogger<ProductionBaseStaffController> logger)
        {
            _logger = logger;
        }

        /// <summary>
        /// 获得所有员工信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllStaff()
        {
            this._logger.LogWarning("The server excute GetAllStaff   --" + DateTime.Now.ToString());
            EFHelper<TProductionBaseStaff> eFHelper = new EFHelper<TProductionBaseStaff>();
            var result = eFHelper.getList(a => true).ToList();
            return result.Count > 0 ? new ProductionBaseStaffStatus(true) { Staffs = result } : new ProductionBaseStaffStatus(false) { Staffs = null };
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
            EFHelper<TProductionBaseStaff> eFHelper = new EFHelper<TProductionBaseStaff>();
            var result = eFHelper.getList(a => a.Id == id).ToList();
            return result.Count > 0 ? new ProductionBaseStaffStatus(true) { Staffs = result } : new Status(false);
        }
        /// <summary>
        /// 添加员工
        /// </summary>
        /// <param name="staffname">员工姓名</param>
        /// <param name="tel">电话号码</param>
        /// <param name="productionbasename">生产基地名称</param>
        /// <param name="level">级别</param>
        /// <param name="file">员工图片</param>
        /// <returns></returns>
        [HttpPost]
        public Status AddStaff(string staffname,string tel,string productionbasename,string level,List<IFormFile>file)
        {
            this._logger.LogWarning("The server excute AddStaff   --" + DateTime.Now.ToString());
            TProductionBaseStaff productionBaseStaff = new TProductionBaseStaff()
            {
                StaffName=staffname,
                Telephone=tel,
                ProductionBaseName=productionbasename,
                Position=level
            };
            List<string> filenames = new List<string>();
            string resultfilename = string.Empty;
            if (productionBaseStaff.StaffName != "")
            {
                UpLoadFile.FileSave(file, productionBaseStaff.StaffName, out filenames);
            }
            else
            {
                UpLoadFile.FileSave(file, DateTime.Now.ToString("yyyy-MM-dd hh:mm:ss"), out filenames);
            }
            filenames.Sort();
            resultfilename = string.Join("", filenames.ToArray());
            productionBaseStaff.Image = resultfilename;
            EFHelper<TProductionBaseStaff> eFHelper = new EFHelper<TProductionBaseStaff>();
            int result = eFHelper.Add(productionBaseStaff);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 修改员工信息
        /// </summary>
        /// <param name="productionBaseStaff"></param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateStaff(TProductionBaseStaff productionBaseStaff)
        {
            this._logger.LogWarning("The server excute UpdateStaff   --" + DateTime.Now.ToString());
            EFHelper<TProductionBaseStaff> eFHelper = new EFHelper<TProductionBaseStaff>();
            int result = eFHelper.Update(productionBaseStaff);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 删除员工信息
        /// </summary>
        /// <param name="productionBaseStaff"></param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteStaff(TProductionBaseStaff productionBaseStaff)
        {
            this._logger.LogWarning("The server excute DeleteStaff   --" + DateTime.Now.ToString());
            EFHelper<TProductionBaseStaff> eFHelper = new EFHelper<TProductionBaseStaff>();
            int result = eFHelper.Delete(productionBaseStaff);
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
            this._logger.LogWarning("The server excute StaffPage   --" + DateTime.Now.ToString());
            EFHelper<TProductionBaseStaff> eFHelper = new EFHelper<TProductionBaseStaff>();
            var result = eFHelper.getListByPage(a => true,a=>a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TProductionBaseStaff>(true) { PageList = result } : new Status(false);
        }

        /// <summary>
        /// 分页 根据所在生产基地
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpPost]
        public Status StaffSearchPage(string keyword,int pagesize, int pageindex)
        {
            this._logger.LogWarning("The server excute StaffSearchPage   --" + DateTime.Now.ToString());
            EFHelper<TProductionBaseStaff> eFHelper = new EFHelper<TProductionBaseStaff>();
            var result = eFHelper.getListByPage(a => a.ProductionBaseName==keyword, a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TProductionBaseStaff>(true) { PageList = result } : new Status(false);
        }
    }
}
