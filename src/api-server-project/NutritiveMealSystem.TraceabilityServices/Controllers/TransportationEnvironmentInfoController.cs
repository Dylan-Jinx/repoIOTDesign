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
    /// 车辆运输环境登记信息
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class TransportationEnvironmentInfoController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<TransportationEnvironmentInfoController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public TransportationEnvironmentInfoController(ILogger<TransportationEnvironmentInfoController> logger)
        {
            _logger = logger;
        }
        /// <summary>
        /// 查询所有信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllEnvironmentInfo()
        {
            EFHelper<TTransportationEnvironmentInfo> eFHelper = new EFHelper<TTransportationEnvironmentInfo>();
            var result = eFHelper.getList(a => true).ToList();
            return result.Count > 0 ? new TransportationEnvironmentInfoStatus(true) { EnvironmentInfos = result } : new Status(false);
        }
        /// <summary>
        /// 添加车辆环境等信息
        /// </summary>
        /// <param name="info"></param>
        /// <returns></returns>
        [HttpPost]
        public Status AddEnvironment(TTransportationEnvironmentInfo info)
        {
            EFHelper<TTransportationEnvironmentInfo> eFHelper = new EFHelper<TTransportationEnvironmentInfo>();
            int result = eFHelper.Add(info);
            return result > 0 ? new Status(true): new Status(false);
        }
        /// <summary>
        /// 修改车辆环境等信息
        /// </summary>
        /// <param name="info"></param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateEnvironment(TTransportationEnvironmentInfo info)
        {
            EFHelper<TTransportationEnvironmentInfo> eFHelper = new EFHelper<TTransportationEnvironmentInfo>();
            int result = eFHelper.Update(info);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 删除车辆环境等信息
        /// </summary>
        /// <param name="info"></param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteEnvironment(TTransportationEnvironmentInfo info)
        {
            EFHelper<TTransportationEnvironmentInfo> eFHelper = new EFHelper<TTransportationEnvironmentInfo>();
            int result = eFHelper.Delete(info);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 用产品批次编号查询运输信息
        /// </summary>
        /// <param name="productnum"></param>
        /// <returns></returns>
        [HttpPost]
        public Status UseProductNumSearchInfo(string productnum)
        {
            EFHelper<TTransportationEnvironmentInfo> eFHelper = new EFHelper<TTransportationEnvironmentInfo>();
            var result = eFHelper.getList(a => a.ProductNumber == productnum).ToList();
            return result.Count > 0 ? new TransportationEnvironmentInfoStatus(true) { EnvironmentInfos = result } : new Status(false);
        }
        /// <summary>
        /// 查询所有结果  分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpPost]
        public Status EnvironmentInfoPages(int pagesize,int pageindex)
        {
            EFHelper<TTransportationEnvironmentInfo> eFHelper = new EFHelper<TTransportationEnvironmentInfo>();
            var result = eFHelper.getListByPage(a => true, a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TTransportationEnvironmentInfo>(true) { PageList = result } : new Status(false);
        }
    }
}
