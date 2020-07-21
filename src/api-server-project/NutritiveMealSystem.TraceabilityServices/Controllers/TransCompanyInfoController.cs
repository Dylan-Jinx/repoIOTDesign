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

namespace NutritiveMealSystem.TraceabilityServices.Controllers
{
    /// <summary>
    /// 对运输公司表基本信息的操控
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class TransCompanyInfoController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<TransCompanyInfoController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public TransCompanyInfoController(ILogger<TransCompanyInfoController> logger)
        {
            _logger = logger;
        }
        /// <summary>
        /// 查询所有信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllCompanyInfo()
        {
            this._logger.LogWarning("The server excute GetAllCompanyInfo  --" + DateTime.Now.ToString());
            EFHelper<TTransportationCompanyInfo> eFHelper = new EFHelper<TTransportationCompanyInfo>();
            var result = eFHelper.getList(a => true).ToList();
            return result.Count > 0 ? new TransportationCompanyInfoStatus(true) { CompanyInfos=result} : new Status(false);
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
            EFHelper<TTransportationCompanyInfo> eFHelper = new EFHelper<TTransportationCompanyInfo>();
            var result = eFHelper.getList(a => a.Id == id).ToList();
            return result.Count > 0 ? new TransportationCompanyInfoStatus(true) { CompanyInfos = result } : new Status(false);
        }
        /// <summary>
        /// 添加运输公司信息
        /// </summary>
        /// <param name="transportationCompanyInfo"></param>
        /// <returns></returns>
        [HttpPost]
        public Status AddCompanyInfo(TTransportationCompanyInfo transportationCompanyInfo)
        {
            this._logger.LogWarning("The server excute AddCompanyInfo  --"+DateTime.Now.ToString());
            EFHelper<TTransportationCompanyInfo> eFHelper = new EFHelper<TTransportationCompanyInfo>();
            int result = eFHelper.Add(transportationCompanyInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 修改运输公司信息
        /// </summary>
        /// <param name="transportationCompanyInfo"></param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateCompanyInfo(TTransportationCompanyInfo transportationCompanyInfo)
        {
            this._logger.LogWarning("The server excute UpdateCompanyInfo  --" + DateTime.Now.ToString());
            EFHelper<TTransportationCompanyInfo> eFHelper = new EFHelper<TTransportationCompanyInfo>();
            int result = eFHelper.Update(transportationCompanyInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 删除运输公司信息
        /// </summary>
        /// <param name="transportationCompanyInfo"></param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteCompanyInfo(TTransportationCompanyInfo transportationCompanyInfo)
        {
            this._logger.LogWarning("The server excute DeleteCompanyInfo  --" + DateTime.Now.ToString());
            EFHelper<TTransportationCompanyInfo> eFHelper = new EFHelper<TTransportationCompanyInfo>();
            int result = eFHelper.Delete(transportationCompanyInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpPost]
        public Status CompanyInfoPage(int pagesize,int pageindex)
        {
            this._logger.LogWarning("The server excute CompanyInfoPage  --" + DateTime.Now.ToString());
            EFHelper<TTransportationCompanyInfo> eFHelper = new EFHelper<TTransportationCompanyInfo>();
            var result = eFHelper.getListByPage(a=>true,a=>a.Id,pagesize,pageindex);
            return result != null ? new PageStatus<TTransportationCompanyInfo>(true) { PageList = result } : new Status(false);
        }
        /// <summary>
        /// 分页 根据公司名查询
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <param name="keyword"></param>
        /// <returns></returns>
        [HttpPost]
        public Status CompanyInfoSearchNamePage(int pagesize, int pageindex,string keyword)
        {
            this._logger.LogWarning("The server excute CompanyInfoSearchNamePage  --" + DateTime.Now.ToString());
            EFHelper<TTransportationCompanyInfo> eFHelper = new EFHelper<TTransportationCompanyInfo>();
            var result = eFHelper.getListByPage(a => a.Name==keyword, a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TTransportationCompanyInfo>(true) { PageList = result } : new Status(false);
        }
    }
}
