using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.InteropServices.ComTypes;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;
using NutritiveMealSystem.FoodAnalysisServices.Models;
using NutritiveMealSystem.FoodAnalysisServices.Models.ReturnModels;
using NutritiveMealSystem.TraceabilityServices.Models;

namespace NutritiveMealSystem.FoodAnalysisServices.Controllers
{
    /// <summary>
    /// 对营养素表的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class NutrientInfoController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<NutrientInfoController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public NutrientInfoController(ILogger<NutrientInfoController> logger)
        {
            _logger = logger;
        }
        /// <summary>
        /// 返回营养素信息表中所有营养素的基本信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllNutritionInfo()
        {
            this._logger.LogWarning("The Server execute GetAllNutritionInfo Function  --" + DateTime.Now.ToString());
            using (DietaryNutritionContext dbcontext = new DietaryNutritionContext())
            {
                var result = dbcontext.TNutrientInformation.ToList();
                if (result.Count > 0)
                {
                    NutritionInfoStatus nutritionInfoStatus = new NutritionInfoStatus
                    {
                        StatusCode = 200,
                        Message = "获取成功",
                        ReturnTime = DateTime.Now,
                        NutrientInformation = result
                    };
                    return nutritionInfoStatus;
                }
                else
                {
                    Status status = new Status
                    {
                        StatusCode = 0,
                        Message = "获取失败",
                        ReturnTime = DateTime.Now,
                    };
                    return status;
                }
            }
        }
        /// <summary>
        /// 用营养素的别名或者是名字查询营养素信息表中所有营养素的基本信息
        /// </summary>
        /// <param name="NutritionName">营养素名字/别名</param>
        /// <returns></returns>
        [HttpPost]
        public Status UseNutritionNameBySearchInfo(string NutritionName)
        {
            this._logger.LogWarning("The Server execute UseNutritionNameBySearchInfo  --" + DateTime.Now.ToString());
            using (DietaryNutritionContext dbcontext = new DietaryNutritionContext())
            {
                var result = dbcontext.TNutrientInformation.Where(a=>a.Name==NutritionName||a.OtherName==NutritionName).ToList();
                if (result.Count > 0)
                {
                    NutritionInfoStatus nutritionInfoStatus = new NutritionInfoStatus
                    {
                        StatusCode = 200,
                        Message = "获取成功",
                        ReturnTime = DateTime.Now,
                        NutrientInformation = result
                    };
                    return nutritionInfoStatus;
                }
                else
                {
                    Status status = new Status
                    {
                        StatusCode = 0,
                        Message = "获取失败",
                        ReturnTime = DateTime.Now,
                    };
                    return status;
                }
            }
        }
        /// <summary>
        /// 添加平台营养素的基础信息
        /// </summary>
        /// <param name="datas"></param>
        /// <returns></returns>
        [HttpPost]
        //string name,string othername,string unit,string intro,string desymp,string muchharm,string source,string focusgroups,string hco
        public Status AddNutritionInfo(TNutrientInformation datas)
        {
            this._logger.LogWarning("The server execute AddNutritionInfo Fuction  --" + DateTime.Now.ToString());
            EFHelper<TNutrientInformation> eFHelper = new EFHelper<TNutrientInformation>();
            try
            {
                eFHelper.Add(datas);
                Status status = new Status()
                {
                    StatusCode = 200,
                    Message = "添加成功",
                    ReturnTime = DateTime.Now
                };
                return status;
            }
            catch (Exception ex)
            {
                this._logger.LogWarning("The server execute AddNutrition Fuction  --" + ex.Message + DateTime.Now.ToString());
                Status status = new Status()
                {
                    StatusCode = 0,
                    Message = "添加失败",
                    ReturnTime = DateTime.Now
                };
                return status;
            }
            //using(DietaryNutritionContext dbcontext=new DietaryNutritionContext())
            //{
            //    TNutrientInformation nutrientInformation = new TNutrientInformation()
            //    {
            //        Name=name,
            //        OtherName=othername,
            //        Unit= unit,
            //        Introduction=intro,
            //        DeSymptom=desymp,
            //        MuchHarm=muchharm,
            //        Source=source,
            //        FocusGroups=focusgroups,
            //        HighContentOfSource=hco
            //    };
            //    try
            //    {
            //        dbcontext.Add(nutrientInformation);
            //        dbcontext.SaveChanges();
            //        Status status = new Status()
            //        {
            //            StatusCode = 200,
            //            Message = "添加成功",
            //            ReturnTime = DateTime.Now
            //        };
            //        return status;
            //    }
            //    catch(Exception ex)
            //    {
            //        this._logger.LogWarning("The server execute AddNutrition Fuction  --" +ex.Message + DateTime.Now.ToString());
            //        Status status = new Status()
            //        {
            //            StatusCode = 0,
            //            Message = "添加失败",
            //            ReturnTime = DateTime.Now
            //        };
            //        return status;
            //    }
            //}
        }
        /// <summary>
        /// 修改平台营养素的基础信息
        /// </summary>
        /// <param name="datas">模型，参考下面请求体内容</param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateNutritionInfo(TNutrientInformation datas)
        {
            this._logger.LogWarning("The server execute UpdateNutritionInfo Fuction  --" + DateTime.Now.ToString());
            EFHelper<TNutrientInformation> eFHelper = new EFHelper<TNutrientInformation>();
            try
            {
                eFHelper.Update(datas);
                Status status = new Status()
                {
                    StatusCode = 200,
                    Message = "修改成功",
                    ReturnTime = DateTime.Now
                };
                return status;
            }
            catch (Exception ex)
            {
                this._logger.LogWarning("The server execute AddNutrition Fuction  --" + ex.Message + DateTime.Now.ToString());
                Status status = new Status()
                {
                    StatusCode = 0,
                    Message = "修改失败",
                    ReturnTime = DateTime.Now
                };
                return status;
            }
        }
        /// <summary>
        /// 修改平台营养素的基础信息
        /// </summary>
        /// <param name="id">对应内容的id</param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteNutritionInfo(int id)
        {
            this._logger.LogWarning("The server execute UpdateNutritionInfo Fuction  --" + DateTime.Now.ToString());
            EFHelper<TNutrientInformation> eFHelper = new EFHelper<TNutrientInformation>();
            try
            {
                TNutrientInformation result = eFHelper.getList(a => a.Id == id).FirstOrDefault();
                if(result == null)
                {
                    this._logger.LogWarning("This object is null ");
                    throw new Exception();
                }
                else
                {
                    eFHelper.Delete(result);
                    CookBookStatus status = new CookBookStatus()
                    {
                        StatusCode = 200,
                        Message = "删除成功",
                        ReturnTime = DateTime.Now
                    };
                    return status;
                }
            }
            catch (Exception ex)
            {
                this._logger.LogWarning("The server execute DeleteNutritionInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
                CookBookStatus status = new CookBookStatus()
                {
                    StatusCode = 0,
                    Message = "删除失败",
                    ReturnTime = DateTime.Now
                };
                return status;
            }
        }
        /// <summary>
        /// 正常分页（属于网页功能）
        /// </summary>
        /// <param name="pagesize">分页大小</param>
        /// <param name="pageindex">当前页码</param>
        /// <returns></returns>
        [HttpPost]
        public Status NutritionInfoPages(int pagesize,int pageindex)
        {
            this._logger.LogWarning("The server execute NutritionInfoPages Fuction  --" + DateTime.Now.ToString());
            EFHelper<TNutrientInformation> eFHelper = new EFHelper<TNutrientInformation>();
            var result = eFHelper.getListByPage(a => true,a=>a.Id, pagesize, pageindex);
            if (result!=null)
            {
                PagesStatus<TNutrientInformation> nutritionInfoStatus = new PagesStatus<TNutrientInformation>
                {
                    StatusCode = 200,
                    Message = "获取成功",
                    ReturnTime = DateTime.Now,
                    PageList = result
                };
                return nutritionInfoStatus;
            }
            else
            {
                Status status = new Status
                {
                    StatusCode = 0,
                    Message = "获取失败",
                    ReturnTime = DateTime.Now,
                };
                return status;
            }
        }
        /// <summary>
        /// 模糊查询分页（网页功能）
        /// </summary>
        /// <param name="keyword">模糊查询词</param>
        /// <param name="pagesize">分页大小</param>
        /// <param name="pageindex">当前页码</param>
        /// <returns></returns>
        [HttpPost]
        public Status NutritionInfoLikePages(string keyword,int pagesize,int pageindex)
        {
            this._logger.LogWarning("The server execute NutritionInfoLikePages Fuction  --" + DateTime.Now.ToString());
            EFHelper<TNutrientInformation> eFHelper = new EFHelper<TNutrientInformation>();
            var result = eFHelper.getListByPage(a => a.Name.Contains(keyword), a => a.Id, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TNutrientInformation> nutritionInfoStatus = new PagesStatus<TNutrientInformation>
                {
                    StatusCode = 200,
                    Message = "获取成功",
                    ReturnTime = DateTime.Now,
                    PageList = result
                };
                return nutritionInfoStatus;
            }
            else
            {
                Status status = new Status
                {
                    StatusCode = 0,
                    Message = "获取失败",
                    ReturnTime = DateTime.Now,
                };
                return status;
            }
        }
    }
}
