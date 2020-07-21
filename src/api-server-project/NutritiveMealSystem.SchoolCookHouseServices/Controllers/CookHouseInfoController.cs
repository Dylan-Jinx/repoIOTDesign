using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging;
using NutritiveMealSystem.SchoolCookHouseServices.Models;
using NutritiveMealSystem.SchoolCookHouseServices.Models.ReturnModels;
using NutritiveMealSystem.SchoolCookHouseServices.Utility;

namespace NutritiveMealSystem.SchoolCookHouseServices.Controllers
{
    /// <summary>
    /// 对T_CookHouseInfo（厨房信息表）的操作
    /// </summary>
    [Route("api/[controller]/[action]")]
    [ApiController]
    public class CookHouseInfoController : ControllerBase
    {
        /// <summary>
        /// 加载Log日志服务
        /// </summary>
        private readonly ILogger<CookHouseInfoController> _logger;
        /// <summary>
        /// 初始化Log日志对象
        /// </summary>
        /// <param name="logger"></param>
        public CookHouseInfoController(ILogger<CookHouseInfoController> logger)
        {
            _logger = logger;
        }

        /// <summary>
        /// 返回T_CookHouseInfo（厨房信息表）的所有信息
        /// </summary>
        /// <returns></returns>
        [HttpGet]
        public Status GetAllCookHouseInfo()
        {
            this._logger.LogWarning("The Server execute GetAllCookHouseInfo Function  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                var result = dbcontext.TCookHouseInfo.ToList();
                if (result.Count > 0)
                {
                    CookHouseInfoStatus userInfoStatus = new CookHouseInfoStatus
                    {
                        StatusCode = 200,
                        Message = "获取成功",
                        ReturnTime = DateTime.Now,
                        CookHouseInfo = result
                    };
                    return userInfoStatus;
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
        /// 上传厨房信息
        /// </summary>
        /// <param name="cookhousename">厨房名称</param>
        /// <param name="temperature">温度</param>
        /// <param name="humidity">湿度</param>
        /// <param name="reporttime">上报时间</param>
        /// <returns></returns>
        [HttpPost]
        public Status AddCookHouseInfo(string cookhousename, float temperature, float humidity, string reporttime)
        {
            this._logger.LogWarning("The server execute AddCookHouseInfo Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                TCookHouseInfo cookHouseInfo = new TCookHouseInfo()
                {
                    CookHouseName = cookhousename,
                    Temperature = temperature,
                    Humidity = humidity,
                    ReportTime = reporttime,
                };
                try
                {
                    dbcontext.Add(cookHouseInfo);
                    dbcontext.SaveChanges();
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
                    this._logger.LogWarning("The server execute AddCookHouseInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
                    Status status = new Status()
                    {
                        StatusCode = 0,
                        Message = "添加失败",
                        ReturnTime = DateTime.Now
                    };
                    return status;
                }
            }
        }

        /// <summary>
        /// 删除厨房信息
        /// </summary>
        /// <param name="cookhousename">厨房名称</param>
        /// <returns></returns>
        [HttpPost]
        public Status DeleteCookHouseInfo(string cookhousename)
        {
            this._logger.LogWarning("The server execute DeleteCookHouseInfo Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                TCookHouseInfo userInfo = new TCookHouseInfo()
                {
                    CookHouseName = cookhousename
                };
                try
                {
                    var a = dbcontext.TCookHouseInfo.Where(a => true).ToList().Find(a => a.CookHouseName == cookhousename);
                    dbcontext.TCookHouseInfo.Remove(a);
                    dbcontext.SaveChanges();
                    Status status = new Status()
                    {
                        StatusCode = 200,
                        Message = "删除成功",
                        ReturnTime = DateTime.Now
                    };
                    return status;
                }
                catch (Exception ex)
                {
                    this._logger.LogWarning("The server execute DeleteCookHouseInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
                    Status status = new Status()
                    {
                        StatusCode = 0,
                        Message = "删除失败",
                        ReturnTime = DateTime.Now
                    };
                    return status;
                }
            }
        }

        /// <summary>
        /// 通过厨房名称查询厨房信息
        /// </summary>
        /// <param name="cookhousename">厨房名称</param>
        /// <returns></returns>
        [HttpGet]
        public Status GetConditionCookHouseInfo(string cookhousename)
        {
            this._logger.LogWarning("The server execute GetConditionCookHouseInfo Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                var result = dbcontext.TCookHouseInfo.Where(a => a.CookHouseName == cookhousename).ToList();
                if (result.Count > 0)
                {
                    CookHouseInfoStatus cookHouseInfoStatus = new CookHouseInfoStatus
                    {
                        StatusCode = 200,
                        Message = "查询成功",
                        ReturnTime = DateTime.Now,
                        CookHouseInfo = result
                    };
                    return cookHouseInfoStatus;
                }
                else
                {
                    Status status = new Status
                    {
                        StatusCode = 0,
                        Message = "查询失败",
                        ReturnTime = DateTime.Now,
                    };
                    return status;
                }
            }
        }

        /// <summary>
        /// 修改T_CookHouseInfo（厨房信息表）的信息
        /// </summary>
        /// <param name="conditionusercookhousename">厨房名称-条件</param>
        /// <param name="cookhousename">厨房名称</param>
        /// <param name="temperature">温度</param>
        /// <param name="humidity">湿度</param>
        /// <param name="reporttime">上传时间</param>
        /// <returns></returns>
        [HttpPost]
        public Status UpdateCookHouseInfo(string conditionusercookhousename, string cookhousename, float temperature, float humidity, string reporttime)
        {
            this._logger.LogWarning("The server execute UpdateCookHouseInfo Fuction  --" + DateTime.Now.ToString());
            using (SchoolCookHouseContext dbcontext = new SchoolCookHouseContext())
            {
                TCookHouseInfo cookHouseInfo = new TCookHouseInfo()
                {
                    CookHouseName = cookhousename,
                    Temperature = temperature,
                    Humidity = humidity,
                    ReportTime = reporttime,
                };

                var ReadPeoples = dbcontext.TCookHouseInfo.Where(a => true).ToList().Find(a => a.CookHouseName == conditionusercookhousename);

                ReadPeoples.CookHouseName = cookHouseInfo.CookHouseName;
                ReadPeoples.Temperature = cookHouseInfo.Temperature;
                ReadPeoples.Humidity = cookHouseInfo.Humidity;
                ReadPeoples.ReportTime = cookHouseInfo.ReportTime;

                try
                {
                    dbcontext.Entry(ReadPeoples).State = EntityState.Modified;
                    dbcontext.SaveChanges();
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
                    this._logger.LogWarning("The server execute UpdateCookHouseInfo Fuction  --" + ex.Message + DateTime.Now.ToString());
                    Status status = new Status()
                    {
                        StatusCode = 0,
                        Message = "修改失败",
                        ReturnTime = DateTime.Now
                    };
                    return status;
                }
            }
        }

        /// <summary>
        /// 查询所有信息  并分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <returns></returns>
        [HttpGet]
        public Status CookHouseInfoPages(int pagesize, int pageindex)
        {
            this._logger.LogWarning("The server execute CookHouseInfoPages Fuction  --");
            EFHelper<TCookHouseInfo> eFHelper = new EFHelper<TCookHouseInfo>();
            var result = eFHelper.getListByPage(a =>true, a => a.Id, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TCookHouseInfo> status = new PagesStatus<TCookHouseInfo>
                {
                    StatusCode = 200,
                    Message = "获取成功",
                    ReturnTime = DateTime.Now,
                    PageList = result
                };
                return status;
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
        /// 查询单个厨房信息  并分页
        /// </summary>
        /// <param name="pagesize"></param>
        /// <param name="pageindex"></param>
        /// <param name="cookhousename">查询的厨房名</param>
        /// <returns></returns>
        [HttpGet]
        public Status CookHouseInfoPagesSearch(int pagesize, int pageindex,string cookhousename)
        {
            this._logger.LogWarning("The server execute CookHouseInfoPages Fuction  --");
            EFHelper<TCookHouseInfo> eFHelper = new EFHelper<TCookHouseInfo>();
            var result = eFHelper.getListByPage(a => a.CookHouseName ==cookhousename, a => a.Id, pagesize, pageindex);
            if (result != null)
            {
                PagesStatus<TCookHouseInfo> status = new PagesStatus<TCookHouseInfo>
                {
                    StatusCode = 200,
                    Message = "获取成功",
                    ReturnTime = DateTime.Now,
                    PageList = result
                };
                return status;
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
