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
    /// 商品基础信息表单的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class ProductionBaseInfoController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<ProductionBaseInfoController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public ProductionBaseInfoController(ILogger<ProductionBaseInfoController> logger)
        {
            _logger = logger;
        }        

        /// <summary>
        /// 获得所有商品基础信息表单
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllProductionBaseInfo()
        {
            this._logger.LogWarning("The server execute GetAllProductionBaseInfo   --" + DateTime.Now.ToString());
            EFHelper<TProductionBaseInfo> eFHelper = new EFHelper<TProductionBaseInfo>();
            var result = eFHelper.getList(a => true).ToList();
            return result.Count > 0 ? new ProductionBaseInfoStatus(true) { ProductionBaseInfos = result } : new ProductionBaseInfoStatus(false) { ProductionBaseInfos = null };
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
            EFHelper<TProductionBaseInfo> eFHelper = new EFHelper<TProductionBaseInfo>();
            var result = eFHelper.getList(a => a.Id == id).ToList();
            return result.Count > 0 ? new ProductionBaseInfoStatus(true) { ProductionBaseInfos = result } : new Status(false);
        }
        /// <summary>
        /// 添加商品基础信息表单
        /// </summary>
        /// <param name="proname">商品名</param>
        /// <param name="category">商品类型</param>
        /// <param name="responsiblename">负责人</param>
        /// <param name="tel">电话</param>
        /// <param name="file">商品外观图</param>
        /// <returns></returns>
        [HttpPost]
        public Status AddProductionBaseInfo(string proname,string category,string responsiblename,string tel,List<IFormFile> file)
        {
            this._logger.LogWarning("The server execute AddProductionBaseInfo   --" + DateTime.Now.ToString());
            TProductionBaseInfo productionBaseInfo = new TProductionBaseInfo()
            {
                Name = proname,
                Category = category,
                ResponsibleName = responsiblename,
                Telephone = tel
            };
            List<string> filenames = new List<string>();
            string resultfilename = string.Empty;
            if (productionBaseInfo.Name != "")
            {
                UpLoadFile.FileSave(file, productionBaseInfo.Name, out filenames);
            }
            else
            {
                UpLoadFile.FileSave(file, DateTime.Now.ToString("yyyy-MM-dd hh:mm:ss"), out filenames);
            }
            filenames.Sort();
            resultfilename = string.Join("", filenames.ToArray());
            productionBaseInfo.Image = resultfilename;
            EFHelper<TProductionBaseInfo> eFHelper = new EFHelper<TProductionBaseInfo>();
            int result = eFHelper.Add(productionBaseInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 修改商品基础信息
        /// </summary>
        /// <param name="productionBaseInfo">数据模型</param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateProuductionBaseInfo(TProductionBaseInfo productionBaseInfo)
        {
            this._logger.LogWarning("The server execute UpdateProuductionBaseInfo   --" + DateTime.Now.ToString());
            EFHelper<TProductionBaseInfo> eFHelper = new EFHelper<TProductionBaseInfo>();
            int result = eFHelper.Update(productionBaseInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 删除商品基础信息表
        /// </summary>
        /// <param name="productionBaseInfo">数据模型</param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteProductionBaseInfo(TProductionBaseInfo productionBaseInfo)
        {
            this._logger.LogWarning("The server execute DeleteProductionBaseInfo   --" + DateTime.Now.ToString());
            EFHelper<TProductionBaseInfo> eFHelper = new EFHelper<TProductionBaseInfo>();
            int result = eFHelper.Delete(productionBaseInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 分页
        /// </summary>
        /// <param name="pagesize">分页大小</param>
        /// <param name="pageindex">页码</param>
        /// <returns></returns>
        [HttpPost]
        public Status ProductionBaseInfoPage(int pagesize,int pageindex)
        {
            this._logger.LogWarning("The server execute ProductionBaseInfoPage   --" + DateTime.Now.ToString());
            EFHelper<TProductionBaseInfo> eFHelper = new EFHelper<TProductionBaseInfo>();
            var result = eFHelper.getListByPage(a => true, a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TProductionBaseInfo>(true) { PageList = result } : new Status(false);
        }
        /// <summary>
        /// 分页 精准查询
        /// </summary>
        /// <param name="pagesize">分页大小</param>
        /// <param name="pageindex">页码</param>
        /// <returns></returns>
        [HttpPost]
        public Status ProductionBaseInfoSearchPage(string keyword,int pagesize,int pageindex)
        {
            this._logger.LogWarning("The server execute ProductionBaseInfoSearchPage   --" + DateTime.Now.ToString());
            EFHelper<TProductionBaseInfo> eFHelper = new EFHelper<TProductionBaseInfo>();
            var result = eFHelper.getListByPage(a => a.Name==keyword, a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TProductionBaseInfo>(true) { PageList = result } : new Status(false);
        }

        /// <summary>
        /// 分页 模糊查询
        /// </summary>
        /// <param name="pagesize">分页大小</param>
        /// <param name="pageindex">页码</param>
        /// <returns></returns>
        [HttpPost]
        public Status ProductionBaseInfoSearchLikePage(string likeword, int pagesize, int pageindex)
        {
            this._logger.LogWarning("The server execute ProductionBaseInfoSearchLikePage   --" + DateTime.Now.ToString());
            EFHelper<TProductionBaseInfo> eFHelper = new EFHelper<TProductionBaseInfo>();
            var result = eFHelper.getListByPage(a => a.Name.Contains(likeword), a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TProductionBaseInfo>(true) { PageList = result } : new Status(false);
        }
    }
}
