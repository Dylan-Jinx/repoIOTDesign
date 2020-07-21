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
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class WarehouseInfoController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<WarehouseInfoController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public WarehouseInfoController(ILogger<WarehouseInfoController> logger)
        {
            _logger = logger;
        }

        /// <summary>
        /// 获得所有仓库信息表
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetWareHouseInfo()
        {
            this._logger.LogWarning("The server execute GetWareHouseInfo   --" + DateTime.Now.ToString());
            EFHelper<TWarehouseInfo> eFHelper = new EFHelper<TWarehouseInfo>();
            var result = eFHelper.getList(a=>true).ToList();
            return result.Count > 0 ? new WarehouseInfoStatus(true) { Warehouses = result } : new Status(false);
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
            EFHelper<TWarehouseInfo> eFHelper = new EFHelper<TWarehouseInfo>();
            var result = eFHelper.getList(a => a.Id==id).ToList();
            return result.Count > 0 ? new WarehouseInfoStatus(true) { Warehouses = result } : new Status(false);
        }
        /// <summary>
        /// 添加仓库信息
        /// </summary>
        /// <param name="warehouseInfo"></param>
        /// <returns></returns>
        [HttpPost]
        public Status AddWareHouseInfo(TWarehouseInfo warehouseInfo)
        {
            this._logger.LogWarning("The server execute AddWareHouseInfo   --" + DateTime.Now.ToString());
            EFHelper<TWarehouseInfo> eFHelper = new EFHelper<TWarehouseInfo>();
            int result = eFHelper.Add(warehouseInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 修改仓库信息
        /// </summary>
        /// <param name="warehouseInfo"></param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateWareHouseInfo(TWarehouseInfo warehouseInfo)
        {
            this._logger.LogWarning("The server execute UpdateWareHouseInfo   --" + DateTime.Now.ToString());
            EFHelper<TWarehouseInfo> eFHelper = new EFHelper<TWarehouseInfo>();
            int result = eFHelper.Update(warehouseInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 删除仓库信息
        /// </summary>
        /// <param name="warehouseInfo"></param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteWareHouseInfo(TWarehouseInfo warehouseInfo)
        {
            this._logger.LogWarning("The server execute DeleteWareHouseInfo   --" + DateTime.Now.ToString());
            EFHelper<TWarehouseInfo> eFHelper = new EFHelper<TWarehouseInfo>();
            int result = eFHelper.Delete(warehouseInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpPost]
        public Status WareHouseInfoPage(int pagesize,int pageindex)
        {
            this._logger.LogWarning("The server execute WareHouseInfoPage   --" + DateTime.Now.ToString());
            EFHelper<TWarehouseInfo> eFHelper = new EFHelper<TWarehouseInfo>();
            var result = eFHelper.getListByPage(a=>true,a=>a.Id,pagesize,pageindex);
            return result != null ? new PageStatus<TWarehouseInfo>(true) { PageList = result } : new Status(false);
        }

        /// <summary>
        /// 分页  用仓库名查询
        /// </summary>
        /// <param name="warehousename">仓库名</param>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpPost]
        public Status WareHouseInfoSearchNamePage(string warehousename,int pagesize, int pageindex)
        {
            this._logger.LogWarning("The server execute WareHouseInfoPage   --" + DateTime.Now.ToString());
            EFHelper<TWarehouseInfo> eFHelper = new EFHelper<TWarehouseInfo>();
            var result = eFHelper.getListByPage(a => a.Name== warehousename, a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TWarehouseInfo>(true) { PageList = result } : new Status(false);
        }
    }
}
