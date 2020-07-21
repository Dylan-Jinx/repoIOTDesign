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
    /// 对商品批次基本信息表的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class ProductNumInfoController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<ProductNumInfoController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public ProductNumInfoController(ILogger<ProductNumInfoController> logger)
        {
            _logger = logger;
        }
        /// <summary>
        /// 查询所有信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllProductInfo()
        {
            this._logger.LogWarning("The server excute GetAllProductInfo  --" + DateTime.Now.ToString());
            EFHelper<TProductNumInfo> eFHelper = new EFHelper<TProductNumInfo>();
            var result = eFHelper.getList(a => true).ToList();
            return result.Count > 0 ? new ProductNumInfoStatus(true) { Products = result } : new Status(false);
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
            EFHelper<TProductNumInfo> eFHelper = new EFHelper<TProductNumInfo>();
            var result = eFHelper.getList(a => a.Id == id).ToList();
            return result.Count > 0 ? new ProductNumInfoStatus(true) { Products = result } : new Status(false);
        }
        /// <summary>
        /// 添加商品信息
        /// </summary>
        /// <param name="productnumber">商品批次编号</param>
        /// <param name="productinfo">商品信息</param>
        /// <param name="productionbase">生产基地</param>
        /// <param name="warehouse">存储仓库</param>
        /// <param name="files"></param>
        /// <returns></returns>
        [HttpPost]
        public Status AddProduct(string productnumber,string productinfo,string productionbase,string warehouse,List<IFormFile> files)
        {
            this._logger.LogWarning("The server excute AddProduct  --" + DateTime.Now.ToString());
            bool flag;
            List<string> filenames = new List<string>();
            string resultfilename = string.Empty;
            TProductNumInfo product = new TProductNumInfo()
            {
                ProductNumber=productnumber,
                ProductionBase=productionbase,
                ProductInfo=productinfo,
                WareHouse=warehouse
            };
            if (product.ProductInfo != "")
            {
                flag = UpLoadFile.FileSave(files, product.ProductInfo, out filenames);
            }
            else
            {
                flag = UpLoadFile.FileSave(files, DateTime.Now.ToString("yyyy-MM-dd hh:mm:ss"), out filenames);
            }
            if (flag)
            {
                filenames.Sort();
                resultfilename = string.Join("", filenames.ToArray());
                product.Image = resultfilename;
                EFHelper<TProductNumInfo> eFHelper = new EFHelper<TProductNumInfo>();
                int result = eFHelper.Add(product);
                return result > 0 ? new Status(true) : new Status(false);
            }
            else
            {
                return new Status(false);
            }
        }
        /// <summary>
        /// 修改商品信息
        /// </summary>
        /// <param name="product"></param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateProduct(TProductNumInfo product)
        {
            this._logger.LogWarning("The server excute UpdateProduct  --" + DateTime.Now.ToString());
            EFHelper<TProductNumInfo> eFHelper = new EFHelper<TProductNumInfo>();
            int result = eFHelper.Update(product);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 删除商品信息
        /// </summary>
        /// <param name="product"></param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteProduct(TProductNumInfo product)
        {
            this._logger.LogWarning("The server excute DeleteProduct  --" + DateTime.Now.ToString());
            EFHelper<TProductNumInfo> eFHelper = new EFHelper<TProductNumInfo>();
            int result = eFHelper.Delete(product);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpPost]
        public Status ProductInfoPages(int pagesize,int pageindex)
        {
            this._logger.LogWarning("The server excute ProductInfoPages  --" + DateTime.Now.ToString());
            EFHelper<TProductNumInfo> eFHelper = new EFHelper<TProductNumInfo>();
            var result = eFHelper.getListByPage(a => true, a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TProductNumInfo>(true) { PageList = result } : new Status(false);
        }
        /// <summary>
        /// 分页查询  根据商品信息
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpPost]
        public Status ProductInfoInfoSearchPages(int pagesize, int pageindex,string productinfo)
        {
            this._logger.LogWarning("The server excute ProductInfoSearchPages  --" + DateTime.Now.ToString());
            EFHelper<TProductNumInfo> eFHelper = new EFHelper<TProductNumInfo>();
            var result = eFHelper.getListByPage(a => a.ProductInfo== productinfo, a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TProductNumInfo>(true) { PageList = result } : new Status(false);
        }
        /// <summary>
        /// 分页查询  根据生产基地
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpPost]
        public Status ProductInfoBaseSearchPages(int pagesize, int pageindex, string productionbase)
        {
            this._logger.LogWarning("The server excute ProductInfoSearchPages  --" + DateTime.Now.ToString());
            EFHelper<TProductNumInfo> eFHelper = new EFHelper<TProductNumInfo>();
            var result = eFHelper.getListByPage(a => a.ProductionBase == productionbase, a => a.Id, pagesize, pageindex);
            return result != null ? new PageStatus<TProductNumInfo>(true) { PageList = result } : new Status(false);
        }
    }
}
