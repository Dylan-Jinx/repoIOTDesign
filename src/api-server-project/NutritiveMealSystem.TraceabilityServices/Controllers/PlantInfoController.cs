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
    /// 种植信息表操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class PlantInfoController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<PlantInfoController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public PlantInfoController(ILogger<PlantInfoController> logger)
        {
            _logger = logger;
        }
        
        /// <summary>
        /// 获得所有种植信息表
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllPlantInfo()
        {
            this._logger.LogWarning("The server execute GetAllPlantInfo   --" + DateTime.Now.ToString());
            EFHelper<TPlantInfo> eFHelper = new EFHelper<TPlantInfo>();
            var result = eFHelper.getList(a => true).ToList();
            return result.Count > 0 ? new PlantInfoStatus(true) { PlantInfos = result } : new PlantInfoStatus(false) { PlantInfos = null };
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
            EFHelper<TPlantInfo> eFHelper = new EFHelper<TPlantInfo>();
            var result = eFHelper.getList(a => a.Id == id).ToList();
            return result.Count > 0 ? new PlantInfoStatus(true) { PlantInfos = result } : new Status(false);
        }
        /// <summary>
        /// 添加种植信息表
        /// </summary>
        /// <param name="plantInfo">数据模型</param>
        /// <returns></returns>
        [HttpPost]
        public Status AddPlantInfo(TPlantInfo plantInfo)
        {
            this._logger.LogWarning("The server execute AddPlantInfo   --" + DateTime.Now.ToString());
            plantInfo.PlantTime = DateTime.Now;
            EFHelper<TPlantInfo> eFHelper = new EFHelper<TPlantInfo>();
            int result = eFHelper.Add(plantInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 修改种植信息
        /// </summary>
        /// <param name="plantInfo">数据模型</param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdatePlantInfo(TPlantInfo plantInfo)
        {
            this._logger.LogWarning("The server execute UpdatePlantInfo   --" + DateTime.Now.ToString());
            EFHelper<TPlantInfo> eFHelper = new EFHelper<TPlantInfo>();
            int result = eFHelper.Update(plantInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 删除种植信息
        /// </summary>
        /// <param name="plantInfo">数据模型</param>
        /// <returns></returns>
        [HttpPost]
        public Status DeletePlantInfo(TPlantInfo plantInfo)
        {
            this._logger.LogWarning("The server execute DeletePlantInfo   --" + DateTime.Now.ToString());
            EFHelper<TPlantInfo> eFHelper = new EFHelper<TPlantInfo>();
            int result = eFHelper.Delete(plantInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 分页显示
        /// </summary>
        /// <param name="pagesize">分页大小</param>
        /// <param name="pageindex">页码</param>
        /// <returns></returns>
        [HttpPost]
        public Status PlantInfoPages(int pagesize,int pageindex)
        {
            this._logger.LogWarning("The server execute PlantInfoPages   --" + DateTime.Now.ToString());
            EFHelper<TPlantInfo> eFHelper = new EFHelper<TPlantInfo>();
            var result = eFHelper.getListByPage(a => true, a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TPlantInfo>(true) { PageList = result } : new PageStatus<TPlantInfo>(false) { PageList = null };
        }
        /// <summary>
        /// 精准查询
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <param name="keyword">种子来源</param>
        /// <returns></returns>
        [HttpPost]
        public Status UseNameSearchPage(int pagesize,int pageindex,string keyword)
        {
            this._logger.LogWarning("The server execute UseNameSearchPage   --" + DateTime.Now.ToString());
            EFHelper<TPlantInfo> eFHelper = new EFHelper<TPlantInfo>();
            var result = eFHelper.getListByPage(a => a.SeedSource==keyword, a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TPlantInfo>(true) { PageList = result } : new PageStatus<TPlantInfo>(false) { PageList = null };
        }
        /// <summary>
        /// 模糊查询
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <param name="likeword">种子来源</param>
        /// <returns></returns>
        [HttpPost]
        public Status UseNameSearchLikePage(int pagesize, int pageindex, string likeword)
        {
            this._logger.LogWarning("The server execute UseNameSearchLikePage   --" + DateTime.Now.ToString());
            EFHelper<TPlantInfo> eFHelper = new EFHelper<TPlantInfo>();
            var result = eFHelper.getListByPage(a => a.SeedSource.Contains(likeword), a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TPlantInfo>(true) { PageList = result } : new PageStatus<TPlantInfo>(false) { PageList = null };
        }
    }
}
