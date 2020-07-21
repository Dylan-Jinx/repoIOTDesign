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
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class WaterQualityController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<WaterQualityController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public WaterQualityController(ILogger<WaterQualityController> logger)
        {
            _logger = logger;
        }
        /// <summary>
        /// 查询所有信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllWaterQualityInfo()
        {
            this._logger.LogWarning("The server excute GetAllWaterQualityInfo   --" + DateTime.Now.ToString());
            EFHelper<TWaterQualityInfo> eFHelper = new EFHelper<TWaterQualityInfo>();
            var result = eFHelper.getList(a => true).ToList();
            return result.Count > 0 ? new WaterQualityStatus(true) { WaterQualityInfos = result } : new Status(false);
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
            EFHelper<TWaterQualityInfo> eFHelper = new EFHelper<TWaterQualityInfo>();
            var result = eFHelper.getList(a => a.Id == id).ToList();
            return result.Count > 0 ? new WaterQualityStatus(true) { WaterQualityInfos = result } : new Status(false);
        }
        /// <summary>
        /// 添加水质监测信息
        /// </summary>
        /// <param name="samplingdate">检测时间</param>
        /// <param name="ph"></param>
        /// <param name="comprehensiveevaluation">水质综合评测</param>
        /// <param name="remark"></param>
        /// <param name="files"></param>
        /// <returns></returns>
        [HttpPost]
        public Status AddWaterQuality(double ph,string comprehensiveevaluation,string remark,List<IFormFile> files)
        {
            this._logger.LogWarning("The server execute AddWaterQuality   --" + DateTime.Now.ToString());
            List<string> filenames = new List<string>();
            string resultfilename = string.Empty;
            bool flag;
            TWaterQualityInfo waterQualityInfo = new TWaterQualityInfo()
            {
                DateOfSampling=DateTime.Now,
                Ph=ph,
                ComprehensiveEvaluation=comprehensiveevaluation,
                Remark=remark
            };
            flag = UpLoadFile.FileSave(files, DateTime.Now.ToString("yyyy-MM-dd"), out filenames);
            if (flag)
            {
                filenames.Sort();
                resultfilename = string.Join("", filenames.ToArray());
                waterQualityInfo.Image = resultfilename;
                EFHelper<TWaterQualityInfo> eFHelper = new EFHelper<TWaterQualityInfo>();
                int result = eFHelper.Add(waterQualityInfo);
                return result > 0 ? new Status(true) : new Status(false);
            }
            else
            {
                return new Status(false);
            }
        }
        /// <summary>
        /// 修改水质监测信息
        /// </summary>
        /// <param name="waterQualityInfo"></param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateWaterQuality(TWaterQualityInfo waterQualityInfo)
        {
            this._logger.LogWarning("The server execute UpdateWaterQuality   --" + DateTime.Now.ToString());
            EFHelper<TWaterQualityInfo> eFHelper = new EFHelper<TWaterQualityInfo>();
            int result = eFHelper.Update(waterQualityInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 删除水质监测信息
        /// </summary>
        /// <param name="waterQualityInfo"></param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteWaterQuality(TWaterQualityInfo waterQualityInfo)
        {
            this._logger.LogWarning("The server execute DeleteWaterQuality   --" + DateTime.Now.ToString());
            EFHelper<TWaterQualityInfo> eFHelper = new EFHelper<TWaterQualityInfo>();
            int result = eFHelper.Delete(waterQualityInfo);
            return result > 0 ? new Status(true) : new Status(false);
        }
        /// <summary>
        /// 分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpPost]
        public Status WaterQualityPage(int pagesize,int pageindex)
        {
            this._logger.LogWarning("The server execute WaterQualityPage   --" + DateTime.Now.ToString());
            EFHelper<TWaterQualityInfo> eFHelper = new EFHelper<TWaterQualityInfo>();
            var result = eFHelper.getListByPage(a=>true,a=>a.Id,pagesize,pageindex);
            return result!=null ? new Status(true) : new Status(false);
        }
    }
}
